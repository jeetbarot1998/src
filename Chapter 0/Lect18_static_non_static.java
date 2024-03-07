public final class Lect18_static_non_static {

    private final int salary = 5000;
    void m1(){
        System.out.println("m1 called");
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int sal) {
//        this.salary = sal; => cannot do this as the value is final
        ;
    }


}

class test18{
    public static void main(String[] args) {
        Lect18_static_non_static l = new Lect18_static_non_static();
        l.m1();
        System.out.println(l.getSalary());
    }
}

//class inheritance extends Lect18_static_non_static{} => Cannot extend as the parent class is final

class Employee18{
    private int id;
    private String name;

    public static String dept = "Psychology";
    void m1(){
        System.out.println("hi");
    }

    public static void main(String[] args) {
        Employee18 e18 = new Employee18();
//      m1() is an instance variable a hence it needs an object to call the function
        e18.m1();
//      can call the static member directly without making an instance of the class as it is not an
//      instance member
        System.out.println(dept);
//      Or you can use the reference of the class to do the same
        System.out.println(Employee18.dept);
    }

}

