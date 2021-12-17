package treePackage;

/** * * * * * * * * * * * * * *
 *  Created by: * * * * * * * *
 * @author Warren Peterson* * *
 * Binary Tree Search -CST201 *
 * Assignment 6 12/16/2021* * *
 *  * * * * * * * * * * * * * */

public  class BinarySearchTree{

	Node root;
	
	class Node {
		int key;
		String name;
		Node leftChild;
		Node rightChild;
		
		Node(int key, String name){ //O(1)
			this.key = key;
			this.name = name;
		}
		
		public Node(String name) { // O(1)
			this.name = name;
		}

		public String toString() { // O(1)
			return name ;
		}
	}
	
	// Add the node to Binary Tree
	public void addNode( String name) {// O(n)
		// Create a new Node and initialize it
		Node newNode = new Node(name);
		// If there is no root this becomes root
	    if (root == null) {
	    	root = newNode;
	    }else {
	    	//Set root as the node we will start
	    	// with as we traverse the tree
	    	Node focusNode = root;
	    	// Future parent for our new Node
	    	Node parent;
	    	while (true) {
	    		//root is the top parent so we start there
	    		parent = focusNode;
	    		// Check if the new node should go on the
	    		// left side of the parent node
	    		if (name.compareTo(focusNode.name) < 0) {
	    			//Switch focus to the left child
	    			focusNode = focusNode.leftChild;
	    			//If the left child has no children
	    			if (focusNode == null) {
	    				// then place the new node on the left of it
	    				parent.leftChild = newNode;
	    				return;
	    			}
	    		//If we get here put the node on the right
	    		}else if(name.compareTo(focusNode.name) > 0) {
	    			focusNode = focusNode.rightChild;
	    			// If the right child has no children
	    			if (focusNode == null) {
	    				// then place the new node to the right of it
	    				parent.rightChild = newNode;
	    				return;
	    			}
	    		}else {
	    			return;
	    		}
	    	}
	    }
	}// End of Method
	
	// All nodes are visited in ascending order
	// Recursion is used to go to one node and
	// then go to its child nodes and so forth
	public void inOrderTraverseTree(Node focusNode) { // O(n) n is number of nodes in tree
	    if (focusNode != null) {
	    	// Traverse the left node
	    	preorderTraverseTree(focusNode.leftChild);
	    	// Visit the currently focused on node
	    	System.out.println(focusNode);
	    	// Traverse the right node
	    	preorderTraverseTree(focusNode.rightChild);
	    }
	}// End of Method
	
	public void preorderTraverseTree(Node focusNode) { // O(n)
		if(focusNode != null) {
			System.out.println(focusNode);
			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);
		}
	}// End of Method
	
	public void postorderTraverseTree(Node focusNode) { // O(n)
		if(focusNode != null) {
			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}// End of Method
	
	public boolean remove(String name){	//O(n)
		// Start at the top of the tree	
	    Node focusNode = root;
	    Node parent = root; 
	    // prevent infinite loop on empty tree
	    if (root == null){
	    return false;
	    }
	    // When searching for a Node this will
	    // tell us whether to search to the right or left
	    boolean isALeftChild = true;
	    // While we haven't found the Node keep looking
	    while (!focusNode.name.equals(name)){	    	
	    	parent = focusNode;
	    	// If we should search to the left
	    	if(name.compareTo(focusNode.name) < 0){
	    		isALeftChild = true;	    		
	    		// Shift the focus Node to the left Chlid
	    		focusNode = focusNode.leftChild;
	    	}else {
	    		// Greater than focus node so go to the right
	    		isALeftChild = false;
	    		// Shift the focus Node to the right child
	    		focusNode = focusNode.rightChild;
	    	}
	    	// The node wasn't found
	    	if(focusNode == null)
	    		return false;
	    }
	    // If Node doesn't have children delete it
	    if(focusNode.leftChild == null && focusNode.rightChild == null){
	    	// If root delete it
	    	if (focusNode == root){
	    		root = null;
	    	// If it was marked as a left child
	    	// of the parent delete it in its parent
	    	}else if(isALeftChild){
	    		parent.leftChild = null;
	    	// Vice Versa for the right child
	    	}else {
	    		parent.rightChild = null;
	    	}
	    }
	    // If no right child
	    else if(focusNode.rightChild == null){
	    	if(focusNode == root)
	    		root = focusNode.leftChild;
	    	// If focus Node was on the left of parent 
	    	// move the focus Nodes left child up to the
	    	// parent node
	    	else if(isALeftChild)
	    		parent.leftChild = focusNode.leftChild;
	    	// Vice versa for the right child
	    	else
	    		parent.rightChild = focusNode.leftChild; // error?
	    }
	    // If no left child
	    else if(focusNode.leftChild == null){
	    	if(focusNode == root)
	    		root = focusNode.rightChild;
	    	// If focus Node on the left of parent
	    	// move the focus Nodes right child up to the
	    	// parent node
	    	else if(isALeftChild)
	    		parent.leftChild = focusNode.rightChild; 
	    	// Vice versa for the right child
	    	else
	    		parent.rightChild = focusNode.rightChild; // was changed
	    }
	    // Two children so I need to find the deleted nodes replacement
	    else {
	    	Node replacement = getReplacementNode(focusNode);
	    	// If the focusNode is root replace root
	    	// with the replacement
	    	if(focusNode == root)
	    		root = replacement;
	    	//If the deleted node was a left child
	    	// make the replacement the left child
	    	else if(isALeftChild)
	    		parent.leftChild = replacement;
	    	// Vice versa if it was a right child
	    	else
	    		parent.rightChild = replacement;

	    	replacement.leftChild = focusNode.leftChild;
	    }
	    return true;
	 }// End of Method

	// Created a replacement node when a Node is deleted
	 private Node getReplacementNode(Node replacedNode){// O(n)
		 Node replacementParent = replacedNode;
	     Node replacement = replacedNode;
	     Node focusNode = replacedNode.rightChild;
	     // While there are no more left children
	     while (focusNode != null){
	    	replacementParent = replacement;
	    	replacement = focusNode;
	    	focusNode = focusNode.leftChild;
	     }
	     // If the replacement isn't the right child
	     // move the replacement into the parents
	     // leftChild slot and move the replaced nodes
	     // right child into the replacement rightChild
	     if(replacement != replacedNode.rightChild){
	    	replacementParent.leftChild = replacement.rightChild;
	       	replacement.rightChild = replacedNode.rightChild;
	     }
	     return replacement;
	 }// End of Method
	 
	 // Searches for the node in the BST by string name rather than by key
	 public void findNode(String name){ // change to int key //O(n)
		 // Start at the top of the tree
		 Node focusNode = root;
		 int count = 0;
		 if(focusNode.name.equals(name)){		 
		 }
		 // While we haven't found the Node keep looking
		 while (!focusNode.name.equals(name)){
			 // If we should search to the left
			 if(name.compareTo(focusNode.name) < 0){
				 count++;
				 focusNode = focusNode.leftChild;
				 if(focusNode == null){
					 System.out.println("Inspected " + count + " elements" + "\n" + name + " was not located");
					 return;
				 }
			 // If we should search to the right
			 }else if(name.compareTo(focusNode.name) > 0) {
				 count++;
				 focusNode = focusNode.rightChild;
				 if(focusNode == null){
					 System.out.println("Inspected " + count + " elements" + "\n" + name + " was not located");
					 return;
				 }
		     }
		 }
		 System.out.println("Inspected " + count + " elements" + "\n" + name + " located");
	 }// End of Method	
}
