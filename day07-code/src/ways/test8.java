package ways;

// 随机打乱数组

import java.util.Arrays;
import java.util.Random;

public class test8 {
    public static void main(String[] args) {
        int[] arr = {2,588,888,1000,10000};
        int[] result = rand_arr(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] rand_arr(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--) {
            Random r = new Random();
            int j = r.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

}
