public class Lect7_1 {
}


class Employee2 {
    int id;
    String name;
    int salary;

    int score;

    public int getSalary() {
        return salary;
    }


    public String getName() {
        return name;
    }

    public void setName(String updatedName){
        this.name = updatedName;
    }

    public int getTotalScore()  {
        return score;
    }

    public void doWork(){
        System.out.println( this.name + " is Working who has salary " + this.salary);
    }

    public void sleep(){
        System.out.println( this.name + " is Sleeping who has salary " + this.salary);
    }

    public void dance(){
        System.out.println( this.name + " is Dance who has salary " + this.salary);
    }


    public Employee2 (int empId, String empName,  int wages) {
        this.id = empId;
        this.name = empName;
        this.salary= wages;
    }

    public Employee2 () {
        ;
    }

    public static void main (String arg[]) {
        //To call a setter you must have created an instance of the class.
        Employee2 e = new Employee2();
        System.out.println(e.getSalary()); // This will print the value of the salary on the console. If I need to calculate salary 50 times then I will have to
        System.out.println(e.getSalary()); // call getSalary() 50 times. If I assume  getSalary() method has quite complicated logic and it takes lot of time
        System.out.println(e.getSalary()); // to calculate salary.. then 50 invocations of getSalary() method will take lot of time. So instead of calling
        System.out.println(e.getSalary()); // the method 50 times we can store the returned value in a local variable called temp of type int

        int temp = e.getSalary();  // This is a better way. Call the getSalary() method once and store it in a local variable temp and use that variable name
        System.out.println(temp);  // whereever you have the necessity to call getSalary() method. This will avoid the necessity of calling getSalary() method
        System.out.println(temp);// repeatedly.
        System.out.println(temp);
        System.out.println(temp);
    }
}
