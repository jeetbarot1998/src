public class Neighbour {

    public static void main(String[] args){
        Employee e1 = new Employee();

//      IMPLEMENTED ENCAPSULATION.
//      calling private members of the class "employee" via an object in other file gives error
//      e1.salary;
//      e1.play("newobj");
//      calling public methods of the class

        System.out.println(e1.getSalary());
        e1.publicPlay("testName");

    }
}
