package test.demo3;


import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        /**客户端：将本地文件上传到服务器，接收服务器的反馈
         * 创建socket对象
         * 上传文件
         * 接收反馈*/

        //创建对象
        Socket socket = new Socket("127.0.0.1",10000);

        /**创建输出流和输入流
         * 用缓冲流保证效率*/
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src\\provide\\a.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        //上传完毕，通知服务器
        socket.shutdownOutput();

        /**接收服务器的反馈
         * socket提供输入流
         * 转成字符流
         * 用缓冲流提供的readLine方法*/
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str = br.readLine();
        System.out.println(str);

        //关闭流
        socket.close();
        bis.close();



    }
}
