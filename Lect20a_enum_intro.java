import java.util.Arrays;

public class Lect20a_enum_intro {
}

enum Gender{
//  These are enum constants
//  These are static and final and cannot be instantiated.
    MALE, FEMALE, OTHER;

    Gender(){
        System.out.println("Enum Constructor called");
    }
}

class Test20{
    public static void main(String[] args) {
//      Whenever we refer to the enum, JVM creates object of all the values inside the enum.
//      Thus even when only a single constant is referred from the enums,the constructor gets called
//      Multiple times (The number of values).
        Gender input = Gender.OTHER;
        Gender g[] = Gender.values();
//      JVM has taken the responsibility to create the object of the enums whenever they are referred
//      Enum cannot be instantiated with the "new" keyword. As it cannot be instantiated it cannot have public
//      or any other access specifier.
//      variable "g" is of type "Gender" and hence it can only store data of type "Gender". As there are only 3
//      possible values, one has to assign values of type "Gender" to "g" using "Gender" enum.
//      =========================================
//      Gender input2 = "FEMALE";
//      You cannot assign the value "FEMALE" as it is of type String, not Gender. As these values inside the enum
//      are static and final in nature we are calling it using the name of the class.

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
//  It's like whenever you refer to one of the constants, each of these constants get instantiated
//  by JVM as static and final objects of the enum class. JVM iterates over each of the constants
//  and instantiates it using the constructor and the parameter predefined/already provided with the constants
//  This way each of the constants of the enums get the values assigned to themselves using the constructor
//  and are of the custom user data type with certain pre-defined values.
    JUNIOR(3), TEENAGER(15), ADULT(40);
    private int age;

    RideCategory(int i){
        this.age = i;
    }

    public int getAge(){
        return age;
    }
}

class TestEmployee20{
    public static void main(String[] args) {
//      Array/collection of type RideCategory.
        RideCategory[] rcategory = RideCategory.values();
//      View all the constants in an enum.
        System.out.println(Arrays.toString(RideCategory.values()));

        for(RideCategory rc:rcategory){
//          .name() function is inside the enum class and hence we can directly get the name of the constants
            System.out.println("Riders with age upto " + rc.getAge() + " fall into " + rc.name() + " group.");
        }
    }
}