import java.io.File;
import java.util.Random;

/**
 * Mess up my data, what?
 * 
 * @author Jason Chandler
 *
 */
public class Salter {

	Random gen = new Random();
	
	/**
	 * Salts the data by adding or subtracting a random
	 * number from the second (output) column
	 * 
	 * @param unseasonedData The data to ruin 
	 */
	public void saltThatFile(File unseasonedData) {
		
		// choose to add or subtract
		int temp = gen.nextInt(2);
		
		if (temp == 0);
			
		
	}
	
}
