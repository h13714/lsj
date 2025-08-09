package mytest;

import java.io.*;

//判断文件运行次数
public class Test5 {
    public static void main(String[] args) throws IOException {
        //获取流
        BufferedReader br = new BufferedReader(new FileReader("d.txt"));
        int count = Integer.parseInt(br.readLine());
        br.close();

        count++;
        //判断次数
        if(count > 3){
            System.out.println("文件已被运行3次");
            return;
        }else{
            System.out.println("文件运行次数为：" + count);
        }

        //写入
        BufferedWriter bw = new BufferedWriter(new FileWriter("d.txt"));
        bw.write(count + "");
        bw.close();
    }
}
