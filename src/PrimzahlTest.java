import java.util.ArrayList;
import java.util.List;

public class PrimzahlTest {

    public List<Integer> worstCase = new ArrayList<>();
    public List<Integer> bestCase = new ArrayList<>();
    public List<Integer> avgCase = new ArrayList<>();

    public PrimzahlTest() {
        generateTestData();
    }
    public void generateTestData() {
        for(int i = 3; i < 100; i++) {
            if(i % 2 == 0){
                worstCase.add(i);
                avgCase.add(i-1);
                bestCase.add(2);
            }
        }

    }

    public static boolean isPrime(int n)
    {
        boolean isPrime = true;
        int k = 2;
        while(k < n){
            if(n % k == 0) isPrime = false;
            k = k + 1;
        }
        return isPrime;
    }
}
