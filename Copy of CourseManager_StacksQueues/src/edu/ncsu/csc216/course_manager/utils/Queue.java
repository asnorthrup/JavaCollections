/**
 * 
 */
package edu.ncsu.csc216.course_manager.utils;

/**This is a generic interface for a queue
 * @author Andrew Northrup
 *
 */
/**This is a generic interface for a queue
 * @author Andrew Northrup
 * @param <E> for genereic type the queue is
 */
public interface Queue<E> {
	
	/**Adds an element to the end of the queue
	 * @param obj of generic type is added to the end of the queue
	 */
	void enqueue(E obj);
	/**Removes the element from the front of the queue
	 * @return generic object that is removed from the front of the queue
	 */
	E dequeue();
	/**Checks to see if queue is empty
	 * @return boolean which is true if queue is empty
	 */
	boolean isEmpty();
}
