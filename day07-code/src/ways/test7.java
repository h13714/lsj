package ways;

import java.util.Arrays;

public class test7 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 0, 1, 9, 8, 7, 6};
        int[] public_arr = code(arr);

        System.out.println(Arrays.toString(public_arr));

    }


    public static int[] code(int[] arr){
        int x;
        for (int i = 0; i <= arr.length / 2; i++) {
            x = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = x;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] <= 4){//0到9加5的范围是[5,14],[5,9]中的数%10不变，[10,14]的数%10+10
                arr[i] += 10;
            }
            arr[i] -= 5;
        }
        return arr;
    }
}
