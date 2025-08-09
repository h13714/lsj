package test;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public void start() {
        ArrayList<Student> list = new ArrayList<>();
        System.out.println("--------欢迎使用菜单系统--------");
        System.out.println("1:添加学生");
        System.out.println("2:删除学生");
        System.out.println("3:修改学生");
        System.out.println("4:查询学生");
        System.out.println("5:退出系统");
        System.out.println("请输入你的选择：");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        while(true){
            switch (choice) {
                case 1:addStudent(list);break;
                case 2:deleteStudent(list);break;
                case 3:updateStudent(list);break;
                case 4:queryStudent(list);break;
                case 5:System.exit(0);break;
                default:System.out.println("输入有误，请重新输入：");break;
            }

            System.out.println("请输入你的选择：");
            choice = sc.nextInt();
        }

    }

    //添加学生
    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        Student stu = new Student();
        System.out.println("请输入学生的学号：");
        stu.setId(sc.next());
        for(Student s : list){
            if(stu.getId().equals(s.getId())){
                System.out.println("学号已存在，请重新输入：");
                stu.setName(sc.next());
            }
        }
        System.out.println("请输入学生的姓名：");
        stu.setName(sc.next());
        System.out.println("请输入学生的年龄：");
        stu.setAge(sc.nextInt());
        System.out.println("请输入学生的地址：");
        stu.setAddress(sc.next());
        list.add(stu);
        System.out.println("添加成功！");
    }

    //删除学生
    public static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生的学号：");
        int id = sc.nextInt();
        for(Student s : list){
            if(s.getId().equals(id)){
                list.remove(s);
                System.out.println("删除成功！");
                return;
            }
        }
        System.out.println("学号不存在");
    }

    //修改学生
    public static void updateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生的学号：");
        int id = sc.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                System.out.println("请输入学生的姓名：");
                list.get(i).setName(sc.next());
                System.out.println("请输入学生的年龄：");
                list.get(i).setAge(sc.nextInt());
                System.out.println("请输入学生的地址：");
                list.get(i).setAddress(sc.next());
                System.out.println("修改成功！");
                return;
            }
        }
        System.out.println("学号不存在");
    }

    //查询学生
    public static void queryStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的学生的学号：");
        int id = sc.nextInt();
        for(Student s : list){
            if(s.getId().equals(id)){
                System.out.println(s.getName());
                System.out.println(s.getAge());
                System.out.println(s.getAddress());
                return;
            }
        }
        System.out.println("学号不存在");
    }

}
