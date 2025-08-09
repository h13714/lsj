package test1;

public class Dog2 extends Dog {
    private String name;

    public Dog2() {
    }

    public Dog2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void play(){
        System.out.println("Playing ");
    }
}
