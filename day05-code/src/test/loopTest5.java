package test;

import java.util.Random;
import java.util.Scanner;

public class loopTest5 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int x = r.nextInt(100);
        System.out.println("输入你猜的数字:");
        int count = 0;
        while(true){
            int y = sc.nextInt();
            if(y >x){
                System.out.println("猜大了");
            }
            else if(y < x){
                System.out.println("猜小了");
            }
            else{
                System.out.println("猜对了");
                break;
            }
            count++;
            if(count == 5){
                System.out.println("触发保底");
                break;
            }
        }
    }
}
