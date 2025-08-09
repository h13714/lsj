package regex;

public class RegexDemo3 {
    public static void main(String[] args) {
        String regex = "\\w+@[\\w^_]{2,6}(\\.[a-zA-Z]{2,3}){1,2}";
        System.out.println("3486922838@qq.com".matches(regex));
    }
}
