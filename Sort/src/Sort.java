import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/* Created by Warren Peterson 11/16/2021
 * for CST-201 (Project 0) Warm Up Array
 */

public class Sort{
    // The Bubble Sorting Method
    private static void bubbleSort(ArrayList<String> list)
    {
    	//if each element is closer to z it moves it to the right

    	for (int j=1; j<list.size(); j++)
    	{
    		for (int i=0; i<list.size() - j; i++) {
    			// i is left word, +1 is word to the right
    			if (list.get(i).compareTo(list.get(i + 1)) > 0) {
    				// if elements not in order, swap them
    				String tmp = list.get(i);
    				list.set(i,  list.get(i + 1));
    				list.set(i + 1,  tmp);
    			}
    		}
    	}
    }
    // The Binary Search Iterative Method
    public static int binarySearch(String[] arr, String x)
    {
    	// returns index of searched word if it is present in array[1..
    	// right]. else return -1
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2); // picks midpoint, cuts in half
 
            int res = x.compareTo(arr[mid]); // compare searched word to midpoint
 
            // Check if the searched word is present at mid
            // middle itself
            if (res == 0)
                return mid;
            
            // if searched word is on the right
            // If the searched word greater, ignore left half
            if (res > 0)
                left = mid + 1;
            
            // if searched word is on the left
            // If the searched word is smaller, ignore right half
            else
                right = mid - 1;
        }
        // we get here when searched word is not present
        return -1;
    }
    // The method that handles all user input and runs the programs
    public static ArrayList<String> readWordsFromFile(String fileName) throws FileNotFoundException {
    	
    	String line = "";
    	Scanner file = new Scanner(new File(fileName)).useDelimiter(",");
    	// creates an array with a max of 10000 values
    	ArrayList<String> wordList1 = new ArrayList<>(10000);
    	//reads the file and prints the unsorted array list
    	while (file.hasNextLine()) {
    		line = file.nextLine();
    		String[] items = line.split(" "); // splits each word with a space so they can be referenced easily and added to list
    		System.out.println("Before: " + "[" + items[0] + ", " + items[1] + ", " + items[2] + ", " + items[3] +
    							", " + items[4] + ", " + items[5] + ", " + items[6] + ", " + items[7] + ", " + 
    							items[8] + ", " + items[9] + ", " + items[10] + ", " + items[11] + "]");  		
    		String newSort = new String();
    		wordList1.add(newSort); 
    		ArrayList<String> list = new ArrayList<>();
    		// adds the unsorted list to a new array list to be sorted
    		list.add(items[0]);
    		list.add(items[1]);
    		list.add(items[2]);
    		list.add(items[3]);
    		list.add(items[4]);
    		list.add(items[5]);
    		list.add(items[6]);
    		list.add(items[7]);
    		list.add(items[8]);
    		list.add(items[9]);
    		list.add(items[10]);
    		list.add(items[11]);
    		bubbleSort(list); // sorts the list
    		System.out.println("After: " + list); //prints out the after list
    		// Prompts user for word to search for
    		System.out.println("Enter a word to search for: ");
    		// Takes the sorted array list and puts the words in the same order into an array to be binary searched by user
    		// The while loops allows the user to search for words until a certain point and then terminates
        	while(true) {
        		Scanner input = new Scanner(System.in);
        		items[0] = list.get(0);
        		items[1] = list.get(1);
        		items[2] = list.get(2);
        		items[3] = list.get(3);
        		items[4] = list.get(4);
        		items[5] = list.get(5);
        		items[6] = list.get(6);
        		items[7] = list.get(7);
        		items[8] = list.get(8);
        		items[9] = list.get(9);
        		items[10] = list.get(10);
        		items[11] = list.get(11);
        		String[] arr = { items[0],items[1],items[2],items[3],items[4],items[5],items[6],items[7],items[8],
        						items[9],items[10],items[11]};
        		String x = "";
                x = input.nextLine(); //prompts the user for input on word to search for
                int result = binarySearch(arr, x); // does a binary search for the prompted word
                // if the users input is invalid
                if (result == -1) {
                	try {
                		System.out.println(x + " Is not in the list");
                		// if the users input is 0
                		if (input.nextInt() == 0) {
                			System.out.println("Goodbye");
                		}
                		// catches exceptions before loop is closed
                	}catch (Exception e) {
                		System.out.println("Goodbye");
                		input.close();
                	}
                	System.exit(0); // Terminates program after loop is completed 
                }
                // Shows user location of requested word and then goes through loop again
                else {
                    System.out.println( x + " Is in the list at "
                                      + "index " + result);
                }
        	}
    	}
    	file.close();
    	return wordList1;
    }
    // Main Driver Method with no file found handling capabilities
    public static void main(String[] args) throws IOException {
    	// Locates file and sends it to method above for processing
        ArrayList<String> wordsReadFromFile = new ArrayList<String>(); 
        wordsReadFromFile = readWordsFromFile("wordList1.txt");  
    }
}