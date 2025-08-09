package myfile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        File file = new File("E:\\临时");
        HashMap<String, Integer> map = getCount(file);
        System.out.println(map);
    }

    /*
    获得文件夹
    判断文件
    统计文件数量
    递归
     */
    public static HashMap<String,Integer> getCount(File file){
        HashMap<String,Integer> hm = new HashMap<>();
        File[] files = file.listFiles();
        if (files != null){
            for (File f : files){
                if(f.isFile()){//是文件
                    //获得文件后缀和大小
                    String src = f.getName();
                    String[] arr = src.split("\\.");
                    if(arr.length >= 2){
                        String name = arr[arr.length - 1];
                        if(hm.containsKey(name)){
                            hm.put(name,hm.get(name) + 1);
                        }else{
                            hm.put(name,1);
                        }
                    }
                }else{//是文件夹
                    HashMap<String, Integer> map = getCount(f);
                    Set<Map.Entry<String, Integer>> entries = map.entrySet();
                    for (Map.Entry<String, Integer> entry : entries) {
                        String key = entry.getKey();
                        Integer value = entry.getValue();
                        if(hm.containsKey(key)){
                            hm.put(key,hm.get(key) + value);
                        }else{
                            hm.put(key,value);
                        }
                    }
                }
            }
        }
        return hm;
    }
}
