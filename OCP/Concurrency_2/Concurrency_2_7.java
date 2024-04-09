package OCP.Concurrency_2;
import java.io.*;

// ========= LAZY LOADING =========
// Object is not made as long as it is not required. Hence, less space.
class SingletonLazy {
    // Making this variable static as the static method has to access this variable. If it is not static then it cannot be accessed without making an object
    private static SingletonLazy instance;

    // Private constructor to prevent direct instantiation
    private SingletonLazy() {
// As the constructor is private, hence no one can call the constructor directly.
        System.out.println("Constructor Invoked");
    }

    // We have to make this variable static as we cannot call the constructor, so using the class name we can
//    call the method to invoke the method internally.
//    If there are multiple threads then multiple threads
//    can access the getInstance method and hence it can
//    create 2 different objects of the same class.
//    Hence use synchronized keyword to ensure only 1
//    thread at a time.
    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class){
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
            return instance;
    }

    public Object readResolve(){
        return instance;
    }
}

// ========= EAGER LOADING =========
// Object is made immediately as the class is loaded without even wanting to make an object
// Hence, more space.
class SingletonEager  implements Serializable{

    private static SingletonEager SINGLETON_INSTANCE = new SingletonEager();
    private SingletonEager(){
        System.out.println("constructor called");
    }

    public static SingletonEager getInstance(){
        return SINGLETON_INSTANCE;
    }

    public Object readResolve(){
        return SINGLETON_INSTANCE;
    }

}

class SerializationBreakSingleton {
    static void saveToFile(SingletonEager singleton, String fileName) throws Exception {
        try(FileOutputStream fis = new FileOutputStream(fileName);
            ObjectOutputStream obs = new ObjectOutputStream(fis)){
            obs.writeObject(singleton);
        }
    }

    static SingletonEager readFromFile(String filename)  throws Exception{
        try(FileInputStream fis = new FileInputStream(filename);
            ObjectInput ois = new ObjectInputStream(fis)){
            return (SingletonEager)ois.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        SingletonEager singleton = SingletonEager.getInstance();
        String fileName = "singleton.bin";
        saveToFile(singleton, fileName);

        SingletonEager singleton2 = readFromFile(fileName);
        System.out.println("This shows that 2 different instances of \n" +
                "the singleton class is obtained");
        System.out.println(singleton2 == singleton);

    }
}