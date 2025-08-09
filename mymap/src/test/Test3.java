package test;

import java.util.ArrayList;
import java.util.Collections;

public class Test3 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1,"范闲", "范建", "范统", "杜子腾", "宋合泛", "侯笼藤", "朱益群", "朱穆朗玛峰");
        ArrayList<String> list2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            System.out.println("-----------------------");
            while (!list1.isEmpty()) {
                Collections.shuffle(list1);
                String name = list1.remove(0);
                list2.add(name);
                System.out.println(name);
            }

            list1.addAll(list2);
            list2.clear();
        }



    }
}
