package test10;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String a = "abcde";
        String b = sc.nextLine();
        if(a.length() != b.length()){
            System.out.println("No");
            return;
        }
        if(a.equals(b)){
            System.out.println("Yes");
            return;
        }
        String c;
        String[] x = new String[b.length()];
        for (int i = 0; i < b.length(); i++) {
            x[i] = String.valueOf(b.charAt(i));
        }
        for (int i = 0; i < b.length()/2; i++) {
            c = x[i];
            x[i] = x[b.length()-i-1];
            x[b.length()-i-1] = c;
            for (String s : x) {
                sb.append(s);
            }
            if(sb.toString().equals(a)){
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
