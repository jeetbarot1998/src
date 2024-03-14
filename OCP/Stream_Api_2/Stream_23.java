package OCP.Stream_Api_2;

import java.util.*;

public class Stream_23 {
    public static void main(String[] args) {
        List <Integer> l = Arrays.asList(1,2,3,4,5);
        System.out.println(l.stream()
                .peek(n -> System.out.println("Number is : " + n))
                .filter(n -> n*n > 24)
                .peek(n -> System.out.println("Number is : " + n))
                .mapToInt(n ->n*n)
                .average().
                getAsDouble());
    }
}


class ReadingObj{
    private int id;
    private String name;

    public ReadingObj(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Stream_223{
    public static void main(String[] args) {
        List <ReadingObj> al = new ArrayList<>();
        al.add(new ReadingObj(1,"AB"));
        al.add(new ReadingObj(2,"RFVGBN"));
        al.add(new ReadingObj(10,"PIU"));
        al.add(new ReadingObj(65,"SHD"));
        OptionalDouble average = al.stream()
                .mapToDouble(ReadingObj::getId)
                .average();
        if(average.isPresent()){
            System.out.println(average.getAsDouble());
        }
        else{
            System.out.println("Not present");
        }
    }
}

class ReduceExample{
    public static void main(String[] args) {
        List <ReadingObj> al = new ArrayList<>();
        al.add(new ReadingObj(1,"AB"));
        al.add(new ReadingObj(2,"RFVGBN"));
        al.add(new ReadingObj(10,"PIU"));
        al.add(new ReadingObj(65,"SHD"));

        OptionalDouble reduce_sum = al.stream().mapToDouble(ReadingObj::getId)
                .reduce((v1, v2) -> v1 + v2);
        if(reduce_sum.isPresent()){
            System.out.println(reduce_sum.getAsDouble());
        }
        else{
            System.out.println("Sum error.");
        }
    }
}

class ReduceAverage{
    public static void main(String[] args) {
        List <ReadingObj> al = new ArrayList<>();
        al.add(new ReadingObj(1,"AB"));
        al.add(new ReadingObj(2,"RFVGBN"));
        al.add(new ReadingObj(10,"PIU"));
        al.add(new ReadingObj(65,"SHD"));

        System.out.println("Incorrect way of calculating Average");
        System.out.println("We cannot use reduce to calculate " +
                "average as it is not associative in nature");
        OptionalDouble reduce_avg = al.stream().mapToDouble(ReadingObj::getId)
                .reduce((v1, v2) -> (v1 + v2)/2);
        if(reduce_avg.isPresent()){
            System.out.println(reduce_avg.getAsDouble());
        }
        else{
            System.out.println("average error.");
        }
        OptionalDouble reduce_avg2 = al.stream().mapToDouble(ReadingObj::getId)
                .average();
        System.out.println("Correct way of calculating Average");
        if(reduce_avg2.isPresent()){
            System.out.println(reduce_avg2.getAsDouble());
        }
        else{
            System.out.println("average error.");
        }

    }
}

class OptionalEx{
    public static void main(String[] args) {
        String s1 = null;
        Optional <String> o1 = Optional.ofNullable(s1);
        o1.ifPresent(System.out::println);
        System.out.println(o1.orElse("default Value o1"));

        String s = "ABC";
        Optional <String> o2 = Optional.of(s);
        o2.ifPresent(System.out::println);
        System.out.println(o2.orElse("default Value o2"));

    }
}