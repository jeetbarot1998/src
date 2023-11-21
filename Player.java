public class Player {

    // constructor
    public Player(int age, String sportName){
        this.age = age;
        this.sportName = sportName;
    }

    public Player(){
        ;
    }

//    Attributes
    private int age;
    private String sportName;


//    Methods
    public void play(){
        System.out.println("Playing");
    }

    public void relax(){
        System.out.println("Relaxing");
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int ageToSet){
        this.age = ageToSet;
    }


    public static void main(String[] args) {
        Player p1 = new Player(50,"Cricket");
        System.out.println(p1.age);
        System.out.println(p1.sportName);
        Player p2 = new Player();
        System.out.println(p2.age);
        System.out.println(p2.sportName);
        p1.setAge(40);
        System.out.println(p1.age);
    }
}
