import java.text.DecimalFormat;
import java.util.Random;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 3 steps for the programming portion:
 * 	1.  Get the inputs and outputs into a csv file
 * 	2.	Salt the outputs
 * 	3.	Smooth the outputs
 * 
 * 
 * 
 * 
 * @author jchan
 *
 */
public class EquationPlotter {

	double[] inputs;
	double[] outputs;
	double increment;
	double range;
	
	// the file
	File csv = new File("CSV Data");
	
	// round everything to four decimal places
	DecimalFormat df = new DecimalFormat("#.#####");
	
	public EquationPlotter(double bottomLimit, double topLimit, int numberOfIncrements) {
		
		range = topLimit - bottomLimit;
		increment = range / (numberOfIncrements - 1);
		
		inputs = new double[numberOfIncrements];
		outputs = new double[numberOfIncrements];
		
		if (numberOfIncrements == 2) { return; }
		
		double current = bottomLimit;
		
		for (int i = 0; i < numberOfIncrements; i++) {
							
			inputs[i] = Double.parseDouble(df.format(current));
			outputs[i] = Double.parseDouble(df.format(calculateEquation(inputs[i])));
			current += increment;
			
		}
		
		
		
		
	}
	
	/**
	 * Fills a file with the inputs and one output
	 * 
	 * @throws FileNotFoundException
	 */
	private void fillCSV() throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter("csv.csv");
		
		// add the header
		pw.println("Input (x), Output (y)");
		
		// now iterate through the array and print each line
		for (int i = 0; i < inputs.length; i++) {
			
			pw.print(inputs[i] + ", ");
			pw.println(outputs[i]);
			
			
		}
		
		pw.close();
	}
	
	/**
	 * Adds an output column to the csv file
	 * 
	 */
	public void appendCSVColumn(int newcol) {
		
		//BufferedReader bf = new BufferedReader(csv);
		int[] newOutputs = new int[inputs.length];
		
		
		
		
	}
	
	public File getCSV() throws FileNotFoundException {

		fillCSV();
		
		return csv;
		
	}
	
	/**
	 * Alters the output column
	 * 
	 * @param lowerBound The lower bound of random salt value
	 * @param upperBound The upper bound of random salt value
	 */
	public void saltThatFile(int lowerBound, int upperBound) {
		
		Random gen = new Random();
		
		for (int i = 0; i < outputs.length; i++) {
			
			// get a salt value
			int seasoning = gen.nextInt(upperBound - lowerBound) + lowerBound;
			
			// randomly add
			if (gen.nextBoolean()) {
				
				outputs[i] += seasoning;
				
			}
			
			// or randomly subtract
			else {
				
				outputs[i] -= seasoning;
				
			}
			
		}
		
	}
	
	/**
	 * Fixes each output value by 
	 * averaging the averageRange outputs nearby 
	 * 
	 * @param averageRange the radius
	 */
	public void fixThatData(int averageRange) {
		
		double[] newOutputs = new double[outputs.length];
		
		for (int i = 0; i < outputs.length; i++) {
			
			double sum = 0;
			int lower, upper;
			
			lower = i - averageRange;
			upper = i + averageRange;
			
			for (int j = lower; j <= upper; j++) {
				
				// handle invalid inputs
				if (j < 0 || j >= outputs.length) {
					
					sum += 0;
					
				}
				
				else {
					
					sum += outputs[j];
					
				}

			}
			
			// sum / averageRange on each side + the center number
			newOutputs[i] += sum / (averageRange * 2 + 1);
			
		}
		
		
		
		
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
	 * @param inputNum the 
	 * 
	 */
	private double calculateEquation(double inputNum) {
		
		return -(Math.pow(inputNum - 50, 2) + 50);
		
	}
	
	
}
