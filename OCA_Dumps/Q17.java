package OCA_Dumps;

public class Q17 {
}

interface Breakable17{ void breakSmoothly();}
class Car17{public void acc(){
    System.out.println("accelerate");
}}
class FancyCar17 extends Car17{ public void breakSmoothly(){
    System.out.println("FancyCar : breakSmoothly");
}}
class SuperFancyCar17 extends  FancyCar17 implements Breakable17{
    public void breakSmoothly(){
        System.out.println("SuperFancyCar : breakSmoothly");
    }
    public void turn(){}
}

class Start{
    private static void print(Car car){
//        ((Breakable) car).breakSmoothly(); // R.E
        ((FancyCar) car).breakSmoothly();
        car.acc();
    }
    public static void main(String[] args) {
        print(new FancyCar());
    }

}






