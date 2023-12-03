package Chap4;

public class Lect7_LogicalOperators {
    public static void main(String[] args) {
//      Due to double "||" operator, if 1st condition is true, 2nd condition will not be checked.
        int a1 = 5;
        int b1 = 15;
        if(++a1 <10 || ++b1>15){
            a1++;
        }
        else{
            b1++;
        }
        System.out.println(a1 + ", " + b1);
        System.out.println(a1 + b1);

//      Due to double "||" operator, if 1st condition is false, then only 2nd condition will be checked.
        a1 = 10;
        b1 = 15;
        if(++a1 <10 || ++b1>15){
            a1++;
        }
        else{
            b1++;
        }
        System.out.println(a1 + ", " + b1);
        System.out.println(a1 + b1);

        for(int i = 0; true|false; i++){
            if(--i==0 || i==2){
                System.out.println("YES " + i);
                break;
            }
            else if(i++ %2 ==0){
                System.out.println("NO " + i);
            }
        }
    }
}
