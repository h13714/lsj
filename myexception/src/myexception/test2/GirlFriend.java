package myexception.test2;

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
            throw new NameFormatException(name + "有误，姓名长度必须在3-5之间");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18 || age > 30){
            throw new AgeOutOfBoundsException(age + "超出了范围");
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
