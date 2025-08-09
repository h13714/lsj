package test.demo3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.*;

public class Server {
    public static void main(String[] args) throws IOException {
        /**服务端：接收客户端上传的文件，上传完毕之后给出反馈
         * 创建对象绑定端口
         * 创建输入流接收数据，用缓冲区提高效率
         * 创建输出流写入本地文件
         * 创建输入流读取客户端数据
         * 用缓冲流提高效率*/

        //创建线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,
                16,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        ServerSocket ss = new ServerSocket(10000);

        while (true) {
            Socket socket = ss.accept();

            //创建线程对象,开启线程
            //new Thread(new MyThread(socket)).start();
            pool.submit(new MyThread(socket));
        }


    }
}
