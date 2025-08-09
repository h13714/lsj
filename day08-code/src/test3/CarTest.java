package test3;
import java.util.Scanner;

public class CarTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car[] arr = new Car[3];
        for(int i = 0; i<arr.length;i++){
            arr[i] = new Car();
            System.out.println("Enter Car Name: ");
            arr[i].setMake(sc.next());
            System.out.println("Enter Car Price: ");
            arr[i].setPrice(sc.nextDouble());
            System.out.println("Enter Car Color: ");
            arr[i].setColor(sc.next());
            System.out.println();
        }
        for(Car car : arr){
            System.out.println(car.getMake() + " " + car.getPrice() + " " + car.getColor());
        }

        double average = (arr[0].getPrice() + arr[1].getPrice() + arr[2].getPrice()) / 3;
        System.out.println("Average Price: " + average);
    }
}
