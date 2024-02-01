package OCA_Dumps;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Q4 {
}


class Bird2{
    private int ozWeight;
    private boolean canTalk;

    public Bird2(int ozWeight, boolean canTalk) {
        this.ozWeight = ozWeight;
        this.canTalk = canTalk;
    }

    public int getOzWeight() {
        return ozWeight;
    }

    public boolean isCanTalk() {
        return canTalk;
    }

    public String toString(){
        return ("" + getOzWeight() + " " + isCanTalk());
    }

    public static void main(String[] args) {
        ArrayList<Bird2> birds = new ArrayList<>();
        birds.add(new Bird2(1, true));
        birds.add(new Bird2(1, false));
        birds.add(new Bird2(48, false));
        birds.add(new Bird2(32, true));
        System.out.println("Medium Birds " + sorter(birds, b -> {return b.getOzWeight() == 32;}));
        System.out.println("Medium Birds " + sorter(birds, b -> b.getOzWeight() == 32));
    }

    static ArrayList<Bird2> sorter (ArrayList<Bird2> blist, Predicate<Bird2> expr){
        ArrayList<Bird2> result = new ArrayList<>();
        for(Bird2 b : blist)
            if(expr.test(b))
                result.add(b);
        return result;
    }
}



class Knowing{
    static long tooth = 343L;
    static long doIt(long tooth){
        System.out.println(++tooth);
        return ++tooth;
    }

    public static void main(String[] args) {
        System.out.println(tooth);
        final long tooth = 340L;
        new Knowing().doIt(tooth);
//        System.out.println(++tooth); // CE as final.
        System.out.println(tooth);
    }
}

class TestUnreachable{
    public static void main(String[] args) {
        int [] arr ={1,2,3,4,5,6};
        int counter = 0;
        for(int val : arr){
            if(counter >= 5){
                break;
            }
            else{
                continue;
            }
//          Unreachable statement
//            if(val > 4){
//                arr[counter]  = val +1;
//            }
//            counter++;
        }
        System.out.println(arr[counter]);
    }
}











