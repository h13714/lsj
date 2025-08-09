package ways;

import java.util.Arrays;

public class test6 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int[] privet_arr = code(arr);

        System.out.println(Arrays.toString(privet_arr));

    }


    public static int[] code(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + 5;
            arr[i] = arr[i] % 10;
        }
        int x = 0;
        for (int i = 0; i <= arr.length / 2; i++) {
            x = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = x;
        }
        return arr;
    }
}
