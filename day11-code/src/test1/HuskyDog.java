package test1;

public class HuskyDog extends Dog {
    @Override
    public void eat() {
        System.out.println("一只叫" + getName() + "," + getAge() +"的哈士奇在吃骨头，边吃边拆家");
    }
}
