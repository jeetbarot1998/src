package Chap4;
import javax.swing.JButton;

public class Operator {}

class CompareTest {
    public static void main(String [] args) {
        boolean b = 100 > 99;
        System.out.println("The value of b is " + b);
    }
}

class GuessAnimal {
    public static void main(String[] args) {
        String animal = "unknown";
        int weight = 700;
        char sex = 'm';
        double colorWaveLength = 1.630;
        if (weight >= 500) { animal = "elephant"; }
        if (colorWaveLength > 1.621) { animal = "gray " + animal; }
        if (sex <= 'f') { animal = "female " + animal; }
        System.out.println("The animal is a " + animal);
    }
}


class ComparePrimitives {
    public static void main(String[] args) {
        System.out.println("char 'a' == 'a'? " + ('a' == 'a'));
        System.out.println("char 'a' == 'b'? " + ('a' == 'b'));
        System.out.println("5 != 6? " + (5 != 6));
        System.out.println("5.0 == 5L? " + (5.0 == 5L));
        System.out.println("true == false? " + (true == false));
    }
}

class CompareReference {
    public static void main(String[] args) {
        JButton a = new JButton("Exit");
        JButton b = new JButton("Exit");
        JButton c = a;
        System.out.println("Is reference a == b? " + (a == b));
        System.out.println("Is reference a == c? " + (a == c));
    }
}

class Budgie {
    public static void main(String[] args) {
        Budgie b1 = new Budgie();
        Budgie b2 = new Budgie();
        Budgie b3 = b1;
        String s1 = "Bob";
        String s2 = "Bob";
        String s3 = "bob"; // lower case "b"
        System.out.println(b1.equals(b2)); // false, different objects
        System.out.println(b1.equals(b3)); // true, same objects
        System.out.println(s1.equals(s2)); // true, same values
        System.out.println(s1.equals(s3)); // false, values are case sensitive
    }
}

class EnumEqual {
    enum Color {RED, BLUE} // ; is optional
    public static void main(String[] args) {
        Color c1 = Color.RED; Color c2 = Color.RED;
        if(c1 == c2) { System.out.println("=="); }
        if(c1.equals(c2)) { System.out.println("dot equals"); }
    }
}

class instanceOf{
    public static void main(String[] args) {
        String s = new String("foo");
        if (s instanceof String) {
            System.out.print("s is a String");
        }
    }
}

class A { }
class B extends A {
    public static void main (String [] args) {
        A myA = new B();
        m2(myA);
    }
    public static void m2(A a) {
        if (a instanceof B)
            ((B)a).doBstuff(); // downcasting an A reference
// to a B reference
    }
    public static void doBstuff() {
        System.out.println("'a' refers to a B");
    }
}

class InstanceTest {
    public static void main(String [] args) {
//      NULL INSTANCE OF ANYTHING IS FAlSE
        String a = null;
        boolean b = null instanceof String;
        boolean c = a instanceof String;
        boolean d = null instanceof Object;
        System.out.println(b + " " + c);
        System.out.println(d);
    }
}

class Cat { }
class Dog {
    public static void main(String [] args) {
        Dog d = new Dog();
//        System.out.println(d instanceof Cat);
        int [] nums = new int[3];
        if (nums instanceof Object) { } // result is true
    }
}

class MathTest {
    public static void main (String [] args) {
        int x = 15;
        int y = x % 4;
        System.out.println("The result of 15 % 4 is the "
                + "remainder of 15 divided by 4. The remainder is " + y);
    }
}

class StringConcatOperator{
    public static void main(String[]args){
        String a = "String";
        int b = 3;
        int c = 7;
        System.out.println(a + b + c);
        System.out.println(a + (b + c));
        String s = "123";
        s += "45";
        s += 67;
        System.out.println(s);
        int b1 = 2;
        System.out.println("" + b1 + 3);
        System.out.println(b1 + 3);

    }
}

class MathTest1 {
static int players = 0;
public static void main (String [] args) {
        System.out.println("players online: " + players++);
        System.out.println("The value of players is " + players);
        System.out.println("The value of players is now "+ ++players);
        int x = 2; int y = 3;
        if ((y == x++) | (x < ++y)) {
            System.out.println("x = " + x + " y = " + y);
    }
        }
}


class Salary {
    public static void main(String [] args) {
        int numOfPets = 3;
        String status = (numOfPets<4) ? "Pet limit not exceeded"
                : "too many pets";
        System.out.println("This pet status is " + status);
    }
}

class AssignmentOps {
    public static void main(String [] args) {
        int sizeOfYard = 10;
        int numOfPets = 3;
        String status = (numOfPets<4)?"Pet count OK"
                :(sizeOfYard > 8)? "Pet limit on the edge"
                :"too many pets";
        System.out.println("Pet status is " + status);

        byte b1 = 6 & 8;
        byte b2 = 7 | 9;
        byte b3 = 5 ^ 4;
        System.out.println(b1 + " " + b2 + " " + b3);
    }
}

class TestOR {
    public static void main(String[] args) {
        if ((isItSmall(3)) || (isItSmall(7))) {
            System.out.println("Result is true");
        }
        if ((isItSmall(6)) || (isItSmall(9))) {
            System.out.println("Result is true");
        }
    }

    public static boolean isItSmall(int i) {
        if (i < 5) {
            System.out.println("i < 5");
            return true;
        } else {
            System.out.println("i >= 5");
            return false;
        }
    }
}


class SpecialOps {
    public static void main(String[] args) {
        String s = "";
        boolean b1 = true;
        boolean b2 = false;
//      below line is not an error bcz the assignment of b2 = false returns
//      "false" which is boolean. But, the assignment b2 = 0 will
//      return "0" which is not boolean in nature.

        if ((b2 = false) | (21 % 5) > 2) s += "x";
//        if ((b2 = 0) | (21 % 5) > 2) s += "x"; // this is error.
        if (b1 || (b2 == true)) s += "y";
        if (b2 == true) s += "z";
        System.out.println(s);
    }
}


class Incr {
    public static void main(String[] args) {
        Integer x = 7;
        int y = 2;
        x *= x;
        y *= y;
        y *= y;
        x -= y;
        System.out.println(x);
    }
}




/*
1. D CORRECT
2. C CORRECT
3. E CORRECT
4. G CORRECT
5. CORRECT
6. A CORRECT
7. A CORRECT
8. A WRONG
9. C,F CORRECT
10. D CORRECT
*/

