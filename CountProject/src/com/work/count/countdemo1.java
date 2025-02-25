package com.work.count;

public class countdemo1 {
    public static void main(String[] args) {
        start();
    }

    public static void start(){
        String[] cards = new String[54];

        String [] colors = {"黑桃","红桃","梅花","方片"};
        String [] nums = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                cards[index++] = colors[j] + nums[i];
            }
        }

        cards[52] = "xiaowang";
        cards[53] = "joker";

        for (int i = 0; i < 54; i++) {
            int n = (int)(Math.random()*54);
            String m = cards[n];
            cards[n] = cards[i];
            cards[i] = m;
        }

        for (int i = 0; i < 54; i++) {
            System.out.print(cards[i]);
        }
    }
}
