package test8;

//屏蔽敏感词
public class stringDemo2 {
    public static void main(String[] args) {
        String talk = "我很讨厌lgbt和sb";
        String[] arr = {"lgbt","sb"};
        for (String s : arr) {
            talk = talk.replace(s, "***");
        }
        System.out.println(talk);
    }
}
