package test1;

public class Dog1 extends Dog {
    private String name;

    public Dog1() {
    }

    public Dog1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void breakHouse(){
        System.out.println("breakHouse");
    }
}
