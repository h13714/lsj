package myiotest.myiotest3;

import java.io.*;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) throws IOException {
        //1.读取正确的用户名和密码
        BufferedReader br = new BufferedReader(new FileReader("E:\\Javaworksapce\\Studyfromstart\\myiotest\\src\\myiotest\\myiotest3\\nameinfo.txt"));
        String line = br.readLine();//username=zhangsan&password=123&count=0
        br.close();
        String[] userInfo = line.split("&");
        String[] arr1 = userInfo[0].split("=");
        String[] arr2 = userInfo[1].split("=");
        String[] arr3 = userInfo[2].split("=");

        String rightName = arr1[1];
        String rightPwd = arr2[1];
        int count = Integer.parseInt(arr3[1]);

        //输入信息
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = sc.nextLine();
        System.out.println("请输入密码：");
        String pwd = sc.nextLine();

        //判断并写入文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Javaworksapce\\Studyfromstart\\myiotest\\src\\myiotest\\myiotest3\\nameinfo.txt"));
        if (rightName.equals(name) && rightPwd.equals(pwd) && count < 3) {
            System.out.println("登录成功");
            bw.write("username=" + name + "&password=" + pwd + "&count=" + 0);
        } else {
            System.out.println("登录失败");
            count++;
            if (count < 3) {
                System.out.println("您还有" + (3 - count) + "次机会");
            } else {
                System.out.println("您的账号已被锁定");
            }
            bw.write("username=" + rightName + "&password=" + rightPwd + "&count=" + count);
        }
        bw.close();
    }
}
