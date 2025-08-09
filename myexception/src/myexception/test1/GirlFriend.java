package myexception.test1;

public class GirlFriend {
    private String name;
    private int age;

    public GirlFriend(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public GirlFriend() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        int len = name.length();
        if (len <3 || len > 5){
            throw new RuntimeException();
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18 || age > 30){
            throw new RuntimeException();
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
