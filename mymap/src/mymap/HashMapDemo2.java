package mymap;

import java.util.*;





public class HashMapDemo2 {
    public static void main(String[] args) {
        String[] arr = {"A","B","C","D"};
        ArrayList<String> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            int index = r.nextInt(arr.length);
            list.add(arr[index]);
        }

        HashMap<String, Integer> hm = new HashMap<>();
        for (String s : list) {
            if(hm.containsKey(s)) {
                Integer count = hm.get(s);
                count++;
                hm.put(s, count);
            }else{
                hm.put(s,1);
            }
        }

        Set<Map.Entry<String, Integer>> entries = hm.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "=" + value);
        }

        int max = 0;

        for (Map.Entry<String, Integer> entry : entries) {
            Integer value = entry.getValue();
            if(value > max) {
                max = value;
            }
        }

        for (Map.Entry<String, Integer> entry : entries) {
            Integer value = entry.getValue();
            if(value == max) {
                System.out.println(entry.getKey());
            }
        }

    }
}
