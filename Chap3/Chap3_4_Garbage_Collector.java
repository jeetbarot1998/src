package Chap3;

public class Chap3_4_Garbage_Collector {
}

class Mixer {
    static float a;
    Mixer() { }
    Mixer(Mixer m) { m1 = m; }
    Mixer m1;
    public static void main(String[] args) {
//        Mixer m2 = new Mixer();
////        m2.m1.go();
//        Mixer m3 = new Mixer(m2);
//        m3.go();
//        Mixer m4 = m3.m1;
//        m4.go();
//        Mixer m5 = m2.m1;
//        m5.go();
        System.out.println(a);
        int x = 10;
        int y = 20;
        int z = 30;
        System.out.println(x+y);
        System.out.println(x+y%z);


    }
    void go() { System.out.print("hi "); }
}

class Happy {
    int id;
    Happy(int i) { id = i; }
    public static void main(String[] args) {
        Happy h1 = new Happy(1);
        Happy h2 = h1.go(h1);
//        System.out.println(h2.id);
    }
    Happy go(Happy h) {
        Happy h3 = h;
        h3.id = 2;
//        h1.id = 3; // error
//        return h1;
        return null;
    }
}

class A{
    public void m1() {
        int i = 6;
        m2(i);
        System.out.println("inside m1 " + i);
    }

    private void m2(int i) {
        i = 7;
        System.out.println("inside m2 " + i);
    }

    public static void main(String[] args) {
        A obj = new A();
        obj.m1();
    }
}


class Network {
    Network(int x, Network n) {
        id = x;
        p = this;
        if(n != null) p = n;
    }
    int id;
    Network p;
    public static void main(String[] args) {
        Network n1 = new Network(1, null);
        n1.go(n1);
    }
    void go(Network n1) {
        Network n2 = new Network(2, n1);
        Network n3 = new Network(3, n2);
        System.out.println(n3.p.p.id);
    }
}


class Dark {
    int x = 3;

    public static void main(String[] args) {
        new Dark().go1();
    }

    void go1() {
        int x;
//        go2(++x); => error as local variable does not
//        have any default value.
    }

    void go2(int y) {
        int x = ++y;
        System.out.println(x);
    }
}

class Mirror {
    int size = 7;
    public static void main(String[] args) {
        Mirror m1 = new Mirror();
        Mirror m2 = m1;
        int i1 = 10;
        int i2 = i1;
        go(m2, i2);
        System.out.println(m1.size + " " + i1);
    }
    static void go(Mirror m, int i) {
        m.size = 8;
        i = 12;
    }
}

// ================= Garbage collector =================
class GarbageCollection{
    public static void main(String[] args) {
        m1();
    }
    static void m1(){

        //      ======== NULLING THE REFERENCE ========
        System.out.println("======== NULLING THE REFERENCE ========");
        Student322 s1 = new Student322();
        Student322 s2 = new Student322();
//      if we want the object at line 105 to be available for garbage collection, then
        s1 = null;
//      This way the object s1 was referring to is no more being referred to by any variable,
//      hence available for garbage collection.

//      ======== REASSIGNING SAME REF VARIABLE TO ANOTHER OBJECT ========
        System.out.println("======== REASSIGNING SAME REF VARIABLE TO ANOTHER OBJECT ========");
        Student322 s3 = new Student322();
//      There is a reference variable in the stack and an object of the class “Student” on
//      the heap. The reference variable is pointing to the object on the heap at 100x
//      location. If we do not wish to use the current object and want to get rid of it,
//      we can reassign the same reference variable s1 to another object on the heap,
//      this way the older object will become available for garbage collection.
        s3 = new Student322();
//      So now the stack variable s1 reference variable is not pointing to the location
//      100x on the heap rather it is pointing to 200x on the heap and thus makes
//      the object on location 100x eligible for garbage collection.

//      ======== LOCAL VARIABLE ========
        System.out.println("======== LOCAL VARIABLE ========");
        m2();
//      ======== ISLAND OF ISOLATION ========
        System.out.println("======== ISLAND OF ISOLATION ========");


    }
    static void m2() {
        Student322 s1 = new Student322();
        Student322 s2 = new Student322();
//      Here 2 objects are created but nothing is returned to the main method.
//      Hence, once the program goes back to the main method, s1 and s2 are removed from
//      the stack and hence the 2 objects are not being referenced anymore.
//      Thereby, making them available for garbage collection.
    }
}

class Test34{

    public static void main(String[] args) {
        m1(); // => 2 objects available for garbage collection
        Student322 s = giveInstance(); // => 1 objects available for garbage collection
        giveInstance(); // => 2 objects available for garbage collection as we are
//      not saving thee returned reference variable in any other local variable.
    }

    static void m1() {
        System.out.println("======== LOCAL VARIABLE GARBAGE COLLECTION ========");
        Student322 s1 = new Student322();
        Student322 s2 = new Student322();
//      here 2 objects are created but nothing is returned to the main method.
//      Hence, once the program goes back to the main method, s1 and s2 are removed from
//      the stack and hence the 2 objects are not being referenced anymore.
//      Thereby, making them available for garbage collection.
    }

    static Student322 giveInstance(){
        Student322 s1 = new Student322();
        Student322 s2 = new Student322();
//      here 2 objects are created but only one of them is returned to the main method.
//      Hence, the object on heap which s2 was referring to is
//      available for garbage collection.
        return s1;
    }
}

class IslandOfIsolation{
    IslandOfIsolation i;

    public static void main(String[] args) {
        IslandOfIsolation i2 = new IslandOfIsolation();
        IslandOfIsolation i3 = new IslandOfIsolation();
        IslandOfIsolation i4 = new IslandOfIsolation();
        i2.i = i3; // i2 refers to i3
        i3.i = i4; // i3 refers to i4
        i4.i = i2; // i4 refers to i2
        i2 = null;
        i3 = null;
        i4 = null;
//      In this example, obj1 and obj2 initially reference each other,
//      creating a loop or circle of references. However, when i2, i3, i4
//      is set to null, it breaks the chain of references to this island of objects.
//      Now, neither i2, i3 nor obj2 can be reached from any active part of the program.
    }
}


class A34{
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        A34 a = new A34();
        a.finalize();
        a.finalize();
        a = null;
        r.gc(); // this is the time when the garbage collector calls the finalize method
//      and only when the gc calls the finalize method, the object is deleted from the heap.
    }

//    Write/over-ride the finalize method if you want to perform some clean up activity in the
//    class you on whose object you want call the garbage collector.
    public void finalize(){
//      Supposing we had some db connections,then nullify it here.
//      This will be called only once per object life cycle.
        System.out.println("Finalize method called ");
    }
}

class Test{

    Test(String s){
        System.out.println("constructor called");
    }

    public static void main(String[] args) {
        String s = new String("ABC");
        s = null; // making it eligible for gc
        System.gc(); // the gc will run the finalize method of the String class not Test class
        System.out.println("main MID");
        Test t = new Test("ABC");
        t = null; // making it eligible for gc
        System.gc(); // This triggers the finalize method of "Test" class.
        System.out.println("main END");
    }

    public void finalize(){
        System.out.println("finalize method called");
    }
}

