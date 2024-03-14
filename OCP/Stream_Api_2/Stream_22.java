package OCP.Stream_Api_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_22 {

    public static void main(String[] args) {
        List<String > l = new ArrayList<>();
        l.add("ABC");
        Stream.of(l).count();
        l.forEach(c-> System.out.println(c.toUpperCase()));
        int [] a = {1,2,5,6};
        Arrays.stream(a).count();
        Arrays.stream(a).average();
        Stream.of(a).count();
//        Stream.of(a).average(); error
//        Stream.of(a).mapToInt(y -> y).average(); error

        IntStream.of(a).average();
        Arrays.asList(a).stream().count();
//        Arrays.asList(a).stream().average(); error
//        Arrays.asList(a).stream().mapToInt(y -> y).average(); error

        List <Integer> al = new ArrayList<>();
        al.add(100);
        al.add(101);
        al.stream().mapToDouble(ap -> ap).average().ifPresent(System.out::println);
        Integer [] In = {1,2,5,6};
        Arrays.stream(In).count();
//        Arrays.stream(In).average(); error
        Arrays.stream(In).mapToInt(each -> each).average();
        Stream.of(In).count();
//        Stream.of(In).average(); error
        Stream.of(In).mapToInt(each -> each).average();
//        IntStream.of(In).average(); error
        Arrays.asList(In).stream().count();
//        IntStream.of(In).average(); error.
        Arrays.asList(In).stream().mapToInt(each -> each).average();
    }

}

class Testst2{
    public static void main(String[] args) {
        int [] nums = {12,3,4,5,6,7,8,0};
        System.out.println(Arrays.stream(nums).map(n -> n * n).filter(n -> n >25).average());
        System.out.println(Arrays.toString(nums));
    }
}
