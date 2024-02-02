package OCA_Dumps;

import java.io.IOException;

public class Q3 {
}

class Yup{
    private static int x = 4;
    private final int y = 5;

    public static int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

//    public void setY(int i) {
//        this.y = i;
//    }
}

class Work{
    public static void main(String[] args) {
        Yup y = new Yup();
        y.setX(8);
//        y.setY(10);
        System.out.println(y.getX() +  y.getY());
    }
}

class TestClass{
    private static int x = 5;

    public TestClass(int x) {
        System.out.println("Before " + this.x);
        this.x = x;
        System.out.println("After " + this.x);
    }

    public static int getX() {
        return x;
    }
}

class Demo3{
    public static void main(String[] args) {
        System.out.println(TestClass.getX());
        TestClass t = new TestClass(10);
        System.out.println(t.getX());
        System.out.println(TestClass.getX());
    }
}

class TestClass2{
    public static void main(String[] args) {

        try{
            m1();
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("1");
            System.out.println("The below Null pointer exception does not handled \n" +
                    "as it is not inside a try catch. ");
            throw new NullPointerException();
        }
        catch (NullPointerException nle){
            System.out.println("2");
            return;
        }
        catch (Exception e){
            System.out.println("3");
        }
        finally {
            System.out.println("4");
            return;
        }
//        System.out.println("End");
    }
    static void m1(){
        System.out.println("m1 starts");
        throw new IndexOutOfBoundsException("Big Bang");
    }

    static void m2() throws IOException{
        System.out.println("m1 starts");
        throw new IOException("Big Bang");
    }
}



// Exception, static block, local variable shadowing.
