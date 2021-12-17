package treePackage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/** * * * * * * * * * * * * * *
 *  Created by: * * * * * * * *
 * @author Warren Peterson* * *
 * Binary Tree Search -CST201 *
 * Assignment 6 12/16/2021* * *
 *  * * * * * * * * * * * * * */

public class Driver {

	public static void main(String[] args) throws IOException {
	    BinarySearchTree theTree = new BinarySearchTree();
	    Helpers helpers = new Helpers();

	    ArrayList<String> inputArray = helpers.splitString("Input.txt");
	    System.out.println(inputArray.toString());

	    for (int i = 0; i <= inputArray.size() - 1; i++) {
	    	theTree.addNode(inputArray.get(i)); 
	    }

	    theTree.inOrderTraverseTree(theTree.root);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
	    do {
	      System.out.println("Enter string, enter -1 to quit: ");
	      String input = scanner.nextLine();
	      if(input.equals("-1")){
	        break;
	      }
	      theTree.findNode(input);
	    } while (true);

	    System.out.println("Enter string to remove: ");
	    do {
	    	System.out.println("Enter string to remove, enter -1 to quit:");
	    	String removedString = scanner.nextLine();
	    	if(removedString.equals("-1")) {
	    		break;
	    	}
	    	boolean isRemoved = theTree.remove(removedString);
	    	if(isRemoved) {
	    		theTree.inOrderTraverseTree(theTree.root);
	    	}else {
	    		System.out.println(removedString + " not found, nothing removed.");
	    		theTree.inOrderTraverseTree(theTree.root);
	    	}
	    }while(true);	
	}
}