package test2;

import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        Random rand = new Random();
        char c = (char)(rand.nextInt(10) + 48);
        System.out.println(c);
    }
}
