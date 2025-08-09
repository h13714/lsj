package regex;

public class RegexDemo2 {
    public static void main(String[] args) {
        String regex = "0\\d{2,3}-?[1-9]\\d{4,9}";
        String str = "010-123456789";
        System.out.println(str.matches(regex));
    }
}
