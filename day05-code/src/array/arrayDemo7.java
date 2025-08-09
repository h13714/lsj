package array;
import java.util.Random;

public class arrayDemo7 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100) + 1;
            sum += arr[i];
        }
        System.out.println("sum = " + sum);
        System.out.println("average = " + sum / arr.length);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < sum / arr.length){
                count++;
            }
        }
        System.out.println("一共有" + count + "个数小于平均值");
    }
}
