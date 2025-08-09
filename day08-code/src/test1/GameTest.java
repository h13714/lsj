package test1;

public class GameTest {
    public static void main(String[] args) {
        Role r1 = new Role("李逍遥", 100);
        Role r2 = new Role("郭襄", 100);
        while(true){
            r1.attack(r2);
            if(r2.getBlood() == 0){
                System.out.println(r2.getName() + "已经死亡，" + r1.getName() + "获胜");
                break;
            }
            r2.attack(r1);
            if(r2.getBlood() == 0){
                System.out.println(r1.getName() + "已经死亡，" + r2.getName() + "获胜");
                break;
            }
        }
    }
}
