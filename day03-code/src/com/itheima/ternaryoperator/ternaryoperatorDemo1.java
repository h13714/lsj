package com.itheima.ternaryoperator;
import java.util.Scanner;

public class ternaryoperatorDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int max = number1 > number2 ? number1 : number2;
        System.out.println(max);
    }
}
