/**
 * 
 */
package edu.ncsu.csc216.course_manager.utils;

/**This is a generic interface for a stack
 * @author Andrew Northrup
 * @param <E> for generic stack type 
 */
public interface Stack<E> {
	/**Push method adds an object to the top of the stack
	 * @param obj of generic type is added to top of stack
	 */
	void push(E obj);
	/**Removes the top object from the stack
	 * @return generic object that is removed from the top of the stack
	 */
	E pop();
	/**Looks at the top of the stack but doesn't remove it from the stack
	 * @return generic object on the top of the stack 
	 */
	E peek();
	/**Checks to see if stack is empty
	 * @return boolean which is true if stack is empty
	 */
	boolean isEmpty();
}
