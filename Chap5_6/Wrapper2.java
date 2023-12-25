package Chap5_6;

public class Wrapper2 {
    static Integer I = 10; // ( At compile time: Primitive to Wrapper, hence Integer.valueOf(10); )

    public static void main(String[] args) {
        int i = I; // ( At compile time: Wrapper to Primitive;  same as int i = I.intValue(); )
        m1(i); //( At compile time: Primitive to Wrapper, hence Integer.valueOf(i); )
        m2();
        m3();
        pooling();
        pooling2();
        m4();
        m5();
        m6Boolean();
        m7Boolean();
    }

    /**
    - To provide support for autoboxing and unboxing of wrapper objects, a buffer is created at the loading time
    - There is a pool constant for Byte, Short, Integer, Long which ranges from -128 to 127. 0 to 127 for character and true or false for Boolean. There is no such buffer pool for Float, Double.
    - This making of the buffers happens at the time of class loading inside static block.
    **/

    static void m1(Integer k){
        System.out.println("=================m1");
        int m = k; // ( At compile time: Wrapper to Primitive;  same as int m = k.intValue(); )
        System.out.println(m); // 10
    }

    static void m2(){
        System.out.println("=================m2");

        Integer x = 10;
        Integer y = x;
        x++;
        System.out.println(x);
        System.out.println(y);
        System.out.println(x == y);
    }
    static void m3(){
        System.out.println("=================m3");
        /** on compile time
         * Integer x = Integer.valueOf(10);
         * Integer y = Integer.valueOf(10);
         * As the number lie in range -127 and +128
         * Both of these point to the same value n the buffer
         */
        Integer x = 10;
        Integer y = 10;
        System.out.println(x);
        System.out.println(y);
        System.out.println(x == y); // true
    }

    static void pooling(){
        System.out.println("=================pooling");
        /**
         - Here we are using 'new Integer()' and hence it makes new object on the heap and points ther
         - a buffer is created at the loading time
         **/
        Integer x = new Integer(10);
        Integer y = new Integer(10);
        System.out.println(x == y); // false
    }

    static void pooling2(){
        System.out.println("=================pooling2");
        /** here 'x' is on heap and y is pointing to the buffer
         * as 10 lies between -127 and +128.
         **/
        Integer x = new Integer(10);
        Integer y = 10; // ( At compile time it will become Integer y = Integer.valueOf(10); )
        System.out.println(x == y); // false
    }

    static void m4(){
        System.out.println("=================m4");
        /** on compile time
         * Integer x = Integer.valueOf(10);
         * Integer y = Integer.valueOf(10);
         * As the numbers lie in range -127 and +128
         * Both of these point to the same value n the buffer
         */
        Integer x = 10;
        Integer y = 10;
        System.out.println(x == y); // true
    }

    static void m5(){
        System.out.println("=================m5");
        /** on compile time
         * 1000 does not lie between -127 and +128.
         * Thus, it cannot point to the buffer. It will create new object
         * on heap
         * Thus it is recommended to always use
         * '''''Integer.valueOf(<primitive>)'''''.
         **/

        Integer x = 1000;
        Integer y = 1000;
        System.out.println(x == y); // false
    }

    static void m6Boolean(){
        /** on compile time
         * Boolean buffer has true and false in it
         * Boolean b = new Boolean("true"); => makes new object on heap
         * Boolean b1 = Boolean.valueOf("true"); => points to the buffer
         * As, comparing 2 objects,one from heap and another from buffer
         * hence comparison gives false.
         */
        System.out.println("=================m6Boolean");
        Boolean b = new Boolean("true");
        Boolean b1 = Boolean.valueOf("true");
        System.out.println(b==b1);// false
    }

    static void m7Boolean(){
        /** on compile time
         * Boolean buffer has true and false in it
         * Boolean b = Boolean.valueOf("true"); => points to the buffer
         * Boolean b1 = Boolean.valueOf("true"); => points to the buffer
         * Comparing 2 objects from the buffer having same value, hence
         * result is 'true'.
         */
        System.out.println("=================m7Boolean");
        Boolean b = Boolean.valueOf("true");
        Boolean b1 = Boolean.valueOf("true");
        System.out.println(b==b1); // true
    }
}
