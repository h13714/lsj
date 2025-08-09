package test2;

public class Test {
    public static void main(String[] args) {
        String[] salarys = {"1000","2000","3000"};
        Person m1 = new Manager("Manager","001",100000,salarys);
        Person c1 = new Cooker();
        c1.setName("C1");
        c1.setId("002");
        c1.setSalary(Integer.parseInt(salarys[0]));
        m1.work();
        c1.work();
        m1.eat();
        c1.eat();
    }
}
