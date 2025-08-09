package test;

import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] x = arrayCopy(arr,a,b);
        System.out.print("[");
        for (int i = 0; i < x.length; i++) {
            if (i < x.length - 1) {
                System.out.print(x[i] + ",");
            }
            else{
                System.out.println(x[i] + "]");
            }
        }
    }

    public static int[] arrayCopy(int[] arr,int a,int b){
        int[] arr2 = new int[b-a+1];
        for (int i = 0; i < b-a+1; i++) {
            arr2[i] = arr[a + i - 1];
        }
        return arr2;
    }
}
