package mytest;

//拷贝文件夹里的所有文件

import java.io.*;

public class Test1 {
    public static void main(String[] args) throws IOException {

        File file = new File("E:\\Javaworksapce\\Studyfromstart\\myfile");
        File dest = new File("E:\\临时\\dest");
        copyDir(file, dest);
    }

    //获取文件数组
    //判断文件类型
    //如果是文件，直接拷贝
    //如果是文件夹，递归
    private static void copyDir(File file, File dest) throws IOException {
        dest.mkdir();//创建文件夹
        File[] files = file.listFiles();//获取文件数组
        for (File f : files) {//判断文件类型
            if (f.isFile()) {
                //如果是文件，直接拷贝
                //通过字节流拷贝
                FileInputStream fis = new FileInputStream(f);
                FileOutputStream fos = new FileOutputStream(new File(dest, f.getName()));
                byte[] b = new byte[1024];
                int len;
                while((len = fis.read(b)) != -1) {
                    fos.write(b, 0, len);
                }
                fos.close();
                fis.close();
            } else {
                //如果是文件夹，递归
                copyDir(f, new File(dest, f.getName()));
            }
        }
    }
}
