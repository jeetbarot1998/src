package OCA_Dumps;

public class Test8 {
}

class TestClass82{
    public static void main(String[] args){
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int counter = 0;
        for (int value : arr) {
            if (counter >= 5) {
                break;
            } else {
                continue;
            }
//            if (value > 4) {
//                arr[counter] = value + 1;
//            }
//            counter++;
        }
        System.out.println(arr[counter]);
    }
}


class TestClass81{
    public void method(Object o){
        System.out.println("Object Version");
    }
    public void method(java.io.FileNotFoundException s){
        System.out.println("java.io.FileNotFoundException Version");
    }
    public void method(java.io.IOException s){
        System.out.println("IOException Version");
    }
    public static void main(String args[]){
        TestClass81 tc = new TestClass81();
        tc.method(null);

    }
}


class ArrayTest{
    static int x= 5;
    public static void main(String[] args){
        int x  = ( x=3 ) * 4;  // 1
        System.out.println(x);
        int ia[][] = { {1, 2}, null };
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                System.out.println(ia[i][j]);
    }
}


class Triangle{
    public int base;
    public int height;
//    private final double ANGLE;

//    public  void setAngle(double a){  ANGLE = a;  }

    public static void main(String[] args) {
//        Triangle t = new Triangle();
//        t.setAngle(90);
    }
}


class TestClass83{
    public static void main(String args[]){
        int i = 0;
        loop :         // 1
        {
            System.out.println("Loop Lable line");
            try{
                for (  ;  true ;  i++ ){
                    System.out.println("i" + i);
                    if( i >5) break loop;       // 2
                }
            }
            catch(Exception e){
                System.out.println("Exception in loop.");
            }
            finally{
                System.out.println("In Finally");      // 3
            }
        }
        System.out.println(i);
    }
}

class Super1{
    static{ System.out.print("super "); }
}
class One{
    static {  System.out.print("one "); }
}
class Two extends Super1{
    static {  System.out.print("two "); }
}
class Test82{
    public static void main(String[] args){
        One o = new One();
        Two t = new Two();
    }
}


interface Flyer81{ }
class AirPlane implements Flyer81{ }
class TestClass84 {
    static void flyIt(Flyer81 f){
        System.out.println("Flyer Flying");
    }
    static void flyIt(AirPlane a){
        System.out.println("AirPlane Flying");
    }
    public static void main(String[] args){
        Flyer81 f = new AirPlane();
        AirPlane a = new AirPlane();
        flyIt(f);  //1
        flyIt(a);  //2
//        System.out.println(null + true); //1
//        System.out.println(true + null); //2
//        System.out.println(null + null); //3
    }
}

class Test85{
    public static void main(String[] args){
        int k = 1;
        int[] a = { 1 };
        k += (k = 4) * (k + 2);
        a[0] += (a[0] = 4) * (a[0] + 2);
        System.out.println( k + " , " + a[0]);
    }
}



