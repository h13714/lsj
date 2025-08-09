package doudizhu.util;

import java.util.ArrayList;
import java.util.Random;

public class CodeUtil {

    public static String getCode(){
      //自己练习
        //创建一个集合用来装验证码
        ArrayList<Character> list = new ArrayList<>();
        //添加验证码
        //添加大写字母
        for (int i = 0; i < 26; i++) {
            list.add((char)('A'+i));
        }
        //添加小写字母
        for (int i = 0; i < 26; i++) {
            list.add((char)('a'+i));
        }
        //添加数字
        for (int i = 0; i < 10; i++) {
            list.add((char)(48+i));
        }
        //包含大小写A-Z和数字0-9
        //字母4个，数字1个
        //字母和数字的位置是随机的。
        Random r = new Random();
        String code = "";
        //添加一个大写字母
        char s1 = list.get(r.nextInt(26));
        code += s1;
        //添加3个随机字母
        for (int i = 0; i < 3; i++) {
            code += list.get(r.nextInt(52));
        }
        //添加数字
        code += list.get(r.nextInt(52)+10);

        //将字符转转成字符数组
        char[] arr = code.toCharArray();
        //随机打乱数组
        int count = 0;
        for (int i = arr.length; i > 0; i--) {
            int random = r.nextInt(arr.length - count);
            char temp = arr[random];
            arr[random] = arr[i];
            arr[i] = temp;
            count++;
        }
        //将字符数组转成字符串
        code = String.valueOf(arr);

        return code;
    }
}