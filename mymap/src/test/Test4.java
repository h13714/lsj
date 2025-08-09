package test;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> mp = new HashMap<>();

        ArrayList<String> city1 = new ArrayList<>();
        city1.add("南京市");
        city1.add("扬州市");
        city1.add("苏州市");
        city1.add("无锡市");
        city1.add("常州市");

        ArrayList<String> city2 = new ArrayList<>();
        city2.add("武汉市");
        city2.add("孝感市");
        city2.add("十堰市");
        city2.add("宜昌市");
        city2.add("鄂州市");

        ArrayList<String> city3 = new ArrayList<>();
        city3.add("石家庄市");
        city3.add("唐山市");
        city3.add("邢台市");
        city3.add("保定市");
        city3.add("张家口市");

        mp.put("江苏省", city1);
        mp.put("湖北省", city2);
        mp.put("河北省", city3);

        Set<Map.Entry<String, ArrayList<String>>> entries = mp.entrySet();
        for (Map.Entry<String, ArrayList<String>> entry : entries) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            StringJoiner sj = new StringJoiner(",","","");
            for (String s : value) {
                sj.add(s);
            }
            System.out.println(key + " = " + sj);
        }
    }
}
