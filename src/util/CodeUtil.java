package util;
import java.util.ArrayList;
import java.util.Random;

//生成验证码
public class CodeUtil {
    public static String getCode(){
        ArrayList<Character> list = new ArrayList<>();
        //在集合中添加字母
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i));
            list.add((char)('A' + i));
        }
        //随机四个字母组成一个字符串
        Random r = new Random();
        String code = "";
        for (int i = 0; i < 4; i++) {
            code += list.get(r.nextInt(list.size()));
        }
        //随机添加一个数字
        code += (char)(r.nextInt(10) + 48);
        //将字符转转成字符数组
        char[] arr = code.toCharArray();
        //随机一个位置与数字交换
        int p = r.nextInt(arr.length);
        char temp = arr[p];
        arr[p] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
        //将字符数组转成字符串
        code = String.valueOf(arr);
        return code;
    }
}
