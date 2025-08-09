package mytreemap;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo1 {
    public static void main(String[] args) {
        TreeMap<Integer, String> tm = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        tm.put(1, "one");
        tm.put(2, "two");
        tm.put(3, "three");
        tm.put(4, "four");

        Set<Integer> integers = tm.keySet();
        for(Integer i : integers) {
            System.out.println(i + " : " + tm.get(i));
        }
    }
}
