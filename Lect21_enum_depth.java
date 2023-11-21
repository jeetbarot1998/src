public class Lect21_enum_depth {
}

class A21 {

    void m1(){
        System.out.println(this.hashCode());
        System.out.println("m1");
        this.m3();
        m3();
        m2();
    }

    static void m2(){
        System.out.println("static m2");
    }

    void m3(){
        System.out.println(this.hashCode());
        System.out.println("m3");
    }

    public static void main(String ...a) {
        A21 obj = new A21();
        obj.m1();
        obj.m3();
    }
}


enum Color21{
    RED, BLUE, YELLOW;

    Color21(){
        System.out.println("Constructor called");
    }
    public static void main(String ...a) {
//      Constructor is loaded and hence all the static variables are also instantiated
//      and hence constructor is called 3 times.
        System.out.println("Enum main");
    }
}

class Test21{
    public static void main(String ...a) {
        System.out.println("Test 21");
        Color21 c = Color21.BLUE;
    }
}


enum Drinks{
    BEER, HORLICKS(20),RUM;
    private int price;
    Drinks(int cal){
        System.out.println("Called constructor for " + this.name());
        this.price = cal;
    }

    Drinks(){
        System.out.println("Called constructor for " + this.name());
        this.price = 12;
    }

    public int getPrice() {
        return price;
    }
}

class Test21A{
    public static void main(String ...args) {
        Drinks[] drinks = Drinks.values();
        for(Drinks each_drink :drinks){
            System.out.println(each_drink.name() + ":" + each_drink.getPrice());
        }
    }
}


enum Color21A{
    GREEN, RED{
        public String getDesc() {
            return "Danger";
        }
    }, ORANGE;
    private String desc;

    Color21A(){
    }

    public String getDesc() {
        return "UNIVERSAL";
    }
}

class Demo21{
    public static void main(String ...args) {
        Color21A[] col = Color21A.values();
        for(Color21A each_col: col){
            System.out.println(each_col.name() + ":" + each_col.getDesc());
        }


    }
}