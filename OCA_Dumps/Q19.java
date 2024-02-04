package OCA_Dumps;

public class Q19 {
    public static void main(String[] args) {

        try {
            Object o = new String("ABC");
            StringBuffer sb = (StringBuffer) o;
        }
        catch (ClassCastException cce){
//            cce.printStackTrace();
        }
        Throwable t = new Exception("A");
        System.out.println("Exception : ");
        RuntimeException npe = (RuntimeException) t;
    }
}

class Tree{}
class Redwood extends Tree{
    public static void main(String[] args) {
        new Redwood().go();
    }

    void go(){
        go2(new Tree(), new Redwood());
        go2((Redwood)new Tree(), new Redwood());
    }

    void go2(Tree t1, Redwood r1){
        Redwood r2 = (Redwood) t1; // ClassCastException
        Tree t2 = (Tree) r1;
    }
}

