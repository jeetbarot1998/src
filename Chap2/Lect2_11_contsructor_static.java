package Chap2;

public class Lect2_11_contsructor_static {
}

// ============= Constructor, static block, instance block =============
// ============= Field doesn't override the parent's field =============

class Person{

    static int tes = 0;
    static {
        System.out.println("tes " + tes);
        tes = 10;
        System.out.println("Static Block Parent");
        System.out.println("tes " + tes);
    }

    {
        System.out.println("Instance Block Parent");
    }

    int id = 10;
    String name;
}

class Employee211 extends Person{

    static {
        System.out.println("Static Block");
    }

    {
        System.out.println("Instance Block");
    }
    int id = 11;
    private String name;
    private String address;
    private String spouseName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Employee211(int id, String name){
        this.name = name;
        this.id = id;
    }

    Employee211(){}

    public static void main(String[] args) {
        System.out.println("HERE");
        Employee211 ee = new Employee211(1, "ABC");
//      If a parent class and a child class have a field with the same name,
//      the field doesn't override the parent's field.
//      When the compiler has to decide which field to use - the one declared in the parent
//      or the one in the child - it does so based on the type of the reference variable being used.
        Employee211 ee1 = new Employee211();
        Person p = new Employee211();
        System.out.println(ee1.id);
        System.out.println(p.id);
//        System.out.println(ee.getAddress());
//        System.out.println(ee.getId());
//        System.out.println(ee.getName());
//        System.out.println(ee.getSpouseName());
    }

}










