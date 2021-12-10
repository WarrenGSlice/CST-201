package recursiveStringsPackage;

/** * * * * * * * * * * * *
 * * * * * * * * * * * * * 
 * @author Warren Peterson
 * CST-201 12/8/2021
 * * * * * * *  * * * * * *
 * * * * * * * * * * * * * */

public class SlipSlapSlop {
	
	static String orginalString = "";
	  
	// Empty Constructor Method
	public SlipSlapSlop() {
		
	}
	
	/**
     * A slip has the following rules
     * Its first character is either D of E
     * The first character is followed by a string of 1 or more F's
     * the string of F's is followed by another Slip (D or E) or a G
     * the Slip (D or E) or G that follows the string of F's ends the string.  Ex EFFFFG
     * Examples of Slips: DFG, EFG, DFFFFFG, DFDFDFDFG, DFEFFFFFG
     */
	public boolean isSlip(String input) { // O(n + n) or O(n^2) Quadratic Time
	    orginalString = input;
	    try {
	    	// if length of slip is less than 2
	    	if (input.length() <= 2) {
	    		return false;
	    	}
	    	// Checking to see if first letter is D or E
	    	if (input.charAt(0) != 'D' && input.charAt(0) != 'E') {
	    		return false;
	    	}
	    	// Checking to see if an F follows first letter
	    	if (input.charAt(1) != 'F') {
	    		return false;
	    	}
	    	// Check for Sequence of F's in a row
	    	int i = 1;
	    	int n;
	    	n = input.length();
	    	// Iterate through to get past all of the F's
	    	while ( i < n && input.charAt(i) == 'F') { //O(n) Linear Time
	    		i+=1;
	    	}
	    	// if word ends with an F
	    	if (i == n) {
	    		return false;
	    	}
	    	// check if it ends with a G or a slip
	    	if ((n == i + 1 && input.charAt(i) == 'G' || isSlip(input.substring(i)))) { // O(n) because its recursive
	    		return true;
	    	}else {
	    		return false;
	    	}
	    } catch (Exception e) {
	    	System.out.println("Something is wrong with isSlip()");
	    }
		return false;
	}
	
	/** 
	 * A Slap has a first character 'A'
	 * if Two Characters than the second and last character can be 'H'
	 * if not Two Characters, then it must be:
	 * 'A' followed by 'B' followed by a Slap, followed by a 'C'
	 * 'A' followed by a Slip, followed by a 'C'
	 * Nothing else is a Slap
	 */
	public boolean isSlap(String string) { // O(2^n) Exponential Time
	    try {
	    	// If length of Slap is 2
	    	if(string.length() == 2){ // O(1)
	    		// and if character at beginning of word is 'AH'
	            if(string.charAt(0) == 'A' && string.charAt(1) == 'H'){ // O(1)
	                return true; 
	            }else{
	                return false;
	            }
	        // If length of word is 3 or 4
	        }else if(string.length() == 3 || string.length() == 4){ // O(1)
	            return false;
	        }else{
	        	// if The beginning of word does not start with an 'A'
	            if(string.charAt(0) != 'A'){ // O(1)
	                return false;
	            }
	            int n = string.length();
	            // case 1 = is a Slap where we look at second character to second to last and is followed by a C
	            boolean case1 = isSlap(string.substring(2, n-1)) && (string.charAt(n-1)=='C'); // O(2^n)
	            // case 2 = is a SLip where we take the first to second to last and is followed by a C
	            boolean case2 = isSlip(string.substring(1, n-1)) && (string.charAt(n-1)=='C'); // O(n^2)
	            // Second character is a B and fits case 1 or case 2
	            if((string.charAt(1)=='B' && case1) || case2){ //
	                return true;
	            }else{
	                return false;
	            }
	        }	
	    }catch (Exception e) {
	    	
	    }
		return false;
	}

	public boolean isSlop(String str){ // O(2^n) Exponential Time
		// A Slap is at least 2 characters long while a slip is at least 3 chars long
		// Thus, the size of a slop is at least 5
		if(str.length() < 5){
			return false;
		}else{
			//Slap end with 'H' if it is two characters long else it ends with 'C'
	        if(isSlap(str.substring(0,2)) && isSlip(str.substring(2)) ){ // O(2^n)
	        	return true;
	        }
	        //find the last occurrence of 'C'
	        int lastCidx = str.lastIndexOf('C');
	        if(lastCidx == -1){
	        	return false;
	        }else{
	            if(isSlap(str.substring(0,lastCidx+1)) && isSlip(str.substring(lastCidx+1))){ // O(2^n)
	            	return true;
	            }else{
	                return false;
	            }
	        }   
	    }
	}
}
