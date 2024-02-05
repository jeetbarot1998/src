package OCA_Dumps;

public class Test1 {
    public static void main(String[] args) throws Exception{
        int a = Integer.MIN_VALUE;
        int b = -a;
        System.out.println( a+ "   "+b);
        Boolean b1 = Boolean.FALSE;
        Boolean b2 = Boolean.parseBoolean("false");
        Boolean b3 = Boolean.valueOf(true);
        Q63();
    }


    static void Q63(){
        int i = 1234567890;
        float f = i;
        System.out.println(i - (int)f);
    }
}

class T11{
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("snorkler");
        StringBuilder sb2 = new StringBuilder("yoodler");
        System.out.println(" 1============ ");
        sb1.append(sb2.substring(2,5).toUpperCase());
        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(" 2============ ");
        sb1 = new StringBuilder("snorkler");
        sb2 = new StringBuilder("yoodler");
        sb2.insert(3,sb1.append("a"));
        System.out.println(sb1);
        System.out.println(sb2);

        System.out.println(" 3============ ");
        sb1 = new StringBuilder("snorkler");
        sb2 = new StringBuilder("yoodler");
        sb1.replace(3,4,sb2.substring(4)).append(sb2.append(false));
        System.out.println(sb1);
        System.out.println(sb2);
    }
}

class T12{

//    static {
//        throw new NullPointerException();
//    }

    public static void main(String[] args) {
        try{
            String s = null;
            System.out.println(s.length());
        }
        catch (NullPointerException nle){
            System.out.println(nle);
        }

        try {

            int[] ia = new int[]{1, 2, 3};
            System.out.println(ia[3]);
        }
        catch (ArrayIndexOutOfBoundsException nle){
            System.out.println(nle);
        }
//        Unhandled exception: java.lang.ClassNotFoundException
//        Class.forName("java.lang.String");
    }
}

class T13{
    public static void main(String[] args) {
        Short k = 9;
        Integer i =9;
        Boolean b = false;
        char c = 'a';
        String str = "123";
        i = (int) k.shortValue();
        str += b;
        c *= i;
    }
}

