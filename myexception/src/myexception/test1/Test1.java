package myexception.test1;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GirlFriend gf = new GirlFriend();
        while (true) {
            try {
                System.out.println("Enter name: ");
                String name = sc.nextLine();
                gf.setName(name);
                System.out.println("Enter age: ");
                int age = Integer.parseInt(sc.nextLine());
                gf.setAge(age);
                break;
            } catch (NumberFormatException e) {
                System.out.println("年龄的格式有误");
            } catch (RuntimeException e) {
                System.out.println("姓名或者年龄的长度范围有误");
            }
        }
        System.out.println(gf);
    }
}
