public class Lect12 {
    static String name = "TEST STATIC NAME";
     Lect12 (String name){
//      1. The assignment has taken place for "name". variable "name" has been assigned with "name".
//      Local variable gets precedence over instance variable. Local variable gets the "name".
//      It is so because we have same variable name in local scope and hence it gets preference.
//      In order to make it work either change the name of the
//      variable or use "this" to refer to the instance variable. Hence, we get output as null.
        name = name;
//      Can see that "name" has been assigned here, but it won't persist outside the scope of the function
        System.out.println("inside constructor " + name);

//      2. In order to make it work, use instance level assignment
//      this.name = name;

//      3. Or change the name of the variable in order to avoid clashing. Change the name of the input variable to something
//      else than "name". Then it will automatically refer to the instance as there is no other "name" inside the scope of this
//      function and hence it will look outside the scope of the function and will find the "name" variable we want.
//      name = stname;

//      4.
//      name = this.name;
//      This will also give output as null as we are assigning the value of local variable to the instance value of "name"
//      which is null at this juncture. Hence, value of the instance variable will not change.

    }

    public static void main(String[] args) {
        Lect12 obj1 = new Lect12("ABC");
        System.out.println(obj1.name);
        obj1.setName("Kundan");
        System.out.println(obj1.name);
    }

    private void setName(String name){
//      1. The compiler looks for a local variable "name". As it exists it assigns "name" to "name" and hence in the next line
//          We can see the correct output, but the value of variable "name" is scoped till this function and also not assigned
//          to the instance variable "name" hence cannot be seen outside.
        name = name;
        System.out.println("inside setter " + name);

//      2. We can assign the static variable with either "this" keyword as it will refer to the common static variable of the class via
//         the current object of the class.
//        this.name = name;

//      3. Or we can point directly to the static variable using the class.
        Lect12.name = name;
    }
}



class Employeee {
    int empId;  // example of instance variable.

    String name; // example of instance variable. All employees will have this attribute Sam id will be 1 once initialised through constructor
    int salary;
    static String companyName;
    public Employeee(int id, String name, int salary) { // All arguments to a constructor or a method are also called local variable
        this.empId = id;
        this.name = name;
        this.salary = salary;
    }

    public static void main(String arg[ ] ) {
        int temp = 5;  // local variable. (declared inside the method.)
        Employeee emp1 = new Employeee(1, "Sam", 5000);
        // emp1 will be initialised  with name as  Sam , id as 1, and salary as 5000 through constructor
        System.out.println(emp1.name); //here we are trying to access instance variable name belonging to the instance emp1.
        Employeee emp2 = new Employeee(2, "Kavita", 4000);
        System.out.println(emp2.salary); //here we are trying to access instance variable salary  belonging to the instance emp2.
        // emp1 will be initialised  with name as  Kavita , id as 2, and salary as 4000 through constructor
        Employeee.companyName = "Microsoft";  // static variable does not belong to any object, it belongs to the whole class.
        System.out.println(Employeee.companyName); //here we are trying to access static variable companyName  which does not  belong to any particular employee
        // but shared by all the employees.
        // static variables are also called class variables sometimes because they can be accessed directly with class name
    }
}
