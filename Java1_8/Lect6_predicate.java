package Java1_8;

//interface Predicate<T> {
//    t – the input argument
//    boolean test(T,t);
//}

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lect6_predicate {

    public static void main(String[] args) {
        Predicate<Integer> greaterThan10 = (i) -> {
            return i>10;
        };

        System.out.println(greaterThan10.test(15));
//        System.out.println(greaterThan10.test("Fifteen")); // CE

        Predicate<String> p = s -> s.length()>2;
        System.out.println(p.test("ABC"));
        System.out.println(p.test("A"));

        Predicate<Collection> c = collec -> collec.isEmpty();

        List l = new ArrayList();
        System.out.println(c.test(l));
        l.add("ABC");
        System.out.println(l);
        System.out.println(c.test(l));
    }
}

class PredicateExample{
    public static void main(String[] args) {

        Predicate<Integer> p1 = (i1) -> {
            return i1%2 == 0;
        };

        Predicate<Integer> p2 = i0 ->  i0>10;



        System.out.println(p2.and(p1).test(13));
        System.out.println(p2.and(p1).test(34));

        int [] num = {1,34,3,4,17,24};
        System.out.println(Arrays.toString(num));
        for(int a : num){
            System.out.println(p2.and(p1).test(a));
        };

        System.out.println("Even Numbers.");
        m1(p1,num);
        System.out.println("Greater than 10.");
        m1(p2,num);
        System.out.println("Less than 10.");
        m1(p2.negate(),num);
        System.out.println("Greater than 10 or even.");
        m1(p1.or(p2),num);
        System.out.println("Greater than 10 and even.");
        m1(p1.and(p2),num);

        String [] s1 ={"ABC","UGD","IUY","UQP"};
        System.out.println(Arrays.toString(s1));

        System.out.println("The Strings starting with 'U' are: ");
        Predicate<String> p3 = (s) -> {
            return s.charAt(0) == 'U';
        };

        for(String eachString: s1){
            if(p3.test(eachString))
                System.out.println(eachString);
        }

        System.out.println("Predicate to check if String is empty or null");

        String [] s2 ={"ABC","UGD","IUY","UQP", null, "       " };
        Predicate<String> p5 = (s) ->{
//            System.out.print(s + " result of predicate is: ");
          return s == null || s.trim().length() == 0;
        };

        System.out.println(p5.test(null));
        System.out.println(p5.test("              "));
        System.out.println(p5.test("ABC"));

        System.out.println("Predicate to check if String is empty or null on array");

        for(String eachString: s2){
            if(p5.negate().test(eachString))
                System.out.println(eachString);
        }
    }

    static void m1(Predicate<Integer> p , int x[]) {
        for(int a: x){
            if(p.test(a))
                System.out.println(a);
        }
    }
}

class User{
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }



    public static void main(String[] args) {
        Predicate<User> p = (o) -> {
            return o.getUserName().equals("ABC") && o.getPassword().equals("CDE");
        };

        Scanner s = new Scanner(System.in);
        System.out.println("Enter userName");
        String userName = s.next();
        System.out.println("Enter password");
        String password = s.next();
        User u = new User(userName, password);
        if (p.test(u)) {
            System.out.println("Welcome");
        }
        else {
            System.out.println("Incorrect credentials");
        }
    }
}

class c61{
    public static void main(String[] args) {
        Predicate<String> p = Predicate.isEqual("ABC");
        System.out.println(p.test("ABC"));
        System.out.println(p.test("CDE"));

        Function<String, String> p1 = s -> s.substring(0,3);
        System.out.println(p1.apply("ABVCD"));
    }
}

