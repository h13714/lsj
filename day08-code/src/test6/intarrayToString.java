package test6;

import java.util.Arrays;

public class intarrayToString {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        StringBuilder sb = new StringBuilder("[");
        for(int i :arr){
            sb.append(i);
            if(i < arr.length){
                sb.append(",");
            }
        }
        sb.append("]");
        String s = sb.toString();
        System.out.println(s);
    }
}
