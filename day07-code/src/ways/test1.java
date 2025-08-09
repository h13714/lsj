package ways;

import java.util.Scanner;


public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入机票原价：");
        double price = sc.nextDouble();
        System.out.println("输入月份: ");
        int month = sc.nextInt();
        System.out.println("输入舱室类型：");
        int type = sc.nextInt();
        calculate(price, month, type);
    }

    public static void calculate(double price, int month, int type){
        if(type == 1){
            if(month >= 5 && month <=10){
                System.out.println("机票最终价格为：" + price * 0.9);
            }
            if(month >=11 && month <= 12 || month >= 1 && month <= 4){
                System.out.println("机票最终价格为：" + price * 0.7);
            }
            else{
                System.out.println("输入错误");
            }
        }
        else if(type == 0){
            if(month >= 5 && month <=10){
                System.out.println("机票最终价格为：" + price * 0.85);
            }
            if(month >=11 && month <= 12 || month >= 1 && month <= 4){
                System.out.println("机票最终价格为：" + price * 0.65);
            }
            else{
                System.out.println("输入错误");
            }
        }
        else{
            System.out.println("输入错误");
        }

    }
}
