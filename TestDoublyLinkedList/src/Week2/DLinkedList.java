package Week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * provided file for DLinkedList Assignment
 *
 * @author lkfritz
 */

/* * * * * * * * * * * * * * * * * * * * *
 * Changed and edited by Warren Peterson *
 * for use in class CST-201 on * * * * * *
 * 11/26/2021 - Project 3  * * * * * * * *
 * Doubly Linked List  * * * * * * * * * *
 * * * * * * * * * * * * * * * * * * * * */

public class DLinkedList<T extends Comparable<T>> {

	// 4b) I am providing a main method.
  public static void main(String[] args) throws FileNotFoundException {

    DLinkedList<String> lst1 = new DLinkedList<>();
    DLinkedList<String> lst2 = new DLinkedList<>();

    Scanner fin = new Scanner(new File("src\\Week2\\File1.txt"));
    String str;

    while (fin.hasNext()) {
      str = fin.next();
      str = cleanUp(str);
      lst1.insertOrderUnique(str);
    }
    fin.close();

   fin = new Scanner(new File("src\\Week2\\File2.txt"));
   while (fin.hasNext()) {
     str = fin.next();
     str = cleanUp(str);
     lst2.insertOrderUnique(str);
   }

    System.out.println("List 1:  " + lst1);
    System.out.println("List 2:  " + lst2);


    DLinkedList combined = lst1.merge(lst2);

    System.out.println("\nAFTER MERGE");
    System.out.println("List 1:  " + lst1);
    System.out.println("List 2:  " + lst2);
    System.out.println("\n" + combined);
  }

  /**
   * ASSIGNED
   * @param str
   * @return str in all lower case with LEADING and TRAILING non-alpha
   * chars removed
   */
  // 5) You will add a static method called cleanUp(). that takes a string
  // as an argument. The method should return the string after removing any
  // leading or trailing non-alphabetic characters. The resulting string
  // should be in all lower case. Method signature is provided and may not
  // be changed.
  public static String cleanUp(String str) {
    return str.toLowerCase().replaceAll("^[^a-z]+|[^a-z]+$", "");
  }

  //inner DNode class:  PROVIDED
  private class DNode {

    private DNode next, prev;
    private T data;

    private DNode(T val) {
      this.data = val;
      next = prev = this;
    }
  }

  //DLinkedList fields:  PROVIDED
  private DNode header;

  //create an empty list:  PROVIDED
  public DLinkedList() {
    header = new DNode(null);
  }

  /**
   * PROVIDED add
   *
   * @param item return ref to newly inserted node
   */
  public DNode add(T item) {
    //make a new node
    DNode newNode = new DNode(item);
    //update newNode
    newNode.prev = header;
    newNode.next = header.next;
    //update surrounding nodes
    header.next.prev = newNode;
    header.next = newNode;
    return newNode;
  }

  //PROVIDED
  public String toString() {
    String str = "[";
    DNode curr = header.next;
    while (curr != header) {
      str += curr.data + " ";
      curr = curr.next;
    }
    str = str.substring(0, str.length() - 1);
    return str + "]";
  }

  /**
   * ASSIGNED
   * remove val from the list
   *
   * @param val
   * @return true if successful, false otherwise
   */
  //1) A remove() method that removes a single node containing the value passed in
  // as a parameter from the list. Method signature is provided and may not be
  // changed.
  public boolean remove(T val) {
    DNode current = header.next;
    while (current != header && current.data.compareTo(val) != 0) {
      current = current.next;
    }
    if(current == header){
      return false;
    }
    current.prev.next = current.next;
    current.next.prev = current.prev;
    current.next = current;
    current.prev = current;
    return true;
  }

  /**
   * ASSIGNED
   *
   * @param item
   */
  //2) An insertOrder() method that inserts a value into the list in
  // such a way that the list remains sorted in ascending order. Method
  // signature is provided and may not be changed.
  public void insertOrder(T item) {
    DNode current = header.next;
    while (current != header && current.data.compareTo(item) < 0) {
      current = current.next;
    }
    DNode newNode = new DNode(item);
    newNode.prev = current.prev;
    newNode.next = current;
    current.prev.next = newNode;
    current.prev = newNode;

  }

  /**
   * ASSIGNED
   *
   * @param item
   */
  // 3) An insertOrderUnique() method that does the same as insertOrder()
  // with the additional requirement that the value is only inserted in the
  // list if it is unique. Method signature is provided and may not be changed.
  public boolean insertOrderUnique(T item) {//O(item + n + 1) or O(n) 
    DNode current = header.next;//O(1)
    while (current != header && current.data.compareTo(item) < 0) {//O(n)
      current = current.next;
    }
    if(current != header && current.data.compareTo(item) == 0){//O(1)
      return false;
    }
    DNode newNode = new DNode(item);//O(1)
    newNode.prev = current.prev;//O(1)
    newNode.next = current;//O(1)
    current.prev.next = newNode;//O(1)
    current.prev = newNode;//O(1)
    return true;
  }

  /**
   * ASSIGNED
   * PRE:  this and rhs are sorted lists
   * @param rhs
   * @return list that contains this and rhs merged into a sorted list
   * POST:  returned list will not contain duplicates
   */
  // 4) A merge() method that merges the calling list with the parameter
  // list in such a way that the result is a list that is sorted in
  // ascending order and contains no duplicate values. The resulting
  // list should be returned. The two original lists should be empty
  // when the function exits(not destroyed). Method signature is
  // provided and may not be changed.
  public DLinkedList merge(DLinkedList rhs) {//O(rhs + n + n^2) or O(n^2)
    DLinkedList result = new DLinkedList();//O(1)
    DNode current = this.header.prev;//O(1)
    while (current != this.header){//O(n)
      result.add(current.data);
      current = current.prev;
    }
    current = rhs.header.next;
    while (current != rhs.header){//O(n) + O(n) or O(n^2)
      result.insertOrderUnique(current.data);//O(n)
      current = current.next;//O(1)
    }
    return result;
  }

}