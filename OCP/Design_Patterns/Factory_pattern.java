package OCP.Design_Patterns;

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
