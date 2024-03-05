package OCP.MISC;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class misc {
    public static void main(String[] args) {
        Function<String, Integer> fs = (String s) -> s.length();
        System.out.println(fs.apply("ABC"));
        Predicate<Integer> pr = (i) -> i > 5;
        System.out.println(pr.test(6));
        Function<String , String> fs1 = s -> s.toUpperCase();
        System.out.println(fs1.apply("MyString"));
    }
}

class FunctionEx{
    public static void main(String[] args) {
        Function<String,String > f = s -> s.substring(0,5);
        System.out.println(f.apply("ABCDEFGHJKLMNO"));
        Function<Integer,Integer > cube = i -> i*i*i;
        System.out.println(cube.apply(10));
        Function<Integer, Integer> doubling = i -> i*2;
        int a [] = new int[] {1,2,4,5};
        ArrayList <Integer> al = new ArrayList<>();
        for (int each: a) {
            al.add(doubling.apply(each));
        }
        System.out.println(al);

        Function<String, String> st = s -> s.replace(" ","");
        System.out.println(st.apply("Hello AbCd, How are You Doing? "));

        Function<String, Integer> st1 = s -> s.length() - s.replace(" ","").length();
        System.out.println(st1.apply("Hello AbCd, How are You Doing? "));
    }
}

class StudentMisc{
    private int marks;
    private String name;

    public StudentMisc(int marks, String name) {
        this.marks = marks;
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }
}

class FunctionEx1{
    public static void main(String[] args) {
        Function<StudentMisc, String> st = stu -> {
            if (stu.getMarks() >80){
                return "A";
            }
            else if(stu.getMarks() >= 60){
                return "B";
            }
            else if(stu.getMarks() >= 50){
                return "C";
            }
            else if(stu.getMarks() >= 35){
                return "D";
            }
            else {
                return "PHAIL";
            }
        };
//        System.out.println(st.apply(new StudentMisc(77,"ABC")));
        ArrayList<StudentMisc> myStudent = new ArrayList<>();
        myStudent.add(new StudentMisc(77, "ABC"));
        myStudent.add(new StudentMisc(57, "CDE"));
        myStudent.add(new StudentMisc(87, "GHI"));
        myStudent.add(new StudentMisc(40, "JKL"));
        myStudent.add(new StudentMisc(4, "MNO"));
        for (StudentMisc stmc: myStudent) {
            System.out.println(stmc.getMarks() + " : " + st.apply(stmc));
        }
    }
}

class EmpMisc{
    private float salary;
    private String name;

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public EmpMisc(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }


    @Override
    public String toString() {
        return "EmpMisc{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }
}

class TestMisc{
    public static void main(String[] args) {
        Predicate<EmpMisc> p = e -> e.getSalary() < 3000;
        Function<EmpMisc, EmpMisc> emp = e -> {
        e.setSalary((e.getSalary()*1.1f));
        return e;};
        ArrayList<EmpMisc> em = new ArrayList<>();
        em.add(new EmpMisc(2000,"ABC"));
        em.add(new EmpMisc(3500,"ABC"));
        em.add(new EmpMisc(1000,"ABC"));
        System.out.println("Old Salary : " + em);
        System.out.println("After revising only for employees below 3000");
        for (EmpMisc e:em) {
            if(p.test(e)){
                emp.apply(e);
            }
        }
        System.out.println(em);

    }
}



