package test;
import java.util.Scanner;

//输入一个大于2的整数x，计算并返回x的平方根，结果只保留整数部分，小数部分将被舍去。
public class loopTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x <= 2){
            System.out.println("输入的数不大于2");
            return;
        }
        for(int i = 1; i <= Math.sqrt(x); i++){
            if( i + 1 > Math.sqrt(x)){
                System.out.println(i);
                break;
            }
        }
    }
}
