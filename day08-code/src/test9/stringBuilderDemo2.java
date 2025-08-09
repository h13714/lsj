package test9;
//拼接字符串
public class stringBuilderDemo2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1){
                sb.append(arr[i]);
                break;
            }
            sb.append(arr[i]).append(",");
        }
        sb.append("]");
        String s = sb.toString();
        System.out.println(s);
    }
}
