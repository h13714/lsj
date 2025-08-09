package myiotest.myiotest1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//网络爬虫获取姓名
//制造假数据
public class Test1 {
    public static void main(String[] args) throws IOException {
        //存放网址
        String FamilyNameNet = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String boyNameNet = "http://www.haoming8.cn/baobao/10881.html";
        String girlNameNet = "http://www.haoming8.cn/baobao/7641.html";

//        获取网址中的所有信息
        String FamilyNameStr = webCrawler(FamilyNameNet);
        String boyNameStr = webCrawler(boyNameNet);
        String girlNameStr = webCrawler(girlNameNet);

        //通过正则表达式获取信息中的姓名
        ArrayList<String> FamilyNameTempList = GetData(FamilyNameStr, "(\\W{4})(，|。)", 1);
        ArrayList<String> boyNameTempList = GetData(boyNameStr, "([\\u4e00-\\u9fa5]{2})(、|。)", 1);
        ArrayList<String> girlNameTempList = GetData(girlNameStr, "((.. ){4}(..))", 0);

        //获取姓氏
        ArrayList<String> FamilyNameList = new ArrayList<>();
        for (String str : FamilyNameTempList) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                FamilyNameList.add(c + "");
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
        ArrayList<String> list = getInfos(FamilyNameList, boyNameList, girlNameList, 10, 10);
        Collections.shuffle(list);
        System.out.println(list);

        //写入文件
        FileWriter fw = new FileWriter("name.txt");
        for (String str : list) {
            fw.write(str+"\r\n");
        }
        fw.close();

    }

    public static ArrayList<String> getInfos(ArrayList<String> FamilyNameList,ArrayList<String> boyNameList,ArrayList<String> girlNameList,int boyNumber,int girlNumber){
        //生成男生姓名
        HashSet<String> boyhs = new HashSet<>();
        while(true){
            if (boyhs.size() == boyNumber){
                break;
            }
            Collections.shuffle(FamilyNameList);
            Collections.shuffle(boyNameList);
            boyhs.add(FamilyNameList.get(0) + boyNameList.get(0));
        }
        //生成女生姓名
        HashSet<String> girlhs = new HashSet<>();
        while(true){
            if (girlhs.size() == girlNumber){
                break;
            }
            Collections.shuffle(FamilyNameList);
            Collections.shuffle(girlNameList);
            girlhs.add(FamilyNameList.get(0) + girlNameList.get(0));
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

    public static ArrayList<String> GetData(String str, String regex, int index) {
        ArrayList<String> list = new ArrayList<>();
        //通过正则表达式获取信息中的姓名
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while (m.find()) {
            list.add(m.group(index));
        }
        return list;
    }

    public static String webCrawler(String net) throws IOException {
//        网址对象
        URL url = new URL(net);

        StringBuilder sb = new StringBuilder();
        //链接上网址
        URLConnection conn = url.openConnection();
        //获取网址中的信息
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        int b;
        while ((b = isr.read()) != -1) {
            sb.append((char) b);
        }
        //关闭资源
        isr.close();

        return sb.toString();
    }
}
