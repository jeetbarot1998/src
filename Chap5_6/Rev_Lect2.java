package Chap5_6;

public class Rev_Lect2 {
    public static void main(String[] args) {
        int val = 33;
        if(val >= 0){
            if(val != 0)
                System.out.println("the");
            else
                System.out.println("quick");
            if(val < 10)
                System.out.println("brown");
            if(val > 30)
                System.out.println("fox");
            else if (val < 50)
                System.out.println("jumps");
            else if (val < 10)
                System.out.println("over");
            else
                System.out.println("the");
            if(val > 10)
                System.out.println("lazy");
        }
        else{
            System.out.println("dog");
        }
        System.out.println("---");
    }
}

class IfElse{
    public static void main(String[] args) {
        if(true)
            System.out.println("Here");
        if(true);
        ;;;;;;;
//        if (true)
//            int x;
        if (true){
            int x;
        }
    }
}

class SwitchStatements{
    public static void main(String[] args) {
        int b = 5;
        final int b1 = 10;
        switch (b){

        }

        switch (b){
            default:
            case 5:
            case 2:
            case 2 + 4:
            case 2+b1:
//            case 2+b:

        }

        SwitchColor();
        selectColor("orange");
    }

    static void selectColor(String color){
        switch (TL.valueOf(color.toUpperCase())){
            case RED:
                System.out.println("RED");
                break;
            case ORANGE:
                System.out.println("ORANGE");
                break;
            case GREEN:
                System.out.println("GREEN");
                break;
        }
    }

    static void Switch1(){
        byte b = 10;
        switch (b){
            case 10:
//                case 10: // not allowed.
                System.out.println("10");
                switch (b){
                    case 10:
                }
//            case 1000: // outside limit of byte
        }

        switch (b+1){ // auto type cast to int
            case 10:
            case 1000:
        }
    }

    static void SwitchColor(){
        TL e = TL.ORANGE;
        switch (e){
            case RED:
                System.out.println("RED");
                break;
            case ORANGE:
                System.out.println("ORANGE");
                break;
            case GREEN:
                System.out.println("GREEN");
                break;
        }
    }
}

enum TL{
    RED,GREEN,ORANGE;
}


