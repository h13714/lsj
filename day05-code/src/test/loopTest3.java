package test;
import java.util.Scanner;

//输入一个整数x，判断质数
public class loopTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x <= 1){
            System.out.println("输入的数不大于1");
            return;
        }
        for(int i = 2; i < x; i++){
            if(x % i ==0){
                System.out.println("不是质数");
                break;
            }
            if(i + 1 == x){
                System.out.println("是质数");
            }
        }
    }
}
