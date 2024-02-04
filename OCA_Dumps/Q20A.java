package OCA_Dumps;

public class Q20A {
    int ns;
    static int s;

    public Q20A(int ns) {
        if(s < ns ){
            s = ns;
            this.ns = ns;
        }
    }

    void doPrint(){
        System.out.println("ns = " + ns + " s = " + s);
    }
}

class TQ201{
    public static void main(String[] args) {
        Q20A a = new Q20A(50);
        Q20A b = new Q20A(125);
        Q20A c = new Q20A(100);

        a.doPrint();
        b.doPrint();
        c.doPrint();
    }
}


class Scope{
    int z;

    public static void main(String[] args) {
        Scope s = new Scope();
        int z = 6;
        System.out.println(z); // 6
        s.doStuff();
        System.out.println("line 40 " + z); // 6
        System.out.println("s.z : " + s.z); // 4
    }

    void doStuff(){
        int z = 5;
        doStuff2();
        System.out.println("line 47 " + z); // 5
    }

    void doStuff2(){
        z=4;
    }

}


