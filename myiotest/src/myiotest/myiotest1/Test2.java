package myiotest.myiotest1;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        //存放网址
        String familyNameNet = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String boyNameNet = "http://www.haoming8.cn/baobao/10881.html";
        String girlNameNet = "http://www.haoming8.cn/baobao/7641.html";

        //获取网页内容
        String familyNameStr = HttpUtil.get(familyNameNet);
        String boyNameStr = HttpUtil.get(boyNameNet);
        String girlNameStr = HttpUtil.get(girlNameNet);


        //正则表达式获取姓名信息
        List<String> familyNameTempList = ReUtil.findAll("(\\W{4})(，|。)", familyNameStr, 1);
        List<String> boyNameTempList = ReUtil.findAll("([\\u4e00-\\u9fa5]{2})(、|。)", boyNameStr, 1);
        List<String> girlNameTempList = ReUtil.findAll("((.. ){4}(..))", girlNameStr, 0);

        //获取姓氏
        ArrayList<String> familyNameList = new ArrayList<>();
        for (String str : familyNameTempList) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                familyNameList.add(c + "");
            }
        }

        //获取男生名字
        ArrayList<String> boyNameList = new ArrayList<>();
        for (String str : boyNameTempList) {
            if (!boyNameList.contains(str)){
                boyNameList.add(str);
            }
        }

        //获取女生名字
        ArrayList<String> girlNameList = new ArrayList<>();
        for (String str : girlNameTempList) {
            String[] arr = str.split(" ");
            for (String s : arr) {
                girlNameList.add(s);
            }
        }

        //生成数据
        ArrayList<String> list = getInfos(familyNameList, boyNameList, girlNameList, 10, 10);
        Collections.shuffle(list);
        System.out.println(list);

        //写入文件
        FileUtil.writeLines(list,"name.txt","UTF-8");

    }

    public static ArrayList<String> getInfos(ArrayList<String> familyNameList,ArrayList<String> boyNameList,ArrayList<String> girlNameList,int boyNumber,int girlNumber){
        //生成男生姓名
        HashSet<String> boyhs = new HashSet<>();
        while(true){
            if (boyhs.size() == boyNumber){
                break;
            }
            Collections.shuffle(familyNameList);
            Collections.shuffle(boyNameList);
            boyhs.add(familyNameList.get(0) + boyNameList.get(0));
        }
        //生成女生姓名
        HashSet<String> girlhs = new HashSet<>();
        while(true){
            if (girlhs.size() == girlNumber){
                break;
            }
            Collections.shuffle(familyNameList);
            Collections.shuffle(girlNameList);
            girlhs.add(familyNameList.get(0) + girlNameList.get(0));
        }

        //合并姓名
        Random r = new Random();
        ArrayList<String> list = new ArrayList<>();
        for (String str : boyhs) {
            int age = r.nextInt(10) + 18;
            list.add(str + "-男-" + age);
        }
        for (String str : girlhs) {
            int age = r.nextInt(7) + 18;
            list.add(str + "-女-" + age);
        }
        return list;
    }
}
