package Chap5_6;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rev_Lect3 {
}

class Flip2 {
    public static void main(String[] args) {
        String o = "-";
        String[] sa = new String[4];
        for(int i = 0; i < args.length; i++)
            sa[i] = args[i];
        System.out.println(Arrays.toString(sa));
        for(String n: sa) {
            System.out.println(n);
            System.out.println(o);
            switch(n.toLowerCase()) {
                case "yellow": o += "y";
                case "red": o += "r";
                case "green": o += "g";
            }
        }
        System.out.print(o);
    }
}


class ForLoop3 {
    public static void main(String[] args) {

        /*
         * for(<any_java_statement> (Optional); <boolean(default = true) (Optional) > ;
         *  <any_java_statement>(Optional) )
         * */
        ValidForLoop();
    }

    static void Loop1() {
        int i = 0;
        for (System.out.println("Only once"); i < 3; System.out.println("As long as the check is valid")) {
            i++;
        }
    }

    static void Loop2() {
        for (int i =0, j=0; i<10 || j<20; i++,j=j+2){
            System.out.println("Hello");
        }
    }

    static void Loop3() {
        for (int i =0; i<3 ; i++);
    }

    static void LoopNotReachable() {
        System.out.println("In the below For loop, the boolean is true by default if not set");
        for (; ; ) {
            System.out.println("hi");
        }
//        System.out.println("I am not reachable");
    }

    static void LoopNotReachable1() {
        for (; true; ) {

        }
//        System.out.println("I am not reachable");
    }

    static void LoopNotReachable2() {
        for (; 5 < 7; ) {

        }
//        System.out.println("I am not reachable");
    }

    static void InfiniteLoop() {
        for (int i = 0; ; i++) {

        }
//        System.out.println("I am not reachable");
    }

    static void Unreachable(){
        for(;;);
//        System.out.println("I am unreable");
    }

    static void LoopNotReachable3() {
        System.out.println("Loop condition is always false making the loop body unreachable");
//        for (; false; ) {
//
//        }
        System.out.println("I am reachable");
    }

    void LoopNotReachable4() {
        System.out.println("Loop condition is always false making the loop body unreachable");
//        for (; 5>7; ) {
//
//        }
        System.out.println("I am reachable");
    }

    static void traverseMultiDimensionalTraditional(){
        int arr[][] = new int[][]{{1,2,3}, {4,5}};
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[i].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void traverseMultiDimensionalEnhanced(){
        int arr[][] = new int[][]{{1,2,3}, {4,5}};
        for (int[] ar : arr){
            for (int i : ar){
                System.out.println(i + " ");
            }
            System.out.println();
        }
    }

    static void ValidForLoop(){
        int x = 3;
        for (x = 12; x < 20; x++) { }
        System.out.println(x);
    }

}


