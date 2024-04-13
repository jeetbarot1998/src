package OCP.Design_Patterns;

import java.util.ArrayList;

public class Factory_pattern {
}

interface IComputer{

}

class PC implements  IComputer{
    private int RAM;

    public PC(int RAM) {
        this.RAM = RAM;
    }
}
class Tablet implements  IComputer{
    private int RAM;
    private int displaySize;

    public Tablet(int RAM, int displaySize) {
        this.RAM = RAM;
        this.displaySize = displaySize;
    }
}
class Laptop implements  IComputer{
    private int RAM;
    private int displaySize;
    private String brand;

    public Laptop(int RAM, int displaySize, String brand) {
        this.RAM = RAM;
        this.displaySize = displaySize;
        this.brand = brand;
    }
}


class ComputerFactory{
    public static IComputer createComputer(String type){
        if(type.equalsIgnoreCase("TABLET")){
            return new Tablet(16,12);
        }
        else if(type.equalsIgnoreCase("PC")){
            return new PC(16);
        }
        else if(type.equalsIgnoreCase("Laptop")){
            return new Laptop(16,24,"Toshiba");
        }
        return null;
    }
}

class Client{
    public static void main(String[] args) {
        IComputer ic = ComputerFactory.createComputer("Laptop");
    }
}


// Coupling, Cohesion, Singleton, Factory, Abstract Factory, DAO,



// =======================================================================
abstract class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList toppings = new ArrayList();
    void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings: ");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println(" " + toppings.get(i));
        }
    }
    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }
    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }
    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }
    public String getName() {
        return name;
    }
}

abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
    abstract Pizza createPizza(String type);
// other methods here
}


class NYPizzaStore extends PizzaStore {
    Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (item.equals("veggie")) {
            return new NYStyleVeggiePizza();
        } else return null;
    }
}

class ChicagoPizzaStore extends PizzaStore {
    Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new ChStyleCheesePizza();
        } else if (item.equals("veggie")) {
            return new ChStyleVeggiePizza();
        } else return null;
    }
}


class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
}
class NYStyleVeggiePizza extends Pizza {
    public NYStyleVeggiePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
}
class ChStyleCheesePizza extends Pizza {
    public ChStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
}
class ChStyleVeggiePizza extends Pizza {
    public ChStyleVeggiePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
}


class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";
        toppings.add("Shredded Mozzarella Cheese");
    }
    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}

class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");
        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}



