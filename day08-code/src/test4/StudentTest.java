package test4;

import java.util.Objects;

public class StudentTest {
    public static void main(String[] args) {
        Student[] arr = new Student[3];
        arr[0] = new Student("2022900661", "张三", 20);
        arr[1] = new Student("2022900662", "李四", 21);
        arr[2] = new Student("2022900663", "王五", 22);
        Student stu = new Student("2022900664", "赵六", 23);
        Student[] newArr = addStudent(arr, stu);
        printAllStudent(newArr);
        deleteStudentById(newArr,"2022900661");
        printAllStudent(newArr);
        Student student = getStudentById(newArr, "2022900662");
        if (student != null) {
            student.setAge(student.getAge()+1);
        }
    }
    public static Student[] addStudent(Student[] arr, Student stu){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null){
                arr[i] = stu;
                return arr;
            }
        }
        Student[] newArr = new Student[4];
        for(int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
            if(Objects.equals(arr[i].getId(), stu.getId())){
                System.out.println("该学生已存在");
                return arr;
            }
        }
        newArr[arr.length] = stu;
        return newArr;
    }

    //遍历所有学生信息
    public static void printAllStudent(Student[] arr){
        for (Student student : arr) {
            if (student != null) {
                System.out.println(student.toString());
            } else {
                return;
            }
        }
    }

    //通过id删除学生信息
    public static void deleteStudentById(Student[] arr, String id){
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(arr[i].getId(), id)) {
                arr[i] = null;
                return;
            }
        }
        System.out.println("该学生不存在");
    }

    //通过id查找学生信息
    public static Student getStudentById(Student[] arr, String id){
        for (Student student : arr) {
            if (Objects.equals(student.getId(), id)) {
                return student;
            }
        }
        return null;
    }
}

