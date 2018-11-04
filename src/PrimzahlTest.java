import org.knowm.xchart.*;

import java.util.ArrayList;
import java.util.List;

public class PrimzahlTest implements AlgorithmTest{

    public List<Double> testData = new ArrayList<>();
    public List<Double> testDataTime = new ArrayList<>();

    public List<Double> testDataLog = new ArrayList<>();
    public List<Double> testDataTimeLog = new ArrayList<>();

    public PrimzahlTest() {

    }

    private double lastStopwatch;

    public void stopTime() {

        for(double i : testData) {
            long startTime = System.nanoTime();
            isPrime(i);

            if(lastStopwatch != 0) {
                testDataLog.add(Math.log10(i));
                testDataTimeLog.add(Math.log10(lastStopwatch));
            }
            testDataTime.add(lastStopwatch);

        }

    }

    @Override
    public void generateChart() {
        ChartUtil.generateChart("Primzahlen", "Länge der Zahl", "T(n)", testData, testDataTime);
    }

    @Override
    public void generateLogChart() {
        ChartUtil.generateChart("Primzahlen", "Länge der Zahl", "T(n)", testDataLog, testDataTimeLog);
    }

    public void generateRegressionChart() {
        System.out.println(MathUtil.getFunction(testData, testDataTime));
        //ChartUtil.generateChart("Primzahlen", "Länge der Zahl", "T(n)");
    }

    @Override
    public double getCorrelationCoefficient() {
        return MathUtil.correlationCoefficient(testData, testDataTime);
    }

    public void generateTestData() {
        for(int i = 1; i < 100000; i += (Math.random() * 10)) {
            testData.add((double)i);
        }

    }

    public boolean isPrime(double n)
    {
        long startTime = System.nanoTime();

        boolean isPrime = true;
        int k = 2;
        while(k < n){
            if(n % k == 0) isPrime = false;
            k = k + 1;
        }

        lastStopwatch = (System.nanoTime() - startTime) / (double)1000000;
        return isPrime;
    }
}

