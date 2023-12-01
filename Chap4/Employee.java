package Chap4;

public class Employee {
    private String name = "ABC";
    private int salary = 5000;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    Employee(){}
    Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    public static void main(String[] args) {
        System.out.println("hi");
    }
}
