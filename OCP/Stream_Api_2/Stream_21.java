package OCP.Stream_Api_2;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.*;

public class Stream_21 {

    void m2(){
        for(int i=0; i<10; i++){
            System.out.println("Main Thread using method reference");
        }
    }

    public static void main(String[] args) {
        Stream_21 t = new Stream_21();
        Runnable r = t::m2;
        Thread t1 = new Thread();
    }
}

class PersonFactory{
    public static List<PersonExSt1> getPersons(){
        return Arrays.asList(new PersonExSt1("A", 10),
                new PersonExSt1("B", 12),
                new PersonExSt1("P", 62));
    }
}

class PersonExSt1{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "PersonExSt1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PersonExSt1(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class TestSt21{
    int i = 0;

    TestSt21(){
        System.out.println("Without Params");
    }

    TestSt21(int i){
        this.i = i;
        System.out.println("With Params : " + i);
    }
    public static void main(String[] args) {
        Consumer<PersonExSt1> c = p -> System.out.println(p);
        PersonFactory.getPersons().forEach(c);
        Supplier <PersonExSt1> sp = TestSt21::getPerson;
        System.out.println(sp.get());

        Predicate<PersonExSt1> age_more_than_11 = p -> p.getAge() > 11;
        Function<String, String > f = String::toUpperCase;
        List <String> l = Arrays.asList("abc", "HsdfJ", "dhskjG");
        Consumer <String> c1 = System.out::println;
        l.forEach(c1);
    }

    static PersonExSt1 getPerson(){
        return new PersonExSt1("EDD", 10);
    }

    @Override
    public String toString() {
        return "TestSt21{" +
                "i=" + i +
                '}';
    }
}


interface intrfst21{
    TestSt21 get();
}
interface intrfst212{
    TestSt21 getWithParams(int i);
}

class TestSt212{
    public static void main(String[] args) {
        intrfst21 i = TestSt21::new;
        TestSt21 t = i.get();
        System.out.println(t);
        intrfst212 ii = TestSt21::new;
        TestSt21 t2 = ii.getWithParams(8);
        System.out.println(t2);
    }
}

class BiFuncDemo{
    public static void main(String[] args) {
        BiFunction<String, String, Locale> localfactory = (lang, countryName) -> {
          Locale l = new Locale(lang, countryName);
          return l;
        };

        BiFunction<String, String, Locale> localfactory1 = Locale::new;
        System.out.println(localfactory1.apply("en", "US"));

    }
}


class SystemEnvDemo{
    public static void main(String[] args) {
        Map<String, String> getenv = System.getenv();
        getenv.entrySet().forEach((i) ->{
            System.out.println(i);
        });
    }
}
