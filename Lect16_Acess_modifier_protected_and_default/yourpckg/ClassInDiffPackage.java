package Lect16_Acess_modifier_protected_and_default.yourpckg;

import Lect16_Acess_modifier_protected_and_default.mypckg.ClassPublic;

public class ClassInDiffPackage {
    public static void main(String[] args) {
        ClassPublic cp = new ClassPublic();
        cp.publicMethod();
//      cp.protectedMethod(); => This does not work as methods is protected.
//      cp.defaultMethod(); => This does not work as methods is default.
//      cp.privateMethod(); => This does not work as methods is private.
//      Can make an object of the class "ClassPublic" because the class is public
//      But cannot use "defaultMethod" & "protectedMethod" via the reference variable.

//      ClassDefault cd = new ClassDefault(); Cannot make an object of class "ClassDefault" as it has the "default" access specifier.
    }
}

class InheritedFromDiffPackage extends ClassPublic{

    /**
     *  Explanation of protected access specifier with code example
     **/
    public void test(){
//      Can use "protectedMethod" directly without reference variable as it is a protected method and
//      Class "InheritedFromDiffPackage" inherits from "ClassPublic".
        protectedMethod();
        publicMethod();
//      defaultMethod(); =>  This does not work as methods is default.
//      privateMethod(); => This does not work as methods is private.

        ClassPublic cp = new ClassPublic();
        cp.publicMethod();
//      cp.protectedMethod(); => This does not work as methods is protected.
//      cp.defaultMethod(); => This does not work as methods is default.
//      cp.privateMethod(); => This does not work as methods is private.
    }

    public static void main(String[] args) {
        ClassPublic cp = new ClassPublic();
        cp.publicMethod();
//      cp.protectedMethod(); => This does not work as methods is protected.
//      cp.defaultMethod(); => This does not work as methods is default.
//      cp.privateMethod(); => This does not work as methods is private.

        InheritedFromDiffPackage ifdc = new InheritedFromDiffPackage();
//      Can make an object of the class "ClassPublic" because the class is public
//      But cannot use "defaultMethod" & "protectedMethod" via the reference variable.
//      Can use "protectedMethod" directly without reference variable as it is a protected method and
//      Class "InheritedFromDiffPackage" inherits from "ClassPublic".
//      protectedMethod(); => Not possible, unless you make an object of the class "InheritedFromDiffPackage",
//      because the method "protectedMethod" is a member of the class "InheritedFromDiffPackage" as it has inherited from
//      "ClassPublic" class. So you can either call it somewhere inside the class or you can make an object of the class
//      "InheritedFromDiffPackage" and then call the protected member.
//      instead use =>
        ifdc.protectedMethod();
        ifdc.publicMethod();
//      ifdc.defaultMethod(); => This does not work as methods is default.
//      ifdc.privateMethod(); => This does not work as methods is private.

    }

}

