package com.example;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaboratoryManagementSystem {

    // MySQL 配置
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/laboratory_db?useSSL=false&serverTimezone=UTC";
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PASSWORD = "123456";

    // Redis 配置
    private static final String REDIS_HOST = "localhost";
    private static final int REDIS_PORT = 6379;

    // Redis 缓存键
    private static final String HOT_COURSES_CACHE_KEY = "hot_courses";

    // Redis 发布频道
    private static final String REPORT_NOTIFICATION_CHANNEL = "report_notifications";

    public static void main(String[] args) {
        try {
            // 初始化 Redis 客户端
            Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT);
            System.out.println("Connected to Redis!");

            // 查询热门实验课程列表
            List<Course> courses = getHotCourses(jedis);

            // 打印查询结果
            System.out.println("热门实验课程列表:");
            for (Course course : courses) {
                System.out.println(course);
            }

            // 模拟新实验报告提交
            submitNewReport(jedis, "实验报告1");

            // 启动 Redis 订阅线程，监听通知
            Thread subscriberThread = new Thread(() -> {
                Jedis subscriberJedis = new Jedis(REDIS_HOST, REDIS_PORT);
                subscriberJedis.subscribe(new ReportNotificationListener(), REPORT_NOTIFICATION_CHANNEL);
            });
            subscriberThread.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取热门实验课程列表（从 Redis 缓存或 MySQL 数据库）
     */
    private static List<Course> getHotCourses(Jedis jedis) throws SQLException {
        // 尝试从 Redis 缓存中获取数据
        String cachedCourses = jedis.get(HOT_COURSES_CACHE_KEY);
        if (cachedCourses != null) {
            System.out.println("从 Redis 缓存中获取热门实验课程...");
            return new Gson().fromJson(cachedCourses, new ArrayList<Course>() {}.getClass());
        }

        // 如果缓存中没有数据，则从 MySQL 数据库中查询
        System.out.println("从 MySQL 数据库中获取热门实验课程...");
        List<Course> courses = queryCoursesFromDatabase();

        // 将查询结果存储到 Redis 缓存中（设置过期时间为 5 分钟）
        jedis.setex(HOT_COURSES_CACHE_KEY, 300, new Gson().toJson(courses));
        return courses;
    }

    /**
     * 从 MySQL 数据库中查询热门实验课程
     */
    private static List<Course> queryCoursesFromDatabase() throws SQLException {
        List<Course> courses = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, description FROM courses ORDER BY popularity DESC LIMIT 10")) {

            while (rs.next()) {
                Course course = new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description")
                );
                courses.add(course);
            }
        }
        return courses;
    }

    /**
     * 模拟提交新的实验报告，并发送通知
     */
    private static void submitNewReport(Jedis jedis, String reportName) {
        System.out.println("提交新的实验报告: " + reportName);

        // 发送通知到 Redis 频道
        jedis.publish(REPORT_NOTIFICATION_CHANNEL, "新的实验报告需要审核: " + reportName);
    }

    /**
     * Redis 订阅监听器
     */
    static class ReportNotificationListener extends JedisPubSub {
        @Override
        public void onMessage(String channel, String message) {
            System.out.println("收到通知: [频道=" + channel + "] " + message);
        }
    }

    /**
     * 实验课程实体类
     */
    static class Course {
        private int id;
        private String name;
        private String description;

        public Course(int id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }

        @Override
        public String toString() {
            return "Course{id=" + id + ", name='" + name + "', description='" + description + "'}";
        }
    }
}
