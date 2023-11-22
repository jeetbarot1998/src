package Chap3;

public class Lect3_2_PassByValueAndReference {
    private static void modifiedScore(int score){
        score = score + 2;
        System.out.println("Modified score in calling method = " + score);
    }
    private static void modifiedScore(Student32 st){
        st.marks += 20;
        System.out.println("score in student class = " + st.marks);
    }


    public static void main(String[] args) {

        Student32 st =  new Student32(40);
        modifiedScore(st);
        System.out.println("Modified of student =" + st.marks);

//      st1 is pointing to an address on the heap which is an object of Student class.
//      passing by reference as the "st" is not primitive data type, rather an object reference.
//      Anything that is generated on the heap and if that is passed then it is passed by reference,
//      else it is passed by value

        int score = 6;
//      passing by value as the "score" is primitive data type.
//      Anything that is generated on the heap and if that is passed then it is passed by reference,
//      else it is passed by value
        modifiedScore(score);
        System.out.println("Modified score = " + score);
    }
}

class Student32{
    int marks;

    Student32(int marks){
        this.marks = marks;
    }
}

class Foo2 {
    static int size = 7;
    static void changeIt(int size) {
        size = size + 200;
        System.out.println("size in changeIt is " + size);
    }
    public static void main (String [] args) {
        Foo2 f = new Foo2();
        System.out.println("size = " + size);
        changeIt(size);
        System.out.println("size after changeIt is " + size);
    }
}

class Bar {
    int barNum = 28;
}
class Foo {
    Bar myBar = new Bar();
    void changeIt(Bar myBar) {
        myBar.barNum = 99;
        System.out.println("myBar.barNum in changeIt is " + myBar.barNum);
        myBar = new Bar();
        myBar.barNum = 420;
        System.out.println("myBar.barNum in changeIt is now " + myBar.barNum);
    }
    public static void main (String [] args) {
        Foo f = new Foo();
        System.out.println("f.myBar.barNum is " + f.myBar.barNum);
        f.changeIt(f.myBar);
        System.out.println("f.myBar.barNum after changeIt is "
                + f.myBar.barNum);
    }
}