package test10;
//转换罗马数字
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        StringBuilder sb = new StringBuilder();
        String s = sc.nextLine();
        String[] x = {" ", "Ⅰ","Ⅱ","Ⅲ","Ⅳ", "Ⅴ", "Ⅵ","Ⅶ","Ⅷ","Ⅸ"};
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                System.out.println("Invalid input");
                return;
            }
            sb.append(x[s.charAt(i) - 48]);
        }
        System.out.println(sb.toString());
    }
}
