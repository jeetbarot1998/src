public class Lect8_1debugging {
}

// A file can have "n" number of classes but only "1" public class
// There can be multiple start points and main methods in a file but only 1 in a class.
// Think of it in business perspective. One of the class will be consumer and other will be provider
// When the user wants to order a pizza, the "customer" will be "consumer" of the class "pizzaHut" and hence pizaHut
// will be a "provider"
// Post ordering when the pizzaHut wants to know the address of the user, the "pizzaHut" class is the "consumer" and the
// "Customer" class is the "provider"

class pizzaHut {
    private String shopName;
    private String shopAddress;
    private int totalSale;

    public String getShopName(){
        return shopName;
    }

    public String getShopAddress(){
        return shopAddress;
    }

    public void preparePizza(){
        System.out.println("Preparing Pizza");
    }
    public void prepareBurger(){
        System.out.println("Prepare Burger");
    }
    public void deliverPizzaAtHome(){
        System.out.println("Delivering at Home");
    }

    public int getTotalSale(){
        return totalSale;
    }

    public static void main(String[] args) {
        Customer cu = new Customer();
        System.out.println(cu.getAddress());
    }

}

class Customer {
    private String name;
    private String address;

    public String getName(){
        return name;
    }

    public String getAddress(){
        System.out.println("Getting Address");
        return address;
    }

    public static void main(String[] args) {
        pizzaHut pz = new pizzaHut();
        pz.deliverPizzaAtHome();
    }

}

// ============================================

// So based on who wants the data of whom, one of the class will make an object of the other class and use the methods
// to fetch the data

class Car {
    private String model;
    private int mileage;
    private int fuelCapacity;

    public String getModel() {
        return model;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public int getMileage() {
        return mileage;
    }
    public Car(String model,int fuelCap, int mileage){
        this.model = model;
        this.fuelCapacity = fuelCap;
        this.mileage = mileage;
    }

    public Car(){
        ;
    }

}

class Driver {
    private String name;
    private int age;
    private int drivingExperience;

    public int getAge() {
        return age;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public String getName() {
        return name;
    }
}

class InsuranceCompany{

    public static void main(String[] args) {
//        here insurance company might want to know the car model and the age of the driver to calculate insurance and
//        hence "InsuranceCompany" is the "consumer" and both "Car" and "Driver" class are "provider" classes
        Car c = new Car();
        Car c1 = new Car("Maruti", 30, 15);
        System.out.println(c1.getFuelCapacity());
        System.out.println(c1.getMileage());
        System.out.println(c1.getModel());

        Driver d =  new Driver();
        System.out.println(d.getAge());
        System.out.println(d.getDrivingExperience());
        System.out.println(d.getName());

    }
}

class AA{
}

class BB{
}

class CC{
}

