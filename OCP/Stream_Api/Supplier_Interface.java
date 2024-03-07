package OCP.Stream_Api;
import java.util.ArrayList;
import java.util.function.*;

public class Supplier_Interface {
    public static void main(String[] args) {
        Supplier<Integer> getOtp = () -> {
            int a = (int) (Math.random()*1000000);
            System.out.println(a);
            return a;
        };
        System.out.println(getOtp.get());
        System.out.println(getOtp.get());
        System.out.println(getOtp.get());
        System.out.println(getOtp.get());
        Supplier<String> getOtp1 = () -> {
            String randomNumber = "";
            for (int i=0; i<6;i++){
                randomNumber += (int) (Math.random()*10);
            }
            return randomNumber;
        };
        System.out.println(getOtp1.get());
        System.out.println(getOtp1.get());
        System.out.println(getOtp1.get());
        System.out.println(getOtp1.get());

    }

}

class SupplierRandomGenerate{
    public static void main(String[] args) {
        String allowed = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$";
        Predicate <Integer> isEven = ival -> ival % 2 ==0;
        Supplier<Integer> getRandomNumber0to28 = () -> (int) (Math.random()*29);
        Supplier<Integer> getRandomNumber0to9 = () -> (int) (Math.random()*10);

        Supplier <String> sp = () ->{
            String s ="";
            for (int i =0; i<10; i++){
                if(isEven.test(i)){
                    s = s + getRandomNumber0to9.get();
                }
                else {
                    s = s + allowed.charAt(getRandomNumber0to28.get());
                }
            }
            return s;
        };
        System.out.println(sp.get());
    }
}

class BifunctionalInterface{
    public static void main(String[] args) {
        BipredicateEx();
        BiFunctionEx();
        BiConsumerEx();
        BiConsumerEx();
    }

    private static void BipredicateEx(){
        System.out.println("===========BipredicateEx==============");
        BiPredicate<Integer,Integer> bip = (i1,i2) -> (i1+i2) %2 ==0;
        System.out.println(bip.test(10,12));
        System.out.println(bip.test(10,11));
    }

    private static void BiFunctionEx(){
        System.out.println("===========BiFunctionEx==============");
        BiFunction<Integer,Integer,Integer> bip = (i1, i2) -> i1+i2;
        Integer i1 = bip.apply(10,12);
        System.out.println(i1);
        System.out.println(bip.apply(10,11));

        BiFunction<Integer,Integer,Integer> bip0 = (i, i2) -> i+i2;
        Integer ii1 = bip0.apply(10,12);
        System.out.println(ii1);
        System.out.println(bip0.apply(10,11));

        BiFunction<String ,String,Integer> bip2 = (ii, i2) -> (ii+i2).length();
        Integer ii2 = bip2.apply("ABC","O00OO");
        System.out.println(ii2);

        BiFunction<String ,Integer, StudentExSup> bip3 = (s, i) -> new StudentExSup(s,i);
        System.out.println(bip3.apply("MyName", 1));
        System.out.println(bip3.apply("MyName2", 10));
    }

    private static void BiConsumerEx(){
        System.out.println("===========BiConsumerEx==============");
        BiConsumer<String, String > bic0 = (s1,s2) -> System.out.println(s1+s2);
        bic0.accept("ABC", "EDC");
        BiFunction<String ,Integer, EmployeeExSup> makeEmpObj = (s, i) -> new EmployeeExSup(i,s);

        BiConsumer<EmployeeExSup, Double> increase_salary = (emp_obj, increment) -> emp_obj.setSalary((int)(emp_obj.getSalary()*(1 + increment/100)));
        ArrayList<EmployeeExSup> al = new ArrayList<>();
        EmployeeExSup e1 = makeEmpObj.apply("ABC", 100);
        EmployeeExSup e2 = makeEmpObj.apply("CDE", 200);
        al.add(e1);
        al.add(e2);
        System.out.println(" Before : " + al);
        for (EmployeeExSup emp: al) {
            increase_salary.accept(emp,10.0);
        }
        System.out.println(" After : " + al);

    }


}

class StudentExSup{
    private String name;
    private int id;

    @Override
    public String toString() {
        return "StudentExSup{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public StudentExSup(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class EmployeeExSup{
    private int Salary;
    private String name;

    @Override
    public String toString() {
        return "EmployeeExSup{" +
                "Salary=" + Salary +
                ", name='" + name + '\'' +
                '}';
    }

    public int getSalary() {
        return Salary;
    }

    public String getName() {
        return name;
    }

    public EmployeeExSup(int salary, String name) {
        Salary = salary;
        this.name = name;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

}


