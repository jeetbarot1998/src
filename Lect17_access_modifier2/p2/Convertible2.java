package Lect17_access_modifier2.p2;

//import Lect17_access_modifier2.p1.Convertible;
import Lect17_access_modifier2.p1.SportCar;

public class Convertible2 extends SportCar {
    public static void main(String ...args) {
//      Accessing with Inheritance "I"
        Convertible2 cv2 = new Convertible2();
//      Able to access this as it is a protected member, as we are using Inheritance "I" to access it
        cv2.protectedMethod();
//      cv2.goFast(); => The class may be public but the method is default and hence we cannot access this

//        =======================================

//      Convertible cv = new Convertible(); => Despite importing the class, and having public methods inside,
//      we cannot make an object of the class as the class has default access.

//        =========================
//      Accessing with reference "R"
        SportCar sc =  new SportCar();
//      sc.goFast() =>  The class may be public but the method is default and hence we cannot access this
//      Cannot access it is a protected member, as we are using reference "R" to access it
//      sc.protectedMethod();

    }
}
