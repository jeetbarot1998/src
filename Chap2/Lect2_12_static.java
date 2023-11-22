package Chap2;

public class Lect2_12_static {
}

// ================= Over-riding the parent static method ==============
class Parent212 {
    final int fin = 90;
    int id = 10;
    int x = 9;

    public static void myStaticMethod() {
        System.out.println("Static method in Parent");
    }

    public int getId(){
        return id;
    }

    public void instanceMethod(){
        System.out.println("Instance Method in Parent");
    }
}

class Child212 extends Parent212 {

//    This won't work as "Instance method 'myStaticMethod()' in 'Chap2.Child212'
//    cannot override static method 'myStaticMethod()' in 'Chap2.Parent212'"
//    public void myStaticMethod() {
//        System.out.println("Static method in Child");
//    }
    int id = 11;
//    It can also be static.
//    static int id = 11;


    public int getId(){
        return id;
    }

    public void instanceMethod(){
        System.out.println("Instance Method in Child");
    }

    public static void myStaticMethod() {
        System.out.println("Static method in Child");
    }
}

class MethodHidingExample {
    public static void main(String[] args) {
        Parent212 p = new Parent212();
        Parent212 cp = new Child212();
        Child212 c = new Child212();

        // Invoking the static method using Parent reference
        Parent212.myStaticMethod();  // Output: Static method in Parent

        // Invoking the static method using Child reference
        Child212.myStaticMethod();   // Output: Static method in Child

//      ======== Method Hiding ========
        // Polymorphism: Invoking the static method using Parent reference pointing to Child object
//      At run time it looks at what is the reference type of the variable
        cp.myStaticMethod();
        // Output: Static method in Parent (not overridden, as static methods don't exhibit polymorphic behavior)

        p.myStaticMethod();
        c.myStaticMethod();

//      ======== invoking instance method where over-riding works ========
        p.instanceMethod();
        cp.instanceMethod();
        c.instanceMethod();
        System.out.println(cp.getId());
        System.out.println(p.getId());
        System.out.println(c.getId());

//      ======== Instance variables ========
//      If a parent class and a child class have a field with the same name,
//      the field doesn't override the parent's field.
//      When the compiler has to decide which field to use - the one declared in the parent
//      or the one in the child - it does so based on the type of the reference variable being used.
//      parent's attribute has been inherited.
//        cp.fin = 91;
        System.out.println("Parent variable called " + cp.id);
        System.out.println("Child variable called " + c.id);
        System.out.println("Inherited Variable called " + c.x);
        System.out.println("Parent Variable called " + p.x);
    }
}



class Bird {
    { System.out.print("b1 "); }
    public Bird() { System.out.print("b2 "); }
}
class Raptor extends Bird {
    static { System.out.print("r1 "); }
    public Raptor() { System.out.print("r2 "); }
    { System.out.print("r3 "); }
    static { System.out.print("r4 "); }
}
class Hawk extends Raptor {
    public static void main(String[] args) {
        System.out.print("pre ");
        new Hawk();
        System.out.println("hawk ");
    }
}

