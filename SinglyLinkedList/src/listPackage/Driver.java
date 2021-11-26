package listPackage;

/* * * * * * * * * * * * * * * *
 * This beauty was created by* *
 * Warren Peterson for * * * * *
 * CST-201 Assignment* * * * * *
 * Project 2: Singly-Linked List
 * Hope you enjoyed* * * * * * *
 * * * * * * * * * * * * * * * */

public class Driver{

	// Test Program to test methods in List Class
	public static void main(String[] args) {
		// Start with an empty list
		List list1 = new List();
		list1.addToHead(6);
		list1.addToTail(7);
		System.out.println("This is the current list");
		list1.printList();
		
		//Test to Access first element
		list1.addToHead(10);
		System.out.println("\n\nThis is a Test of First Element Access Method, Adding 10 to head");
		System.out.println("Current List is: ");
		list1.printList();
		
		list1.addToTail(1);
		System.out.println("\n\nThis is a Test of the Last Element Access Method, Adding 1 to Tail");
		list1.printList();
		
		list1.insertAfter(list1.head.next.next, 2);
		System.out.println("\n\nThis is a Test of the Insert value method, Inserting 2 after 7");
		list1.printList();
		
		list1.pop_front();
		System.out.println("\n\nThis is a test of Removing head method, Removing 10");
		list1.printList();
		
		list1.pop_back();
		System.out.println("\n\nThis is a test of Remove tail Method, Removing the 1");
		list1.printList();
		
		list1.isEmpty();
		System.out.println("\n\nThis is a test of isEmpty, Is the list empty?\n" + list1.isEmpty());
		
		System.out.println("\nThis is a test of size method,\nThere are " + list1.size() + " elements in the Linked List");
		
		list1.reverse();
		System.out.println("\nThis is a test of reverse list method, 6,7,2 should become 2,7,6");
		list1.printList();
		
		List list2 = new List();
		list2.addToHead(10);
		list2.addToTail(20);
		list2.addToTail(30);
		List list3 = new List();
		list3.addToHead(15);
		list3.addToTail(25);
		list3.addToTail(35);
		System.out.println("\n\nI have Created Two new Sorted List Below:");
		list2.printList();
		System.out.println("\n");
		list3.printList();
		System.out.println("\n");
		list2.head = new List().SortedMerge(list2.head, list3.head);
		list2.printList();
	}

}
