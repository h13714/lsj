package test.test1;

import java.util.Random;

public class MyThread extends Thread {
    //定义共享数据
    //100块红包，分成3份，5人抢
    static double money = 100;
    static int count = 3;

    //最小中奖金额
    static final double MIN = 0.01;


    @Override
    public void run() {
        /*
        同步代码块
        判断循环是否结束（未结束）
        判断循环是否结束(结束)
        */

        //同步代码块
        synchronized (MyThread.class) {
            if (count == 0) {//判断循环是否结束(结束)
                System.out.println("抢完了");
            } else {//判断循环是否结束（未结束）
                /*
                 * 判断是否为最后一人
                 * 最后一人不需要随机
                 * 第一个人的最大随机金额为100-（count-1）*0.01*/
                double price = 0;
                //判断是否为最后一人
                if (count == 1) {//最后一人不需要随机
                    price = money;
                } else {//一个人的最大随机金额为100-（count-1）*0.01
                    Random r = new Random();
                    price = r.nextDouble(MIN, money - (count - 1) * MIN);
                }
                money -= price;
                count--;
                System.out.println(getName() + "抢到了" + price + "元");
            }
        }
    }
}
