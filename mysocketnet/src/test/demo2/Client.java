package test.demo2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        /**客户端：发送一条数据，接受服务端反馈的消息并打印*/
        Socket socket = new Socket("127.0.0.1", 10000);

        //发送数据
        OutputStream os = socket.getOutputStream();
        String str = "hello";
        os.write(str.getBytes());
        //结束标记
        socket.shutdownOutput();

        //接收数据
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }

        os.close();
    }
}
