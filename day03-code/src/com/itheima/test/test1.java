package com.itheima.test;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入第一个整数");
        int a = sc.nextInt();
        System.out.println("输入第二个整数");
        int b = sc.nextInt();
        boolean result = a == b || a + b < 10 || a - b > 0;
        System.out.println(result);
    }
}
