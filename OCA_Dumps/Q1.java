package OCA_Dumps;

//System.arraycopy(source arr, offset in source arr, destination arr, offset in destination arr, length to be copied)

public class Q1 {
    final public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6};
        int [] b = {0,0,0,0,0,0};
        System.arraycopy(a,2,b,3,2);
        // copy from index 2 of array 'a', to index 3 of array 'b'
        // for length 2.
        for(int i: b){
            System.out.println(i);
        }
    }
}

//'main(String[])' cannot override 'main(String[])' in 'OCA_Dumps.Q1'; overridden method is final
//class Q2 extends Q1{
//    public static void main(String[] args) {
//
//    }
//}


class TQ11{
    public static void main(String[] args) {
        short [] [] b = new short[4][4];
        short [] [] big = new short[2][2];
        short b3 = 8;
        short [] [] [] [] b2 = new short[2][3][2][2];
        b2[1][1] = big;
        b[1][0] = b3;
//        b2[0][1][1] = b;
//        b2[0][2][1] = b[1][0];
        b2[1][1][0][1] = b[1][0];
        b2[1][1] = b;
    }
}


class TQ12{
    public static void main(String[] args) {
        calculate(2);
    }

    static void calculate(int x){
        String val;
        switch(x){
            case 2:
                String a = "A";
//                val = "def"; If here then CE.
//                break; If break then CE.
            default:
                a = "O"; // without this you cannot print 'a'.
                System.out.println(a);
//                System.out.println(a); // Not accessible.
                val = "def";
        }
        System.out.println(val);
    }
}

class TQ13{

}



