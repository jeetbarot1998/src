package Chap5_6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Lect6_Break_Continue {
}

class Baap{
    public int h = 4;
    public int getH(){
        System.out.println("Baap : " + this.h);
        return h;
    }
}

class Beta extends Baap{
    public int h = 44;
    public int getH(){
        System.out.println("Beta : " + h);
        return h;
    }

    public static void main(String[] args) {
        Baap b = new Beta();
        System.out.println(b.h + " " + b.getH());
        Beta bb = (Beta) b;
        System.out.println(bb.h + " " + bb.getH());

    }
}

class A{
    int i = 5;
    A(){
        print();
    }

    void print(){
        System.out.println("A");
    }
}


class B extends A{
    int i = 4;

    B(){
        super();
        print();
    }
    public static void main(String[] args) {
        System.out.println("FLOW OF THE PROGRAM IS");
        System.out.println("The creation of object calls the constructor of B class\n" +
                "The default constructor having a call to the 'super'.\n" +
                "No argument Constructor of class 'A' is called.\n" +
                "It calls the method 'print'.\n" +
                "As the object is 'B' also has the method 'print' it calls the method  \n from class 'B' and prints '0' " +
                "As the constructor of class 'B' has not been executed, \n" +
                "The default values are given to the instance variables \n" +
                "Hence the value of 'i' is 0.\n" +
                "Once the execution of 'A' constructor is done, \n" +
                "The control comes to 'B' constructor \n" +
                "Before executing any code in constructor, \n" +
                "Explicit value assignment of variable takes place. \n" +
                "Here 'i' is given the value '4'");
        System.out.println("\n" +
                "child constructor\n" +
                "default value to instance variables in child\n" +
                "parent constructor\n" +
                "default value to instance variables in parent\n" +
                "gives defined values to the instance variables in parent\n" +
                "executes parent constructor\n" +
                "control comes back to the child class constructor\n" +
                "gives defined values to the instance variables in child class\n" +
                "executes the lines inside the child constructor\n");

        System.out.println(" child constructor\n" +
                "default value to instance variables in child\n" +
                "parent constructor\n" +
                "default value to instance variables in parent\n" +
                "gives defined values to the instance variables in parent\n" +
                "executes parent constructor\n" +
                "control comes back to the child class constructor\n" +
                "gives defined values to the instance variables in child class\n" +
                "executes the lines inside the child constructor\n");

        System.out.println(
                "1. Constructor\n" +
                "2. Instance variable default values\n" +
                "3. Call to 'super'\n" +
                "4. Control back to class constructor\n" +
                "5. Explicitly Defined value assignment to instance variables\n" +
                "6. 2nd line execution of constructor.\n");

        A a = new B();

        a.print();
    }

    @Override
    void print() {
        System.out.println(i);
    }
}


class A1{
    A1() throws IOException {

    }

}

class B1 extends A1{

//    B1() throws IOException {
//    }
//
//    B1() throws Exception {
//    }

    B1() throws Throwable {
    }

    public static void main(String[] args) {
        try {
            A1 a = new B1();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee06{
    private String emplName;

    Employee06(String eName){
        this.emplName = eName;
    }

    public String getEmplName() {
        return emplName;
    }

    public void setEmplName(String emplName) {
        this.emplName = emplName;
    }
}

class EnhanceForEach{
    public static void main(String[] args) {

        Employee06 [] emp_arr = {getNewObj("A"), getNewObj("O"), getNewObj("D") , getNewObj("B")};

        System.out.println("Using enhanced for loop");
        for (Employee06 eobj : emp_arr) {
            System.out.println(eobj.getEmplName());
            System.out.println(eobj);
        }


        System.out.println("Using normal for loop");
        for(int i =0;i< emp_arr.length; i++){
            Employee06 eobj = emp_arr[i];
            System.out.println(eobj.getEmplName());
            System.out.println(eobj);
        }


    }

    static Employee06 getNewObj(String ename){
        return new Employee06(ename);
    }
}


class TwoDArray{
    public static void main(String[] args) {
        int [][] x = {{10,20,30},{40,50}};
//        System.out.println(x[1][1]);

        System.out.println("Using normal for loop");
        for(int i = 0; i<x.length; i++){
            for (int j = 0; j<x[i].length; j++){
                System.out.println(x[i][j]);
            }
        }

        System.out.println("Using enhanced for loop");
        for (int[] each_arr :x){
            for(int each_elem: each_arr){
                System.out.println(each_elem);
            }
        }

        Iterable [] it ={new HashSet(2), new ArrayList(4)};
    }
}


class BreakAndContinue{
    static int x = 10;
    public static void main(String[] args) {
        System.out.println("Break and Continue are Always used in either switch case or loops");

        System.out.println("Label Example");
        BreakAndContinue bc =  new BreakAndContinue();
        bc.LabeledBreak1();
        bc.LabeledBreak2();
        bc.LabeledContinue1();
        bc.LabeledContinue2();
        System.out.println("For Switch case");
        bc.BreakEx2(5D);
    }

    void BreakEx() {
//        if(x==10){
//            break;
//        }
//        System.out.println("Hello");
    }
    void BreakEx2(Double b){
        System.out.println("Incompatible types. Found: 'boolean', required: 'char, byte, short, int, Character, Byte, Short, Integer, String, or an enum'");
//        switch (b){
//            case true:
//                System.out.println("true");
//                break;
//            case false:
//                System.out.println("false");
//                break;
//        }
    }

    void BreakEx3(){
        m:{
            int x = 10;
            System.out.println("Begin");
            if(x==10){
                break m;
            }
            System.out.println("End");
        }
        System.out.println("Hello");
    }

    void BreakEx4(){
//        m:{
//            int x = 10;
//            System.out.println("Begin");
//            if(x==10){
//                continue m;
//            }
//            System.out.println("End");
//        }
//        System.out.println("Hello");
    }

    void LabeledBreak1(){
        System.out.println("Unlabeled Break");
        l1:{
            for(int i = 0 ;i < 3; i++){
                m:{
                    for (int j = 0; j<3; j++){
                        if(i==j){
                            break;
                        }
                        System.out.println("i : " + i + ", j : " + j);
                    }
                }
            }
        }
    }

    void LabeledBreak2(){
        System.out.println("Labeled Break");
        l1:{
            for(int i = 0 ;i < 3; i++){
                m:{
                    for (int j = 0; j<3; j++){
                        if(i==j){
                            break l1;
                        }
                        System.out.println("i : " + i + ", j : " + j);
                    }
                }
            }
        }
    }

    void LabeledContinue1(){
        System.out.println("Unlabeled Continue");
        l1:{
            for(int i = 0 ;i < 3; i++){
                m:{
                    for (int j = 0; j<3; j++){
                        if(i==j){
                            continue;
                        }
                        System.out.println("i : " + i + ", j : " + j);
                    }
                }
            }
        }
    }

    void LabeledContinue2(){
        System.out.println("Labeled Continue");
        System.out.println("cannot have a labeled continue");
//        l1:{
//            for(int i = 0 ;i < 3; i++){
//                m:{
//                    for (int j = 0; j<3; j++){
//                        if(i==j){
//                            continue l1;
//                        }
//                        System.out.println("i : " + i + ", j : " + j);
//                    }
//                }
//            }
//        }
    }
}



class LoopLabelExample {
    public static void main(String[] args) {
        outerLoop:
        for (int i = 1; i <= 3; i++) {
            System.out.println("Outer Loop Iteration: " + i);

            innerLoop:
            for (int j = 1; j <= 3; j++) {
                System.out.println("Inner Loop Iteration: " + j);

                if (i == 2 && j == 2) {
                    System.out.println("Breaking out of both loops");
                    break outerLoop;  // Breaks out of the outer loop
                }

                if (i == 1 && j == 1) {
                    System.out.println("Skipping inner loop iteration");
                    continue innerLoop;  // Skips the current iteration of the inner loop
                }
            }
        }
    }
}

class DoWhileAndContinue{
    public static void main(String[] args) {
        int x = 0;
        do{
            x++;
            System.out.println(x);
            if(++x<5){
                continue;
            }
            x++;
            System.out.println(x);
        }
        while (++x<10);
    }
}
