package test5;
import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        User user = new User("h13714","2022900662");
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 3; i++){
            System.out.println("用户名:");
            String username = sc.nextLine();
            System.out.println("密码:");
            String password = sc.nextLine();
            if(username.equals(user.getUsername())){
                if(password.equals(user.getPassword())){
                    System.out.println("登录成功");
                    break;
                }
                else{
                    System.out.println("密码错误");
                }
            }else{
                System.out.println("用户名错误"); }
        }
    }
}
