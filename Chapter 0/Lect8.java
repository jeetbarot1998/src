public class Lect8 {
}

class Student3 {

    private int score;
    private String name;

    public int getScore(){
        return score;
    }

    public String getName(){
        return name;
    }

    public Student3(){
        ;
    }

    public Student3(String name){
        this.name = name;
    }

    public Student3(String name, int score){
        this.name = name;
        this.score = score;
    }

    public static void main(String[] args) {
        Student3 st1 = new Student3();
        Student3 st2 = new Student3("Aman", 92);
        Student3 st3 = new Student3("Kundan", 65);

        System.out.println(st1.score);
        System.out.println(st2.score);
        System.out.println(st3.score);


    }
}


class Book {
    private int price;      // instance variable
    private  String publisher;  // instance variable
    private String author;  // instance variable
    public Book(int cost, String pub, String writer) {
        this.price = cost;
        this.publisher = pub;
        this.author = writer;
    }
    public static void main (String arg [ ] ) {
        //Note: Every object (specific book, b1, b2, b3) in this case will have same three attributes price, publisher and
        // author but the value of these attributes will be different
        Book b1 = new Book(2000, "Penguin publisher", "Salman Rushdie");
        Book b2 = new Book( 3000, "McGraw Hill", "Kathy Sierra");
        Book b3 = new Book( 4000, "Macmillan Publishers.", "Leo Tolstoy");
        // Note: here b1, b2, b3 are called reference variables that point to the object that gets created on heap.
        System.out.println(b1.price); //this will print price for first book.
        System.out.println(b2.price); //this will print price for second book.
        System.out.println(b3.author); //this will print author for the third book.
        // In a laptop we have two types of memory hard disk and RAM. Similarly we have two types of memory in Java Heap and Stack.
        // Similarly, In Java we have mainly two types of memory heap and stack. Heap is a special type of memory where object gets created.
    }
}