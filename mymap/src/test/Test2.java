package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,1,1,1,1,1,1);
        Collections.addAll(list,0,0,0);
        Collections.shuffle(list);

        Random r = new Random();
        int index = r.nextInt(list.size());
        Integer number = list.get(index);


        ArrayList<String> boyList = new ArrayList<>();
        ArrayList<String> girlList = new ArrayList<>();
        Collections.addAll(boyList,"范闲", "范建", "范统", "杜子腾", "宋合泛", "侯笼藤", "朱益群", "朱穆朗玛峰");
        Collections.addAll(girlList, "杜琦燕", "袁明媛", "李猜", "田蜜蜜");

        if(number == 1){
            int index1 = r.nextInt(boyList.size());
            System.out.println(boyList.get(index1));
        }else{
            int index2 = r.nextInt(girlList.size());
            System.out.println(girlList.get(index2));
        }
    }
}
