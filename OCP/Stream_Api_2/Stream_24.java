package OCP.Stream_Api_2;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.Objects.hash;

class Stream_242 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        );

        // Sorting people by age using Comparator.comparing()
        List<Person> sortedPeople = people.stream()
                .sorted(Comparator.comparing(Person::getAge)
                .thenComparing(Comparator.comparing(Person::getName)))
                .collect(Collectors.toList());

        sortedPeople.forEach(person -> System.out.println(person.getName() + " - " + person.getAge()));
    }
}

class Stream_243{
    public static void main(String[] args) {
        List<String>  al = Arrays.asList("abv", "ds", "ugu");
        List<String> al2 = al.stream().filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());
        System.out.println(al2);
    }
}

class partitioningByEx {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> partitionedNumbers = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        System.out.println("Partitioned numbers: " + partitionedNumbers);
    }
}

class joiningEx {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "grape");

        String joinedString = words.stream()
                .collect(Collectors.joining(", "));

        System.out.println("Joined string: " + joinedString);
    }
}

class Person {
    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person){
            Person person = (Person) obj;
            return this.age == person.age && person.getName().equals(this.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class groupingByEx {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 30),
                new Person("Alice", 30),
                new Person("Charlie", 35)
        );

        Map<Integer, List<Person>> peopleByAge = people.stream()
                .collect(Collectors.groupingBy(p -> p.getAge()));

        Map<Person, List<Person>> peopleByObject = people.stream()
                .collect(Collectors.groupingBy(person -> person));

        Map<Object, Long> peopleByObjectCount = people.stream()
                .collect(Collectors.groupingBy(person -> person,
                        Collectors.counting()));

        Map<Integer, List<String>> namesByAgeList = people.stream()
                .collect(Collectors.groupingBy(Person::getAge,
                        Collectors.mapping(Person::getName,
                                Collectors.toList())));

        Map<Integer, Set<String>> namesByAgeSet = people.stream()
                .collect(Collectors.groupingBy(Person::getAge,
                        Collectors.mapping(Person::getName,
                                Collectors.toSet())));

        System.out.println("People grouped by age: " + peopleByAge);
        System.out.println("People grouped by peopleByObject: " + peopleByObject);
        System.out.println("People grouped by peopleByObjectCount: " + peopleByObjectCount);
        System.out.println("Names grouped by namesByAgeList: " + namesByAgeList);
        System.out.println("Names grouped by namesByAgeSet: " + namesByAgeSet);

//        ========================== Summing and Averaging ==========================
        Map<Object, Integer> NameToAgeSum = people.stream()
                .collect(Collectors.groupingBy(p -> p.getName(),
                        Collectors.summingInt(p -> p.getAge())));

        System.out.println("Names grouped by NameToAgeSum: " + NameToAgeSum);

        Map<Object, Double> NameToAgeAvg = people.stream()
                .collect(Collectors.groupingBy(p -> p.getName(),
                        Collectors.averagingDouble(p -> p.getAge())));

        System.out.println("Names grouped by NameToAgeAvg: " + NameToAgeAvg);
    }
}

class StudentExSt24{
    private int id;
    private String name;
    private List<Integer> phoneNumbers;

    public StudentExSt24(int id, String name, List<Integer> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getPhoneNumbers() {
        return phoneNumbers;
    }
}

class Stream_244{
    public static void main(String[] args) {
        Stream <StudentExSt24> s = Stream.of(
                new StudentExSt24(1,"ABC", Arrays.asList(12,2,57,7)),
                new StudentExSt24(2,"GJG", Arrays.asList(03,32,233)),
                new StudentExSt24(3,"JHGJJ", Arrays.asList(45,33)));
        List<Integer> flatPhoneNumbers = s.flatMap(each_st -> each_st.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println("Flat Map : " + flatPhoneNumbers);
        System.out.println("flatPhoneNumbers.contains(233) : " + flatPhoneNumbers.contains(233));
        System.out.println("flatPhoneNumbers.contains(44) : " + flatPhoneNumbers.contains(44));
    }
}

