/**
 * 
 */
package edu.ncsu.csc216.course_manager.utils;

import java.util.EmptyStackException;


/**Creates a stack from a linked list
 * @author Andrew Northrup
 * @param <E> for generic type of a linked list stack
 */
public class LinkedStack<E> implements Stack<E> {
	/** Private instance variable for new linked list*/
	private LinkedList<E> stack;
	/** Null constructor for the linked list*/
	public LinkedStack(){
		stack = new LinkedList<E>();
	}
	
	/**Push method adds an object to the top of the stack
	 * @param object of generic type is added to top of stack
	 */
	@Override
	public void push(E obj) {
		stack.add(0, obj);
	}
	/**Removes the top object from the stack
	 * @return generic object that is removed from the top of the stack
	 */
	@Override
	public E pop() {
		if(isEmpty()){throw new EmptyStackException(); }
		return stack.remove(0);
	}
	/**Looks at the top of the stack but doesn't remove it from the stack
	 * @return generic object on the top of the stack 
	 */
	@Override
	public E peek() {
		if(isEmpty()){throw new EmptyStackException(); }
		return stack.get(0);
	}
	/**Checks to see if stack is empty
	 * @return boolean which is true if stack is empty
	 */
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
}
