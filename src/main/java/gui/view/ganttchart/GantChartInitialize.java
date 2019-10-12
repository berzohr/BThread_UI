package gui.view.ganttchart;

import gui.event.GanttEventScheduling;
import gui.event.GanttThreadEvent;

import gui.event.NewGantProcess;
import javafx.application.Platform;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicInteger;

public class GantChartInitialize implements Observer {


    protected final NumberAxis xAxis = new NumberAxis();
    protected final CategoryAxis yAxis = new CategoryAxis();
    protected GanttChart<Number, String> chart = new GanttChart<>(xAxis, yAxis);

    private List<XYChart.Series> seriesList;
    private static List<String> threads;

    private AtomicInteger tick;

    protected GantChartInitialize() {
    }

    public static GantChartInitialize create() {
        GantChartInitialize gantChartInitialize = new GantChartInitialize();
        gantChartInitialize.xAxis.setLabel("Time");
        gantChartInitialize.xAxis.setTickLabelFill(Color.CHOCOLATE);
        gantChartInitialize.xAxis.setMinorTickCount(100);

        gantChartInitialize.yAxis.setLabel("Thread");
        gantChartInitialize.yAxis.setTickLabelFill(Color.CHOCOLATE);
        gantChartInitialize.yAxis.setTickLabelGap(10);

        gantChartInitialize.chart.setLegendVisible(false);
        gantChartInitialize.chart.setBlockHeight(50);
        return gantChartInitialize;
    }

    public void init(int n) {
        if (n == 0)
            return;

        if (seriesList == null) {
            seriesList = new ArrayList<>();
            threads = new ArrayList<>();
            tick = new AtomicInteger(0);

            for (int i = 0; i < n; i++) {
                threads.add("Thread " + (i + 1));
                XYChart.Series serie = new XYChart.Series();
                serie.getData().add(new XYChart.Data(0, threads.get(i), new GanttChart.ExtraData(0, "status-blue")));
                seriesList.add(serie);
                chart.getData().add(seriesList.get(i));
            }
            chart.getStylesheets().add("ganttchart.css");
        }
    }

    @Override
    public void update(Observable o, Object event) {
        if (event instanceof GanttEventScheduling) {
            for (int i = 0; i < seriesList.size(); i++) {
                final int counter = i;
                if (((GanttEventScheduling) event).getThreadNumber() == (i + 1)) {
                    Platform.runLater(() -> {
                        seriesList.get(counter).getData().add(new XYChart.Data<>(tick.getAndIncrement(), threads.get(counter), new GanttChart.ExtraData(1, "status-blue")));
                        chart.getData().retainAll(seriesList);
                    });
                }
            }
        } else if (event instanceof GanttThreadEvent) {
            this.init(((GanttThreadEvent) event).getN());
        } else if (event instanceof NewGantProcess) {
            chart.getData().clear();
            chart.layout();
            seriesList = null;
            threads = null;
        }
    }

    public GanttChart<Number, String> getChart() {
        return chart;
    }

}
