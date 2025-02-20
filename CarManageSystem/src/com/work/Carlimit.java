package com.work;

public class Carlimit {
    public String model = "";
    private int doors = 4;
//门数设置
    public void setDoors(int d) {
        if (d >= 0 && d <= 5){
            doors = d;
        }else doors = 4;
    }
    public int getDoors() {
        return doors;
    }
//人员添加
    public void joins(String...names){
        for (String s : names){
            System.out.println("欢迎" + s + "加入");
        }
    }

    public Carlimit(String m, int d){
        model = m;
        setDoors(d);
        System.out.println("创建"+m+"汽车");
    }

    public void moveto(int x, int y){
        String s = String.format("汽车%s,在(%d,%d)位置", model, x, y);
        System.out.println(s);
    }
}

