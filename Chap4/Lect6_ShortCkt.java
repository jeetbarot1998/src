package Chap4;

public class Lect6_ShortCkt {
    public static void main(String[] args) {
//      SHORT CIRCUIT operator (&&,||)
//      The execution of the 2nd operator is optional. Only check 2nd condition if the 1st condition is true.
//      situation: supposing you are trying to log-in into fb, and if you use the wrong username, it makes no sense to
//      check if the password is correct or not. Hence, the 2nd parameter becomes redundant
//      It is only valid for boolean type, not valid for integer type.

//      Due to single "&" operator, both the conditions are executed
        int x = 10;
        int y = 15;
        if(++x <10 & ++y>15){
            x++;
        }
        else{
            y++;
        }
        System.out.println(x + ", " +y);
        System.out.println(x + y);

//      Due to double "&&" operator, 2nd condition will only be checked
//      if 1st condition is true.
        int x1 = 10;
        int y1 = 15;
        if(++x1 <10 & ++y1>15){
            x1++;
        }
        else{
            y1++;
        }
        System.out.println(x1 + ", " +y1);
        System.out.println(x1 + y1);



//      Due to double "||" operator, if 1st condition is true, 2nd condition will not be checked.
        int a1 = 10;
        int b1 = 15;
        if(++a1 <10 || ++b1>15){
            a1++;
        }
        else{
            b1++;
        }
        System.out.println(a1 + ", " + b1);
        System.out.println(a1 + b1);


    }
}
