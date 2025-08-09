package test9;
//判断一个字符串是否是对称字符串
import java.util.Scanner;
public class stringBuilderDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(str);
        String str_new = sb.reverse().toString();
        if(str.equals(str_new)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
