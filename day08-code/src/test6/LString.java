package test6;
import java.util.Scanner;

public class LString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length/2; i++){
            char temp = ch[i];
            ch[i] = ch[ch.length-1-i];
            ch[ch.length-1-i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ch.length;i++){
            sb.append(ch[i]);
        }
        String s1 = sb.toString();
        System.out.println(s1);
    }
}
