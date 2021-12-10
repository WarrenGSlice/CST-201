package recursiveStringsPackage;

import java.io.IOException;

/** * * * * * * * * * * * *
 * * * * * * * * * * * * * 
 * @author Warren Peterson
 * CST-201 12/8/2021
 * * * * * * *  * * * * * *
 * * * * * * * * * * * * * */

public class TestHelpers {
	Helpers helpers = new Helpers();

	public TestHelpers() {
		
	}
	
	// Method to create output for Slips
	public void testSlip(String filename) throws IOException {  // O(n^2)
	    System.out.println("****SLIPS OUTPUT****");
	    String[] inputArray = helpers.readLines(filename);
	    int i;
	    for (i = 0; i < inputArray.length; i++) {
	    	SlipSlapSlop testingSlip = new SlipSlapSlop();
	    	if (testingSlip.isSlip(inputArray[i])) { 
	    		System.out.println("\t" + inputArray[i] + " YES");
	    	}else {
	    		System.out.println("\t" + inputArray[i] + " NO");
	    	}
	    }
	    System.out.println("****END OF OUTPUT****");
	}
	
	// Method to create output for Slaps
	public void testSlap(String filename) throws IOException { // O(2^n)
	    System.out.println("****SLAPS OUTPUT****");
	    String[] inputArray = helpers.readLines(filename);
	    int i;
	    for (i = 0; i < inputArray.length; i++) {
	    	SlipSlapSlop testingSlap = new SlipSlapSlop();
	    	if (testingSlap.isSlap(inputArray[i])) {
	    		System.out.println("\t" + inputArray[i] + " YES");
	    	}else {
	    		System.out.println("\t" + inputArray[i] + " NO");
	    	}
	    }
	    System.out.println("****END OF OUTPUT****");
	}
	
	// Method to create output for Slops
	public void testSlop(String fileName) throws IOException { // O (2^n)
	    System.out.println("****SLOPS OUTPUT****");
	    String[] inputArray = helpers.readLines(fileName);
	    int i;
	    for (i = 0; i < inputArray.length; i++) {
	    	SlipSlapSlop testingSlop = new SlipSlapSlop();
	    	if (testingSlop.isSlop(inputArray[i])) {
	    		System.out.println("\t" + inputArray[i] + " YES");
	    	}else {
	    		System.out.println("\t" + inputArray[i] + " NO");
	    	}
	    }
	    System.out.println("****END OF OUTPUT****");
	}
	
	
	
	
}
