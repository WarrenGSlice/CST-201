package listPackage;
/* * * * * * * * * * * * * * * *
 * This beauty was created by* *
 * Warren Peterson for * * * * *
 * CST-201 Assignment* * * * * *
 * Project 2: Singly-Linked List
 * Hope you enjoyed* * * * * * *
 * * * * * * * * * * * * * * * */
class List {
	
	Node head;
	Node tail;

	class Node{
		
		Node list;
		int value;
		Node next;
		Node previous;

		public Node(Node list, int value, Node next, Node previous) {
			super(); //0(1)
			this.list = list;
			this.value = value;
			this.next = next;
			this.previous = previous;
		}

		// 1) Default Constructor
		public Node(int val) {//0(1)
			value = val;
			next = null;
		}
		
		// 2) Copy Constructor
		public Node(int val, Node list) {//0(1)
		}

		public Node() {//0(1)
			// TODO Auto-generated constructor stub
		}
	}

	// 3) Access to First Element *adds to head*
	public void addToHead(int new_head) {//O(head)
		// Allocate the Node & put in the value
		Node new_node = new Node(new_head);//0(1)
		// Make next of new node as head
		new_node.next = head;//0(1)
		// Move the head to point to new Node
		head = new_node;//0(1)
	}
	
	// 5) insert value after the given prev_node
	public void insertAfter(Node prev_node, int new_value) {//0(node+value)
		// check if the given node is null
		if (prev_node == null) {//0(1)
			System.out.println("The given previous node cannot be null");
			return;
		}
		// Allocate the Node & Put in the value
		Node new_node = new Node(new_value);
		// Make next of new Node as next of Previous Node
		new_node.next = prev_node.next;
		// make next of prev_node as new_node
		prev_node.next = new_node;
	}
	
	//4) Access to last element *addToTail*
	public void addToTail (int new_tail) {//0(1)
		// Allocate the Node & Put in the value & set next as null
		Node new_node = new Node(new_tail);//0(1)
		//If the Linked List is empty, then make the new node as head
		if (this.head == null) {//0(1)
			head = new Node(new_tail);
			return;		
		}
		// This new node is going to be the last node, so make next of it as null
		new_node.next = null;
		// Ele traverse til the last node
		Node last = head;
		while (last.next != null) {//0(1)
			last = last.next;
		}
		// Change the next of last node
		last.next = new_node;
		return;
	}
	
	// Prints contents of LinkedList
	public void printList() {//0(1)
		Node tempNode = head;
		while (tempNode != null) {//0(1)
			System.out.print(tempNode.value+" ");
			tempNode = tempNode.next;
		}
	}
	
	// 6) Remove value at front
	public void pop_front() {//0(1)
		if (this.head != null) {//0(1)
			// If head is not null, create a
			// temp node pointing to head
			Node temp = this.head;//0(1)
			// Move head to next of head
			this.head = this.head.next;//0(1)
			// Delete temp node
			temp = null;
		}
	}
	
	// 7) Remove value at End
	public void pop_back() {//0(1)
		// if head in not null and next of head
		// is null, release the head
		if(this.head.next == null) {//0(1)
			this.head = null;
		    }else {//0(1)
		      
		    //2. Else, traverse to the second last 
		    //   element of the list
		    Node temp = new Node();//0(1)
		    temp = this.head;//0(1)
		    while(temp.next.next != null)//0(1)
		    	temp = temp.next;
		      
		    //3. Change the next of the second 
		    //   last node to null and delete the
		    //   last node
		    Node lastNode = temp.next;//0(1)
		    temp.next = null; //0(1)
		    lastNode = null;//0(1)
		    }
	}
	
	//8) Determine if Empty
	public boolean isEmpty() {//0(1)
	    if (head == null) {//0(1)
	      return true;
	    }
	    return false;
	  }
	
	//9) Return # of Elements
	public int size() {//0(1)
	    // create a temp node pointing to head
		Node temp = new Node();//0(1)
		 temp = this.head;

		 //2. create a variable to count nodes
		 int i = 0;

		 //3. if the temp node is not null increase 
		 //   i by 1 and move to the next node, repeat
		 //   the process till the temp becomes null
		 while(temp != null) {//0(1)
			 i++;
		     temp = temp.next;
		 }

		 //4. return the count
		 return i; 
	}
	
	// 10) Reverse order of elements in list
	public void reverse() {//0(1)
		// If head is not null, create three nodes
		// prev_node pointing to head
		// temp_node pointing to head
		// cur_node pointing to next of head
		if(this.head != null) {//0(1)
			Node prev_node = this.head;
			Node temp_node = this.head;
			Node cur_node = this.head.next;
			//Assign next of prev_node as null to make first node as last of the reversed list
			prev_node.next = null;
			while(cur_node != null) {//0(1)
				//While the cur_node is not null, adjust links
				temp_node = cur_node.next;
				cur_node.next = prev_node;
				prev_node = cur_node;
				cur_node = temp_node;
			}
			// Make prev_node as head
			this.head = prev_node;
		}
	}
	
	// 11) Merge with another ordered list
	public Node SortedMerge(Node headA,Node headB) {//0(head + head)
		Node dummyNode = new Node(0);
		Node tail = dummyNode;
		while(true) {//0(1)
			if( headA == null ) {//0(1)
				tail.next = headB;
				break;
			}
			if(headB == null) {//0(1)
				tail.next = headA;
				break;
			}
			if(headA.value <= headB.value) {//0(1)
				tail.next = headA;
				headA = headA.next;
			}else {//0(1)
				tail.next = headB;
				headB = headB.next;
			}
			tail = tail.next;
		}
		return dummyNode.next;
	}
}
