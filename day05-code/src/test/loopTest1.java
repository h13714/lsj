package test;
//import java.util.Scanner;

public class loopTest1 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 7 || i % 7 == 0 || i / 10 % 10 == 7){
                System.out.println("过");
            }
            else{
                System.out.println(i);
            }
        }
    }
}
