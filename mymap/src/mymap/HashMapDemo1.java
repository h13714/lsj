package mymap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * HashMap存储自定义类型键值
 * Map集合保证key是唯一的：
 * 作为key的元素，必须重写hashCode方法和equals方法，以保证key唯一
 */

public class HashMapDemo1 {
    public static void main(String[] args) {

        //创建一个HashMap集合对象
        HashMap<Student, String> hm = new HashMap<Student, String>();

        Student s1 = new Student("张三", 23);
        Student s2 = new Student("李四", 23);
        Student s3 = new Student("王五", 23);

        hm.put(s1, "北京");
        hm.put(s2, "上海");
        hm.put(s3, "广州");

        Set<Student> keyset = hm.keySet();
        for (Student key : keyset) {
            String value = hm.get(key);
            System.out.println(key + ":" + value);
        }

        System.out.println("----------------------");


        Set<Map.Entry<Student, String>> entries = hm.entrySet();
        for (Map.Entry<Student, String> entry : entries) {
            Student key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }

        System.out.println("----------------------");

        hm.forEach((key, value) -> System.out.println(key + ":" + value));

    }
}
