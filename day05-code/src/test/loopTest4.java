package test;
import java.util.Random;

public class loopTest4 {
    public static void main(String[] args) {
        Random r = new Random();
        /*
        int x = r.nextInt(100);//生成[0,99]的随机数
        System.out.println(x);
        System.out.println("\n");
        for (int i = 0; i < 10; i++){
            int y = r.nextInt(100);
            System.out.println(y);
        }
         */
        int x = r.nextInt(100)+1;//生成[1,100]的随机数
        System.out.println(x);
    }
}
