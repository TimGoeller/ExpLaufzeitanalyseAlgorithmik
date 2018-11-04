import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String args[]) throws InterruptedException {
        Math.random();
        TimeUnit.SECONDS.sleep(1);

        /*PrimzahlTest p = new PrimzahlTest();
        p.generateTestData();
        p.stopTime();
        p.generateChart();
        p.generateRegressionChart();*/

        BinarySearch b = new BinarySearch();
        b.generateTestData();
        b.stopTime();
        b.generateChart();
        b.generateRegressionChart();
        b.generateLogChart();
        System.out.println(b.getCorrelationCoefficient());
        /*BinarySearch b = new BinarySearch();
        b.stopTime();
        XYChart chart = QuickChart.getChart("BinarySearch", "Größe des Arrays", "Laufzeit", "T(n)", b.testDataLength, b.testDataTime);*/

    }

}

