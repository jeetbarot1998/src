package Chap5_6;

public class Lect14_exception {
}

class InvalidArgumentException extends Exception{}
class InvalidArgumentExceptionRunTime extends RuntimeException{
    InvalidArgumentExceptionRunTime(String message){
        super(message);
    }
}

class Demo14{
    void m1(){
//        throw new InvalidArgumentException(); // will not work because it is partially handled exception
        throw new InvalidArgumentExceptionRunTime("Error");

    }
}

class Propogate{
    public static void main(String[] args) {
        try{
            reverse("");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            System.out.println("executed successfully.");
        }
    }

    static String reverse(String arg){
        if (arg.length() == 0){
            throw new InvalidArgumentExceptionRunTime("Length needs to be greater than 0");
        }
        String rev = null;
        for (int i = arg.length() - 1 ; i>=0 ; --i){
            rev += arg.charAt(i);
        }
        System.out.println(rev);
        return rev;
    }
}


class BadFoodException extends Exception{
    BadFoodException(String s){
        super(s);
    }
}

// =====================================================================================

class TasteFood{
    public static void main(String[] args) {
        for(String eachArg : args){
            try{
                checkFood(eachArg);
            } catch (BadFoodException e) {
                System.out.println("Stale food");
                e.printStackTrace();
//                throw new RuntimeException(e);
            }
        }
    }

    static void  checkFood(String food) throws BadFoodException{
        if(food.equals("Stale")){
            throw new BadFoodException("Stale food and tastes bad");
        }
        else {
            System.out.println("Good Food.");
        }
    }
}

// =====================================================================================


class SocialMediaUser{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class TooYoungException extends RuntimeException{
    TooYoungException(String s){
        super(s);
    }
}

class TooOldException extends RuntimeException{
    TooOldException(String s){
        super(s);
    }
}

class SocialMediaRegisteration{
    public static void main(String[] args) {
        SocialMediaUser su = new SocialMediaUser();
        try{
            int age = Integer.parseInt(args[0]);
            if(age<18){
                throw new TooYoungException("You are too young");
            } else if (age<18) {
                throw new TooOldException("You are too old");
            }
        }
        catch (TooYoungException ty){
            ty.printStackTrace();
        }
        catch (TooOldException to){
            to.printStackTrace();
        }
        catch (NumberFormatException nfe){
            System.out.println("Please give a number");
        }
        catch (Exception e){
            System.out.println("Some other issue occurred");
        }


    }
}


class Test{
    public static void main(String[] args) {
//        String s1 = "ABC";
//        String s2 = s1;
//        System.out.println(s1 == s2); // true
//        String s3 = s1.concat("");
//        String s4 = s1 + "";
//        System.out.println(s3 == s1); // true
//        System.out.println(s4 == s1); // false

        StringBuilder sb = new StringBuilder("abc");
        String s = "abc";
        sb.reverse().append("d");
        s.toUpperCase().concat("d");
    }
}



