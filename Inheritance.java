// A CLASS CANNOT EXTEND FROM MULTIPLE CLASS.
// A CLASS CAN IMPLEMENT MULTIPLE INTERFACES.
// AN INTERFACES can extend multiple INTERFACES.

interface I0{
    void m0();
}

interface I1{
    void m1();
}

interface I2 extends I1,I0{
    void m2();
}

interface I3{
    void m3();
}

class interfaceImplemented implements I2,I3  {
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

class Food{
    private String name;
    private int calories;
    private String type;
    private int price;
//    Constructor
    public Food(String name, int calories, String type, int price){
        this.name = name;
        this.calories = calories;
        this.type = type;
        this.price = price;
    }

    public Food(){
        ;
    }

    public String getName(){
        return name;
    }

    public int calories(){
        return calories;
    }

    public String type(){
        return type;
    }

    public int price(){
        return price;
    }

}

class junkFood extends Food {

    @Override
    public String getName(){
        System.out.println("over ridden");
        return "over ridden";
    }

}
