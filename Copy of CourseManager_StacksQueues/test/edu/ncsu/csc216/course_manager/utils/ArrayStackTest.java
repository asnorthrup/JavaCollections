/**
 * 
 */
package edu.ncsu.csc216.course_manager.utils;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

/**Extends tests written by Sarah Heckman for determining
 * ArrayBasedList testing procedures.
 * @author Andrew Northrup
 *
 */
public class ArrayStackTest {
	
	private ArrayStack<Object> list;

	/**Sets up each test by creating the arraybasedlist of objects
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new ArrayStack<Object>();
	}
	
	/**Tests working with an array stack
	 * 
	 */
	//write test cases for Array Stack
	@Test
	public void testArrayStack() {
		//test can add to stack
		String testAdd = new String("test added 1st element to stack");
		try{
			list.peek();
			fail();
		} catch(EmptyStackException e) {
			assertTrue(list.isEmpty());
		}
		try{
			list.pop();
			fail();
		} catch(EmptyStackException e) {
			assertTrue(list.isEmpty());
		}
		assertTrue(list.isEmpty());
		list.push(testAdd);
		assertFalse(list.isEmpty());
		//test add multiple elements to stack
		testAdd = "test added 2nd element to stack";
		list.push(testAdd);
		testAdd = "test added 3rd element to stack";
		list.push(testAdd);
		//test remove single element from stack
		assertEquals(list.peek(), "test added 3rd element to stack");
		assertEquals(list.pop(), "test added 3rd element to stack");
		//test remove multiple elements from stack
		assertEquals(list.peek(), "test added 2nd element to stack");
		assertEquals(list.pop(), "test added 2nd element to stack");
		assertEquals(list.peek(), "test added 1st element to stack");
		assertEquals(list.pop(), "test added 1st element to stack");
		//test remove last element from the stack
		
		//test interleaved inserts and removes
		
		//test remove an element from an empty stack
		list = new ArrayStack<Object>();
		assertTrue(list.isEmpty());
		try{
			list.pop();
			fail();
		} catch(EmptyStackException e){
			assertTrue(list.isEmpty());
		}
	}

}
