package test8;

public class stringDemo1 {
    public static void main(String[] args) {
        String str = "20229006622";
        String time = str.substring(0,4);
        String num = str.substring(4,10);
        String gender = str.substring(10);
        int genderNum = gender.charAt(0) - 48;
        if(genderNum % 2 == 0){
            System.out.println("time:" + time + " num:" + num + " gender:" + "男");
        }
        else{
            System.out.println("time:" + time + " num:" + num + " gender:" + "女");
        }
    }
}
