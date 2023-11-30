package Chap4;

public class Lect1 {
}

class Wind{

    int id;
    static int i = 2;
    Wind(int i){
//        i = this.i;
        this.id = i;
    }

    private void go(){
        Wind w1 = new Wind(1);
        Wind w2 = new Wind(2);
        System.out.println(w1.id + " " + w2.id);
    }

    public static void main(String[] args) {
        new Wind(3).go();
    }

}



class Ouch {
    static int ouch = 7;
    public static void main(String[] args) {
        new Ouch().go(ouch);
        System.out.print(" " + ouch);
    }
    void go(int ouch) {
        ouch++;
//      Variable 'ouch' is already defined in the scope
//        for(int ouch = 3; ouch < 6; ouch++)
//            ;
//      But just reassignment of the variable will work fine
        for(ouch = 3; ouch < 6; ouch++)
            ;
        System.out.print(" " + ouch);
    }
}
