package OCA_Dumps;

import java.sql.SQLException;

public class Q18 {
    private static void getData() throws SQLException{
        try{
            double f = 10;
            System.out.println(f);
            throw new SQLException();
        }
        catch (Exception e){
            e = new SQLException();
//            throw new SQLException();
//            throw e; // CE as 'Exception' type is thrown and delegation is only done of 'SQLException'
            e =  null;
            throw null;
//            throw e;
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

class A18{}
class B18 extends A18{}
class Driver18{

    static void m1(B18 b){
        System.out.println("hi");
    }

    public static void main(String[] args) {
        A18 ab =  new B18();
//        m1(ab);
    }
}
