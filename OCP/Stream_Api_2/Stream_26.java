package OCP.Stream_Api_2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_26 {
    public static void main(String[] args) {

//        ================ iterate ================
        Stream.iterate(0,s-> s+1)
                .limit(10)
                .forEach(System.out::println);

//        ================ generate ================
        Sensor s = new Sensor();
        Stream<String> SensorStream = Stream.generate(() -> s.next());
        Optional<String> down = SensorStream.filter(n -> n.equals("down")).findFirst();
        down.ifPresent(System.out::println);


//        ================ range ================
        IntStream numStream = IntStream.range(10,15);
        numStream.forEach(System.out::println);
        IntStream numStreamClosed = IntStream.rangeClosed(10,15);
        numStreamClosed.forEach(System.out::println);

        IntStream evenAfter10 = IntStream.rangeClosed(0,20)
                .filter(i -> i%2 ==0)
                .skip(5);
        evenAfter10.forEach(System.out::println);
        IntStream evenBefore10 = IntStream.rangeClosed(0,20)
                .filter(i -> i%2 ==0)
                .limit( 5);
        evenBefore10.forEach(System.out::println);

//        ================ parallel ================
        List<Integer> nums = Arrays.asList(1,2,3,5,6,8,9,0);
        int sum = nums.stream()
                .parallel()
                .mapToInt(n -> n)
                .sum();
        System.out.println("sum : " + sum);

        int sum2 = nums.parallelStream().mapToInt(n -> n).sum();
        System.out.println("sum2 : " + sum2);

    }
}

class Sensor{
    String value = "up";
    int i = 0;

    public String next(){
        i += 1;
        return i > 10 ? "down" : "up";
    }
}

class Stream_261{
    public static void main(String[] args) {
        int [] a = {1,2,5,6};
        System.out.println(Arrays.stream(a).reduce(0,(n1,n2) -> n1+n2));
        Integer [] In = {1,2,5,6};
        IntStream.of(a).average();
        Arrays.asList(In).stream().sorted();
    }
}