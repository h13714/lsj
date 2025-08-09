package test3;

public class BasketballCoach extends Coach implements PlayingBasketball{
    public BasketballCoach() {
    }

    public BasketballCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("Teaching Basketball");
    }

    @Override
    public void playBasketball() {
        System.out.println("Coach playing basketball");
    }
}
