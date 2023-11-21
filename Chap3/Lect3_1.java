package Chap3;

public class Lect3_1 {
}

class ScopeErrors {
    public static void main(String [] args) {
        ScopeErrors s = new ScopeErrors();
        s.go();
    }
    void go() {
        int y = 5;
        System.out.println("13 " + y);
        go2(y);
        System.out.println("15 " + y);
        y++; // once go2() completes, y is back in scope
        System.out.println("17 " + y);
    }
    void go2(int y) {
        y++; // won't compile, y is local to go()
        System.out.println("21 " + y);
    }
}


class TestLocal {
    public static void main(String [] args) {
        int x;
        if (args[0] != null) { // assume you know this is true
            x = 7; // compiler can't tell that this
// statement will run
        }
//        int y = x; // the compiler will choke here
    }
}