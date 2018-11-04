import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class BinarySearch implements AlgorithmTest{

    public List<ArrayList<Integer>> testData = new ArrayList<>();
    public List<Double> testDataLength = new ArrayList<>();
    public List<Double> testDataTime = new ArrayList<>();

    public List<Double> testDataLengthLog = new ArrayList<>();
    public List<Double> testDataTimeLog = new ArrayList<>();

    private double lastStopwatch;

    public void generateTestData() {
        for(int i = 1; i < 5000; i += 1) {
            //testData.add(i);

            ArrayList<Integer> numbers = new ArrayList<>();

            for (int it = 0; it < i; it++) {
                if(it < i - 1) {

                    numbers.add(((int)(0)));
                }
                else {
                    numbers.add(15);
                }
            }

            //BubbleSort.staticSort(numbers);
            testData.add(numbers);
            testDataLength.add((double)i);
        }
        System.out.println("Bin fertig :)");

    }

    public int search(int key, List<Integer> list){
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
        /*int[] array = list.stream().mapToInt(i->i).toArray();
        long startTime = System.nanoTime();
        int ret = Arrays.binarySearch(array, key);
        lastStopwatch = (System.nanoTime() - startTime) / (double)1000000;

        return ret;*/
    }

    public void stopTime() {

        BubbleSort b = new BubbleSort();

        for(ArrayList<Integer> i : testData) {

            //search(i.get((int)(Math.random()*i.size())), i);
            long startTime = System.nanoTime();
            search(15, i);
            //System.out.println("Größe des Arrays: " + i.size() + " Key: " + search(15, i));
            lastStopwatch = (System.nanoTime() - startTime) / (double)1000000;

            if(lastStopwatch < 0.01) {
                testDataTime.add(lastStopwatch);

                if(lastStopwatch > 0) {
                    testDataLengthLog.add(Math.log10(testData.indexOf(i) + 1));
                    testDataTimeLog.add(Math.log10(lastStopwatch));
                }

            }
            //System.out.println(lastStopwatch);
            /*testDataTime.add(lastStopwatch);
            testDataLengthLog.add(Math.log10(testData.indexOf(i) + 1));
            testDataTimeLog.add(Math.log10(lastStopwatch));*/

        }

        testDataLength = new ArrayList<>();
        testDataTime.forEach(i -> testDataLength.add((double)(testDataLength.size() + 1)));

        //int found = search(testData.get(5).get(4), testData.get(5));

    }

    @Override
    public void generateChart() {
        ChartUtil.generateChart("Größe des Arrays", "", "T(n)", testDataLength, testDataTime);
    }

    @Override
    public void generateLogChart() {
        ChartUtil.generateChart("BinarySearch", "Größe des Arrays", "T(n)", testDataLengthLog, testDataTimeLog);
    }


    @Override
    public double getCorrelationCoefficient() {
        return 0;
    }

    public void generateRegressionChart() {
        System.out.println(MathUtil.getFunction(testDataLength, testDataTime));
        //ChartUtil.generateChart("Primzahlen", "Länge der Zahl", "T(n)");
    }
}
