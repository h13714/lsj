package test6;
import java.util.Scanner;

public class StringCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] ch = s.toCharArray();
        int ccount = 0;
        int vcount = 0;
        int icount = 0;
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] >= 65 && ch[i] <= 90){
                ccount++;
            }
            else if(ch[i] >= 97 && ch[i] <= 122){
                vcount++;
            }
            else if(ch[i] >= 48 && ch[i] <= 57){
                icount++;
            }
        }
        System.out.println(ccount);
        System.out.println(vcount);
        System.out.println(icount);
    }
}
