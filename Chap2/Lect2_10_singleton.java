package Chap2;

public class Lect2_10_singleton {
}

// ==================== Singleton ====================
// If object creation is very expensive, singleton can be used.
// The Singleton pattern is beneficial in scenarios where you need precisely one
// instance of a class to coordinate actions across the system,
// share common resources, or manage global settings.
// ========= LAZY LOADING =========
// Object is not made as long as it is not required. Hence, less space.
class Singleton210{

    private static Singleton210 SINGLETON_INSTANCE = null;

    private Singleton210(){
        System.out.println("constructor called");
    }

    public static Singleton210 giveInstance(){
        if( SINGLETON_INSTANCE == null){
            SINGLETON_INSTANCE = new Singleton210();
        }
        return SINGLETON_INSTANCE;
    }
}

// ========= EAGER LOADING =========
// Object is made immediately as the class is loaded without even wanting to make an object
// Hence, more space.
class Singleton2102 {

    private static Singleton2102 SINGLETON_INSTANCE = new Singleton2102();
    private Singleton2102(){
        System.out.println("constructor called 2");
    }

    public static Singleton2102 giveInstance(){
        return SINGLETON_INSTANCE;
    }

}

class Test210{
    public static Singleton210 m;
    public static void main(String[] args) {
        Test210 t = new Test210();
        System.out.println(t.m.giveInstance().toString());
        System.out.println("HERE");
        Singleton210 sg = Singleton210.giveInstance();
        System.out.println("HERE 1");
        Singleton210 sg2 = Singleton210.giveInstance();
        System.out.println(sg == sg2);
        System.out.println(sg.hashCode());
        System.out.println(sg2.hashCode());

    }
}




