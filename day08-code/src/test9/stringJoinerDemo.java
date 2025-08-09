package test9;

import java.util.StringJoiner;
import java.util.Scanner;

public class stringJoinerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringJoiner sj = new StringJoiner(",","[","]");
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            sj.add(String.valueOf(str.charAt(i)));
        }
        String s = sj.toString();
        System.out.println(s);
    }
}
