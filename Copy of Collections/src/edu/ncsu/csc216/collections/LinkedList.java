/**
 * 
 */
package edu.ncsu.csc216.collections;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/** 
 * @author Andrew Northrup
 *@param E for generic data type to be held in the linked list
 */

/**Class is for a linked list that extends an abstract sequential list.
 * @author Andrew Northrup
 * @param <E> for generic data type to be held in the linked list
 */
public class LinkedList<E> extends AbstractSequentialList<E> {
	/**Instance variable for the first (front) node of the linked list*/
	private ListNode front;
	/**Instance variable for the last (back) node of the linked list*/
	private ListNode back;
	/**Instance variable for the size of the linked list*/
	private int size;
	
	/**Constructor for the linked list
	 * 
	 */
	public LinkedList(){
		front = new ListNode(null);
		back = new ListNode(null);
		front.next = back;
		back.prev = front;
		size = 0;
	}
	
	
	/** Returns a list iterator over the elements of the list in sequence
	 * @param idx for index of first element to be returned from the list iterator
	 *@return a list iterator in a sequential orders
	 */

	@Override
	public ListIterator<E> listIterator(int idx) {
		LinkedListIterator iter = new LinkedListIterator(idx);
		return iter;
	}

	/** The method returns the size of a linked list
	 * @return an integer that is the size of the linked list
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**Class creates an inner class for a list node, which will be the basis for the
	 * linked list nodes.
	 * 
	 * @author Andrew Northrup
	 *
	 */
	private class ListNode {
		  public E data;
		  public ListNode prev;
		  public ListNode next;
		  /**
		   * Constructor for a list node that is just a data point
		   * @param data for the information held by the node
		   */
		  public ListNode(E data) {
		  this(data, null, null);
		  }
		  /**Constructor for a list node with a previous and next node stored
		   * in addition to the information 
		   * @param data for the information held by the node
		   * @param prev for the preceding list node
		   * @param next for the next list node in the sequence
		   */
		  public ListNode(E data, ListNode prev, ListNode next) {
			  this.data = data;
			  this.prev = prev;
			  this.next = next;
		  }
		}
	
	/**
	 * This class creates the linkedlist iterator
	 * @author Andrew Northrup
	 *
	 */
	private class LinkedListIterator implements ListIterator<E> {
		/**Instance variable for keeping track of last index the iterator was*/
		int previousIndex = 0;
		/**Instance variable for keeping track of the next index of the iterator*/
		int nextIndex = 0;
		/**Last returned node*/
		ListNode previous;
		/**Next node to be returned by iterator*/
		ListNode next;
		/**The last piece of information needed for the remove 
		 * functionality is a reference to the ListNode that was 
		 * most recently retrieved by the LinkedListIterator 
		 * (through a call to next() or previous())*/
		ListNode mostRecent = null;

		
		/**Null constructor for linked list. Calls constructor in this method
		 * that accepts an index.
		 */
		
		@SuppressWarnings("unused")
		public LinkedListIterator(){
			this(0); //calls constructor with an index of 0
		}
		/**Creates a linked list iterator that will return the node at
		 *at the index passed in on the next call of this inner class
		 * @param index for the element to start the iterator on
		 */
		//Therefore I want to move the iterator just before the index node
		public LinkedListIterator(int index){
			if(index < 0 || index > size()){//need to check index range
				throw new IndexOutOfBoundsException();
			} else {
				previous = front; //start at very first node
				next = front.next; //start at first node past front		 
				while(nextIndex < index){
					previous = next;
					next = next.next;
					nextIndex++;
					previousIndex = nextIndex - 1;	
				}
				//nextIndex++; //this is extra, shouldn't be here unless was 
				if(nextIndex == 0){ nextIndex++; }
				//at this point a call to next will get the elements at nextIndex
			}
		}
		
		//The has*() methods return true if there is a next or 
		//previous node in the list. This can be restated as 
		//follows: the next or previous node has non-null data.
		/**This method determines whether the list has a next element
		 * @return boolean for whether or not the list has a next element
		 */
		@Override
		public boolean hasNext() {
			if(next.data != null) { return true; }
			return false;
		}

		@Override
		// return the element in the next ListNode. 
		//If the next ListNode has null data, throw a NoSuchElementException. 
		//Remember, the next() and previous() methods will move the iterator forward 
		//or backward through the list before returning the value.
		/**This method gets the next element in the list
		 * @return E for the next element in the list
		 */
		public E next() {
			if (next == null || !hasNext()) { throw new NoSuchElementException(); }
			mostRecent = next;
			E data = next.data;
			previous = mostRecent.prev;
			next = next.next;
			nextIndex++; 
			previousIndex++; 
			return data; //this is really what is wanted - to get this next element
		}
		/**This method determines whether the list has a previous method
		 * @return boolean for whether or not the list has a previous element
		 */
		@Override
		public boolean hasPrevious() {
			if(previous != null) { return true; }
			return false;
		}
		/**This method gets the previous element in the list
		 * @return E for previous element in the list
		 */
		@Override
		public E previous() {
			if (previous == null || !hasPrevious()) { throw new NoSuchElementException(); }
			mostRecent = next.prev;
			next = next.prev; //move next back one
			previous = next.prev; //move previous back one from next
			previousIndex--;
			nextIndex--;
			return mostRecent.data;
		}
		/** Gets the next index of the iterator
		 * @return int for next index the iterator 
		 */
		@Override
		public int nextIndex() {
			return nextIndex;
		}
		/** Gets the previous index of the iterator
		 * @return int for previous index the iterator will get to
		 */
		@Override
		public int previousIndex() {
			return previousIndex;
		}
		/** Removes what was previous returned by the previous or next methods
		 */
		@Override
		public void remove() {
			if(mostRecent == null) {throw new IllegalArgumentException(); }
			mostRecent.prev.next = mostRecent.next;
			mostRecent.next.prev = mostRecent.prev;
			size--;
			
		}
		/**Modifies the last returned element, what was returned by previous or next
		 * @param e for the data to set the node to
		 */
		@Override
		public void set(E e) {
			// Need to make sure tests catch IllegalArgumentException and not NPE
			if (e == null) { throw new IllegalArgumentException(); }
			//needed becuase this call can be made only iuf remove nor add have been called after the last 
			//call to next or previous
			if(mostRecent != null){
				mostRecent.data = e;
			}
			
		}
		/**Adds an element at the iterator
		 * @param e for data element to add to the linked list
		 */
		@Override
		public void add(E e) {
			// Need to make sure tests catch IllegalArgumentException and not NPE
			if (e == null) { throw new IllegalArgumentException(); }
			ListNode addData = new ListNode(e, previous, next);
			//next = next.next;
			next.prev = addData;
			previous.next = addData;
			previous = addData;
			//The new element is inserted before the implicit cursor: 
			//a subsequent call to next would be unaffected, and a subsequent 
			//call to previous would return the new element. (This call increases 
			//by one the value that would be returned by a call to 
			//nextIndex or previousIndex.)
			//nextIndex++;//not sure if I need this
			size++;
			mostRecent = null;
		}	
	}
}
