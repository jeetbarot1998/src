package OCP.MISC;
import java.util.*;

public class coll_8 {
}

class CollectionsEx08{
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add("A");
        al.add("a");
        al.add("C");
        al.add("D");
        al.add("B");
//        al.add(1); // CCE
        al.add(null); // Null Point Exception.
        System.out.println("Before sort: " + al);
        Collections.sort(al);
        System.out.println("After sort: " + al);

    }
}

class CollectionsExSortAndBinarySearch{
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(8);
        al.add(0);
//        al.add(1); // CCE
//        al.add(null); // Null Point Exception.
        System.out.println("Before sort: " + al);
        Collections.sort(al, new MyComparator80());
        System.out.println("After sort: " + al);
        System.out.println(Collections.binarySearch(al,3));
        System.out.println(Collections.binarySearch(al,4));
        System.out.println(Collections.binarySearch(al,10));
    }
}

class MyComparator80 implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Integer i1 = (Integer) o1;
        Integer i2 = (Integer) o2;
        return i1.compareTo(i2);
    }
}

class MyComparator81 implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Integer i1 = (Integer) o1;
        Integer i2 = (Integer) o2;
        return i2.compareTo(i1);
    }
}

class CollectionSortAndSearchTogether{
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(1);
        al.add(3);
        al.add(0);
        al.add(2);
        al.add(8);
        System.out.println("Unsorted : " + al);
        Collections.sort(al, new MyComparator81());
        System.out.println("Sorted : " + al);
        System.out.println(Collections.binarySearch(al,3, new MyComparator81()));
        System.out.println(Collections.binarySearch(al,4, new MyComparator81()));
        System.out.println(al);
    }
}

class CollectionsReverse{
    public static void main(String[] args) {
        ArrayList  al = new ArrayList();
        al.add(new Emp80(1));
        al.add(new Emp80(2));
        al.add(new Emp80(50));
        al.add(new Emp80(14));
        al.add("ABC");
        System.out.println(al);
        Collections.reverse(al);
        System.out.println(al);
    }
}

class Emp80{
    private Integer id;

    public Integer getId() {
        return id;
    }

    public Emp80(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id:" + id;
    }
}

class CollectionsComparatorReverse{
    public static void main(String[] args) {
        ArrayList  al = new ArrayList();
        al.add(new Emp80(1));
        al.add(new Emp80(2));
        al.add(new Emp80(50));
        al.add(new Emp80(14));
        System.out.println("before sorting " + al);
        Collections.sort(al, new MyComparator82());
        System.out.println("After Sorting" + al);
        Comparator myComparator = Collections.reverseOrder( new MyComparator82());
        Collections.sort(al,myComparator);
        System.out.println("After reverse logic of comparator ");
        System.out.println(al);
    }
}

class MyComparator82 implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Emp80 e1 = (Emp80) o1;
        Emp80 e2 = (Emp80) o2;
        return e2.getId().compareTo(e1.getId());
    }
}


class ArraySortDemo{
    public static void main(String[] args) {
        int [] a = {5,3,10,2,9,7};
        System.out.println("Primitive before sorting");
        for(int each_val: a){
            System.out.print(each_val + ", ");
        }
        Arrays.sort(a);
        System.out.println("Primitive After sorting");
        for(int each_val: a){
            System.out.print(each_val + ", ");
        }
        String [] s = {"C", "D", "A", "B", "Z"};
        System.out.println("Object before sorting");
        for(String each_val: s){
            System.out.print(each_val + ", ");
        }
        Arrays.sort(s);
        System.out.println("Object After sorting");
        for(String each_val: s){
            System.out.print(each_val + ", ");
        }
        System.out.println("Before sorting Using Comparator.");
        System.out.println(Arrays.toString(s));
        Arrays.sort(s, new MyComparator83());
        System.out.println("After sorting Using Comparator.");
        System.out.println(Arrays.toString(s));
    }
}

class MyComparator83 implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = (String) o2;
        return s2.compareTo(s1);
    }
}

class ArrayToListEx1{
    public static void main(String[] args) {
        String [] s = {"C", "D", "A", "B", "Z"};
        List l = Arrays.asList(s);
        System.out.println(l);
    }
}


class BackedCollection{
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("a", "ant"); map.put("d", "dog"); map.put("h", "horse");
        SortedMap<String, String> submap;
        submap = map.subMap("b", "g"); // #1 create a backed collection
        System.out.println(map + " " + submap); // #2 show contents
        map.put("b", "bat"); // #3 add to original
        submap.put("f", "fish"); // #4 add to copy
        map.put("r", "raccoon"); // #5 add to original - out of range
//        submap.put("p", "pig"); // #6 add to copy - out of range
        System.out.println(map + " " + submap); // #7 show final contents
    }
}