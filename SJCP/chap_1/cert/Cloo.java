package SJCP.chap_1.cert;
import SJCP.chap_1.Roo;

class Cloo extends Roo {
    public void testCloo() {
        System.out.println(doRooThings());
    }
    private String doPvtThings() {
        return "doThing Private";
    }
}

class Toon {
    public static void main(String[] args) {
        Cloo c = new Cloo();
        System.out.println(c.doRooThings()); // No problem; method
// is public
    }
}


class UseARoo {
    public void testIt() {
        Roo r = new Roo(); //So far so good; class Roo is public
//        System.out.println(r.doPvtThings()); // Compiler error!
    }
}

class Cloo2 extends Roo { // Still OK, superclass Roo is public
    public void testCloo() {
//        System.out.println(doPvtThings()); // Compiler error!
    }
}