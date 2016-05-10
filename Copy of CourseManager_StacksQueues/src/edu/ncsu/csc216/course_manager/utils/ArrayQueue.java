/**
 * 
 */
package edu.ncsu.csc216.course_manager.utils;

import java.util.NoSuchElementException;

/**This class is to create a generic type for a queue that is created
 * using an arraylist.
 * @author Andrew Northrup
 * @param <E> is a generic type
 */
public class ArrayQueue<E> implements Queue<E> {
	private ArrayBasedList<E> queue;
	/**
	 * Constructor of list of queue from an array list
	 */

	public ArrayQueue(){
		queue = new ArrayBasedList<E>();
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
		queue.add(obj);		
	}
	/**Removes the element from the front of the queue
	 * @return generic object that is removed from the front of the queue
	 */
	@Override
	public E dequeue() {
		if(isEmpty()){throw new NoSuchElementException(); }
		return queue.remove(0);
	}

}
