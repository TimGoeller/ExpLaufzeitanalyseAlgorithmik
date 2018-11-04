import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChartUtil {

    public static void generateChart(String xTitle, String yTitle, String legend, List<Double> xValues, List<Double> yValues) {
        XYChart chart = new XYChartBuilder().xAxisTitle(xTitle).yAxisTitle(yTitle).build();
        chart.addSeries(legend, xValues,yValues);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        new SwingWrapper(chart).displayChart();
    }

    public static void generateRegressionChart(double a, double b, List<Double> list1, List<Double> list2) {
        List<Double> x = new ArrayList<>();
        x.add(0.0);
        x.add(5000.0);
        List<Double> y = new ArrayList<>();
        x.forEach(xVal -> y.add(a+b*xVal));

        XYChart chart = new XYChartBuilder().build();
        chart.addSeries("T(n)", list1,list2).setLineColor(Color.BLUE);
        chart.addSeries("Regressionsgerade", x,y).setXYSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        new SwingWrapper(chart).displayChart();
    }
}
