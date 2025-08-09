package test2;

public class Manager extends Person{
    private String[] salarys;

    public Manager() {

    }

    public Manager(String[] salarys) {
        this.salarys = salarys;
    }

    public Manager(String name, String id, int salary, String[] salarys) {
        super(name, id, salary);
        this.salarys = salarys;
    }

    public String[] getSalarys() {
        return salarys;
    }

    public void setSalarys(String[] salarys) {
        this.salarys = salarys;
    }

    @Override
    public void work(){
        System.out.println("Manage other people");
    }

    @Override
    public void eat(){
        System.out.println("Eat rice");
    }
}
