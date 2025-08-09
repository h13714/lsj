package test3;

public class Car {
    private String make;
    private double price;
    private String color;

    public Car() {
    }

    public Car(String make, double price, String color) {
        this.make = make;
        this.price = price;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
