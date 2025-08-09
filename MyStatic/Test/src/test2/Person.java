package test2;

public class Person {
    private String name;
    private String id;
    private int salary;

    public Person() {
    }

    public Person(String name, String id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName(String cooker) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId(String number) {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void eat(){
        System.out.println("eat");
    }

    public void work(){
        System.out.println("work");
    }
}
