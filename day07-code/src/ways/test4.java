package ways;

import java.util.Arrays;

public class test4 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {5,6,7,8};
        int[] arr = add(arr1, arr2);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] add(int[] arr1, int arr2[]){
        int[] arr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arr[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr[arr1.length + i] = arr2[i];
        }
        return arr;
    }
}
