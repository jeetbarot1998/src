package OCP.MISC;

import java.util.Collection;
import java.util.Collections;
import java.util.*;

public class coll_2 {
}


class CursorDemo implements Comparable{
    public static void main(String[] args) {
        System.out.println("----------- Enumeration Demo Start -----------");
        Vector v = new Vector();// Thread safe
        for (int i = 0 ; i< 10 ; i++){
            v.addElement(i);
        }
        System.out.println(v);
        final Enumeration enumerator = v.elements();
        while (enumerator.hasMoreElements()){
            final Integer i = (Integer) enumerator.nextElement();
            if(i % 2 == 0){
                continue;
            }
            System.out.println(i);
        }
        System.out.println("----------- Enumeration Demo End -----------");
        iterDemo();
        listIterDemo();
    }

    public static void iterDemo(){
        System.out.println("----------- Iterator Demo Start -----------");
        List l = new ArrayList();
        for (int i = 0 ; i<10; i++){
            l.add(i);
        }
        final Iterator iterator = l.iterator();
        System.out.println(iterator.getClass().getName());
        while (iterator.hasNext()){
            final Integer i = (Integer) iterator.next();
            if(i % 2 == 0){
                System.out.println(i);
            }
            else {
                iterator.remove();
            }
        }
        System.out.println("----------- Iterator Demo End -----------");

    }

    public static void listIterDemo(){
        System.out.println("----------- listIterator Demo Start -----------");
        List l = new ArrayList();
        for (int i = 0 ; i<10; i++){
            l.add(i);
        }
        final ListIterator iterator = l.listIterator();
        System.out.println(iterator.getClass().getName());
        while (iterator.hasNext()){
            final Integer i = (Integer) iterator.next();
            if(i % 2 == 0){
                System.out.println(i);
                iterator.add("A");
            }
            else {
                iterator.remove();
            }
        }
        System.out.println("----------- listIterator Demo End -----------");

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class ArrayListDemo{
    public static void main(String[] args) {
        ArrayList m = new ArrayList();
        m.add("A");
        m.add(2);
        m.add("2");
        m.add(null);
        System.out.println(m);
        m.remove(2);
        System.out.println(m);
        m.add(2,"M");
        m.add("N");
        System.out.println(m);

    }
}


