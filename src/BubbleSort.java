import java.util.ArrayList;

public class BubbleSort {
    public static void sort( ArrayList<Integer> a ){
        for(int i = 0; i < a.size() - 1; i++)
        {
            for(int j = a.size()-1; j >= i + 1; j--)
            {
                if(a.get(j) < a.get(j-1)){
                    int tmp = a.get(j);
                    a.set(j, a.get(j-1));
                    a.set(j-1, tmp);
                }
            }
        }
    }
}
