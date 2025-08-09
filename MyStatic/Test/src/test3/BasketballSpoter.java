package test3;

public class BasketballSpoter extends Spoter implements PlayingBasketball {
    public BasketballSpoter() {
    }

    public BasketballSpoter(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("Study BasketballSpoter");
    }

    @Override
    public void playBasketball() {
        System.out.println("Spoter playing basketball");
    }
}
