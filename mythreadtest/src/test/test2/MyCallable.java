package test.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    /** 共享数据{10,20,30,40,50,60,70,80,90,100}
     * 注意去重问题
     * 使用集合去重*/
    //定义集合
    ArrayList<Integer> list;

    //在构造方法中添加集合参数，保证数据唯一
    public MyCallable(ArrayList<Integer> list) {
        this.list = list;
    }

    /** 循环
     * 同步代码块
     * 判断集合是否为空
     * 集合不为空，随机抽取一个元素，打印并移除
     * 集合为空，打印集合为空*/

    @Override
    public Integer call() throws Exception {
        //创建一个线程自己的集合用于装自己抽到的奖
        ArrayList<Integer> myList = new ArrayList<>();
        //循环
        while (true) {
            synchronized (MyCallable.class) {
                //判断集合是否为空
                if (list.isEmpty()) {
                    //集合为空
                    //打印自己的集合
                    System.out.println(Thread.currentThread().getName() + "抽到的奖为:" + myList);
                    break;
                } else {
                    //集合不为空，随机抽取一个元素，打印并移除
                    Collections.shuffle(list);
                    int num = list.remove(0);
                    Collections.addAll(myList, num);
                }
            }
        }
        //睡眠10ms
        Thread.sleep(10);

        if(myList.isEmpty()){
            return null;
        }else{
            return Collections.max(myList);
        }
    }
}
