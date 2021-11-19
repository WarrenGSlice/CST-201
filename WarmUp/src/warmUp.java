import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class warmUp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String line = "";
		String temp;
		
		//new scanner to read text file 
		Scanner inputFile = new Scanner(new File("input.txt")).useDelimiter(",\\s*");
		
		//declare the array with a capacity for 10,000 strings
		List<String> words = new ArrayList<String>(10000);
		
		//program that reads a text file and stores each word in an array
		while (inputFile.hasNext()) {
			line = inputFile.next();
			words.add(line);
		}
			inputFile.close();
			String[] wordsArray = words.toArray(new String[0]);
			
			for (String s : wordsArray) {
			//unsorted System.out.println(s);
			}
			
			//implement bubble sort to sort by alphabetical order
			for (int j = 0; j < wordsArray.length; j++) {
				for (int i = j + 1; i < wordsArray.length; i++) {
					if (wordsArray[i].compareTo(wordsArray[j]) < 0) {
						temp = wordsArray[j];
						wordsArray[j] = wordsArray[i];
						wordsArray[i] = temp;
					}
				}
				System.out.println(wordsArray[j]);
			}	
				
		//binary search
		//grab user input
			Scanner scan = new Scanner(System.in);
			//System.out.println("Enter a word");
			
			String userInput = scan.next();
			
			//test
			//System.out.println("You entered the word " + userInput + ", " + "right?");

			int lowestIndex = 0;
			int highestIndex = wordsArray.length-1; //6
			int middleIndex = 0;
			
			while(lowestIndex<=highestIndex) {
				middleIndex = (lowestIndex+highestIndex)/2;
				
			if(userInput.compareTo(wordsArray[middleIndex]) < 0) {
				lowestIndex = middleIndex+1;
			}else if (userInput.compareTo(wordsArray[middleIndex]) > 0) {
				highestIndex = middleIndex - 1;
			}else {
				break;
			}if(lowestIndex > highestIndex) {
				System.out.println("-1");
			}else {
				System.out.println("found at" + middleIndex);
			}
		}		
	}
}