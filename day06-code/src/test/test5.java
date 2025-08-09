package test;

import java.util.Random;

public class test5 {
    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt(3)+1;
        System.out.println(num);
    }
}
