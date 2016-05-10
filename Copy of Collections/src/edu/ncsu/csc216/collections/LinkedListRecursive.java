/**
 * 
 */
package edu.ncsu.csc216.collections;


/**Creates a linked list and uses recursive methods to carry out functions associated with linked list
 * @author Andrew Northrup
 * @param <E> for generic object that can be passed in
 */
public class LinkedListRecursive<E> {
	/** Private instance variable for the front of the linked list*/
	private ListNode list;
	/** Private instance variable for the size of the linked list*/
	private int listSize;
	/**Constructor initializes an empty list
	 */
	public LinkedListRecursive(){
		list = null;
		listSize = 0;
	}
	
	
	/**Inner class for the list node that will be held in a linked list
	 * @author Andrew Northrup
	 */
	private class ListNode {
		/**Instance variable for data in node*/
		public E data;
		/**Instance variable for next node in list linked list is attached to*/
		public ListNode next;
		/**Constructor for creating node with not linked to another
		* @param data information contained in the node
		*/
		public ListNode(E data) {
		  this(data, null);
		}
		/**Constructor for creating a linked node
		* @param data the data contained in the node
		* @param next the next node in the linked list
		*/
		public ListNode(E data, ListNode next) {
		  this.data = data;
		  this.next = next;
		}
		  
		/**Adds a list node to the linked list if the linked list is empty
		* @param ele data element to be added to node in linked list
		*/
		private void add(E ele) {
			//The private method is ListNode.add(E element).
			if(next == null){next = new ListNode(ele, null); listSize++; }
			else{next.add(ele); }
		}
		/**Recursive method to add element at specified index
		 * @param idx index to add element
		 * @param ele element to add to list
		 */
		private void add(int idx, E ele) {
			if(idx == 1){next = new ListNode(ele, next); listSize++; }
			else{idx--; next.add(idx, ele); }			
		}
		/**Recursive method to get an element at a certain index
		 * @param idx for the index of the element to return
		 * @return the element at the index passed in
		 */
	
		private E get(int idx) {
			if(idx == 0){
				return data;
			} else{
				return next.get(idx - 1); //I think this strategy is more consistent with notes
			}
		}
		
		/**Recursive method to delete element at passed in position
		 * @param idx position to remove element from
		 * @return data of element removed
		 */
		private E remove(int idx){
			if(idx == 1){
				E temp = next.data;
				next = next.next;
				return temp;
			} else {
				return next.remove(idx - 1);
			}	
		}
		/**Recursive method to set a new node to a value.
		 * @param idx index of position to set to
		 * @return element being replaced
		 */
		public E set(int idx, E ele) {
			if(idx == 0){
				E temp = data;
				data = ele;
				return temp;
			} else{
				return next.set(idx - 1, ele); 
			}
		}
	}
	/**Determines if the list is empty
	 * @return boolean for if the list is empty
	 */
	public boolean isEmpty() {
		return listSize == 0;
	}

	/**Gets size of linked list
	 * @return int for size of the linked list
	 */
	public int size() {
		return listSize;
	}

	/**Gets the element at index specified
	 * @param idx index to get element from
	 * @return element at index passed in
	 */
	public E get(int idx) {
		if(idx < 0 || idx >= listSize) {throw new IndexOutOfBoundsException(); }
		if(idx == 0){ return list.data; }
		else{ return list.get(idx); }
	}

	
	/**Adds an element to end of a recursive linked list
	 * @param ele of element to add to the linked list
	 * @return true if the element was added to the linked list
	 */
	public boolean add(E ele) {
		if (list == null) {list = new ListNode(ele); listSize++; } //hands creating new node in empty list
		else{list.add(ele); }
		return true;
	}
	/**Adds a data element to the recursive linked list at index passed in
	 * @param idx index of the node to insert the data element
	 * @param ele data element to put into the linked list
	 * @return boolean for if the element was added
	 */
	public boolean add(int idx, E ele) {
		if(ele == null){throw new NullPointerException(); }
		if (idx == 0) {list = new ListNode(ele, list); listSize++; return true; }
		if(idx < 0 || idx > listSize){throw new IndexOutOfBoundsException(); }
		else{ list.add(idx, ele); }
		return true;
	}
	/**Removes node at specified index
	 * @param idx index of wehre to remove node from
	 * @return data element of the removed node
	 */
	public E remove(int idx) {
		if(idx < 0 || idx >= listSize){throw new IndexOutOfBoundsException(); }
		if(idx == 0){
			E temp = list.data;
			list = list.next; //deletes first node
			listSize--;
			return temp;
		} else{listSize--; return list.remove(idx); }		
	}


	/**Sets a node at a specific index to certain value
	 * @param idx index to set node 
	 * @param ele element to se node at index
	 * @return element that was replaced by new element
	 */
	public E set(int idx, E ele) {
		if(ele == null){throw new NullPointerException(); }
		if(idx < 0 || idx >= listSize) {throw new IndexOutOfBoundsException(); }
		if(idx == 0){
			E temp = list.data;
			list.data = ele;
			return temp;
		}
		else{ return list.set(idx, ele); }
		
	}

}
