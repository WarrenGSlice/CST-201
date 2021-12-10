package recursiveStringsPackage;

import java.io.FileNotFoundException;
import java.io.IOException;

/** * * * * * * * * * * * *
 * * * * * * * * * * * * * 
 * @author Warren Peterson
 * CST-201 12/8/2021
 * * * * * * *  * * * * * *
 * * * * * * * * * * * * * */

// Driver Class Runs Program
public class Driver {

	public static void main(String[] args) throws IOException{
		TestHelpers helpers = new TestHelpers();
		
		try {
			helpers.testSlip("slipTestFile.txt");
			helpers.testSlap("slapTestFile.txt");
			helpers.testSlop("slopTestFile.txt");
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
	}
}
