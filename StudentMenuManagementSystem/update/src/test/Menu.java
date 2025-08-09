package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        String[] idList = {"123456789012345678", "123456789012345679", "123456789012345680"};
        System.out.println("--------欢迎使用菜单系统--------");
        System.out.println("1:登录");
        System.out.println("2:注册");
        System.out.println("3:忘记密码");
        System.out.println("4:退出系统");
        System.out.println("请输入你的选择：");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        while (true) {
            switch (choice) {
                case 1:
                    boolean flag = login(list);
                    if (flag) {
                        StudentSystem system = new StudentSystem();
                        system.start();
                    }
                    break;
                case 2:
                    logout(list, idList);
                    break;
                case 3:
                    forgetPassword(list, idList);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误，请重新输入：");
                    break;
            }
            System.out.println("请输入你的选择：");
            choice = sc.nextInt();
        }
    }

    //登录
    public static boolean login(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.next();
        System.out.println("请输入密码:");
        String password = sc.next();
        for (User u : list) {
            if (u.getUsername().equals(username)) {
                if (u.getPassword().equals(password)) {
                    System.out.println("登录成功！");
                    return true;
                } else {
                    System.out.println("密码错误");
                    return false;
                }
            }
        }
        System.out.println("用户名不存在");
        return false;
    }

    //注册
    public static void logout(ArrayList<User> list, String[] idList) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        //用户名
        String username;
        while (true) {
            System.out.println("请输入用户名:");
            username = sc.next();
            if (username.length() < 3 || username.length() > 15) {
                System.out.println("用户名长度必须在3-15之间，请重新输入:");
                continue;
            }
            if (username.matches(".*[^a-zA-Z0-9].*")) {
                System.out.println("用户名只能包含字母和数字，请重新输入:");
                continue;
            }
            if (!username.matches("(?=.*[a-zA-Z])(?=.*[0-9]).+")) {
                System.out.println("用户名必须包含字母和数字，请重新输入:");
                continue;
            }
            boolean flag = true;
            for (User u : list) {
                if (u.getUsername().equals(username)) {
                    System.out.println("用户名已存在，请重新输入:");
                    flag = false;
                    break;
                }
            }
            if(flag){
                user.setUsername(username);
                break;
            }
        }
        //密码
        String password;
        String password2;
        while (true) {
            System.out.println("请输入密码:");
            password = sc.next();
            if (password.length() < 3 || password.length() > 15) {
                System.out.println("密码长度必须在3-15之间，请重新输入");
                continue;
            }
            if (password.matches(".*[^a-zA-Z0-9].*")) {
                System.out.println("密码只能包含字母和数字，请重新输入");
                continue;
            }
            System.out.println("请再次输入密码:");
            password2 = sc.next();
            if(!password2.equals(password)){
                System.out.println("两次输入的密码不一致，请重新输入");
                continue;
            }
            user.setPassword(password);
            break;
        }
        //身份证号
        String idNumber;
        while (true) {
            System.out.println("请输入身份证号:");
            idNumber = sc.next();
            boolean flag = true;
            for(String id : idList){
                if(id.equals(idNumber)){
                    break;
                }
                flag = false;
            }
            if(flag){
                user.setIdNumber(idNumber);
                break;
            }
            System.out.println("身份证号不存在需要重新输入");
        }
        //手机号
        String phoneNumber;
        while (true) {
            System.out.println("请输入手机号:");
            phoneNumber = sc.next();
            if(!phoneNumber.matches(".*[0-9].*")){
                System.out.println("手机号只能包含数字，请重新输入:");
                continue;
            }
            if(phoneNumber.length() != 11){
                System.out.println("手机号长度必须为11位，请重新输入:");
                continue;
            }
            user.setPhoneNumber(phoneNumber);
            break;
        }
        list.add(user);
        System.out.println("注册成功！");
    }

    //忘记密码
    public static void forgetPassword(ArrayList<User> list, String[] idList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.next();
        for (User u : list) {
            if (u.getUsername().equals(username)) {
                System.out.println("请输入身份证号:");
                String idNumber = sc.next();
                if(u.getIdNumber().equals(idNumber)){
                    String password;
                    String password2;
                    while (true) {
                        System.out.println("请输入新密码:");
                        password = sc.next();
                        if (password.length() < 3 || password.length() > 15) {
                            System.out.println("密码长度必须在3-15之间，请重新输入");
                            continue;
                        }
                        if (password.matches(".*[^a-zA-Z0-9].*")) {
                            System.out.println("密码只能包含字母和数字，请重新输入");
                            continue;
                        }
                        System.out.println("请再次输入密码:");
                        password2 = sc.next();
                        if(!password2.equals(password)){
                            System.out.println("两次输入的密码不一致，请重新输入");
                            continue;
                        }
                        u.setPassword(password);
                        break;
                    }
                }
                else{
                    System.out.println("身份证号错误");
                }
            }
        }
        System.out.println("用户名不存在");
    }

}
