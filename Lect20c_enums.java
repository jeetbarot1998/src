import java.time.DayOfWeek;

public class Lect20c_enums {
}

enum Color{
    RED("Danger"), YELLOW("Warning"), GREEN("Safe");

    public static String testVar = "Ol Value";
    private String description;

    Color(String desc){
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }
}

class Test20c{

    private Color c;
    private String name;
    private DayOfWeek dayOfWeek;
    public static void main(String[] args) {
        System.out.println(Color.testVar);
        DayOfWeek w = DayOfWeek.MONDAY;
        Color.testVar = "New Value";
        System.out.println(Color.testVar);
        System.out.println(w);
        for (Color c: Color.values()){
            System.out.println(c.getDescription());
        }
    }

}

class Day{
    public Day(){
        System.out.println("Constructor Called");
    }

//  This is how an enum constant is instantiated behind the scene.
//  It is of type final, static and of the same class.
    public static final Day SUNDAY = new Day();

    public static void main(String[] args) {
        Day d;
    }

}

enum CoffeeSize{
    BIG(5),
    HUGE(10),
    OVERWHELMING(15) {
//      Below given code is a method which has been over-ridden.
//      "getLidCode" would give a response "A" only for "OVERWHELMING"
        public String getLidCode(){
            return "A";
        }
    };

    private int ounces;

    CoffeeSize(int ounces){
        this.ounces = ounces;
    }

//  instance method of an enum class
    public String getLidCode(){
        return "B";
    }

    public static void main(String[] args) {
        CoffeeSize c1 = CoffeeSize.BIG;
        System.out.println(c1.name() + " has " + c1.ounces + " and has lid code " + c1.getLidCode());
        CoffeeSize c2 = CoffeeSize.OVERWHELMING;
        System.out.println(c2.name() + " has " + c2.ounces + " and has lid code " + c2.getLidCode());

    }
}


