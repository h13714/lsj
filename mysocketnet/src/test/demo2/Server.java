package test.demo2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        /**服务端：接收数据并打印，再给客户端反馈消息*/
        ServerSocket ss = new ServerSocket(10000);

        Socket socket = ss.accept();

        //接收数据
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }

        //发送数据
        OutputStream os = socket.getOutputStream();
        String str = "nihao";
        os.write(str.getBytes());


        os.close();
        socket.close();
        ss.close();
    }
}
