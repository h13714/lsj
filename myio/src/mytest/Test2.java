package mytest;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//文件的加密和还原
public class Test2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\Game\\M系\\copy.txt");
        FileOutputStream fos = new FileOutputStream("E:\\Game\\M系\\copy2.txt");
        int b;
        while((b = fis.read()) != -1){
            fos.write(b ^ 2);//异或2次，还原(了解异或原理)
        }
        fis.close();
        fos.close();
    }
}
