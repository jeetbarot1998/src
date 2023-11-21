package SJCP.chap_1.somethingElse;
import SJCP.chap_1.certification.OtherClass;
import SJCP.chap_1.certification.Parent;

class AccessClass {
    static public void main(String[] args) {
        OtherClass o = new OtherClass();
//        o.testIt(); => default and hence inaccessible.
    }
}

class Child extends Parent {
    public void testIt() {
        System.out.println("protectedInt is " + protectedInt); // No problem; Child inherits x
    }

    public static void main(String[] args) {
        Child c = new Child();
        c.testIt();
    }
}

class Child2 extends Parent {
    public void testIt() {
        System.out.println("protectedInt is " + protectedInt); // No problem; Child inherits x
//        System.out.println("x is " + defaultInt); // Default scope hence inaccessible
        Parent p = new Parent(); // Can we access x using the p reference?
//        System.out.println("defaultInt in parent is " + p.defaultInt); // Default scope hence inaccessible
//        System.out.println("protectedInt in parent is " + p.protectedInt); // Compiler error!
    }

    public static void main(String[] args) {
        Child2 c2 = new Child2();
        c2.testIt();
    }
}

