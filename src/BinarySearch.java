import java.util.List;

public class BinarySearch {
    public static int search(int key, List<Integer> list){
        int low = 0;
        int high = list.size() - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(list.get(mid)<key)
            {
                low = mid + 1;
            }else if(list.get(mid) > key){
                high = mid - 1;
            }else
            {
                return mid;
            }
        }
        return -1;
    }
}
