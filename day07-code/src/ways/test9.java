package ways;

//双色球中奖号码
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class test9 {
    public static void main(String[] args) {
        int[] my_arr = rand_arr();
        int[] user_arr = input_arr();
        int[] result = print_arr(my_arr,user_arr);
        System.out.println("中奖号码为: " + Arrays.toString(my_arr));
        System.out.println("中红球" + result[0] + "个，" + "中蓝球" + result[1] + "个");
        int prize = prize(result);
        System.out.println("中奖金额为: " + prize + "元");

    }

    //随机生成中奖号码
    public static int[] rand_arr(){

        Random rand = new Random();
        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1){
                arr[i] = rand.nextInt(16) + 1;
                break;
            }
            arr[i] = rand.nextInt(33) + 1;
        }
        return arr;
    }

    //输入用户号码
    public static int[] input_arr(){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];
        for(int i = 0; i < arr.length; i++){
            if(i == arr.length - 1){
                System.out.println("输入第" + (i + 1) + "个号码 （ 1 - 16 ）:");
                arr[i] = sc.nextInt();
                break;
            }
            System.out.println("输入第" + (i + 1) + "个号码（ 1 - 33 ）:");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    //比较中奖号码
    public static int[] print_arr(int[] arr1,int[] arr2){
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            if(i == arr1.length - 1){
                if(arr1[i] == arr2[i]){
                    count2 += 1;
                }
                break;
            }
            else if(arr1[i] == arr2[i]){
                count1 += 1;
            }
        }
        return new int[]{count1, count2};
    }

    //计算奖金
    public static int prize(int[] arr){
        int prize = 0;
        if(arr[1] == 1){
            if(arr[0] <= 1){
                prize = 5;
            }
            else if(arr[0] <= 3){
                prize = 10;
            }
            else if(arr[0] == 4){
                prize = 200;
            }
            else if(arr[0] == 5){
                prize = 3000;
            }
            else if(arr[0] == 6){
                prize = 10000000;
            }
        }
        else{
            if(arr[0] <= 3){
                return 0;
            }
            else if(arr[0] == 4){
                prize = 10;
            }
            else if(arr[0] == 5){
                prize = 200;
            }
            else if(arr[0] == 6){
                prize = 5000000;
            }
        }
        return prize;
    }

}


