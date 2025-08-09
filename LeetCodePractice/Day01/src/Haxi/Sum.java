package Haxi;

import java.util.Scanner;
import java.util.Arrays;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入（示例格式：nums = [2,7,11,15]）：");
        String numsInput = scanner.nextLine().replaceAll("\\s+", "");
        System.out.println("输入目标值（示例格式：target = 9）：");
        String targetInput = scanner.nextLine().replaceAll("\\s+", "");

        // 解析数组输入
        int[] nums = Arrays.stream(numsInput.split("[\\[\\]]")[1].split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 解析目标值
        int target = Integer.parseInt(targetInput.split("=")[1]);

        int[] result = twoSum(nums, target);
        System.out.println("输出：[" + result[0] + "," + result[1] + "]");
    }


    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0]; // 题目保证有解，此处仅为编译需要
    }
}

