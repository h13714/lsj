package test7;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        StringBuilder str = new StringBuilder();
        while(a != 0){
            if(a < 100000000){
                int b = a % 10;
                a = a / 10;
                String s = toString(b);
                str.insert(0, s);
            }
            else{
                System.out.println("输入错误");
                return;
            }
        }
        while(str.length() < 8){
            str.insert(0, "零");
        }
        String[] str1 = {"仟","佰","拾","万","仟","佰","拾"};
        //              0   0    0   0    0    1   2    3
        StringBuilder str2 = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(i == str.length() - 1){
                str2.append(str.charAt(i));
                break;
            }
            str2.append(str.charAt(i));
            str2.append(str1[i]);
        }
        str2.toString();
        System.out.println(str2);

    }

    public static String toString(int number){
        String[] str = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        return str[number];
    }
}
