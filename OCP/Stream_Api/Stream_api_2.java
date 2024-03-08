package OCP.Stream_Api;
import java.util.*;
import java.util.stream.Collectors;
public class Stream_api_2 {
    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        al.add(15);
        al.add(4);
        al.add(0);
        al.add(40);
        System.out.println(al.stream().filter(
                i -> {
                    System.out.println("Lazy in nature");
                    return i % 5 == 0;
                }
        ));
        System.out.println(al.stream().filter(
                i -> {
                    System.out.println("Lazy in nature, and will not be executed \n" +
                            "if Terminal operator is not connected.");
                    return i % 5 == 0;
                }
        ).collect(Collectors.toList()));
        System.out.println(al.stream().filter(i -> i % 39 == 0).findFirst().get());
        al.stream().filter(i -> i % 5 == 0).limit(2).forEach(t -> System.out.println("inside ForEach: " + t));
    }

    static void m1() {
        Stream_api_2 st2 = new Stream_api_2();
        intrfst02 i = () -> System.out.println("Implemented using Lambda");
        intrfst02 ii = st2::m3;
        intrfst02 ii1 = Stream_api_2::m4;
    }

    void m3() {
        System.out.println("implemented using Method reference");
    }

    static void m4() {
        System.out.println("implemented using Method reference");
    }
}

interface intrfst02 {
    void m1();
}

class OptionalEx{
    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        al.add(15);
        al.add(-4);
        al.add(40);
        al.add(40);
        System.out.println("=============== Optional Example ===============");
        Optional o = al.stream().filter(i -> i%39 ==0).findFirst();
        if(o.isPresent()){
            System.out.println(o.get());
        }
        else {
            System.out.println("No such value");
        }

        Set<Integer> s = al.stream().filter(i ->i%4 ==0).collect(Collectors.toSet());
        System.out.println("Set : " + s);

        System.out.println("count : " + al.stream().filter(i -> i%5 ==0).count());
        System.out.println("parallelStream() : " + al.parallelStream().
                filter(i -> i%5 ==0).count());
        System.out.println("Sorted using DNSO : " + al.stream().
                filter(i -> i%5 ==0).sorted().
                collect(Collectors.toList()));
        System.out.println("Reverse order using Comparator : " + al.stream().
                filter(i -> i%5 ==0).sorted((i1,i2)
                -> {return -i1.compareTo(i2);}).collect(Collectors.toList()));

    }
}
