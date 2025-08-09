package myobjectstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e.txt"));

        ArrayList<Student> list = (ArrayList<Student>) ois.readObject();

        ois.close();

        System.out.println(list);
    }
}
