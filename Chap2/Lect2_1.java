package Chap2;

public class Lect2_1 {

    int sa = 'a';
    public static void main(String[] args) {
        int [] a = new int[100];
//      Array is of length 100 and each of it has to be of type int.
//      each int takes 4 bytes.100x4 = 400 bytes of memory allocated to this variable.
//      Adv: similar data together
//      Dis adv: If allocated, then if it has been used or not, the memory is allocated and is blocked.
//      Array list is dynamic array.
        System.out.println(a);
//        int b[] = new int[]; => wont work as we need to give the length
//      Declaration : int b[];
//      Creation : int b[] = new int[5];
//      Initialization : putting values inside the array.

//      Multidimensional arrays: We can assign only one value to the array
//      The values for a certain index in the array can be different.
//      Supposing we have 4 students, all the 4 students can have different amount of subjects selected.
//      This will use less space as we will not have to maintain a matrix will the number of columns
//      for that of the max number of subjects from all the students. S1 might have 10 subjects, while
//      S2 might have 2 subjects and hence we can allocate only needed memory and hence effective
//      use of memory.
        int [] [] b = new int [4] [];
//        int [] [] b1 = new int [] []; => invalid as we need to give the 1st base dimension
//        int [] [] b1 = new int [] [4]; => invalid cannot give 2nd dimension without giving the 1st.
//        int [5] x[]; => invalid
        int x[]= new int[5];
        System.out.println(b.length);

    }
}

class Employee2_1{
    private int salary = 5000;
    private String address = "London";

    public volatile int stockPrice = 100;
    int a = (int) 50L;

    int b = 'i';

    Object q = a;
    public String getAddress() {
        System.out.println(this);
        return address;
    }

    public int getSalary() {
        return salary;
    }


//  var args[] in action.
    public int getSalary(int ...x){
        System.out.println("Array of length " + x.length);
        for(int each_x:x){
            System.out.println(each_x);
        }
//      You can call a static member from an instance member
        staticMethod();
//      but you cannot call an instance member from a static member.
        return x.length;
    }

    public synchronized void callPCO(){
        System.out.println("only one person can talk from PCO at a time");
    }

    public static void staticMethod(){
        System.out.println("called Static method");
    }

    public static void getDept(){
//        System.out.println(this); => as its a static member it will give error.
        System.out.println("IT Dept");
        System.out.println(new Employee2_1().getSalary()); // => can call a non static from static
//      only after making a variable.
//        getSalary(); => Cannot access directly from a static member.
//      you can call a static method from a static method.
        staticMethod();

    }

    public static void main(String ...args) {
        Employee2_1 e = new Employee2_1();
        e.getSalary(1,2,4,5);
        System.out.println(e.getAddress());
        System.out.println(e.getSalary());
        getDept();
        Employee2_1.getDept();
        System.out.println(e.address);
        System.out.println(e.getAddress());
    }

}

class A2{
    public final void test(){
        System.out.println("A2 final");
    }
}

class B2 extends A2{
//    Cannot be over-ridden
//    public final void test(){
//        System.out.println("B2 final");
//    }
//    But can be overloaded
    public final void test(int a){
        System.out.println("B2 final");
    }

    public static void main(String[] args) {
        new B2().test(3);


        Employee2_1 e = new Employee2_1();
        Employee2_1 e1 = e;
        Employee2_1 e2 = new Employee2_1();
        System.out.println(e.equals(e1));
        System.out.println(e.equals(e2));
//        System.out.println(e.address); => Cannot access pvt members of another class.
        System.out.println(e.getAddress());
    }
}


