package treePackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** * * * * * * * * * * * *
 * * * * * * * * * * * * * 
 * @author Warren Peterson
 * CST-201 12/8/2021
 * * * * * * *  * * * * * *
 * * * * * * * * * * * * * */

public class Helpers {
	
	public Helpers() {
		
	}
	
	// Method to Read the Lines from the Files and process them into an Array of String Elements
	public String[] readLines(String filename) throws IOException { // O(n)
		FileReader fileReader = new FileReader(filename);
	    BufferedReader bufferedReader = new BufferedReader(fileReader);
	    List<String> lines = new ArrayList<String>();
	    String line = null;
	    while ((line = bufferedReader.readLine()) != null) {
	    	lines.add(line);
	    }
	    bufferedReader.close();
	    return lines.toArray(new String[lines.size()]);
	}
	
	public ArrayList<String> splitString(String filename) throws IOException { // O(n)
		ArrayList<String> inputArray = new ArrayList<>();
	    Scanner input = new Scanner(new FileReader(filename));
	    String str;

	    while (input.hasNext()) {
	    	str = input.next();
	    	str = stringCleanUp(str);
	    	inputArray.add(str);
	    }
	    input.close();
	    return inputArray;
	}

	private String stringCleanUp(String str) { //O(1)
		return str.toLowerCase().replaceAll("^[^a-z]+|[^a-z]+$", "");
	}

	public <T> ArrayList<T> removeDuplicates(ArrayList<T> list){ //O(n)
		ArrayList<T> newList = new ArrayList<T>();
		for (T element: list){
			if(!newList.contains(element)){
				newList.add(element);
			}
		}
		return newList;
	}
	
}
