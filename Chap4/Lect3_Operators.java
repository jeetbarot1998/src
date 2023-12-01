package Chap4;

import java.lang.reflect.Method;

public class Lect3_Operators {
    public static void main(String[] args) {
        Thread t = new Thread();
        System.out.println("t instanceof Thread " + (t instanceof Thread));
        System.out.println("t instanceof Object " + (t instanceof Object));
        System.out.println("t instanceof Runnable" + (t instanceof Runnable)); // Thread implements Runnable interface
//        System.out.println(t instanceof null);
//        System.out.println(t instanceof String);
        System.out.println("null instanceof String" + (null instanceof String));
        System.out.println("null instanceof Object" + (null instanceof Object));
        System.out.println("null instanceof Runnable" + (null instanceof Runnable));

    }
}

class BitwiseOperator{
    public static void main(String[] args) {

//      BITWISE OPERATOR ARE VALID FOR BOOLEAN AND INTEGER TYPES (&,|,^)
//      AND
        System.out.println(true & true);
        System.out.println(true & false);
        System.out.println(4 & 5); // equivalent to (100 & 101)
//      OR
        System.out.println(true | false);
        System.out.println(true | false);
        System.out.println(4 & 5); // equivalent to (100 | 101)
//      X-OR
        System.out.println(true ^ false);
        System.out.println(true ^ false);
        System.out.println(4 ^ 5); // equivalent to (100 ^ 101)

//      BITWISE COMPLIMENT OPERATOR ARE VALID ONLY FOR INTEGER (~)
        System.out.println(~4);
//        System.out.println(~true); // error

//      Negation of boolean
        System.out.println(!true);

//      SHORT CIRCUIT operator (&&,||)
//      The execution of the 2nd operator is optional. Only check 2nd condition if the 1st condition is true.
//      situation: supposing you are trying to log-in into fb, and if you use the wrong username, it makes no sense to
//      check if the password is correct or not. Hence, the 2nd parameter becomes redundant
//      It is only valid for boolean type, not valid for integer type.

//      Due to single "&" operator, both the conditions are executed
        int x = 10;
        int y = 15;
        if(++x <10 & ++y>15){
            x++;
        }
        else{
            y++;
        }
        System.out.println(x + ", " +y);
        System.out.println(x + y);

//      Due to double "&&" operator, 2nd condition will only be checked
//      if 1st condition is true.
        int a = 10;
        int b = 15;
        if(++a <10 && ++b>15){
            a++;
        }
        else{
            b++;
        }
        System.out.println(a + ", " + b);
        System.out.println(a + b);


//      Due to single "|" operator, 2nd condition will be checked unconditionally.
        int a2 = 10;
        int b2 = 15;
        if(++a2 <10 | ++b2>15){
            a2++;
        }
        else{
            b2++;
        }
        System.out.println(a2 + ", " + b2);
        System.out.println(a2 + b2);


//      Due to double "||" operator, 2nd condition will be checked unconditionally.
        int a1 = 10;
        int b1 = 15;
        if(++a1 <10 || ++b1>15){
            a1++;
        }
        else{
            b1++;
        }
        System.out.println(a1 + ", " + b1);
        System.out.println(a1 + b1);


        int x2 = 12;
//      As the 1st condition is false, it will not check the 2nd condition.
        if (++x2 < 10 && x2/0 >10){
            System.out.println("Hello");
        }
        else {
            System.out.println("Hi");
        }

    }
}

class ConditionalOperator{
    public static void main(String[] args) {
        int x = (10<20) ? 30 : 40;
        int x1 = (10<20) ? 30 : ((40>50) ? 60 : 70);
    }
}

class ChainedOperator{
    public static void main(String[] args) {
        int x,y,z,o;
        x=y=z=o=10;
//      invalid assignment
//      int a =b =c =d =10; // error
        System.out.println(x+=y-=z*=o/=2);
    }
}

class CompoundOperator{
    public static void main(String[] args) {
        int a = 10;
        a +=20; // a = a + 20;
//      in compound operator, iit does implicit type casting
        byte b =10;
//      invalid: need explicit type casting
//        b = b + 10;
        b += 10;
    }
}

class DynamicClassBuilder{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Object obj = Class.forName("Chap4.Employee").newInstance();
        System.out.println(obj.getClass().getName());
        Method[] methods = obj.getClass().getMethods();
        for (Method each_method : methods){
            System.out.println(each_method.getName());
        }
    }
}



