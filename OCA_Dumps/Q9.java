package OCA_Dumps;

class TQ91{
    static String st = "JAVA";
    static void changeIt(String s){
        s = "Hello World";
    }

    public static void main(String[] args) {
        changeIt(st);
        System.out.println(st);
    }
}

public class Q9 {
    public static void main(String[] args) {
        Dimension dim = new Dimension(10,20);
        System.out.println(dim.x + " " + dim.y);
        changeIt(dim);
        System.out.println(dim.x + " " + dim.y);
    }

    static void changeIt(Dimension d){
        d.x = 50;
        d.y = 60;
    }
}

class Dimension{
    int x;
    int y;

    public Dimension(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class TQ92{
    static String m1(){
        try{
            int x = 5/0;
        }
        catch (Exception e){
            return "hi";
        }
        finally {
            return "finally";
        }
//        Unreachable statement
//        return "hi";
    }

    public static void main(String[] args) {
        System.out.println(m1());
    }
}















