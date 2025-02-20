package com.work;

public class zilei extends Carlimit{
    public zilei(String m, int d) {
        super(m, d);
    }

    public static void main(String[] args) {
        zilei z = new zilei("zilei", 4);
        z.model = "Hypercar";
        z.setDoors(4);
        z.moveto(100, 200);
    }
}
