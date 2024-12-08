import java.io.IOException;

public class EquationTester {

	public static void main(String[] args) throws IOException {
		
		EquationPlotter ew = new EquationPlotter(-1, 1, 101);
		ew.printInputs();
		System.out.println("");
		ew.printOutputs();
		ew.getCSV();
		
		double[] salted = ew.saltThatData(ew.getOutputs(), 1, 3);
		ew.updateCSV("Outputs Salted", salted);
		
		double[] fixed = ew.fixThatData(salted, 3);
		ew.updateCSV("Smoothed avg radius 3", fixed);

		fixed = ew.fixThatData(salted, 10);
		ew.updateCSV("Smoothed avg radius 10", fixed);
	}
}