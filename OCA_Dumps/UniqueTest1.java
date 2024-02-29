package OCA_Dumps;

import java.io.IOException;
import java.sql.SQLException;

public class UniqueTest1 {
    static public void stringProcessor(String... strs){ }

//    static public void stringProcessor(String[] strs){ }

    public static void main(String[] args) {
        String s = "ABC";
        String s1 = "ABC";
        String s2 = "ABC";
        stringProcessor(s,s1,s2);
        boolean b = true;
//        System.out.println(1+b+3); error CE
    }
}
interface House{
    public default String getAddress(){
        return "101 Main Str";
    }
}
interface Bungalow extends House{
    public default String getAddress(){
        return "101 Smart Str";   }
}
class MyHouse implements Bungalow, House{
    public static void main(String[] args) {
        new MyHouse().getAddress();
//        short s = 100;
//        char c = 200;
//        c = s; // CE
//        s = c; // CE
    }
}



class PortConnector{
    public PortConnector(int port) throws IOException {}
}

class CleanConnector extends PortConnector{
    CleanConnector() throws IOException {
        super(5);
    }
}



class TestClassu1{
    static boolean b;
    static int[] ia = new int[1];
    static char ch;
    static boolean[] ba = new boolean[1];
    public static void main(String args[]) throws Exception{
        boolean x = false;
        if( b ){
            x = ( ch == ia[ch]);
        }
        else x = ( ba[ch] = b );
        System.out.println(x+" "+ba[ch]);
    }
}


class TestClassu11 {
    public static void main(String[] args) {
        someMethod(null);
    }
    static void someMethod(Object parameter)  {
        System.out.println("Value is "+parameter);
    }
}

class Testu12{
    public static void main(String[] args){
        int d = 0;
        try{
            int i = 1 / (d* doIt());
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public static int doIt() throws Exception{
        throw new Exception("Forget It");
    }
}

class Q18u {
    private static void getData() throws SQLException {
        try{
            double f = 10;
            System.out.println(f);
            throw new SQLException();
        }
        catch (Exception e){
//            e = new SQLException();
//            throw new SQLException();
            throw e; // ERROR.
//            throw null;
        }
    }

    public static void main(String[] args) {
        try{
            getData();
        }
        catch (SQLException s){
            System.out.println("SQL");
        }
    }

}