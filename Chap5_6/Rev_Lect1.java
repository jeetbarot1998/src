package Chap5_6;

import java.util.Arrays;

public class Rev_Lect1 {
    public static void main(String[] args) {
        Array1();
        Array2();
        Array3();
        Array4();
    }

    private static void Array1(){
        int a[]; // declaration
        a = new int[10]; // allocation
        int [] u = new int[2];
//        u = {3, 4};
        System.out.println(Arrays.toString(u));
//        int [] a1 = new int[2] {1,2}; // already array is defined,
        // hence do not specify the size exclusively
        int [] a2 = new int[] {1,2};
        int [] a3 = new int[2]; // memory for array is allocated with default value
        int [] a4 = {1,2};
        int [] [] a5 = new int[2][];
//        System.out.println(a5[0][0]); // AIOBE

        int [] r = {1,25};
        System.out.println(r[1]);
        System.out.println(r.length);
        int [] [] x1 = new int[4][2];
        System.out.println("x1[0] : " + x1[0]);
        System.out.println("x1[0][0] : " + x1[0][0]);
        System.out.println("x1[0][1] : " + x1[0][1]);
        System.out.println("x1[3] : " + x1[3]);
//        System.out.println(x1[0][2]); // AIOBE

        x1[0] = new int[] {2,3,4};
        x1[1] = new int[] {4,8};
        System.out.println(x1[0] + " = " + Arrays.toString(x1[0]));
        int x2 [] [] =  new int[][] {{1,2}, {3,4}, {4,5}, {7,9}};
        System.out.println();
        System.out.println(x2[0] + " = " + Arrays.toString(x2[0]));
        int []  y =  new int[][] {{1,2}, {3,4}, {4,5}, {7,9}}[0]; // take the 1st index from the array
        System.out.println(y[0]);


        String [] [] s = new String[4][2];
        System.out.println("s[0] " + s[0]);
        System.out.println("s[0][0] " + s[0][0]);

        String [] c = {"Hello", "World"};
        System.out.println(c[1]);

        int [] k = new int[2];
        k[0] = 5;
        k[1] = 8;
//        k[2] = 10; // AIOBE
        System.out.println(k);
    }


    private static void Array2(){
        System.out.println("========================= Array2 ===============================");
        String [] ej = new String[][] {{null}, new String[]{"a","b","c"}, {new String()}}[0];
        String [] ej0 = new String[][] {{null}, new String[]{"a","b","c"}, {new String()}}[1];
        String [] ej1 = null;
        String [] ej2 = {null};
        System.out.println(ej0[0]);
        System.out.println(ej + " = " + Arrays.toString(ej));
        System.out.println(ej1 + " = " + Arrays.toString(ej1));
        try{
            System.out.println(ej1[0]);
        }
        catch (NullPointerException npe){
            System.out.println("ej1 is pointing to null and hence NullPointerException");
        }
        System.out.println(ej2 + " = " + Arrays.toString(ej2));
        System.out.println(ej2[0]);
    }

    private static void Array3(){
//        int [] x = new int[0]{}; //invalid
//        new int[2]; // Not a statement
        int [] y = new int[][]{{1}}[0];
        int [] x = new int[]{};
//        int x = new int[]{};
        int x1 [] = {};
    }

    private static void Array4(){
        String chs [] [] = new String[5][2];
        chs[0] = new String[2];
        chs[1] = new String[5];
        int i =97;
        try{
            for (int a = 0; a<chs.length ; a++){
                for ( int b = 0; b< chs.length ; b++){
                    chs[a][b] = "" + i;
                    i ++;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException aiobe){
            System.out.println("Array index out of bound exception.");
        }

        for(String [] ca : chs){
            for (String c:ca){
                System.out.println(c + " ");
            }
        }
    }


}

class Test1{
    public static void main(String[] args) {
        byte [] [] big = new byte[7][7];
        byte [] [] b = new byte[2][1];
        byte b3 = 5;
        byte b2 [][][][] = new byte[2][3][1][2];
        /*
        b2[0][1] = b;
        b[0][0] = b3;
        b2[1][1][0] = b[0][0];
        b2[1][2][0] = b;
        b2[0][1][0][0] = b[0][0];
        b2[0][1] =  big;
         */
    }
}