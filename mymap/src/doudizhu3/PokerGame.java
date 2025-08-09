package doudizhu3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


public class PokerGame {
    //准备牌
    static ArrayList<String> list = new ArrayList<>();

    //定义一个静态的map集合，用来存储牌的牌的值
    static HashMap<String, Integer> hm = new HashMap<>();


    static {
        String[] colors = {"♦", "♣", "♥", "♠"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        for (String color : colors) {
            for (String number : numbers) {
                list.add(color + number);
            }
        }
        list.add(" 小王");
        list.add(" 大王");

        hm.put("J", 11);
        hm.put("Q", 12);
        hm.put("K", 13);
        hm.put("A", 14);
        hm.put("2", 15);
        hm.put("小王", 50);
        hm.put("大王", 100);
    }

    public PokerGame() {
        //洗牌
        Collections.shuffle(list);

        //发牌
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (i <= 2) {
                lord.add(list.get(i));
            } else if (i % 3 == 0) {
                player1.add(list.get(i));
            } else if (i % 3 == 1) {
                player2.add(list.get(i));
            } else {
                player3.add(list.get(i));
            }
        }

        //排序
        order(lord);
        order(player1);
        order(player2);
        order(player3);

        //看牌
        lookPoker("底牌", lord);
        lookPoker("玩家1", player1);
        lookPoker("玩家2", player2);
        lookPoker("玩家3", player3);


    }

    public void order(ArrayList<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //获取牌的值
                String color1 = o1.substring(0, 1);
                int value1 = getValue(o1);

                String color2 = o2.substring(0, 1);
                int value2 = getValue(o2);

                int result = value1 - value2;

                return result == 0 ? o1.compareTo(color2) : result;
            }
        });
    }

    //定义一个方法，用来获取牌的值
    public int getValue(String poker){
        String number = poker.substring(1);
        if (hm.containsKey(number)){
            return hm.get(number);
        }else{
            return Integer.parseInt(number);
        }
    }

    public void lookPoker(String name,ArrayList<String> list){
        System.out.print(name + " ：" );
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
