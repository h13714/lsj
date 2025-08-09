package myfile;

import java.io.File;

public class Test1 {
    public static void main(String[] args) {

        findAVI();
    }


    public static void findAVI(){
        File[] arr = File.listRoots();
        for (File f : arr) {
            findAVI(f);
        }
    }

    /*
    递归
    1.获得所有文件
    2.判断文件
    3.打印
    4.递归
     */
    public static void findAVI(File file){
        File[] files = file.listFiles();
        if(files != null){
            for (File f : files) {
                if (f.isFile() && f.getName().endsWith(".txt")) {
                    System.out.println(f.getName());;
                }else{
                    findAVI(f);//递归
                }
            }
        }
    }
}
