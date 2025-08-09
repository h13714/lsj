package ways;

//生成验证码

import java.util.Random;

public class test3 {
    public static void main(String[] args) {
        char[] arr = new char[5];
        Random rand = new Random();

        for(int i = 0; i< 5; i++){
            arr[i] = getRandom(rand);
        }

        arr[4] = (char)(rand.nextInt(10) + 48);

        String s = new String(arr);
        System.out.println("验证码 ：" + s);
}

public static char getRandom(Random rand){
        int type = rand.nextInt(2);
        int base = type == 0? 65 : 97;
        return (char)(base + rand.nextInt(26));
    }
}



/*
char[] arr = new char[5]; // 改为5位数组
        Random random = new Random();

        // 生成前4位字母
        for (int i = 0; i < 4; i++) {
            arr[i] = getRandom(random);
        }
        // 生成第5位数字
        arr[4] = (char) (random.nextInt(10) + 48);

        System.out.println("验证码：" + new String(arr));
    }

    private static char getRandom(Random random) {
        // 生成随机字母（大小写）
        int type = random.nextInt(2); // 0大写，1小写
        int base = type == 0 ? 65 : 97;
        return (char) (random.nextInt(26) + base);
    }
 */

