/**
 * 
 */
package edu.ncsu.csc216.course_manager.utils;

import java.util.NoSuchElementException;


/**Creates a queue from a linked list
 * @author Andrew Northrup
 * @param <E> for generic type of a linked list queue
 */
public class LinkedQueue<E> implements Queue<E> {
	/** Private instance variable for new linked list*/
	private LinkedList<E> queue;
	/** Null constructor for the linked list*/
	public LinkedQueue(){
		queue = new LinkedList<E>();
	}

	/**Checks to see if queue is empty
	 * @return boolean which is true if queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	/**Adds an element to the end of the queue
	 * @param object of generic type is added to the end of the queue
	 */
	@Override
	public void enqueue(E obj) {
		//queue.add(queue.size(), obj);
		queue.addAtEnd(obj);
	}
	/**Removes the element from the front of the queue
	 * @return generic object that is removed from the front of the queue
	 */
	@Override
	public E dequeue() {
		if(isEmpty()){throw new NoSuchElementException(); }
		return queue.remove(0);
	}
	/**Removes the element from the front of the queue
	 * @return size of queue
	 */
	public int size() {
		return queue.size();
	}
}
