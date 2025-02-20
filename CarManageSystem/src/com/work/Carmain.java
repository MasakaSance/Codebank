package com.work;

public class Carmain {
//    静态初始化结构
    static {
        System.out.println("程序开始");
    }
    private static int counter = 0;

    public static int getCounter() {
        return counter;
    }

    public static Carlimit createSUV(){
        counter++;
        return new Carlimit("SUV", 5);
    }



    public static void main(String[] args) {
        Carlimit suv1 = Carmain.createSUV();
        Carlimit suv2 = Carmain.createSUV();
        Carlimit suv3 = Carmain.createSUV();
        System.out.println("目前有" + Carmain.getCounter() + "辆Car已生产");
        suv1.joins("张三","李四","王五");
    }
}


