package array;

public class arrayDemo6 {
    public static void main(String[] args) {
        int[] arr = {33,5,22,44,55};
        int x;
        for (int i = 1; i < arr.length; i++) {
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[i]){
                    x = arr[j];
                    arr[j] = arr[i];
                    arr[i] = x;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
