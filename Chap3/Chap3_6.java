package Chap3;

public class Chap3_6 {
}

class Snoochy{
    Boochy booch;
    public Snoochy(){
        booch = new Boochy(this);
    }
}


class Boochy{
    Snoochy snooch;
    public Boochy(Snoochy s){
        snooch = s;
    }

    public static void main(String[] args) {
        Snoochy snoog = new Snoochy(); // local ref variable.
        snoog = null;
//      2 objects for garbage collection.
    }
}

interface Animal1 {
    void makeNoise();
}

class Horse implements Animal1{

//    long wt = 1200;
    Long weight = 1200L;
    @Override
    public void makeNoise() {
        System.out.println("Whinny");
    }

}

class Icelandic extends Horse{
    @Override
    public void makeNoise(){
        System.out.println("vinny");
    }

    public static void main(String[] args) {
        Icelandic i1 = new Icelandic(); // makes an object of Icelandic and Long of Horse as it is not of primitive type.
        Icelandic i2 = new Icelandic(); // makes an object of Icelandic and Long of Horse as it is not of primitive type.
        Icelandic i3 = new Icelandic(); // makes an object of Icelandic and Long of Horse as it is not of primitive type.
//      had the weight variable been of the primitive type "long" there would be only 1 object creation.
        i3 = i1;
        i1 = i2;
        i2 = null;
        i3 = null;
        System.gc();
    }
//  4 objects are eligible for garbage collection. 2 of i2 and 2 of i3.
}

