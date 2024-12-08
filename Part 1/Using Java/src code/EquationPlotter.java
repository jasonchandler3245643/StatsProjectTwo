import java.text.DecimalFormat;
import java.util.Random;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *  Plots, salts, and smooths data
 * 
 * @author Jason Chandler
 *
 */
public class EquationPlotter {

	double[] inputs;
	double[] outputs;
	double increment;
	double range;
	
	// the file
	File csv = new File("CSV Equations");
	
	// round everything to four decimal places
	DecimalFormat df = new DecimalFormat("0.####");
	
	/**
	 * Default constructor
	 * 
	 * @param bottomLimit The smallest input value
	 * @param topLimit The largest input value
	 * @param numberOfIncrements The number of increments desired between bottomLimit and topLimit
	 */
	public EquationPlotter(double bottomLimit, double topLimit, int numberOfIncrements) {
		
		range = topLimit - bottomLimit;
		increment = range / (numberOfIncrements - 1);
		
		inputs = new double[numberOfIncrements];
		outputs = new double[numberOfIncrements];
		
		if (numberOfIncrements == 2) { return; }
		
		double current = bottomLimit;
		
		// assign the values of inputs and outputs
		for (int i = 0; i < numberOfIncrements; i++) {
							
			inputs[i] = Double.parseDouble(df.format(current));
			outputs[i] = Double.parseDouble(df.format(calculateEquation(current)));
			
			current += increment;
			
		}
		
	}
	
	/**
	 * Fills a file with the inputs and one output
	 * 
	 * @throws FileNotFoundException
	 */
	public void fillCSV() throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter(csv);
		
		// add the header
		pw.println("Input (x), Output (y)");
		
		// now iterate through the array and print each line
		for (int i = 0; i < inputs.length; i++) {
			
			pw.print(inputs[i] + ",");
			pw.println(outputs[i]);
			
			
		}
		
		pw.close();
	}
	
	
	/**
	 * Adds an output column to the csv file
	 * 
	 * @throws IOException 
	 * 
	 */
	public void updateCSV(String newColName, double[] newColVals) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(csv));
		
		File newCSV = new File("CSV Equations.csv");
		PrintWriter pw = new PrintWriter(newCSV);
		
		
		String line; // holds the entire line
		
		int count = -1; // start at -1 to handle the header row
		
		// go through each line by checking if it exists
		while ((line = br.readLine()) != null) {
			
			// if header row
			if (count == -1) {
				
				pw.println(line + "," + newColName);
				
			}
			
			// if not header row, do the same with new value
			else {
				
				pw.println(line + "," + newColVals[count]);
			}
			
			count++;
			
		}
		
		br.close();
		pw.close();
		
		
		Files.copy(newCSV.toPath(), csv.toPath(), StandardCopyOption.REPLACE_EXISTING);

		Files.delete(newCSV.toPath());
		
	}
	
	public File getCSV() throws FileNotFoundException {

		fillCSV();
		
		return csv;
		
	}
	
	/**
	 * Alters outputs
	 * 
	 * @param data The array to be salted
	 * @param lowerBound The lower bound of random salt value
	 * @param upperBound The upper bound of random salt value
	 */
	public double[] saltThatData(double[] data, int lowerBound, int upperBound) {
		
		double[] saltedOutputs = data.clone();
		
		for (int i = 0; i < saltedOutputs.length; i++) {
			Random gen = new Random();
			// get a salt value
			int seasoning = gen.nextInt(upperBound - lowerBound) + lowerBound;
			
			// randomly add
			if (gen.nextBoolean()) {
				
				Double.parseDouble(df.format(saltedOutputs[i] += seasoning));
				
			}
			
			// or randomly subtract
			else {
				
				Double.parseDouble(df.format(saltedOutputs[i] -= seasoning));
				
			}
			
		}
		

		return saltedOutputs;
		
	}
	
	/**
	 * Fixes each output value by 
	 * averaging the averageRange outputs nearby 
	 * 
	 * @param averageRange The number of items to average with on both sides
	 */
	public double[] fixThatData(double[] data, int averageRange) {
		
		double[] fixedOutputs = data.clone();
		
		for (int i = 0; i < fixedOutputs.length; i++) {
			
			double sum = 0;
			int count = 0;
			
			int lower = i - averageRange;
			int upper = i + averageRange;
			
			for (int j = lower; j <= upper; j++) {
			
				// handle invalid inputs
				if (j < 0 || j >= outputs.length) {
					
					sum += 0;
					
				}
				
				else {
					
					sum += data[j];
					count++;
				}
				
			}
			
			// sum / averageRange on each side + the center number
			fixedOutputs[i] = Double.parseDouble(df.format(sum / (double) count));
			
		}
		
		
		return fixedOutputs;
		
	}
	
	/**
	 * Displays the inputs in the console
	 * 
	 */
	public void printInputs() {

		for (int i = 0; i < inputs.length; i++) {
			
			System.out.print(inputs[i] + " ");
			
		}
		
	}
	
	/**
	 * Displays the inputs in the console
	 * 
	 */
	public void printOutputs() {
		
		for (int i = 0; i < inputs.length; i++) {
			
			System.out.print(outputs[i] + " ");
			
		}
		
		
	}

	/**
	 * Calculates the relevant equation
	 * 
	 * @param inputNum The input value
	 * @return The output value of f(inputNum)
	 */
	private double calculateEquation(double inputNum) {
		
		return 3 * Math.pow(inputNum, 3) - 3 * inputNum;
	}
	
	public double[] getOutputs() {
		
		return outputs;
		
	}
	
}
