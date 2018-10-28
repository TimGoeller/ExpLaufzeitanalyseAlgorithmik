import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String args[]) {
        /*PrimzahlTest pt = new PrimzahlTest();
        System.out.println(pt.bestCase);
        System.out.println(pt.worstCase);
        System.out.println(pt.avgCase);
        System.out.println(PrimzahlTest.isPrime(pt.bestCase.get(0)));
        System.out.println(PrimzahlTest.isPrime(pt.worstCase.get(0)));
        System.out.println(PrimzahlTest.isPrime(pt.avgCase.get(0)));*/

        //int[] a = new int[]{5, 4, 3, 2, 1};
        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(5);
        b.add(4);
        b.add(3);
        b.add(2);
        b.add(1);

        System.out.println(b);
        BubbleSort.sort(b);
        System.out.println(b);
    }
}
