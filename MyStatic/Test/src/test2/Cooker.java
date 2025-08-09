package test2;

public class Cooker extends Person {
    @Override
    public void work() {
        System.out.println("Cook food");
    }
    @Override
    public void eat() {
        System.out.println("Eat rice");
    }
}
