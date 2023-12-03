package Chap4;


public class BitWise{
    public static void main(String[] args) {
        System.out.println(4&5);
        System.out.println(4|5);
        System.out.println(4^5);
        System.out.println(true & true);
        System.out.println(true & false);
        System.out.println(false & false);
        System.out.println(false & true);
        System.out.println(true | true);
        System.out.println(true | false);
        System.out.println(false | false);
        System.out.println(false | true);
        System.out.println(true ^ true);
        System.out.println(true ^ false);
        System.out.println(false ^ false);
        System.out.println(false ^ true);


        System.out.println("BITWISE COMPlIMENT ");
//        System.out.println(~true); //error
        System.out.println(~4);
        System.out.println(~0B100);

        System.out.println("BOOLEAN COMPlIMENT ");
        System.out.println(!true);
        System.out.println(!false);
//        System.out.println(!4); // error
        System.out.println(!getX());
    }

    public static boolean getX(){
        return true;
    }
}
