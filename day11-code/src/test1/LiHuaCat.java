package test1;

public class LiHuaCat extends Cat {
    @Override
    public void eat() {
        System.out.println("一只叫" + getName() + "," + getAge() +"的狸花猫在吃鱼");
    }
}
