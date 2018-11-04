import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;

import java.util.ArrayList;
import java.util.List;

public class ChartUtil {

    public static void generateChart(String xTitle, String yTitle, String legend, List<Double> xValues, List<Double> yValues) {
        XYChart chart = new XYChartBuilder().xAxisTitle(xTitle).yAxisTitle(yTitle).build();
        chart.addSeries(legend, xValues,yValues);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        new SwingWrapper(chart).displayChart();
    }
}
