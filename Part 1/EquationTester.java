import java.io.FileNotFoundException;

public class EquationTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		EquationPlotter ew = new EquationPlotter(0, 100, 101);
		ew.printInputs();
		System.out.println("");
		ew.printOutputs();
		
		
		ew.saltThatFile(0, 5);
		ew.fixThatData(2);
		ew.getCSV();

	}

}
