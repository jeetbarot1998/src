package emplyeeStstem;

class Lect11 {
    public String name;
    private int salary;
    private String address;
    private boolean isContractor;
//    Key word "static" means that it does not belong to any particular instance of the class.
//    It is a "static" property of the class.
//    It is a class level attribute
    public static String dept = "IT";

//    This is a methods which can only be invoked via an object of the class
    public String getName() {
        return name;
    }
// But "static" methods are class level attributes and hence you do not need an object of the class to invoke this method.
    public static String getAddress(){
        return "Address";
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

/** so a static method can start even without having an object of a class.
 * So as there is supposed to be beginning of the code without having an object of a class
 * had this method not been static then you would have to make an object of the class and then start the rest of the program.
 * But in this case as the program starts there is no object of any class and hence there exists a "static" method which
 * can start the program without having an object of any class. You can run the code inside the static methods without needing
 * to have an object of any other class. As the method is static you need not have an object of a class and you need not have
 * an object of a class to call that certain "static" method. "static" is a class level attribute not a object level attribute.
 * "static" methods are class level attributes and hence you do not need an object of the class to invoke this method.
**/
    public static void main(String[] args) {
        System.out.println("This is my first class");
        Lect11 obj1 = new Lect11();
        obj1.setName("ABC");
        obj1.setSalary(2000);
        Lect11 obj2 = new Lect11();
        obj2.setName("DEF");
        obj2.setSalary(1500);
        System.out.println(obj1.getName());
        System.out.println(obj1.getSalary());
        System.out.println(obj2.getName());
        System.out.println(obj2.getSalary());

        Lect11 obj3 = new Lect11();
        System.out.println(obj3.getName());
        System.out.println(obj3.getSalary());

//      As we are calling a static method we can directly call it without making an object of the class
        System.out.println(getAddress());
    }
}

class Student0 {
    int rollNumber;  // if we don't assign any value this will get default value as 0
    String name;  // if we don't assign any value this will get default value as null
    boolean isHostelResident;  // if we don't assign any value this will get default value as false;
}

class Student1 {
    int rollNumber = 101;  // Here we are explicitly assigning roll number as 101.. So all objects or students will be initialised with roll number as 101
    String name = "Peter"; // Here we are explicitly assigning name as Peter..So all objects or students will be initialised with name as Peter.(all Peters in the class)
    boolean isHostelResident= true; // iHere we are explicitly isHostelResident as true..So all objects or students will be hostelResidents.
}

class Student {
    int rollNumber;
    String name;
    boolean isHostelResident;
    static String schoolName = "St. Peter";

    public Student (int roll, String name, boolean isHostelResident) {
        this.rollNumber = roll;
        this.name= name;
        this. isHostelResident=isHostelResident;
    }


    public static void main(String arf[ ] ) {
        Student st1 = new Student (101,"Anushka", true);
        Student st2 = new Student (101,"Kiran", false);
        Student st3 = new Student (101,"Mohan", true);

        System.out.println(st1.name);  //will print Anushka
        System.out.println(st2.name);  //will print Kiran
        System.out.println(st1.name);  //will print Mohan
        st1.name= "Ashok";  //This will change name attribute of st1 object from Anushka to Ashok. This will not have any change in name attribute of other //objects st2 and st3

        System.out.println(st1.schoolName); //This will print "St Peter" since there is a single copy for the whole class to be shared by all objects
        System.out.println(st2.schoolName); //This will print "St Peter" since there is a single copy for the whole class to be shared by all objects
        System.out.println(st3.schoolName); //This will print "St Peter" since there is a single copy for the whole class to be shared by all objects

        Student.schoolName ="Xavier";  // We are trying to access static variable using the class name. and when we modify the single copy of the object since there is only one copy of static variable all objects will see the change..
        //static variables can also be accessed by class representatives (i.e. objects since objects are examples of class )
        System.out.println(st1.schoolName); //st1 represents a Student hence we are accessing static variable using something that represents class.
// Above line will print schoolName as "Xavier" and not "St Peter" since any modification done to static variable will be seen by all the objects

        System.out.println(st2.schoolName); //st2 represents a Student hence we are accessing static variable using something that represents class.
// Above line will print schoolName as "Xavier" and not "St Peter" since any modification done to static variable will be seen by all the objects
        System.out.println(st3.schoolName); //st3 represents a Student hence we are accessing static variable using something that represents class.
// Above line will print schoolName as "Xavier" and not "St Peter" since any modification done to static variable will be seen by all the objects

    }
}