package OCA_Dumps;

import OCA_Dumps.Q6.foo.Stu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Q14 {
}

class StudentQ14{
    String name;
    int age;

    public StudentQ14(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public boolean equals(Object obj){
        System.out.println("Invoked equals");
        if(obj instanceof StudentQ14){
            StudentQ14 std = (StudentQ14)obj;
            if(this.name.equals(std.name) && this.age == std.age){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return this.name + " : " + this.age;
    }
}

class TQ14{
    public static void main(String[] args) {
        List<StudentQ14> l = new ArrayList<>();
        l.add(new StudentQ14("J",10));
        l.add(new StudentQ14("J",27));
        l.add(new StudentQ14("J",10));
        l.add(new StudentQ14("J",10));
        l.remove(new StudentQ14("J",10));
        // gives true if removed or false if not.
        System.out.println(l.remove(new StudentQ14("J",22)));
        System.out.println(l.remove(2)); // gives th object removed.
        System.out.println(l);
        Predicate<StudentQ14> p = (s) -> {
            return (s.name.equals("J") && s.age == 10);
        };
        l.removeIf(p);
        System.out.println(l);
    }
}



