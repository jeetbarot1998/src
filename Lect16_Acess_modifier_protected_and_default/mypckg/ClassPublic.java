package Lect16_Acess_modifier_protected_and_default.mypckg;

public class ClassPublic {

    public void publicMethod(){
        System.out.println("Calling publicMethod in class "+ this.getClass().getSimpleName());
    }

    void defaultMethod(){
        System.out.println("Calling defaultMethod in class "+ this.getClass().getSimpleName());
    }

    protected void protectedMethod(){
        System.out.println("Calling protectedMethod in class "+ this.getClass().getSimpleName());
    }

    private void privateMethod(){
        System.out.println("Calling privateMethod in class "+ this.getClass().getSimpleName());
    }
}


class ClassDefault{
    public void publicMethod(){
        System.out.println("Calling publicMethod in class "+ this.getClass().getSimpleName());
    }

    void defaultMethod(){
        System.out.println("Calling defaultMethod in class "+ this.getClass().getSimpleName());
    }

    protected void protectedMethod2(){
        System.out.println("Calling protectedMethod in class "+ this.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        ClassPublic cp = new ClassPublic();
        cp.publicMethod();
        cp.defaultMethod();
        cp.protectedMethod();
    }
}

class ChildOfAnotherClassSamePackage extends ClassPublic{

    void acessParentMethods(){
        defaultMethod();
        protectedMethod();
        publicMethod();
//        privateMethod() => This does not work as method is private
    }

    public static void main(String[] args) {
        ChildOfAnotherClassSamePackage coac = new ChildOfAnotherClassSamePackage();
        coac.defaultMethod();
        coac.protectedMethod();
        coac.publicMethod();
//        coac.privateMethod() => This does not work as methods is private.
        ClassPublic cp = new ClassPublic();
        cp.protectedMethod();
        cp.defaultMethod();
        cp.publicMethod();
//        cp.privateMethod() => This does not work as methods is private.
    }
}

class AnotherClassInsideSamePackage {
    public static void main(String[] args) {
        ClassPublic cp =  new ClassPublic();
        cp.protectedMethod();
        cp.defaultMethod();
        cp.publicMethod();
//        cp.privateMethod() => This does not work as methods is private.

    }
}

class SportsCar{
    void goFast(){
        System.out.println("Called goFast");
    }

    void doStuff(){
        System.out.println("Called doStuff");
        this.goFast();
    }

    public static void main(String[] args) {
        SportsCar sc = new SportsCar();
        sc.doStuff();
    }

}

class Convertible extends SportsCar{
    void doThings(){
        System.out.println("Called doThings");
        this.doStuff();
    }

    public static void main(String[] args) {
        Convertible c = new Convertible();
        c.doThings();

        SportsCar sc = new SportsCar();
        sc.doStuff();

        SportsCar scc = new Convertible();
    }
}