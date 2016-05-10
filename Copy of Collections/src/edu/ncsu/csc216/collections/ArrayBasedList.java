/**
 * 
 */
package edu.ncsu.csc216.collections;

import java.util.AbstractList;

/**This class is to create a generic type for a list that is created
 * using an array.
 * @author Andrew Northrup
 * @param <E> is a generic type
 */
public class ArrayBasedList<E> extends AbstractList<E> {
	/**Instance variable to keep track of list size*/
	private int sizeOfList;
	/**Instance variable for the initial capacity of list*/
	private int initialCapacity = 10;
	/**Instance variable for the initial capacity of list*/
	private int currentCapacity;
	/**Instance variable for the list of generic type arrays*/
	private E[] list;
	
	/**
	 * Constructor of list of Strings
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList(){
		sizeOfList = 0;
		list = (E[]) new Object[initialCapacity];
		currentCapacity = initialCapacity;
	}
	/**Gets the object at the index of the list
	 * @param int index the index of the object to get
	 * @return object at the index passed in the list
	 */
	@Override
	public E get(int index) {
		if(index < 0 || index > sizeOfList - 1){
			throw new IndexOutOfBoundsException();
		}
		return list[index];
	}

	/**Sets a specific index equal to the object passed in
	 *@return object that was removed from the list 
	 *@param index of object to be replace another object in the list
	 *@param object to be placed in the list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object set(int index, Object element) {
		if (((E) element) == (null)){
			throw new NullPointerException();
		}		
		if(index  > sizeOfList - 1 || this.size() == 0){
			throw new IndexOutOfBoundsException();
		}
		Object removed = list[index];
		list[index] = (E) element;
		return removed;
		//return super.set(index, element);
	}

	/** Adds a new object at the index passed in
	 * @param index of object to be added to the list
	 * @param object to be added to the list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void add(int index, Object element) {
		// Need to copy old list to new list to double size
		if (((E) element) == (null)){
			throw new NullPointerException();
		}
		if(index < 0 || index > sizeOfList){
			throw new IndexOutOfBoundsException();
		}
		// Double list size if list is at capacity
		if(sizeOfList == currentCapacity){
			E[] newlist = (E[]) new Object[currentCapacity * 2];
			for (int i = 0; i < currentCapacity; i++){
				newlist[i] = list[i];
			}
			this.list = newlist;
			this.currentCapacity = currentCapacity * 2;
		}
		//to the left of end of list (i.e. middle or front)
		if(index < sizeOfList){
			for(int i = sizeOfList; i > index; i--){
				list[i] = list[i - 1];
			}	
		list[index] = (E) element;
		sizeOfList++;
		}
		if(index == sizeOfList){
			list[sizeOfList] = (E) element;
			sizeOfList++;
		}
	}

	/** Method removes an object in the list at a specified
	 * index.
	 * @param index of object to be removed from list
	 * @return object that was removed from the list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		if(index > sizeOfList - 1 || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(index < sizeOfList){
			Object removed = list [index];
			for(int i = index; i < sizeOfList; i++){
				list[i] = list[i + 1];
			}
			sizeOfList--;
			return (E) removed;
		}
		return null;
	}

	/** This method returns the size of the ArrayBasedList
	 * @return integer for the size of the list
	 */
	@Override
	public int size() {
		return sizeOfList;
	}

}
