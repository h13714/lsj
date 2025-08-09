package test2;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        // 打乱数组
        Random rand = new Random();
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        int[][] board = new int[4][4];
        int number = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = arr[number];
                number++;
            }
        }
    }
}
