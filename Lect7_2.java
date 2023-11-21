public class Lect7_2 {
}

class Employee3 {
    int id = 1;
    String name= "Joe";
    int salary = 5000;


    public void setSalary(int newSalary) {
        this.salary = newSalary;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }

    public Employee3(int empId, String empName,  int wages) {
        this.id = empId;
        this.name = empName;
        this.salary= wages;
    }

    public Employee3(){
        ;
    }

    public static void main(String[] args) {
        //To call a setter you must have created an instance of the class.
        Employee3 e1 = new Employee3(); // At this line because we are using no arg constructor empId will get default value as 0 and name will be initialised to null
        Employee3 e2 = new Employee3(1 ,"XYZ", 5000);
        System.out.println("e1 name before setter " + e1.getName());
        //if you want to now change the name to Peter. you need to call setter method
        e1.setName("Peter");
        System.out.println("e1 name after setter " + e1.getName());
        System.out.println("e2 name " + e2.getName());
        //Note: to call a setter method instance must have been created before hand, the moment you create instance it initialises the attributes with default values
        // or the values passed as an argument.   In this case default name null be changed to Peter after you call the setName method.

        //Next video will make the difference pretty clear with coding examples
    }
}


class Guest {
    String name;
    public Guest(String guestName) {
        this.name = guestName;   //line 3
    }

    public static void main(String arg[ ] ) {
        Guest guest1 = new Guest("Peter");   // Line 1
        Guest guest2 = new Guest("Sam");   // line 2
        System.out.println(guest1.name);
        System.out.println(guest2.name);
    }
    // Note: At line 1 when you create Object of Guest class we are initialising guest name attribute with Peter. It will invoke/call constructor of Guest class
    //    and at this point "this" on line 3 will refer to the current object which is guest 1 whose name is Peter.

    // At line 2 when you create Object of Guest class we are initialising guest name attribute with "Sam". It will invoke/call constructor of Guest class
    //    and at this point "this" on line 3 will refer to the current object which is guest 2 whose name is "Sam".
}

class PrimeMinister {
    String name;
    String gender;

    public PrimeMinister(String name, String gender) {
        this.name = name;    // Here "this" keyword will refer to the current object (current prime minister)
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public static void main(String args[] ) {
        PrimeMinister p1 = new PrimeMinister("David Cameroon", "Male");
        PrimeMinister p2 = new PrimeMinister("Theresa May", "Female");
        PrimeMinister p3 = new PrimeMinister("Boris Johnson", "Male");
        PrimeMinister p4 = new PrimeMinister("Lizz Truss", "Female");
        PrimeMinister p5 = new PrimeMinister("Rishi Sunak", "Male");
        System.out.println(p1.getName());
        System.out.println(p2.getName());
        System.out.println(p3.getName());
        System.out.println(p4.getName());
        System.out.println(p5.getName());
    }

}

