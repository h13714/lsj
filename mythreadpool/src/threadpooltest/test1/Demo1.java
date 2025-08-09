package threadpooltest.test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 线程池测试*/


        /**
        //创建无上限线程池对象
        ExecutorService pool1 = Executors.newCachedThreadPool();

        //提交任务
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());

        //关闭线程池
        //实际应用中，不建议立即关闭线程池，而是等任务执行完毕再关闭
        pool1.shutdown();*/

        /**
         * 固定线程数的线程池*/
        ExecutorService pool2 = Executors.newFixedThreadPool(3);
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());

        //关闭线程池
        pool2.shutdown();
    }
}
