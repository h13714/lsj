package myobjectstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) throws IOException {
        Student s1 = new Student("北京", "张三", 18);
        Student s2 = new Student("北京", "李四", 19);
        Student s3 = new Student("北京", "王五", 20);
        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        //序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e.txt"));
        oos.writeObject(list);

        oos.close();
    }
}
