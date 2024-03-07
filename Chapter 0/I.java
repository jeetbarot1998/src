public interface I {
    public void m1();
    public abstract void m2();
    void m3();

}

interface J {

}
// As the class is abstract in nature the class is incomplete, so even if the implementations are not given, there
// will be no error.
abstract class A implements I {

}

class B implements I, J {

    @Override
    public void m1() {
        System.out.println("hello");
    }

    @Override
    public void m2() {
        System.out.println("m2 Method");
    }

    @Override
    public void m3() {
        System.out.println("m3 methods");
    }

    public static void main(String[] args) {
        B obj = new B();
        obj.m1();

    }
}

// ========================================

// Inheritance means only public methods and attributes will be inherited

class Parent {
    public void m1(){
        System.out.println(" Public Method of parent");
    }

    private void m2(){
        System.out.println(" Public Method of private");
    }

    public void m3(){
        System.out.println(" m3 Method in parent");
    }
}

class Child extends Parent{

    public void m1(){
        System.out.println(" Public Method of child class");
    }

    public static void main(String[] args) {
        Child c = new Child();
        c.m1();
        c.m3();
//        c.m2() => This is a private method and hence is not inherited
    }
}

// ====================================

abstract class Shape {
    public String shapeType(){
        return "2D Shapes";
    }
// As we do not know the implementation, mark it as incomplete as in "abstract".
    public abstract void calculateArea();
// As one of the methods is abstract in a class, the whole class will also be abstract.
}

// Either this class should implement at-least the abstract method or mark it as abstract.
class triangle extends Shape{

    @Override
    public void calculateArea() {
        System.out.println("calculating area");
    }
}

// An abstract class
// 1. all methods can be abstract.
// 2. few methods are abstract and few are defined.
// 3. all methods fully defined.
// 4. no methods.
// 5. Private methods.

interface IF0{
    void m0();
}

interface IF1{
    void m1();
}

interface IF2 extends IF1,IF0{
    void m2();
}

interface IF3{
    void m3();
}

class interfaceImplement implements IF2,IF3  {
// I2 is an extension of I1 and I0 and hence we have to implement m1,m2,m3.


    @Override
    public void m0() {
        System.out.println("m0");
    }
    @Override
    public void m1() {
        System.out.println("m1");
    }


    @Override
    public void m2() {
        System.out.println("m2");
    }

    @Override
    public void m3() {
        System.out.println("m3");
    }

    public static void main(String[] args) {
        interfaceImplemented ii = new interfaceImplemented();
        ii.m1();
        ii.m2();
        ii.m3();
    }


}