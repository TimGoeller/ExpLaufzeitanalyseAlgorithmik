import javafx.scene.chart.BubbleChart;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements AlgorithmTest {

    public List<ArrayList<Integer>> testData = new ArrayList<>();
    public List<Double> testDataLength = new ArrayList<>();
    public List<Double> testDataTime = new ArrayList<>();

    public List<Double> testDataLengthLog = new ArrayList<>();
    public List<Double> testDataTimeLog = new ArrayList<>();

    public BubbleSort() {

    }

    private double lastStopwatch;

    public void stopTime() {

        for(ArrayList<Integer> i : testData) {
            //long startTime = System.nanoTime();
            sort(i);

            if(lastStopwatch != 0) {
                testDataLengthLog.add(Math.log10(testData.indexOf(i)));
                testDataTimeLog.add(Math.log10(lastStopwatch));
            }

            testDataTime.add(lastStopwatch);
        }

    }

    @Override
    public void generateChart() {
       ChartUtil.generateChart("BubbleSort", "Größe des Arrays", "T(n)", testDataLength, testDataTime);


    }

    @Override
    public void generateLogChart() {
        ChartUtil.generateChart("BubbleSort", "Größe des Arrays", "T(n)", testDataLengthLog, testDataTimeLog);
    }

    @Override
    public double getCorrelationCoefficient() {
        return MathUtil.correlationCoefficient(testDataLength, testDataTime);
    }

    public void generateTestData() {
        for(int i = 1; i < 5000; i += 1) {
            //testData.add(i);

            ArrayList<Integer> numbers = new ArrayList<>();

            for (int it = 0; it < i; it++) {
                numbers.add(((int)(Math.random()*100)));

            }
            testData.add(numbers);
            testDataLength.add((double)i);
        }
        System.out.println("Bin fertig :)");

    }

    public void sort( ArrayList<Integer> a ){
        long startTime = System.nanoTime();
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

        lastStopwatch = (System.nanoTime() - startTime) / (double)1000000;
    }

    public static void staticSort( ArrayList<Integer> a ){
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
