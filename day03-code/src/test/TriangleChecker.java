package test;

import java.util.Scanner;

public class TriangleChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入第一个正整数: ");
        int a = scanner.nextInt();

        System.out.print("请输入第二个正整数: ");
        int b = scanner.nextInt();

        System.out.print("请输入第三个正整数: ");
        int c = scanner.nextInt();

        if (a + b > c && a + c > b && b + c > a) {
            System.out.println(a + " " + b + " " + c);
        } else {
            System.out.println("不能构成三角形");
        }

        scanner.close();
    }
}
