package OCP.Stream_Api;

import java.util.function.*;

public class Primitive_fuctional_Interfaces {
    public static void main(String[] args) {
        System.out.println("======== IntPredicate =====");
        IntPredicate isEven = (i) -> i%2 == 0;
        int [] a = {1,23,4,5,6,8,9,0};
        for (int each :
                a) {
            if (isEven.test(each)) {
                System.out.println(each);
            }
        }

        System.out.println("======== LongPredicate =====");
        LongPredicate isEvenLong = (i) -> i%2 == 0;
        long [] arl = {1,23,4,5,6,8,9,0};
        for (long each :
                arl) {
            if (isEvenLong.test(each)) {
                System.out.println(each);
            }
        }

        System.out.println("======== DoublePredicate =====");
        DoublePredicate isEvenDouble = (i) -> i%2 == 0;
        double [] ard = {1,23,4,5,6,8,9,0};
        for (double each :
                ard) {
            if (isEvenDouble.test(each)) {
                System.out.println(each);
            }
        }

        System.out.println("========IntFunction=====");
        IntFunction<Integer> intf = (i) -> i*i;
        int [] aif = {1,23,4,5,6,8,9,0};
        for (int each :
                aif) {
            System.out.println(intf.apply(each));
        }

        System.out.println("========DoubleFunction=====");
        DoubleFunction<Double> intd = (i) -> i*i;
        double [] aid = {1,23,4,5,6,8,9,0};
        for (double each :
                aif) {
            System.out.println(intd.apply(each));
        }

        System.out.println("========LongFunction=====");
        LongFunction<Long> intl = (i) -> i*i;
        long [] ail = {1,23,4,5,6,8,9,0};
        for (long each :
                aif) {
            System.out.println(intd.apply(each));
        }

        System.out.println("========ToIntFunctionFunction=====");
        ToIntFunction<String> intS = (i) -> i.length();
        System.out.println(intS.applyAsInt("ABCD"));

        System.out.println("========ToLongFunction=====");
        ToLongFunction<String> longs = (i) -> i.length();
        System.out.println(longs.applyAsLong("ABCD"));

        System.out.println("========ToDoubleFunction=====");
        ToDoubleFunction<String> doubleS = (i) -> i.length();
        System.out.println(doubleS.applyAsDouble("ABCD"));

        System.out.println("========IntToDoubleFunction=====");
        IntToDoubleFunction intToDouble = (i) -> Math.sqrt(i);
        System.out.println(intToDouble.applyAsDouble(10));

        System.out.println("========IntConsumer=====");
        IntConsumer intConsumer = (i) -> System.out.println(i*i);
        intConsumer.accept(12); //144

        System.out.println("========LongConsumer=====");
        LongConsumer longConsumer = (i) -> System.out.println(i*i);
        longConsumer.accept(15L); //225

        System.out.println("========DoubleConsumer=====");
        DoubleConsumer doubleConsumer = (i) -> System.out.println(i*i);
        doubleConsumer.accept(12.5); //156.25

        System.out.println("========UnaryOperator=====");
        UnaryOperator<Integer> giveSquare = (i) -> i*i;
        System.out.println(giveSquare.apply(13));

        System.out.println("========LongUnaryOperator=====");
        LongUnaryOperator giveSquareLong = (i) -> i*i;
        System.out.println(giveSquareLong.applyAsLong(13L));

        System.out.println("========DoubleUnaryOperator=====");
        DoubleUnaryOperator giveSquareDouble = (i) -> i*i;
        System.out.println(giveSquareDouble.applyAsDouble(13.192));
    }


}

class ForLoopExample{
    public static void main(String[] args) {
        int i = 0, j=0;
        outLable:{
            for(i=0;i<10;i++){
                InnerLabel:{
                for (j = 0; j<10; j++){
                    if(i>j){
//                        break;
//                        break outLable;
//                        break InnerLabel;
                        continue;
                    }
                }
                }
            }
        }
        System.out.println("value of i: " + i + ", Value of j is: " + j);
    }
}

