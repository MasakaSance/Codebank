import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LaboratoryManagementSystemTest {

    private Jedis mockJedis;
    private Connection mockConnection;
    private Statement mockStatement;
    private ResultSet mockResultSet;

    @Before
    public void setUp() throws Exception {
        // Mock Redis 客户端
        mockJedis = mock(Jedis.class);

        // Mock MySQL 数据库连接
        mockConnection = mock(Connection.class);
        mockStatement = mock(Statement.class);
        mockResultSet = mock(ResultSet.class);

        // 模拟数据库查询结果
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false); // 模拟返回一条记录
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getString("name")).thenReturn("实验课程1");
        when(mockResultSet.getString("description")).thenReturn("这是实验课程1的描述");
    }

    /**
     * 测试从 Redis 缓存中获取热门课程
     */
    @Test
    public void testGetHotCourses_FromRedisCache() {
        // 模拟 Redis 缓存中有数据
        List<LaboratoryManagementSystem.Course> courses = new ArrayList<>();
        courses.add(new LaboratoryManagementSystem.Course(1, "实验课程1", "这是实验课程1的描述"));
        when(mockJedis.get("hot_courses")).thenReturn(new Gson().toJson(courses));

        // 调用方法
        List<LaboratoryManagementSystem.Course> result = LaboratoryManagementSystem.getHotCourses(mockJedis);

        // 验证结果
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("实验课程1", result.get(0).name);
    }

    /**
     * 测试从 MySQL 数据库中获取热门课程
     */
    @Test
    public void testGetHotCourses_FromDatabase() throws SQLException {
        // 模拟 Redis 缓存中没有数据
        when(mockJedis.get("hot_courses")).thenReturn(null);

        // 替换实际的数据库连接为 Mock 对象
        when(DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/laboratory_db?useSSL=false&serverTimezone=UTC",
                "root", "your_password"
        )).thenReturn(mockConnection);

        // 调用方法
        List<LaboratoryManagementSystem.Course> result = LaboratoryManagementSystem.getHotCourses(mockJedis);

        // 验证结果
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("实验课程1", result.get(0).name);
    }

    /**
     * 测试提交新的实验报告
     */
    @Test
    public void testSubmitNewReport() {
        // 模拟 Redis 发布消息
        LaboratoryManagementSystem.submitNewReport(mockJedis, "实验报告1");

        // 验证发布消息是否被调用
        verify(mockJedis).publish("report_notifications", "新的实验报告需要审核: 实验报告1");
    }

    /**
     * 测试 Redis 订阅监听器
     */
    @Test
    public void testReportNotificationListener() {
        // 创建订阅监听器
        LaboratoryManagementSystem.ReportNotificationListener listener =
                new LaboratoryManagementSystem.ReportNotificationListener();

        // 模拟接收到消息
        listener.onMessage("report_notifications", "新的实验报告需要审核: 实验报告1");

        // 这里可以通过日志或其他方式验证消息处理逻辑
        // 例如：捕获控制台输出或断言某些状态变化
    }
}