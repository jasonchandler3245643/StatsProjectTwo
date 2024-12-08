

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.chart.AxisCrosses;
import org.apache.poi.xddf.usermodel.chart.AxisPosition;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.apache.poi.xddf.usermodel.chart.MarkerStyle;
import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.poi.xddf.usermodel.chart.XDDFChartAxis;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.apache.poi.xddf.usermodel.chart.XDDFLineChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFLineChartData.Series;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFValueAxis;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import com.codename1.ui.Sheet;

/**
 * Plots, salts, and smooths data using Apache methods
 * Uses Apache 
 * 
 * @author Jason Chandler
 *
 */
public class EquationPlotterAPI  {

	private static double[] inputs;
	private static double[] outputs;
	private static Row[] rows;
	
	private static int colCount;

	private static XSSFWorkbook equationPlot;
	private static XSSFSheet page1;
	private static Row header;
	
	// round everything to four decimal places
	static DecimalFormat df = new DecimalFormat("0.####");
	
	
	
	/**
	 * Default Constructor
	 * 
	 * @param bottomLimit The lower bound of inputs
	 * @param topLimit The upper bound of inputs
	 * @param numberOfIncrements The number of increments between the limits
	 * @throws FileNotFoundException 
	 */
	public EquationPlotterAPI(double bottomLimit, double topLimit, int numberOfIncrements) throws FileNotFoundException {
		
		equationPlot = new XSSFWorkbook();	
		double range = topLimit - bottomLimit;
		double increment = range / (numberOfIncrements - 1);
		
		inputs = new double[numberOfIncrements];
		outputs = new double[numberOfIncrements];
		
		if (numberOfIncrements == 2) { return; }
		
		double current = bottomLimit;
		
		// assign the values of inputs and outputs
		for (int i = 0; i < numberOfIncrements; i++) {
							
			inputs[i] = current;
			outputs[i] = calculateEquation(current);
			
			current += increment;
			
		}
		
		page1 = equationPlot.createSheet("Equation 1");
		
		rows = new Row[numberOfIncrements + 1];

		
		for (int i = 0; i < numberOfIncrements + 1; i++) {
			
			rows[i] = page1.createRow(i);
		}
		
		header = rows[0];
		colCount = 2;
	}
	
	/**
	 * Makes a line chart
	 * This must be changed to fit any equation changes
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void makeLineChart() throws FileNotFoundException, IOException {
		
		XSSFDrawing drawing = page1.createDrawingPatriarch();
		XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 5, 7, 20, 25);
		XDDFChart chart = drawing.createChart(anchor);
		
		chart.getOrAddLegend();
		chart.setTitleText("Apache plotted, salted, smoothed");
		
        XDDFChartAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
        bottomAxis.setTitle("Inputs");
        XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
        leftAxis.setTitle("Outputs");
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
		
        // make the lines 
        XDDFDataSource<String> inputs = XDDFDataSourcesFactory.fromStringCellRange(page1, new CellRangeAddress(1, 401, 0, 0)); // Inputs column (A)
        XDDFNumericalDataSource<Double> outputVals = XDDFDataSourcesFactory.fromNumericCellRange(page1, new CellRangeAddress(1, 401, 1, 1)); // Outputs column (B)
        XDDFNumericalDataSource<Double> saltedVals = XDDFDataSourcesFactory.fromNumericCellRange(page1, new CellRangeAddress(1, 401, 2, 2)); // Salted column (C)
        XDDFNumericalDataSource<Double> smoothedVals = XDDFDataSourcesFactory.fromNumericCellRange(page1, new CellRangeAddress(1, 401, 3, 3)); // Smoothed column (D)
		
        
        XDDFLineChartData dataChart = (XDDFLineChartData) chart.createData(ChartTypes.LINE, bottomAxis, leftAxis);
        
        XDDFLineChartData.Series series1 = (Series) dataChart.addSeries(inputs, outputVals);
        series1.setTitle("Original");
        series1.setMarkerStyle(MarkerStyle.NONE);
        
        
        XDDFLineChartData.Series series2 = (Series) dataChart.addSeries(inputs, saltedVals);
        series2.setTitle("Salted");
        series2.setMarkerStyle(MarkerStyle.NONE);
        
        XDDFLineChartData.Series series3 = (Series) dataChart.addSeries(inputs, smoothedVals);
        series3.setTitle("Smoothed Window 10");
        series3.setMarkerStyle(MarkerStyle.NONE);
        
        chart.plot(dataChart);
        
        equationPlot.write(new FileOutputStream("EquationPlot.xlsx"));
	}
	
	/**
	 * Plots a new Column at the end
	 * 
	 * @param newVals The new values to add to column
	 * @param newHeaderName The new Column's name
	 * @throws IOException
	 */
	public static void plotNewCol(double[] newVals, String newHeaderName)  throws IOException {
		colCount++;
		Cell newCell = header.createCell(colCount - 1);
		newCell.setCellValue(newHeaderName);
		
		for (int i = 1; i < newVals.length + 1; i++) {
			
			Cell cell = rows[i].createCell(colCount - 1);
			cell.setCellValue(Double.parseDouble(df.format(newVals[i - 1])));
		}
		
		
		equationPlot.write(new FileOutputStream("EquationPlot.xlsx"));
	}
	
	/**
	 * Plots the initial equation information (inputs and outputs)
	 * 
	 * @throws IOException
	 */
	public static void plotInitialData() throws IOException {
		
		
		// The header is row 0
		
		// the first column is simulation number
		Cell input = header.createCell(0);
		input.setCellValue("Inputs");
		
		// The second column is simulation wins
		Cell output = header.createCell(1);
		output.setCellValue("Outputs");
		
		// for the number of simulations, starting at row index 1
		for (int i = 1; i <= inputs.length; i++) {
			
			// create a new row, then create the row's two cells
			Cell cell1 = rows[i].createCell(0);
			Cell cell2 = rows[i].createCell(1);
			
			// fill the new cells
			// the first column is simulation number
			cell1.setCellValue(Double.parseDouble(df.format(inputs[i - 1])));
			
			// the second column is output
			cell2.setCellValue(Double.parseDouble(df.format(outputs[i - 1])));
			
		}
		
		
			
			equationPlot.write(new FileOutputStream("EquationPlot.xlsx"));
	}
	
	
	/**
	 * Uses Apache's DescriptiveStatistics to do a moving average
	 * 
	 * @param data The data to be smoothed
	 * @param windowSize The size of the average window
	 * @return The smoothed values
	 */
	public double[] smoothWithApache(double[] data, int windowSize) {
		
		double[] smoothed = new double[data.length];
		
		DescriptiveStatistics ds = new DescriptiveStatistics(windowSize);
		
		for (int i = 0; i < data.length; i++) {
			
			ds.addValue(data[i]);
			
			
				smoothed[i] = ds.getMean();
		
		}
		
		return smoothed;
		
	}
	
	/**
	 * Salts an array with Uniform or Gaussian noise
	 * 
	 * @param unsaltedArray The array to be salted
	 * @param lowerBound The lower integer bound
	 * @param upperBound The upper integer bound
	 * @param noiseMethod Either 1, 2 corresponding to uniform or normal/Gaussian
	 * @return The salted array
	 */
	public double[] saltWithApache(double[] unsaltedArray, int lowerBound, int upperBound, int noiseMethod) {
		
		double[] saltedArray = unsaltedArray.clone();
		
		for (int i = 0; i < saltedArray.length; i++) {
			
			RandomDataGenerator random = new RandomDataGenerator();

			double seasoning;
			
			if (noiseMethod == 1 ) {
				
				seasoning = (random.nextUniform(lowerBound, upperBound));
				
			}
			
			else {
				
				seasoning = (random.nextGaussian(lowerBound, upperBound));
				
			}
			
			// randomly add
			if (Math.random() < 0.5) {
				
				Double.parseDouble(df.format(saltedArray[i] += seasoning));
				
			}
			
			// or randomly subtract
			else {
				
				Double.parseDouble(df.format(saltedArray[i] -= seasoning));
				
			}
		}
		
		return saltedArray;
	}
	
	/**
	 * Calculates the relevant equation
	 * 
	 * @param inputNum The input value
	 * @return The output value of f(inputNum)
	 */
	private double calculateEquation(double inputNum) {
		
		return 10 * inputNum;
	}
	
	/**
	 * Getter for the outputs double array
	 * 
	 * @return The outputs
	 */
	public static double[] getOutputs() {
		
		return outputs;
		
	}
	
}