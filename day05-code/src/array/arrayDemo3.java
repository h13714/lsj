package array;

public class arrayDemo3 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 3 == 0){
                count++;
                System.out.println(arr[i]);
            }
        }
        System.out.println("一共有" + count + "个数被3整除");
        System.out.println(count);
    }
}
