package ru.vsu.math.java.ui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.function.PolynomialFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;


public class PlotParabolaWindow extends JFrame {

	public PlotParabolaWindow (String title) {
		super(title);
		
		JPanel chartPanel = createChartPanel();
		add(chartPanel, BorderLayout.CENTER);
		
		setSize(640, 480);
		setLocationRelativeTo(null);
	}
	
	private JPanel createChartPanel() {

		String chartTitle = "ПАРАБОЛА";
		String xAxisLabel = "X";
		String yAxisLabel = "Y";
		
		XYDataset dataset = createDataset();
		
		JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, xAxisLabel, yAxisLabel, dataset);
		customizeChart(chart);

		File imageFile = new File("XYLineChart.png");
		int width = 640;
		int height = 480;
		
		try {
			ChartUtilities.saveChartAsPNG(imageFile, chart, width, height);
		} catch (IOException ex) {
			System.err.println(ex);
		}
		
		return new ChartPanel(chart);
	}

	private XYDataset createDataset() {

        double a[] = {1.0, 1.0, 2.0};
        PolynomialFunction2D parabola = new PolynomialFunction2D(a);
        XYDataset dataset = DatasetUtilities.sampleFunction2D(parabola,-20.0,20.0, 20, "y = " + a[2] + "x²+" + a[1] + "x+" + a[0] + " {-20…20}");

		return dataset;
	}
	
	private void customizeChart(JFreeChart chart) {
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		plot.setOutlinePaint(Color.LIGHT_GRAY);
		plot.setOutlineStroke(new BasicStroke(2.0f));

		plot.setRenderer(renderer);

		plot.setBackgroundPaint(Color.DARK_GRAY);

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);
		
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		
	}
}