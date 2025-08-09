package myexception.test2;

import myexception.test1.GirlFriend;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        myexception.test2.GirlFriend gf = new myexception.test2.GirlFriend();
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
                e.printStackTrace();
            } catch (NameFormatException e) {
                e.printStackTrace();
            } catch (AgeOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        System.out.println(gf);
    }
}
