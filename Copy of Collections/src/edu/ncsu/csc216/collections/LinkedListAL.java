/**
 * 
 */
package edu.ncsu.csc216.collections;

import java.util.AbstractList;


/**Creates a linked list from scratch
 * @author Andrew Northrup
 * @param <E> for generic type of a linked list
 */
public class LinkedListAL<E> extends AbstractList<E> {
	/** Private instance variable for the head of the linked list*/
	private Node<E> head;
	/** Private instance variable for the size of the linked list*/
	private int listSize;
	/** Null constructor for the linked list*/
	public LinkedListAL(){
		head = null;
		listSize = 0;
	}
	/**Gets the object of type specified at position passed in
	 *@param int for index number to get the object
	 *@return object E at specified index
	 */
	@Override
	public E get(int index) {
		if( index < 0 || index > size() - 1){throw new IndexOutOfBoundsException(); }
		if (head == null){throw new NullPointerException(); }
		if (index == 0){
			return head.data;
		}
		else {
			Node<E> traveler = head;
			while (traveler != null && index > 0) {
				traveler = traveler.next;
			    index--;
			}
			if (traveler != null) {
				return traveler.data;
			}	
			else{throw new IndexOutOfBoundsException(); }
		}
		//return null;
	}

	/**This gets the size of the linked list
	 * @return int for the size of the linked list
	 * 
	 */
	@Override
	public int size() {
		return listSize;
	}

	/**Sets the element at an index to a certain value
	 * @param index for the position to set a new value to
	 * @param element to put at the index in the linked list
	 * @return element removed from the linked list
	 * @throws Index out of bounds exception if the position passed in is larger than size - 1 or element is null
	 * @throws null pointer exception if element is null that is passed in
	 */
	@Override
	public E set(int index, E element) {
		if( index < 0 || index > size() - 1){throw new IndexOutOfBoundsException(); }
		if( element == null){throw new NullPointerException(); }
		if (index == 0){
			E tempdata = head.data;
			head.data = element;
			return tempdata;
		}
		if (head == null && index > 0){throw new NullPointerException(); } //new
		//else/* if (head != null && index > 0)*/ {
			Node<E> traveler = head;
			while (traveler != null && index > 0) {
				traveler = traveler.next;
			    index--;
			}
			if(traveler != null){
				E tempdata = traveler.data;
				traveler.data = element;
				return tempdata;
			}
/*			if (traveler != null) {
				E tempdata = traveler.next.data;
				traveler.next.data = element;
				return tempdata;
			} else{throw new NullPointerException(); } //new
*/		//}
		return null; 
	}
	/**Adds an element to the linked list at the specified index
	 * @param index to add the element
	 * @param element of what is added to linked list
	 * @throws null pointer exception if element passed in is null
	 */

	@Override
	public void add(int index, E element) {
		// can't add if the list is empty or index is larger than list size
		if(element == null) {throw new NullPointerException(); }
		if(index > size() || index < 0){throw new IndexOutOfBoundsException(); }
		if(index == 0 || head == null){
			head = new Node<E>(element, head);
			listSize++;
		}
		else if (head != null && index > 0){
			Node<E> traveler = head;
			while (traveler != null && index > 1) {
		         traveler = traveler.next;
		         index--;
		     }
			if (traveler != null) {
		         traveler.next = new Node<E>(element, traveler.next);
		         listSize++;
		    }
		}		
	}

	/**Removes the element at the specified index
	 *@param for index of element to remove
	 *@return the element that was removed from the linked list
	 *
	 */
	@Override
	public E remove(int index) {
		if(index < 0){throw new IndexOutOfBoundsException(); }
		Node<E> current = head;  
		Node<E> previous = null; 
		while (current != null && index > 0) {
			previous = current;
		    current = current.next;
		    index--;
		}
		if (current != null) { // current should point to the item to be removed
			if (current == head){ // remove item 0
				head = head.next;
				listSize--;
		    }
		    else { // not removing item 0
		    	previous.next = current.next;
		    	listSize--;
		    }
		    return current.data;   
		}
		throw new IndexOutOfBoundsException();  // psn was out of range
	}

	/**Private inner class for the Nodes of the linkedlist
	 * @author Andrew Northrup
	 * @param <E> for generic type of node
	 */
	private class Node<E> {
		/**Instance variable for the data in the linked list*/
		public E data;
		/**Instance variable for the link in the linked list*/
		public Node<E> next;
		/** Constructor for the node class that is only passed in data with no link*/
		public Node(E data){
			this.data = data;
		}
		/** Constructor for the node class that is passed in data and a link*/
		public Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
	}
	
}
