package OCA_Dumps;

import java.util.Arrays;

public class Q12 {
}

interface Breakable{ void breakSmoothly();}
class Car{public void acc(){
    System.out.println("accelerate");
}}
class FancyCar extends Car{ public void breakSmoothly(){
    System.out.println("FancyCar : breakSmoothly");
}}
class SuperFancyCar extends  FancyCar implements Breakable{
    public void breakSmoothly(){
        System.out.println("SuperFancyCar : breakSmoothly");
    }
    public void turn(){}
    private static void print(Car car){
//        ((Breakable) car).breakSmoothly(); // R.E
        ((FancyCar) car).breakSmoothly();
        car.acc();
    }

    public static void main(String[] args) {
        print(new FancyCar());

    }
}

class Mineral{}
class Gem extends Mineral{}
class Miner{
    static int x = 7;
    static String s = null;
    public static void getWeight(Mineral m){
        int y = 0/x;
        System.out.println(s + " ");
    }

    public static void main(String[] args) {
        Mineral [] ma = new Mineral[]{new Mineral(), new Gem()};
        for (Object o: ma){
            getWeight((Mineral) o);
        }
    }
}


class Punt{
    public static void main(String[] args) {
        Punt p = new Punt();
        Object o = p.go(new Punt());
        Punt[] p2 =((Punt[])o);
        System.out.println(Arrays.toString(p2));
        System.out.println(p.equals(p2[0]) + " " + (p == p2[0]));
    }

    Punt[] go(Punt p){
        Punt[] p1 = {p};
        return p1;
    }
}


