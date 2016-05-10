/**
 * 
 */
package edu.ncsu.csc216.course_manager.utils;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;
/**Tests from Instructor
 * @author SarahHeckman
 *
 */
public class LinkedStackTest {
	
	private LinkedStack<String> list;

	/**Sets up tests
	 *@throws java.lang.Exception if cannot create the array list
	 */
	@Before
	public void setUp() throws Exception {
		list = new LinkedStack<String>();
	}
	//write test cases for Array Stack
		/**Tests working with a linked stack
		 * 
		 */
		@Test
		public void testLinkedStack() {
			//test can add to stack
			try{
				list.peek();
				fail();
			} catch(EmptyStackException e){
				assertTrue(list.isEmpty());
			}
			try{
				list.pop();
				fail();
			} catch(EmptyStackException e){
				assertTrue(list.isEmpty());
			}
			String testAdd = new String("test added 1st element to stack");
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
			list = new LinkedStack<String>();
			assertTrue(list.isEmpty());
			try{
				list.pop();
				fail();
			} catch(EmptyStackException e){
				assertTrue(list.isEmpty());
			}
		}
	
	}
