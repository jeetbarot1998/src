package OCP.MISC;
import java.util.*;

public class coll_10 {
    public static void main(String[] args) {
        String s = "ABC";
        s.charAt(0);
        System.out.println(new Character('c').compareTo(new Character('d')));
    }
}

class Map1Demo{
    public static void main(String[] args) {
        demoWithoutOverridingHashCodeAndEquals();
        demoOverridingHashCodeButNotAndEquals();
        demoOverridingHashCodeAndEquals();
        demoOverridingHashCodeAndEqualsWithHashCollision();
    }

    static void demoWithoutOverridingHashCodeAndEquals(){
        System.out.println("Neither Over riding Hash Code Nor Equals");
        HashMap <LockerId1, Customer1> hm = new HashMap<>();
        hm.put(new LockerId1(1,"A"), new Customer1("A",20));
        hm.put(new LockerId1(2,"B"), new Customer1("C",20));
        System.out.println(hm.containsValue(new Customer1("C",20)));
        System.out.println("Map size : " + hm.size());
        System.out.println(hm.get((new LockerId1(1,"A"))));
    }

    static void demoOverridingHashCodeButNotAndEquals() {
        System.out.println("Over Riding Hash Code But Not Equals");
        HashMap <LockerId2, Customer2> hm = new HashMap<>();
        hm.put(new LockerId2(1,"A"), new Customer2("A",20));
        hm.put(new LockerId2(2,"BA"), new Customer2("A",20));
        hm.put(new LockerId2(3,"BC"), new Customer2("C",30));
        System.out.println(hm.containsValue(new Customer2("C",30)));
        System.out.println("Map size : " + hm.size());
        System.out.println(hm.get((new LockerId2(1,"A"))));
    }

    static void demoOverridingHashCodeAndEquals(){
        System.out.println("Over Riding Hash Code And Equals");
        HashMap <LockerId3, Customer3> hm = new HashMap<>();
        hm.put(new LockerId3(1,"A"), new Customer3("A",20));
        hm.put(new LockerId3(2,"BA"), new Customer3("A",20));
        hm.put(new LockerId3(3,"BCA"), new Customer3("C",30));
        System.out.println(hm.containsValue(new Customer3("C",30)));
        System.out.println("Map size : " + hm.size());
        System.out.println(hm.get((new LockerId3(1,"A"))));
    }

    static void demoOverridingHashCodeAndEqualsWithHashCollision() {
        System.out.println("Over Riding Hash Code And Equals With Hash Collision");
        HashMap <LockerId4, Customer4> hm = new HashMap<>();
        hm.put(new LockerId4(1,"A"), new Customer4("A",20));
        hm.put(new LockerId4(2,"BA"), new Customer4("A",20));
        hm.put(new LockerId4(3,"BC"), new Customer4("C",30));
        System.out.println(hm.containsValue(new Customer4("C",30)));
        System.out.println("Map size : " + hm.size());
        System.out.println(hm.get((new LockerId4(1,"A"))));
    }
}

class LockerId1{
    private int id;
    private String name;

    public LockerId1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "name:'" + name + ", id:" + id ;
    }
}

class Customer1{
    private String name;
    private int age;

    public Customer1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name:'" + name + ", age:" + age ;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if(obj instanceof Customer1){
//            Customer1 ob = (Customer1) obj;
//            return this.name.equals(ob.name) && this.age == ob.age;
//        }
//        return false;
//    }
}

class LockerId2{
    private int id;
    private String name;

    public LockerId2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.name.length();
    }


    @Override
    public String toString() {
        return "name:'" + name + ", id:" + id ;
    }
}

class Customer2{
    private String name;
    private int age;

    public Customer2(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "name:'" + name + ", age:" + age ;
    }
}



class LockerId3{
    private int id;
    private String name;

    public LockerId3(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.name.length();
    }


    @Override
    public String toString() {
        return "name:'" + name + ", id:" + id ;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof LockerId3){
            LockerId3 ob = (LockerId3) obj;
            return this.name.equals(ob.name) && this.id == ob.id;
        }
        return false;
    }
}

class Customer3{
    private String name;
    private int age;

    public Customer3(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "name:'" + name + ", age:" + age ;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Customer3){
            Customer3 ob = (Customer3) obj;
            return this.name.equals(ob.name) && this.age == ob.age;
        }
        return false;
    }
}

class LockerId4{
    private int id;
    private String name;

    public LockerId4(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.name.length();
    }


    @Override
    public String toString() {
        return "name:'" + name + ", id:" + id ;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof LockerId4){
            LockerId4 ob = (LockerId4) obj;
            return this.name.equals(ob.name) && this.id == ob.id;
        }
        return false;
    }
}

class Customer4{
    private String name;
    private int age;

    public Customer4(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "name:'" + name + ", age:" + age ;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Customer4){
            Customer4 ob = (Customer4) obj;
            return this.name.equals(ob.name) && this.age == ob.age;
        }
        return false;
    }
}


