package Chap2.SCJP;

public class Object_Orientation {
}

// ============== Encapsulation ==============
class Box {
// protect the instance variable; only an instance
// of Box can access it
    private int size;
    // Provide public getters and setters
    public int getSize() {
        return size;
    }
    public void setSize(int newSize) {
        size = newSize;
    }
}

class Foo {
//  The variables are public in nature and hence the setter does not help in encapsulation.
    public int left = 9;
    public int right = 3;
    public void setLeft(int leftNum) {
        left = leftNum;
        right = leftNum/3;
    }
// lots of complex test code here
}



class TestOO {
    public static void main(String [] args) {
        TestOO t1 = new TestOO();
        TestOO t2 = new TestOO();
        if (!t1.equals(t2))
            System.out.println("they're not equal");
        if (t1 instanceof Object)
            System.out.println("t1's an Object");
    }
}


// ============== Inheritance & Polymorphism ==============

class GameShape {
    public void displayShape() {
        System.out.println("displaying shape");
    }
}

class PlayerPiece extends GameShape {
    public void movePiece() {
        System.out.println("moving game piece");
    }
}

class TilePiece extends GameShape {
    public void getAdjacent() {
        System.out.println("getting adjacent tiles");
    }
}

class TestShapes {
    public static void main (String[] args) {
        PlayerPiece player = new PlayerPiece();
        TilePiece tile = new TilePiece();
        doShapes(player);
        doShapes(tile);
    }
// ========= Programming to class example =========
    public static void doShapes(GameShape shape) {
        shape.displayShape();
    }
}

// ============== IS A relationship example ==============

class Car00 {
// Cool Car code goes here
}
class Subaru extends Car00 {
// Important Subaru-specific stuff goes here
// Don't forget Subaru inherits accessible Car members which
// can include both methods and variables.
}


// ============== Has A relationship example ==============
class Animal00{}
class LeadRope00{}

class Horse00 extends Animal00 {
    private Halter00 myHalter = new Halter00();
    public void tie(LeadRope00 rope) {
        myHalter.tie(rope); // Delegate tie behavior to the Halter object
    }
}
class Halter00 {
    public void tie(LeadRope00 aRope) {
    }
}

// ============== Has A relationship example ==============
interface Animatable01 {
    public void animate();
}

class PlayerPiece01 extends GameShape implements Animatable01 {
    public void movePiece() {
        System.out.println("moving game piece");
    }
    public void animate() {
        System.out.println("animating...");
    }

    public static void main(String[] args) {
        PlayerPiece01 player = new PlayerPiece01();
        Object o = player;
        GameShape shape = player;
        Animatable01 mover = player;
    }
}

// ============== Over-Riding example ==============
class Animal02 {
    public void eat() {
        System.out.println("Generic Animal Eating Generically");
    }
}

class Horse extends Animal02 {
    public void eat() {
        System.out.println("Horse eating hay, oats, "
                + "and horse treats");
    }
}

// ================
class Animal {
    public void eat() {
        System.out.println("Generic Animal Eating Generically");
    }
}
class Horse01 extends Animal {
    public void eat() {
        System.out.println("Horse eating hay, oats, "
                + "and horse treats");
    }
    public void buck() { }
}
class TestAnimals {
    public static void main (String [] args) {
        Animal a = new Animal();
        Animal b = new Horse01(); // Animal ref, but a Horse object
        a.eat(); // Runs the Animal version of eat()
        b.eat(); // Runs the Horse version of eat()
    }
}

// ============== Invoking a Superclass Version of an Overridden Method ==============

class Animal03 {
    public void eat() { }
    public void printYourself() {
// Useful printing code goes here
    }
}
class Horse03 extends Animal03 {
    public void printYourself() {
// Take advantage of Animal code, then add some more
        super.printYourself(); // Invoke the superclass
// (Animal) code
// Then do Horse-specific
// print work here
// static methods can't be overridden
    }
}

// ============== Over loading example ==============
class Adder {
    public int addThem(int x, int y) {
        return x + y;
    }
    // Overload the addThem method to add doubles instead of ints
    public double addThem(double x, double y) {
        return x + y;
    }
}
// From another class, invoke the addThem() method
class TestAdder {
    public static void main (String [] args) {
        Adder a = new Adder();
        int b = 27;
        int c = 3;
        int result = a.addThem(b,c); // Which addThem is invoked?
        double doubleResult = a.addThem(22.5,9.3); // Which addThem?
    }
}

class Animal04 { }
class Horse04 extends Animal04 { }
class UseAnimals {
    public void doStuff(Animal04 a) {
        System.out.println("In the Animal version");
    }
    public void doStuff(Horse04 h) {
        System.out.println("In the Horse version");
    }
    public static void main (String [] args) {
        UseAnimals ua = new UseAnimals();
        Animal04 animalObj = new Animal04();
        Horse04 horseObj = new Horse04();
        ua.doStuff(animalObj);
        ua.doStuff(horseObj);
        Animal04 animalRefToHorse = new Horse04();
        ua.doStuff(animalRefToHorse); // in the Animal version
    }
}

// ============== main() method over loaded ==============
class DuoMain {
    public static void main(String[] args) {
        main(1);
    }
    static void main(int i) {
        System.out.println("overloaded main");
    }
}

// ============== over loaded and over riding  ==============

class Animal05 {
    public void eat() {
        System.out.println("Generic Animal Eating Generically");
    }
}
class Horse05 extends Animal05 {
    public void eat() {
        System.out.println("Horse eating hay ");
    }
    public void eat(String s) {
        System.out.println("Horse eating " + s);
    }

    public static void main(String[] args) {
        Animal05 a = new Animal05();
        a.eat();
        Horse05 h = new Horse05();
        h.eat();
        Animal05 ah = new Horse05();
        ah.eat();
        Horse05 he = new Horse05();
        he.eat("Apples");
        Animal05 a2 = new Animal05();
//        a2.eat("treats"); => error as Animal class does not have an over-loaded method which takes String as an argument
        Horse05 ah2 = new Horse05();
        ah2.eat("Carrots");
    }
}

// ============== Type casting ==============

class Animal06 {
    void makeNoise() {System.out.println("generic noise"); }
}
class Dog extends Animal06 {
    void makeNoise() {System.out.println("bark"); }
    void playDead() { System.out.println("roll over"); }
}
class CastTest2 {
    public static void main(String [] args) {
        Animal06 [] a = {new Animal06(), new Dog(), new Animal06() };
        for(Animal06 each_animal : a) {
            each_animal.makeNoise();
            if(each_animal instanceof Dog) {
                ((Dog) each_animal).playDead(); // try to do a Dog behavior?
            }
        }
    }
}

class Animal07 { }
class Dog07 extends Animal07 { }
class DogTest {
    public static void main(String [] args) {
        Dog07 d = new Dog07();
        Animal07 a1 = d; // upcast ok with no explicit cast
        Animal07 a2 = (Animal07) d; // upcast ok with an explicit cast
    }
}

// ============== Type casting ==============
class Ball{}
class BeachBall extends Ball {
    // Even though we don't say it in the class declaration above,
// BeachBall implements Bounceable, since BeachBall's abstract
// superclass (Ball) implements Bounceable
    public void bounce() {
// interesting BeachBall-specific bounce code
    }
    public void setBounceFactor(int bf) {
// clever BeachBall-specific code for setting
// a bounce factor
    }
// if class Ball defined any abstract methods,
// they'll have to be
// implemented here as well.
}

// =========
interface Moveable {
    void moveIt();
}
interface Spherical {
    void doSphericalThing();
}
interface Bounceable extends Moveable, Spherical { // ok!
    void bounce();
    void setBounceFactor(int bf);
}

class Ball01 implements Bounceable {
    public void bounce() { } // Implement Bounceable's methods
    public void setBounceFactor(int bf) { }
    public void moveIt() { } // Implement Moveable's method
    public void doSphericalThing() { } // Implement Spherical
}

abstract class Ball02 implements Bounceable {
    public void bounce() { } // Define bounce behavior
    public void setBounceFactor(int bf) { }
// Don't implement the rest; leave it for a subclass
}
class SoccerBall extends Ball { // class SoccerBall must
    // implement the interface
// methods that Ball didn't
    public void moveIt() { }
    public void doSphericalThing() { }
    // SoccerBall can choose to override the Bounceable methods
// implemented by Ball
    public void bounce() { }
}

// ============== Legal return types ==============

// ===== Over loading =====
class Foo0{
    void go() { }
}
class Bar0 extends Foo0 {
    String go(int x) {
        return null;
    }
}

// ===== Over riding =====
class Alpha {
    Alpha doStuff(char c) {
        return new Alpha();
    }
}
class Beta extends Alpha {
    Beta doStuff(char c) { // legal override in Java 1.5
        return new Beta();
    }
}

// ============== Constructor basics ==============

class Foo1 {
    int size;
    String name;
    Foo1(String name, int size) {
        this.name = name;
        this.size = size;
    }
}

class Clothing {
    Clothing(String s) { }
}
//class TShirt extends Clothing { } => There is no default constructor available in 'Chap2.SCJP.Clothing'

class Clothing2 {
    Clothing2(String s) { }
}
class TShirt extends Clothing2 {
    // Constructor identical to compiler-supplied
// default constructor
    TShirt() {
//        super(); // Won't work!
        super("S"); // works!
    } // tries to invoke a no-arg Clothing constructor
// but there isn't one
}

class Animal21{

    private String name;

    Animal21(String name){
        this.name = name;
    }

    Animal21(){
        this(makeRandomName());
    }

    public String getName() {
        return name;
    }

    private static String makeRandomName(){
        int random = (int) (Math.random() * 5);
        String name = new String[] {"A", "B", "C", "D", "E"} [random];
        return name;
    }

    public static void main(String[] args) {
        Animal21 an = new Animal21();
        Animal21 an2 = new Animal21("OJK");
        System.out.println(an.getName());
        System.out.println(an2.getName());
    }
}

// === Recursive constructor invocation
//class A {
//    A() {
//        this("foo");
//    }
//    A(String s) {
//        this();
//    }
//}

// ============== Static access modifier ==============

//
class Frog0 {
    int frogSize = 0;
    public int getFrogSize() {
        return frogSize;
    }
    public Frog0(int s) {
        frogSize = s;
    }
    public static void main (String [] args) {
        Frog0 f = new Frog0(25);
        System.out.println(f.getFrogSize()); // Access instance
// method using f
    }
}

class Frog {
    static int frogCount = 0; // Declare and initialize
    // static variable
    public Frog() {
        frogCount += 1; // Modify the value in the constructor
    }
}
class TestFrog {
    public static void main (String [] args) {
        new Frog();
        new Frog();
        new Frog();
        System.out.print("frogCount:"+Frog.frogCount); // Access
// static variable
    }
}

class A{
    void m1(){
        System.out.println("A m1");
    }
    void m1(int i){
        System.out.println("A m1 params");
    }
}

class Animal11{}
class Monkey extends Animal11{}

class Test2_3_3{
    public void m1(Animal11 a){
        System.out.println("Animal11");
    }

    public void m1(Monkey m){
        System.out.println("Monkey");
    }

    public static void main(String ...args) {
        Test2_3_3 t =  new Test2_3_3();
        Animal11 a = new Animal11();
        t.m1(a);
        Monkey m = new Monkey();
        t.m1(m);
        Animal11 am = new Animal11();
        t.m1(am);
//        The compiler always chooses the most specific method
//        that can handle the argument type. Since Monkey is more specific than Animal
//        (because Monkey is a subclass of Animal), it selects m1(Monkey m).
//        Compiler gives precedence to the child over the parent in over loading.
        t.m1(null);
    }

}

/*
1. B, E => correct.
2. E => correct.
3. A => correct.
4. DID NOT get how to do
5. D => correct.
6. C => correct.
7. A => correct.
8. F => correct.
9. E WRONG
10. B => correct.
11. C => correct.
12. C => correct.
13. A => correct.
14. C or A  => WRONG.
11/14
*/


