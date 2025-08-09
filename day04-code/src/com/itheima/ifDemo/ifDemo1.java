package com.itheima.ifDemo;
import java.util.Scanner;

public class ifDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个大于5的整数");
        int number = sc.nextInt();
        if(number > 5){
            System.out.println("正确");
        }
        else {
            System.out.println("错误");
        }
    }
}
