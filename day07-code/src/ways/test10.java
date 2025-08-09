package ways;

public class test10 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{22,66,44},{77,33,88},{77,33,88},{11,66,99}};
        int result = print_arr(arr);;
        System.out.println("全年营业额为: " + result);
    }

    public static int print_arr(int[][] arr) {
        int count = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(j == arr[i].length - 1){
                    count +=arr[i][j];
                    System.out.println("第" + (i + 1) + "季度的营业额: " + count);
                    sum += count;
                    count = 0;
                }
                count += arr[i][j];
            }
        }
        return sum;
    }
}
