package doudizhu2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {

    //准备牌
    static HashMap<Integer, String> hm = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    static{
        int index = 1;
        String[] colors = {"♦", "♣", "♥", "♠"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        for (String n : numbers) {
            for (String c : colors) {
                hm.put(index, c + n);
                list.add(index);
                index++;
            }
        }
        hm.put(index, "小王");
        list.add(index);
        index++;
        hm.put(index, "大王");
        list.add(index);
    }

    public PokerGame() {
        //洗牌
        Collections.shuffle(list);

        //发牌
        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            int index = list.get(i);
            if (i <= 2) {
                lord.add(index);
            } else if (i % 3 == 0) {
                player1.add(index);
            } else if (i % 3 == 1) {
                player2.add(index);
            } else {
                player3.add(index);
            }
        }

        //看牌
        lookPoker("底牌", lord);
        lookPoker("player1", player1);
        lookPoker("player2", player2);
        lookPoker("player3", player3);

    }

    public void lookPoker(String name, TreeSet<Integer> list){
        System.out.print(name + ": ");
        for (Integer i : list) {
            System.out.print(hm.get(i) + " ");
        }
        System.out.println();
    }

}
