package Lect19_NestedObjectDemo.LocalClassOverride;
public class LocalClassOverRide {
    int rollNo;
    String name;

    public static void main(java.lang.String[] args) {
        System.out.println("hello");
        Lect19_NestedObjectDemo.LocalClassOverride.String s1 = new Lect19_NestedObjectDemo.LocalClassOverride.String();
        System.out.println(s1.x);

    }
}

class String{
    int x = 5;
}

