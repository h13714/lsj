package threadpooltest.test1;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程池测试");
    }
}
