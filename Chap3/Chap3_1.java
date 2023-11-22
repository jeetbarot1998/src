package Chap3;

public class Chap3_1 {
    public static void main(String[] args) {
        byte b = 127;
        short a = b;
        b =  (byte) 130;
        byte c = 12;
        byte d = 13;
//        byte e = d + c; // Will not work. as max(int , type of a, type of b) = int. Hence, We will have to do explicit type casting.

        System.out.println(b);
    }
}

class Test31{
    int marks = 70; // => on Heap
    String name = "ABC"; // => on Heap
    static String courseName = "JAVA"; // => on method area.

    Test31(){
        System.out.println(marks);
    }
    void m1(){
        System.out.println("M1");
    }

    public static void main(String[] args) {
        // => "args" variable is on Stack
        Test31 t = new Test31(); // => "t" variable is on Stack
        t.m1(); // => Method calls are always placed on stack.

    }
}

class DataTypes{
    public static void main(String[] args) {
        int binary = 0b011; // 3
        int hexadecimal = 0x011; // 17
        int octal = 011;
        System.out.println("binary 0(0) to 1(1) " + binary);
        System.out.println("hexadecimal 0(0) to f(15) " + hexadecimal);
        System.out.println("octal 0(0) to 7(7) " + octal);
    }
}

class typeCasting{
    int x , y=1, z;
    public static void main(String[] args) {
    byte a = 6;
//  a = a + 1; //⇒ will not work as we are adding integer to byte.
    a++; // ⇒ will work as the compiler does the casting for us.
    a += 7;
    byte b = 7;
//    b = b + 7;
    b += 7;
    }
}


class Book{
    private String title;

    public String getTitle() {
        return title;
    }

    public static void main(String[] args) {
        String t; // the local variables do not have any default values.
        Book b = new Book();
        String s = b.getTitle();
//      If we do not check the variable "s" then we'll get a run time error as nullPointerException.
        if (s != null){ // null check to see if t the class String has been given some value or not
            System.out.println(s.toLowerCase());
        }
//      hence we cannot print it directly
//        System.out.println(t);

    }
}


class Animal{
    void callMe(){
        System.out.println("Parent Call Me");
    }
}

class Dog extends Animal{
    void callMe(){
        System.out.println("Dog Call Me");
    }
    void callMe2(){
        System.out.println("Dog Call Me 2222");
    }
}

class UseAnimal{
    public static void main(String[] args) {
        Dog d = new Dog();
        Animal a = new Animal();
        Animal ad = d;
        Animal ad2 = (Animal)d; // This only changes the reference type of the object.
//      In the above line the reference type of the object "d" to "Animal" and the explicitly
//      saved it into "Animal" reference.
        Animal ad3 = new Dog();
//      ad is the same as ad2 and same as ad3.
//      It's the same as Animal ad2 = new Dog()
//      Line 92 is the same as 93.
        d.callMe();
        a.callMe();
        ad.callMe();

    }
}



