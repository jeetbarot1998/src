package Chap5_6;

import java.io.IOException;

public class Lect4 {
}

class ValidTryBlocks{
    public static void main(String[] args) {

//      1.  Try with multiple catch
        try{}
//      can have a narrower scope before the wider scope or else it will say
//      Exception already been caught
        catch (ArithmeticException x){}
        catch (Exception x){}
//        catch (Exception x){} // Exception already been caught.
//        catch (ArithmeticException x){} // Exception already been caught

//      2. try with finally without catch
//      CORRECT:
//      even if exception occurs in try
//      the JVM will have to execute the 'finally' block.
        try {
            System.out.println(7/0);
        }
        finally {
            System.out.println("Inside Finally");
        }

//        3. cannot have catch without try
//        INCORRECT:
//        catch(Exception E){}
//        finally{}
    }
}

class TryExample{
    public static void main(String[] args) {
        TryExample te = new TryExample();

    }

    void m1() throws IOException {
        try {
//            return; //makes the line below unreachable
            throw new IOException();
        }
        finally {
            System.out.println("finally block executed");
        }
    }

    void m2() throws IOException {
        try{
            throw new IOException();
        }
        catch (Exception e){
            throw new IOException();

        }
    }

    void m3() {
        try{
            throw new IOException();
        }
        catch (Exception e){
            try {
                throw new IOException();
            }
            catch (IOException ex) {
                throw new RuntimeException(ex);
            }
//          Variable 'e' is already defined in the scope
//            catch (IOException e) {
//                throw new RuntimeException(e);
//            }
        }
    }

    void m4() {
        try{
            throw new IOException();
        }
        catch (Exception e){
            try {
                System.out.println("Inside try");
                throw new IOException();
            }
            catch (IOException ex) {
                System.out.println("Inside catch");
//                throw new RuntimeException(ex);
            }
        }
        finally {
            try {
                System.out.println(7/0);
            }
            catch (Exception e){
                System.out.println(e);
            }
            finally {
                System.out.println("inside finally");
            }
        }

    }
}

class Titanic{
    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = true;
        boolean b3 = true;
//      ==================
        if((b1&b2) | (b2&b3) & b3){
            System.out.println("alpha");
        }
        if((b1=false) | (b1&b3) | (b1|b2)){
            System.out.println("beta");
        }

//        ==================
        if(false)
            System.out.println("If you want to execute single line \n" +
                    "Then you need not add the curly braces");
        else
            System.out.println("Else Statement");

//      ==================
        if(true)
            System.out.println("If you want to execute single line \n" +
                "Then you need not add the curly braces");
        else
            System.out.println("Else Statement");

//      ==================
        if(true)
            System.out.println("Line 142");
        else;


//      ==================
        if (true);
        else
            System.out.println(10);

//      ==================
        if(true);
        else;

//      ==================
        System.out.println("There cannot be any statement between if and else");
//        if(true);
//        System.out.println("HI");
//        else;


//      ======== Declaration not allowed here =========
        System.out.println("Declaration not allowed here");
//        first line cannot be declarative in
//        if statement having no curly braces
//        if(true)
//            int x =10;
//        while (true)
//            int p =5;

        if (true){
            int o = 4;
            System.out.println(o);
        }

//      ========= else wo if =========
//        int x=5;
//        if(true)
//            x =10;
//            System.out.println(++x);
//            System.out.println(++x);
//        else;

//      ==================
        int x=5;
        if(true)
            x = 10;
        int y = 10;
//            System.out.println(x);
        System.out.println(x);


//      ==================


    }
}

class Titanic1{
    ;
}

class Titanic2{
    public static void main(String[] args) {
        ;
    }

    void m1(){
        ;
    }
}


class SwitchCase{
    public static void main(String[] args) {
//      switch case is like one time loop over all
//      the 'if' statements inside switch
//      break; statement ends the checking of all the ifs

//      For Switch cases, we can use
//      byte, short, int, char + Wrapper classes, String
        int x =2;
        System.out.println("x=2");
        switch (x) {
            case 1:
                System.out.println(1);
//              if we do not write break, then it will go
//              and look out for every other match case
                break;
            case 2:
                System.out.println(2);
//          Duplicate label '2' : hence won't work
//            case 2:
//                System.out.println(2);
            case 10:
                System.out.println(10);
            default:
//              it will not come to default as
//              one of the cases has matched.
                System.out.println("default");
        }
        System.out.println("x=1");
        x = 1;
        switch (x){
            default:
                System.out.println("default");
            case 1:
                System.out.println(1);
//              if we do not write break, then it will go
//              and look out for every other match case
                break;

            case 2:
                System.out.println(2);
            case 10:
                System.out.println(10);

        }

        System.out.println("x=10");
        x = 10;
        switch (x){
//          if there is no match then default is selected, hence
//          it has no break statement, hence the flow
//          goes to the nest select as well
            default:
                System.out.println("default");
            case 1:
                System.out.println(1);
//              if we do not write break, then it will go
//              and look out for every other match case
                break;

            case 2:
                System.out.println(2);
            case 11:
                System.out.println(10);

        }


//      ===================
        System.out.println("Legal switch empty");
        switch (x){}


//      ===================
        System.out.println("Legal switch only default");
        switch (x){
            default:
        }


//      ===================
        System.out.println("Legal switch default");
        switch (x){
            case 1:
        }



//      ======== Illegal ===========
        System.out.println("Illegal");
//        switch (x){
//            System.out.println("Hello");
//        }
    }
}






