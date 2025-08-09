package mytreemap;
import java.util.TreeMap;

public class TreeMapDemo2 {
    public static void main(String[] args) {
        TreeMap<Student, String> tm = new TreeMap<>();
        tm.put(new Student("zhangsan", 23), "北京");
        tm.put(new Student("lisi", 22), "上海");
        tm.put(new Student("wangwu", 24), "广州");
        tm.put(new Student("zhaoliu", 24), "深圳");

        System.out.println(tm);
    }
}
