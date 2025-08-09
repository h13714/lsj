package ways;

import java.util.Random;

public class test5 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(101);
        }

        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            System.out.println(j + "号评委的打分：" + arr[i]);
        }

        double n = score(arr);
        System.out.println("最终得分：" + n);
    }

    public static double score(int[] arr){
        int x = 0;
        int sum = 0;
        int average = 0;
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j + 1]){
                    x = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = x;
                }
            }
        }
        for (int i = 1; i < arr.length - 1; i++) {
            sum += arr[i];
        }
        average = sum / (arr.length - 2);
        return average;
    }
}
