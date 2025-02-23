package com.work.sushu;

public class Findsushu {
    public static void main(String[] args) {
        int count = 0;
        for (int number = 101; number <=200 ; number++) {
            if (isprime(number)){
                System.out.println(number);
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isprime(int number){
        for (int i = 2; i <=Math.sqrt(number) ; i++) {
            if (number%i==0){
                return false;
            }
        }
        return true;
    }

}
