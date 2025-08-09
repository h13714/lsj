package test;

public class test2 {
    public static void main(String[] args) {
        int[] arr = {11,22,33,44,55};
        int max = max(arr);
        System.out.println(max);
    }

    public static int max(int[] arr){
        int count = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i] > count){
                count = arr[i];
            }
        }
        return count;
    }
}
