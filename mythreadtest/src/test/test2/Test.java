package test.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//两个奖箱抽一个奖池，打印抽奖结果和最大值
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个集合
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10,20,30,40,50,60,70,80,90,100);

        //创建多线程运行参数对象
        MyCallable mc = new MyCallable(list);
        //设置管理线程对象
        FutureTask<Integer> ft1 = new FutureTask<>(mc);
        FutureTask<Integer> ft2 = new FutureTask<>(mc);
        //创建线程
        Thread t1 = new Thread(ft1);
        Thread t2 = new Thread(ft2);
        //设置线程名称
        t1.setName("奖箱1");
        t2.setName("奖箱2");
        //启动线程
        t1.start();
        t2.start();

        Integer max1 = ft1.get();
        Integer max2 = ft2.get();

        if (max1 > max2) {
            System.out.println("奖箱1出现最大值:" + max1);
        } else {
            System.out.println("奖箱2出现最大值:" + max2);
        }
    }
}
