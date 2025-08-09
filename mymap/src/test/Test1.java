package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        Collections.addAll(list, "a", "b", "c", "d", "e", "f", "g", "h");

//        Random r = new Random();
//
//        int index = r.nextInt(list.size());
//        String s = list.get(index);
//
//        System.out.println(s);

        Collections.shuffle(list);

        String s = list.get(0);
        System.out.println(s);

    }
}
