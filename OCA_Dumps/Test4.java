package OCA_Dumps;

import java.util.Arrays;

public class Test4 {
}

class Test{
    void m1(){}
    public static void main(String[ ] args){
        int[] a = { 1, 2, 3, 4 };
        int[] b = { 2, 3, 1, 0 };
        System.out.println( a [ (a = b)[3] ] );
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        to:{
            if(a[1] >2){
                break to;
            }
        }

        System.out.println(args == null);
        System.out.println(args);
    }
}
