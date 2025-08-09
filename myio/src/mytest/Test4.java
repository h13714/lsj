package mytest;

import java.io.*;
import java.util.TreeMap;

//利用字符缓冲流读取和写入数据并排序
public class Test4 {
    public static void main(String[] args) throws IOException {

        //创建写入流
        BufferedReader br = new BufferedReader(new FileReader("b.txt"));
        //读取数据
        String line;
        TreeMap <Integer,String> mp = new TreeMap<>();
        while((line = br.readLine()) != null) {
            mp.put(Integer.parseInt(line.split("\\.")[0]),line);
        }
        //关闭流
        br.close();

        //写入数据
        //创建写入流
        BufferedWriter bw = new BufferedWriter(new FileWriter("c.txt"));
        //写入数据
        for (Integer key : mp.keySet()) {
            bw.write(mp.get(key));
            bw.newLine();
        }
        //关闭流
        bw.close();
    }


}
