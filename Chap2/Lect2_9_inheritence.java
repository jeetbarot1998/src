package Chap2;

public class Lect2_9_inheritence {
}


class Emp29{
    void swipeCard(){
        System.out.println("Swipe Card");
    }

    void teaBreak(){
        System.out.println("Tea Break");
    }
}

class Vehicle29{}

class Car29 extends Vehicle29{
    private String model;
    Car29(String model){
        this.model = model;
        System.out.println("called Constructor");
    }

    Car29(){}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    void drive(){
        System.out.println("Driving car");
    }
}
class Manager29 extends Emp29{

    private Car29 cr;

    public Car29 getCr() {
        return cr;
    }

    public void setCr(Car29 cr) {
        this.cr = cr;
    }

    Manager29(Car29 c){
        this.cr = c;
    }
    void performanceReview(){
        System.out.println("Review");
    }
}


class ClientDemo{

    public static void main(String[] args) {
//        Car29 c = new Car29("Ambassador");
//        Manager29 m = new Manager29(c);
        Manager29 m = new Manager29(new Car29("Ambassador"));
//        m1.getCr().getModel();
        m.swipeCard();
        m.teaBreak();
        m.performanceReview();
        m.getCr().drive();
    }

}

// ============= loosely coupled =============
// Programming to super class or interface => using a more generic type of
// class or interface object which will allow us to make changes to the type of the child class
// without changing the class implemented. It refers to writing code that utilizes the features
// and behaviors defined in a superclass or interface rather than relying on specific
// implementations provided by subclasses.

interface IVehicle29{
    void drive();
}

class Car291 implements IVehicle29{
    public void drive(){
        System.out.println("Drive Car");
    }
}

class Ship291 implements IVehicle29{
    public void drive(){
        System.out.println("Drive Ship");
    }
}

class Aeroplane29 implements IVehicle29{
    public void drive(){
        System.out.println("Drive Aeroplane");
    }
}

class Manager291{
//    Making loosely coupled using Programming to interface.
    private IVehicle29 vehicle;

    public IVehicle29 getVehicle() {
        return vehicle;
    }

    public void setVehicle(IVehicle29 vehicle) {
        this.vehicle = vehicle;
    }

    public Manager291(IVehicle29 vehicle){
        this.vehicle = vehicle;
    }

    void performanceReview(){
        System.out.println("review");
    }

    public static void main(String[] args) {
        Car291 vh = new Car291();
        IVehicle29 vh1 = new Ship291();
        IVehicle29 vh2 = new Aeroplane29();
        Manager291 mn = new Manager291(vh);
        Manager291 mn1 = new Manager291(vh1);
        Manager291 mn2 = new Manager291(vh2);
        mn.getVehicle().drive();
        mn1.getVehicle().drive();
        mn2.getVehicle().drive();

    }
}