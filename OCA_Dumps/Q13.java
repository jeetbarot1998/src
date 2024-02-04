package OCA_Dumps;

public class Q13 {
    public static void main(String[] args) {
        int arr[] = new int[] {1,2,3,4};
//        int z = arr[0]--/arr[0];
//        System.out.println(z);
        arr = new int[]{1, 2, 3, 4};
//        int z1 = arr[1]--/arr[1];
//        System.out.println(z1);
        System.out.println("USE BODMAS");
        int x = arr[1]-- + arr[0]-- / arr[1]*arr[3] ;
        System.out.println(x);
        arr = new int[]{1, 2, 3, 4};
        int x1 = arr[1]-- + arr[0]--/arr[0] * arr[3];
        System.out.println(x1);
    }
}


class OperationHell11{
    public static void main(String[] args) {
        int x = 100;
        int a = x++;
        int b = ++x;
        int c = x++;
        int d = (a<b) ? (a<c) ? a: (b<c) ? b:c:x;
        System.out.println(d);
    }
}
