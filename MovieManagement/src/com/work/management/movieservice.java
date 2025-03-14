package com.work.management;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.work.management.moviebase;

public class movieservice {
    //准备一个集合装电影
    private static List<moviebase> movies = new ArrayList<>();

    //准备一个接受用户选择的scanner
    private static Scanner sc = new Scanner(System.in);

    //界面
    public void start(){
        while (true) {
            System.out.println("===电影操作系统===");
            System.out.println("1.上架电影");
            System.out.println("2.下架电影");
            System.out.println("3.查询电影");
            System.out.println("4.删除有某人的电影");
            System.out.println("5.退出");
            System.out.println("6.展示全部电影");
            System.out.println("7.修改电影信息");
            System.out.println("您的选择是");

            String command =  sc.next();
            switch (command){
                case "1":
                    addmovie();
                    break;
                case "2":
                    removemovie();
                    break;
                case "3":
                    checkmovie();
                    break;
                case "4":
                    deletestar();
                    break;
                case "5":
                    System.out.println("已退出");
                    return;
                case "6":
                    showallmovie();
                    break;
                case "7":
                    changemovie();
                    break;
                default:
                    System.out.println("有无");
            }
        }

    }

    //1上架
    private void addmovie() {
        //1创建对象，封装信息  2给对象注入数据  3把对象添加到集合终
        moviebase movie = new moviebase();

        System.out.println("=====================");
        System.out.println("电影名称");
        movie.setName(sc.next());
        System.out.println("电影评分");
        movie.setScore(sc.nextDouble());
        System.out.println("演员");
        movie.setActor(sc.next());
        System.out.println("价格");
        movie.setPrice(sc.nextDouble());

        movies.add(movie);
        System.out.println("上架成功");
    }

    private void removemovie(){
        System.out.println("需要删除的电影名称");
        String name = sc.next();

        Iterator<moviebase> iterator = movies.iterator();
        while (iterator.hasNext()) {
            moviebase star1 = iterator.next();
            if (star1.getActor().equals(name)) {
                iterator.remove();
                System.out.println("删除成功");
            }
        }
    }

    //根据电影名称查电影
    public moviebase moviequery(String name){
        for (moviebase m : movies){
            if (m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }

    private void checkmovie(){
        System.out.println("========查询电影=========");
        String name = sc.next();
        moviebase n = moviequery(name);
        if (n != null){
            System.out.println(n.getName()+" "+n.getActor()+" "+n.getScore()+" "+n.getPrice());
        }else {
            System.out.println("输入有误");
        }
    }

    private void deletestar(){
        System.out.println("===需要删除的明星===");
        String star = sc.next();

        Iterator<moviebase> iterator = movies.iterator();
        while (iterator.hasNext()){
            moviebase star1 = iterator.next();
            if (star1.getActor().contains(star)){
                iterator.remove();
                System.out.println("删除成功");
            }
        }
    }

    private void showallmovie(){
        Iterator<moviebase> iterator = movies.iterator();
        while (iterator.hasNext()){
            moviebase q = iterator.next();
            System.out.println(q.getName()+" "+q.getScore()+" "+ q.getActor()+" "+q.getPrice());
        }
    }

    private void changemovie(){
        System.out.println("===需要修改的电影名字===");
        String name = sc.next();
        moviebase r = moviequery(name);
        System.out.println("电影名修改为");
        r.setName(sc.next());

        System.out.println("演员名修改为");
        r.setActor(sc.next());

        System.out.println("电影价格修改为");
        r.setPrice(sc.nextDouble());

        System.out.println("电影评分修改为");
        r.setScore(sc.nextDouble());

        boolean updated = false;
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(name)) {
                movies.set(i, r); // 使用 set 方法更新指定索引处的元素
                System.out.println("电影信息更新成功");
                updated = true;
                break; // 一旦找到并更新了电影，退出循环
            }
        }


    }

}
