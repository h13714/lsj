package test8;

//手机号屏蔽
public class stringdemo {
    public static void main(String[] args) {
        String phone = "15717280822";
        String start = phone.substring(0, 3);
        String end = phone.substring(7);
        String phone_new = start + "****" + end;
        System.out.println(phone_new);
    }
}
