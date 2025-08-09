package test1;

import java.util.ArrayList;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String x = "y";
        while(x.equals("y")){
            Student stu = new Student();
            System.out.println("Enter student name: ");
            stu.setName(sc.next());
            System.out.println("Enter student age: ");
            stu.setAge(sc.nextInt());
            list.add(stu);
            System.out.println("是否继续添加？（y/n）");
            x = sc.next();
        }
        for (Student stu : list) {
            System.out.println(stu.getName() + " " + stu.getAge());
        }
    }
}
