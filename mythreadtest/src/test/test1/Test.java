package test.test1;

//100块红包，分成3份，5人抢

public class Test {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();
        MyThread t5 = new MyThread();
        t1.setName("张三");
        t2.setName("李四");
        t3.setName("王五");
        t4.setName("赵六");
        t5.setName("孙七");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
