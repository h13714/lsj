package regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexDemo1 {
    public static void main(String[] args) {
        String str = "15971884162";
        String regex = "1[3-9]\\d{9}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        //boolean b = m.matches();
        while(m.find()){
            System.out.println(m.group());
        }
        //System.out.println(b);
    }
}
