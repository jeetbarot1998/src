package OCA_Dumps;

import java.util.Arrays;

enum Gender{
    MALE, FEMALE, OTHER;
    Gender(){
        System.out.println("Constructor called");
    }
}


public class Q20B {
//    Gender input  = Gender.MALE;
    public static void main(String[] args) {
//        Q20B q = new Q20B();

//        Gender input  = Gender.MALE;
//        Gender input;
        if(args.length ==0){
            System.out.println("Invalid input");
            return;
        }
        Gender input = Gender.valueOf(args[0].toUpperCase());
//        Gender input = Gender.MALE;
        if(Gender.MALE.equals(input)){
            System.out.println("Use Mr. ");
        }
        else if(Gender.FEMALE.equals(input)){
            System.out.println("Use Ms. ");
        }
        else{
            System.out.println("No salutation");
        }
        }
}

enum RideCategory{
    JUNIOR(3,"ABC"), TEENAGER(15,"CDE"),
    ADULT(40, "FGH");
    private int age;
    private String name;
    RideCategory(int i, String name){
        this.age = i;
        this.name = name;
    }
    public String getName(){ return name; }
    public int getAge(){
        return age;
    }
}

class TQ20B{
    public static void main(String[] args) {
        RideCategory[] rcategory = RideCategory.values();
//      View all the constants in an enum.
        System.out.println(Arrays.toString(RideCategory.values()));
        System.out.println("'.name()' function is inside the\n " +
                " enum class and hence we can directly get\n " +
                " the name of the constants\n");
        for(RideCategory rc:rcategory){
            System.out.println("Riders with age upto " +
                    rc.getAge() + " fall into " + rc.name() + " group " +
                    "having name " + rc.getName());
        }
    }
}

