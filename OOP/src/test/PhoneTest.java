package test;

public class PhoneTest {
    public static void main(String[] args) {
        Phone p1 = new Phone();
        p1.brand = "苹果";
        p1.price = 8388.0;

        Phone p2 = new Phone();
        p2.brand = "华为";
        p2.price = 8388.0;

        p1.call();
        p1.playGame();

        p2.call();
        p2.playGame();
    }
}
