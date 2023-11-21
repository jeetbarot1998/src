package Lect19_NestedObjectDemo;

// You can call a static method from an instance method, but you cannot call an instance method outside the instance area
// in the static area without creating an object of the class.

public class Teacher {
    static String dept="physics";
    private static String teacherName = "XYZ";
    int empId;
    public static void deptName(){
        System.out.println("Dept name method");
//      We cannot call the function "m3()" here as this is a static method, and it will give an error
//      Non-static method "m3()" cannot be referenced from a static context.
//      m3();
//      If we want to call it we will have to make an instance of the class "Teacher" and then call it
//      This is possible as "m3()" is an instance member and hence it needs an instance to call it. Hence
//      We made an instance of the class and called the method.
        Teacher t1 = new Teacher();
        t1.m3();
    }

    public static void address(){
        System.out.println("address method");
    }

    void m3(){
        System.out.println("Called m3");
    }

    void waysToCallStaticMethod(){
        address();
        this.address();
        Teacher.address();
    }

    public static void main(String[] args) {
        System.out.println("Main method");
        deptName();
        address();
        Teacher t = null;
//        t.m3(); => This wont work as there is no object created and the reference won't be having any instance members
//
//      But this will work as the reference variable has access to the static methods. Even if it
//      does not have access to the instance members.
        t.address();

//      The above shown example is so because static methods belongs to the class and the variable "t" is of type
//      "Teacher" but the object has not been referenced to any specific object. It has been initialised to "null"
//      Thus on the heap, the "t" is referred as the type "Teacher" but to no instance,thus null. But the typeof the
//      object is defined and "Teacher" class has static methods. Hence, object "t" has no instance members but the
//      static methods exists. Thus, we can call the static methods despite declaring it as null.
    }
}

