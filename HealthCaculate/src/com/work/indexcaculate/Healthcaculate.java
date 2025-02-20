package com.work.indexcaculate;

import java.util.Scanner;

public class Healthcaculate {
    public static void main(String[] args) {
        indexmain();
    }

    public static void indexmain(){

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的年龄");
        int age = sc.nextInt();
        System.out.println("请输入你的性别 男/女");
        String sex = sc.next();
        System.out.println("请输入你的体重/kg");
        double weight = sc.nextDouble();
        System.out.println("请输入你的身高/m");
        double height = sc.nextDouble();
        System.out.println("------------------");
        System.out.println("你的BMI指数为"+  BMIc(age, sex, weight, height));
        System.out.println("你的BMI结果为"+  BMIresult(BMIc(age, sex, weight, height)));
        System.out.println("你的BMR结果为"+BMRc(age, sex, weight, height));

    }

    public static double BMIc(int age, String sex, double weight, double height){
        double BMI = weight/(height*height);
        return BMI;
    }

    public static String BMIresult(double BMI){

        String result = "";
        if (BMI<18.5){
            result = "体重过轻";
        }else if (18.5<=BMI && BMI<=24.9){
            result = "正常体重";
        }else if (25.0<=BMI){
            result = "超重";
        }
        return result;
    }
    public static double BMRc(int age, String sex, double weight, double height){

        double BMR = 0;
        if ("男".equals(sex)){
            BMR = 88.362+(13.397*weight)+(4.799*100*height)-(5.6778*age);
        }else if("女".equals(sex)) {
            BMR = 447.593+(9.247*weight)+(3.098*100*height)-(4.33*age);
        }
        return BMR;
    }


//
}
