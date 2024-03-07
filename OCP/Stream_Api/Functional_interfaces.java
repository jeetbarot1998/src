package OCP.Stream_Api;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.function.*;

public class Functional_interfaces {
    public static void main(String[] args) {
        Consumer <String> cs = c -> System.out.println(" I am printing the String '" + c + "'.");
        Consumer <String> cs2 = c -> System.out.println(" Chained Consumer '" + c + "'.");
        cs.accept("Passing the Arguments");
        Consumer c1 = cs.andThen(cs2);
        c1.accept("Passing in Chained fashion.");
        m1(s -> s.length());

    }

    private static void m1(Consumer<String> c){
        c.accept("ABC");
    }
}

class MovieFunc1{
     String actor;
     Date DOR;
     String actress;
     String name;

    public MovieFunc1(String actor, Date DOR, String actress, String name) {
        this.actor = actor;
        this.DOR = DOR;
        this.actress = actress;
        this.name = name;
    }
}

class ConsumerEx2{
    public static void main(String[] args) {
        MovieFunc1 m1 = new MovieFunc1("AbC", Calendar.getInstance().getTime() , "CDE", "MOVIE NAME");
        MovieFunc1 m2 = new MovieFunc1("OKJ", Calendar.getInstance().getTime() , "WDF", "MOVIE NAME 2");
        ArrayList <MovieFunc1> myAr = new ArrayList<>();
        myAr.add(m1);
        myAr.add(m2);
        Consumer <MovieFunc1> movie_print = s -> System.out.println(s.actor + " : " + s.actress + " : " + s.name + " : " + s.DOR.toString());
        for (MovieFunc1 each_entry: myAr) {
            m2(movie_print,each_entry);
        }
    }

    private static void m2(Consumer<MovieFunc1> mv, MovieFunc1 mm){
        mv.accept(mm);
    }

}


class StudentFunc{
    private int roll;
    private int score;
    private String name;

    public int getRoll() {
        return roll;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public StudentFunc(int roll, int score, String name) {
        this.roll = roll;
        this.score = score;
        this.name = name;
    }

    @Override
    public String toString() {
        return "roll: " + roll +
                ", score: " + score +
                ", name: '" + name  + "'.";}
}

class ConsumerFunc2{
    public static void main(String[] args) {
        StudentFunc st = new StudentFunc(1,70,"ABC");
        StudentFunc st2 = new StudentFunc(2,50,"CDE");
        StudentFunc st3 = new StudentFunc(5,83,"OHD");
        ArrayList<StudentFunc> arl = new ArrayList<>();
        arl.add(st);
        arl.add(st2);
        arl.add(st3);
        Predicate <StudentFunc> p = s -> s.getScore() > 60;
        Consumer<StudentFunc> cs = c -> System.out.println(c.getName());
        for (StudentFunc each_st: arl) {
            PrintStudents(p,getFunction(),cs,each_st);
        }
    }

    private static void PrintStudents(Predicate<StudentFunc> ps, Function<StudentFunc, String> fs, Consumer<StudentFunc> cs, StudentFunc studentObj){
        if(ps.test(studentObj)){
            System.out.println(fs.apply(studentObj) + " : ");
            cs.accept(studentObj);
        }
    }
    
    private static Function getFunction(){
        Function<StudentFunc, String> f = stu -> {
            if (stu.getScore() >80){
                return "A";
            }
            else if(stu.getScore() >= 60){
                return "B";
            }
            else if(stu.getScore() >= 50){
                return "C";
            }
            else if(stu.getScore() >= 35){
                return "D";
            }
            else {
                return "PHAIL";
            }
        };
        return f;
    }
}


class SupplierEx{
    public static void main(String[] args) {
        Supplier <Date> sd = () -> new Date();
        System.out.println(sd.get());
        Supplier <String > getRandom = () -> {
            String arr [] = {"ABC", "CDE", "EDF", "TGH"};
            int x = (int)(Math.random()*4);
            return arr[x];
        };
        System.out.println(getRandom.get());
        System.out.println(getRandom.get());
        System.out.println(getRandom.get());
        System.out.println(getRandom.get());

    }
}
