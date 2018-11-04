import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BinarySearch implements AlgorithmTest{

    public List<int []> testData = new ArrayList<>();
    public List<Double> testDataLength = new ArrayList<>();
    public List<Double> testDataTime = new ArrayList<>();

    public List<Double> testDataLengthLog = new ArrayList<>();
    public List<Double> testDataTimeLog = new ArrayList<>();

    private double lastStopwatch;

    public void generateTestData() {
        for(int i = 1; i < 7000; i += 1) {
            //testData.add(i);

            int[] numbers = new int[i];



            for(int j = 0; j < numbers.length; j++) {
                numbers[j] = j;
            }

            //BubbleSort.staticSort(numbers);
            testData.add(numbers);
            testDataLength.add((double)i);
        }
        System.out.println("Bin fertig :)");

    }

    public int search(int key, int[] list){
        System.out.println("NEW RUN: " + key + " LIST: " + list);
        long startTime = System.nanoTime();
        int low = 0;
        int high = list.length - 1;
        while(low <= high){
            //System.out.println("LOOP: " + ((System.nanoTime() - startTime)));




            int mid = (low + high) / 2;

            if(list[mid]<key)
            {
                try {
                    TimeUnit.NANOSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                low = mid + 1;

            }else if(list[mid] > key){
                try {
                    TimeUnit.NANOSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                high = mid - 1;
            }else
            {
                lastStopwatch = (System.nanoTime() - startTime);
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

        for(int[] i : testData) {

            //search(i.get((int)(Math.random()*i.size())), i);

            search(i[(int)(Math.random() * i.length)], i);
            //System.out.println("RUNTIME: " + lastStopwatch);
            //System.out.println("Größe des Arrays: " + i.size() + " Key: " + search(15, i));


            testDataTime.add(lastStopwatch / 10000.0);

            if(lastStopwatch > 0) {
                testDataLengthLog.add(Math.log10(testData.indexOf(i) + 1));
                testDataTimeLog.add(Math.log10(lastStopwatch));
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
        return MathUtil.correlationCoefficient(testDataLength, testDataTime);
    }

    public void generateRegressionChart() {
        System.out.println(MathUtil.getFunction(testDataLength, testDataTime));
        //ChartUtil.generateChart("Primzahlen", "Länge der Zahl", "T(n)");
    }
}
