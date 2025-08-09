package test1;
import java.util.ArrayList;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("user1", "password1", "2022900661"));
        list.add(new User("user2", "password2", "2022900662"));
        list.add(new User("user3", "password3", "2022900663"));
        Scanner sc = new Scanner(System.in);
//        boolean flag;
        System.out.println("Enter the number of id");
        String id = sc.nextLine();
        User user = checkId(list,id);
        if (user!=null){
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
        }
//        System.out.println(flag);
    }

    public static User checkId(ArrayList<User> list,String id){
        for (User user : list) {
            if (user.getId().equals(id)) {
                return user;
//                return true;
            }
        }
        System.out.println("User with id " + id + " not found");
        return null;
//        return false;
    }
}
