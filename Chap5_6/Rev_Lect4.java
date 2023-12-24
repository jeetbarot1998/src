package Chap5_6;

public class Rev_Lect4 {
    public static void main(String[] args) {
        LabelBreak();
        IncorrectBreak();
        Continue();
        IncorrectContinue();
        labelNestedFor();
        labelNestedFor1();
        labelNestedForContinue();
        DoWhileContinue();
    }

    static void Break1(){
        for(int i = 0; i<5 ; i++){
            if(i==2)
                break;
            System.out.println(i);
        }
    }

    static void LabelBreak(){
        int x = 3;
        l1:{
            System.out.println("Before Label");
            if(x==3)
                break l1;
            System.out.println("Immediately after label");
        }
        System.out.println("Outside Label");
    }

    static void IncorrectBreak(){
        System.out.println("Break outside switch or loop");
        int i = 3;
        if(i==3){
//            break;
        }
    }

    static void Continue(){
        for (int i=0; i<10; i++){
            if(i%2 == 0)
                continue;
            System.out.println(i + " ");
        }
    }

    static void IncorrectContinue(){
        System.out.println("Continue outside of loop");
        int x = 10;
        if(x==10)
//            continue;
            ;
    }

    static void labelNestedFor(){
        System.out.println("labelNestedFor");
        l1:{
        for(int i = 0; i<3 ; i++){
            for (int j=0; j<3 ; j++){
                if(i==j)
                    break;
                System.out.println("i : " + i + " j : " + j);
            }
        }
        }
    }

    static void labelNestedFor1(){
        System.out.println("labelNestedFor1");
        l1:{
        for(int i = 0; i<3 ; i++){
            for (int j=0; j<3 ; j++){
                if(i==j)
                    break l1;
                System.out.println("i : " + i + " j : " + j);
            }
        }
        }
    }

    static void labelNestedForContinue(){
        System.out.println("labelNestedForContinue");
        l1:{
            for(int i = 0; i<3 ; i++){
                for (int j=0; j<3 ; j++){
                    if(i==j)
                        continue;
                    System.out.println("i : " + i + " j : " + j);
                }
            }
        }
    }

    static void DoWhileContinue(){
        System.out.println("DoWhileContinue");
        int x = 0;
        do{
            x++;
            System.out.println(x);
            if(++x < 5)
                continue;
            x++;
            System.out.println(x);
        }
        while (++x<10);
    }
}
