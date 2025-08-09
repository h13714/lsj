package test;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        isExist(arr);
    }

    public static boolean isExist(int[] arr){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num){
                System.out.println("存在");
                return true;
            }
        }
        System.out.println("不存在");
        return false;
    }
}
