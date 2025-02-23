package randomguess;

import java.util.Random;
import java.util.Scanner;

public class Randomguess {
    public static void main(String[] args) {
        gamemain();
    }
    public static int prorandom(){
        Random random = new Random();
        int a = random.nextInt(100)+1;
        return a;
    }

    public static void gamemain(){
        System.out.println("随机数已生产，游戏开始");
        int b = 0;
        do {
            Scanner sc = new Scanner(System.in);
            b = sc.nextInt();
            if (b<prorandom()){
                System.out.println("小了");
            }else if (b>prorandom()){
                System.out.println("大了");
            }else System.out.println("duile");
        }
        while (b !=prorandom() );
    }
}
