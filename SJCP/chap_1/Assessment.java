package SJCP.chap_1;

import static java.lang.System.out;

import static java.lang.Integer.*;
import static java.lang.Integer.MAX_VALUE;

public class Assessment {
}

class Rocket {
    private void blastOff() { System.out.print("bang "); }
}
class Shuttle extends Rocket {
    public static void main(String[] args) {
        new Shuttle().go();
    }
    void go() {
        blastOff();
// Rocket.blastOff(); // line A
    }
    private void blastOff() { System.out.print("sh-bang "); }
}


class _ {
    static public void main(String[] __A_V_) {
        String $ = "";
        for(int x=0; ++x < __A_V_.length; ) // for loop
            $ += __A_V_[x];
        out.println($);
    }
}


enum Animals {
    DOG("woof"), CAT("meow"), FISH("burble");
    String sound;
    Animals(String s) { sound = s; }
}

class TestEnum {
    static Animals a;
    public static void main(String[] args) {
        System.out.println(a.DOG.sound + " " + a.FISH.sound);
    }
}


class Electronic2 implements Device {
    public void doIt() { }
}

abstract class Phone1 extends Electronic { }

abstract class Phone2 extends Electronic {
    public void doIt(int x) { }
}

class Phone3 extends Electronic2 implements Device {
    public void doStuff() { }
}

interface Device {
    public void doIt();
}



class Announce {
    public static void main(String[] args) {
        for(int __x = 0; __x < 3; __x++) ;
//        int #lb = 7;
//        long[] x[5];
        Boolean[] ba[];
    }
}


class TestDays {
    public enum Days { MON, TUE, WED };
    public static void main(String[] args) {
        for(Days d : Days.values() )
            ;
        Days[] d2 = Days.values();
        System.out.println(d2[2]);
    }
}

class Frodo extends Hobbit {
    public static void main(String[] args) {
        int myGold = 7;
//        System.out.println(countGold(myGold, 6));
    }
}

class Hobbit {
    int countGold(int x, int y) { return x + y; }
}


interface Gadget {
    void doStuff();
}
abstract class Electronic {
    void getPower() { System.out.print("plug in "); }
}
class Tablet extends Electronic implements Gadget {
    public void doStuff() { System.out.print("show book "); }
    public static void main(String[] args) {
        new Tablet().getPower();
        new Tablet().doStuff();
    }
}


class StatTest {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
