package OCA_Dumps;

class Customer16{
    String name;

    public Customer16(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Customer16){
            return ((Customer16)obj).name == this.name;
        }
        return false;
    }
}

public class Q16 {
    public static void main(String[] args) {
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        System.out.println("i1 == i2 :" + (i1==i2));
        System.out.println("i1.equals(i2) :" + i1.equals(i2));
        Byte b1 = new Byte((byte)10);
        System.out.println("i1.equals(b1) :" + i1.equals(b1));
        Integer i3 = 20;
        Byte b2 = 20;
//        System.out.println(i3==b2);
        System.out.println(i3.equals(b2));
        String s1 = new String("hello");
        StringBuffer sb1 = new StringBuffer("hello");
        StringBuffer sb2 = new StringBuffer("hello");
        System.out.println("sb1.equals(sb2) : "+ sb1.equals(sb2));
        System.out.println("s1.equals(sb2) : "+ s1.equals(sb2));
        Customer16 c1 =  new Customer16("ABC");
        Customer16 c2 =  new Customer16("ABC");
        System.out.println("c1 == c2 : " + (c1==c2));
        System.out.println("c1.equals(c2) : " + c1.equals(c2));


    }

}
