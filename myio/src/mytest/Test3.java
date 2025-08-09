package mytest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

//修改文件中的数据
public class Test3 {
    public static void main(String[] args) throws IOException {
        //1.读取文件
        FileReader fr = new FileReader("a.txt");
        int b;
        StringBuilder sb = new StringBuilder();
        while((b = fr.read()) != -1){
            sb.append((char)b);
        }
        fr.close();
        System.out.println(sb);

        //2.修改数据
        Integer[] arr = Arrays.stream(sb.toString()
                .split("-"))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);

        //3.写入文件
        FileWriter fw = new FileWriter("a.txt");
//        String s = Arrays.toString(arr)
//                .replace(" ","")
//                .replace(",", "-");
//        String result = s.substring(1, s.length() - 1);
        String result = String.join("-", Arrays.stream(arr)
                .map(String::valueOf)
                .toArray(String[]::new));
        fw.write(result);
        fw.close();
    }
}
