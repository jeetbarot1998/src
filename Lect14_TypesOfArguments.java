public class Lect14_TypesOfArguments {
    public static void main(String[] args) {

    }
}

class Student14 {
    private int rollno;
    private String name;
    static String teacherName = "Kundan";

    public Student14(int rollno, String nm){
        this.rollno = rollno;
        this.name = nm;
    }

    public int getRollno() {
        return rollno;
    }

    public Student14(){
        System.out.println("No argument constructor");
    }

    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
        int y =6;
        Student14 s1 = new Student14();
        Student14 s2 = new Student14(1, "ABC");
        Student14 s3 = new Student14(2, "DEF");
        System.out.println(y);
    }
}


