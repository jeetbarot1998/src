package Chap3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Chap3_5 {
}

class Test1{
    private static void m1(Employee35 e){
        e.setId(5);
        e = new Employee35("CDE", 7);
        e.setId(9);
    }

    public static void main(String[] args) {
        int val = 10;
        Employee35 e = new Employee35("ABC", 2);
        m1(e);
        System.out.println(e.getId());
    }
}

class Employee35{
    private String name;
    private int id;

    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public Employee35(String s, int i) {
        this.name = s;
        this.id = i;
    }
}

// =========================================================

class Beta{
    public static void main(String[] args) {
        Alpha am1 = new Alpha(4);
        Alpha am2 = new Alpha(4);
        Alpha []ar = fill(am1, am2);
        System.out.println(ar[0].val);
        System.out.println(ar[1].val);
    }

    static Alpha[] fill(Alpha a1,Alpha a2){
        a1.val = 2;
        Alpha [] fa = new Alpha[]{a1, a2};
        return fa;
    }
}

class Alpha{
    int val;
    Alpha(int val){
        this.val = val;
    }
    static Beta b = new Beta();
    static int sval = 200;
}


// ================ Encapsulation of Ref variable ================

class Special {
    private StringBuilder s = new StringBuilder("bob"); // our special data
    StringBuilder getName() { return s; }
    void printName() { System.out.println(s); } // verify our special
// data
}
class TestSpecial {
    public static void main(String[] args) {
        Special sp = new Special();
        StringBuilder s2 = sp.getName();
        s2.append("fred");
        sp.printName();

        int[][] originalArray = {{1, 2}, {3, 4}};
        int[][] shallowCopy = originalArray.clone(); // Shallow copy (references are copied)

        originalArray[0][0] = 99; // Modifying the original array
        System.out.println(Arrays.deepToString(shallowCopy)); // Output: [[99, 2], [3, 4]] - Reflects changes made in originalArray

    }
}

class Test35 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Object obj = Class.forName("Chap3.Employee1").newInstance();
        System.out.println(obj.getClass().getName());
        Method[] declaredMethods = obj.getClass().getDeclaredMethods();
        Method m1 = null;
        for( Method m: declaredMethods){
            if(m.getName().equals("getSalary")){
                m.setAccessible(false);
                m1 = m;
            }
        }

        Employee1 operationInstance = new Employee1();
        System.out.println(m1.invoke(operationInstance));
        System.out.println(m1.getName());

    }
}





