public class Lect23_return_types {
}

class College{

    private int id;
    private String collegeName;
    private String address;

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setId(int id) {
        this.id = id;
        return;
    }
}

class Student23{
    private int id;
    private String name;
    private String address;


    public Student23(String name, String addr, int i){
        this.address = addr;
        this.id = i;
        this.name = name;
    }

    public Student23 getNewStudent(){
//        returning a user defined data type
        return new Student23("ABC", "XYZ", 1);
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void prepareForClass(){
        System.out.println("Preparing for class.");
    }

    public College getCollege(){
        College c = new College();
        c.setCollegeName("Collg Name");
        c.setAddress("Address");
        c.setId(2);
        return c;
    }
}

class Test23{
    public static void main(String[] args) {
        Student23 s = new Student23("name 1", "address 1", 3);
        System.out.println(s.getAddress());
        System.out.println(s.getName());
        College college = s.getCollege();
        System.out.println(college.getCollegeName());
        System.out.println(college.getCollegeName());
        Student23 s2 = s.getNewStudent();
    }
}


interface Machine{
    void start();
    void stop();
}


class WashingMachine implements Machine{

    @Override
    public void start() {
        System.out.println("WashingMachine Started");
    }

    @Override
    public void stop() {
        System.out.println("WashingMachine Stopped");
    }

    public void dry(){
        System.out.println("WashingMachine Drying");
    }
}


class Grinder implements Machine{

    @Override
    public void start() {
        System.out.println("Grinder Started");
    }

    @Override
    public void stop() {
        System.out.println("Grinder Stopped");
    }

    public void extractJuice(){
        System.out.println("Grinder extracting Juice");
    }

}

class TestInterface{

    private Machine getWMachine(){
//      As "WashingMachine" implements "Machine", an object of type "Machine" can store an object of class
//      "WashingMachine". As every "WashingMachine" IS A "Machine"
//      <generic_class_name> <ref_name> = new <specific_class_name()>
        Machine wm = new WashingMachine(); // => This is valid syntax.
        return new WashingMachine();
    }

    private Machine getGMachine(){
//      As "WashingMachine" implements "Machine", an object of type "Machine" can store an object of class
//      "WashingMachine". As every "WashingMachine" IS A "Machine".
//      <generic_class_name> <ref_name> = new <specific_class_name()>
        Machine g = new Grinder(); // => This is valid syntax.
        return new Grinder();
    }

    public void demo(Machine m){
//      Example of polymorphism. => The same method is able to
//      start and stop different machines and hence we do not have to rewrite
//      the code.
//      The class "TestInterface" does not know anything about how the "start"
//      and "stop" method has been implemented. This is so because different classes
//      have implemented the interface "Machine" and has their own ways of implementing
//      Example of "polymorphism" and "abstraction".
        m.start();
        m.stop();
    }


    public static void main(String[] args) {
//      Interface is a variable in which we can store objects of the class which implements it
        TestInterface t = new TestInterface();
        Machine wmachine = t.getWMachine();
//        machine.dry(); => Cannot do this as the "Machine" object does not have the method "dry"
        ((WashingMachine) wmachine).dry(); // => We can run like this because we know that we can type cast the
//      variable to type "WashingMachine" which has the method "dry".
        t.demo(wmachine);
        wmachine.stop();
        wmachine.start();

        Machine gmachine = t.getGMachine();
        t.demo(gmachine);

//      WashingMachine wm = t.getMachine(); => Invalid because  "getMachine" returns a "Machine" type object.
//      And "Machine" class is more generic than "WashingMachine". "Machine" is an interface which has been
//      implemented by the class "WashingMachine" and hence an object of type "Machine" can store an object of class
////    "WashingMachine" but not vice versa.
    }

}


class Vehicle{

}


class Car23 extends Vehicle{

}

enum Color23{
    RED, BLUE, GREEN;
}

class TestReturn{
    public static void main(String[] args) {
        TestReturn t = new TestReturn();
        Vehicle v = t.getVehicle();
//        Car23 v = t.getVehicle(); => cannot do this as "Car23" is more specific
//      than "Vehicle" and as per the inheritance and code above, every "Car23" IS A "Vehicle"
//      but every "Car23" IS NOT A "Vehicle". Hence, "Car23" object can be saved in "Vehicle".
        System.out.println(t.getColorValues());
        System.out.println(t.getColorBlue());
    }

    private Vehicle getVehicle(){
//        return new Vehicle();
//      The below code is valid because the "Car23" class IS A "Vehicle",
//      As it has extended and inherited. Hence, we can save or pass the
//      specific data in generic type. Here "Vehicle" is more generic
//      and "Car23" is less generic, but as it has extended it not has a
//      "IS A" relationship. Every "Car23" is a "Vehicle" and can be stored inside
//      the type "Vehicle" but not vice versa.
        return new Car23();
    }

    public Color23[] getColorValues(){
        return Color23.values();
    }

    public Color23 getColorBlue(){
        return Color23.BLUE;
    }
}