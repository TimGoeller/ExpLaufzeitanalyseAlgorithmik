import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

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
        for(int i = 1; i < 2000; i += 1) {
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

            BubbleSort.staticSort(numbers);
            testData.add(numbers);
            testDataLength.add((double)i);
        }
        System.out.println("Bin fertig :)");

    }

    public int search(int key, List<Integer> list){
        long startTime = System.nanoTime();
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
                lastStopwatch = (System.nanoTime() - startTime) / (double)1000000;
                return mid;
            }
        }
        lastStopwatch = (System.nanoTime() - startTime) / (double)1000000;
        return -1;
    }

    public void stopTime() {

        BubbleSort b = new BubbleSort();

        for(ArrayList<Integer> i : testData) {

            //search(i.get((int)(Math.random()*i.size())), i);
            search(i.get(i.size() - 1), i);
            if(lastStopwatch < 2) {
                testDataTime.add(lastStopwatch);
            }

        }

        testDataLength = new ArrayList<>();
        testDataTime.forEach(i -> testDataLength.add((double)(testDataLength.size() + 1)));

        //int found = search(testData.get(5).get(4), testData.get(5));

    }

    @Override
    public void generateChart() {
        XYChart chart = QuickChart.getChart("BinarySearch", "Größe des Arrays", "Laufzeit", "T(n)", testDataLength, testDataTime);
        new SwingWrapper(chart).displayChart();
    }

    @Override
    public void generateLogChart() {

    }

    @Override
    public double getCorrelationCoefficient() {
        return 0;
    }
}
