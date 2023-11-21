public class Lect9_interface {
}

// Interface basics.

/**
 * Interface is like a contract wherein the debitCard only needs to know that the mentioned operation, but how are these
 * implemented is none of our concern. Only operations are revealed but not how it is being done.
 * Abstract means incomplete.
 * Interface just has the operations/methods, not the implementation
 * The class implementing the interface is responsible for the implementation for the methods.
 * NOTE: Interface is a contract which has all the methods as abstract,ie. incomplete.
 **/
interface DebitCard {
    //    All the methods are by default abstract and public in nature.
    //    All the variables are public static and final in nature
    abstract void withdraw();
    public void deposit();
    void transfer();
}

/**
 * So if a class in honoring a contract "interface" then the class has got to implement all the methods inside the class
 * As every bank will have different functionality for implementing debit card functionality but the operations will remain the same.
 * Hence, we use Interface to achieve abstraction of data.
 * One contract multiple implementations
 * Even if my class is complete i can mark it as abstract if you do not want anyone make an object of the class.
 **/
class HSBCDebitCard implements DebitCard {

    @Override
    public void withdraw() {
        System.out.println("HSBCDebitCard Withdraw Money");
    }

    @Override
    public void deposit() {
        System.out.println("HSBCDebitCard deposit Money");
    }

    @Override
    public void transfer() {
        System.out.println("HSBCDebitCard transfer Money");
    }
}

/** Or if the class has not implemented all the functions of the interface then put the keyword "abstract" before the class
 * NOTE: An abstract class cannot have an object as it has not implemented all the methods
**/
abstract class ICICebitCard implements DebitCard {
    // "withdraw" function is not implemented and hence the class has to be abstract as it has not implemented some methods yet
    @Override
    public void deposit() {
        System.out.println("ICICebitCard deposit Money");
    }

    @Override
    public void transfer() {
        System.out.println("ICICebitCard transfer Money");
    }
}

class testclass{
    public static void main(String[] args) {
//        ICICebitCard dc1 = new ICICebitCard(); => this gives error as the class is abstract in nature
        HSBCDebitCard dc2 = new HSBCDebitCard();
        dc2.deposit();
        dc2.withdraw();
        dc2.transfer();
        final StringBuilder builder = new StringBuilder("Hello");
        builder.append(" World");

    }
}

// ===============================================================================================

interface RemoteControl {
    public void start();
    public void stop();
    public void increaseVolume();
    public void decreaseVolume();
    public void changeChannel();
}
class PlasmaTV implements RemoteControl {
    @Override
    public void start() {
        // write the specific details how Plasma TV remote control starts
        // some plasma technology specific implementation
        System.out.println("Plasma TV started ");
    }

    @Override
    public void stop() {
        // write the specific details how Plasma TV remote control stops
        // some plasma technology specific implementation
        System.out.println("Plasma TV stopped ");
    }
    @Override
    public void increaseVolume() {
        // write the specific details how Plasma TV volume increases
        // some plasma technology specific implementation
        System.out.println("Plasma TV volume increased ");
    }
    @Override
    public void decreaseVolume() {
        // write the specific details how Plasma TV volume decreases
        // some plasma technology specific implementation
        System.out.println("Plasma TV volume decreased ");
    }

    @Override
    public void changeChannel() {
        System.out.println("Plasma TV channel changed ");
    }
}

class LCDTV implements RemoteControl {

    public void start() {
        // write the specific details how LCD  TV remote control starts
        // some LCD technology specific implementation
        System.out.println("LCD TV started ");
    }

    public void stop() {
        // write the specific details how LCD TV remote control stops
        // some LCD technology specific implementation
        System.out.println("LCD TV stopped ");
    }

    public void increaseVolume() {
        // write the specific details how LCD TV volume increases
        // some LCD technology specific implementation
        System.out.println("LCD TV volume increased ");
    }

    public void decreaseVolume() {
        // write the specific details how LCD TV volume decreases
        // some LCD technology specific implementation
        System.out.println("LCD TV volume decreased ");
    }

    @Override
    public void changeChannel() {
        System.out.println("LCD TV channel changed ");
    }

}
// I have created test class just to demonstrate that any class can create object of another class.
// In real life. if there is a class Student and if he wants to know course available in a college. Then Student class
//can create object of College class and using the object of college class it can call method getCourse() present in
// college class. Similarly, if College wants to know address of Student, class College can create object of Student
// class and call its method.

class Test {
    public static void main (String args[ ] ) {
        RemoteControl rt = new LCDTV();
        rt.start();
        rt.stop();
        rt.increaseVolume();
        rt.decreaseVolume();
    }
}