package test.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        /**
         服务端：接受多次数据并打印
         创建socket对象
         等待连接
         接受数据
         打印数据
         关闭资源
         */

        ServerSocket ss = new ServerSocket(10000);

        Socket socket = ss.accept();

        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }
        socket.close();
        ss.close();
    }
}
