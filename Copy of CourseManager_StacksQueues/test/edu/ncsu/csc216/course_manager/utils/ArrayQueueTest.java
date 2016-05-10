/**
 * 
 */
package edu.ncsu.csc216.course_manager.utils;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**Extends tests written by Sarah Heckman for determining
 * ArrayBasedList testing procedures.
 * @author Andrew Northrup
 *
 */
public class ArrayQueueTest {
	
	private ArrayQueue<Object> list;

	/**Sets up each test by creating the arraybasedlist of objects
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new ArrayQueue<Object>();
	}
	
	/**Tests working with an array queue
	 * 
	 */
	//write test cases for Array Queue
	@Test
	public void testArrayQueue() {
		//test can add to stack
		String testAdd = new String("test added 1st element to queue");
		assertTrue(list.isEmpty());
		list.enqueue(testAdd);
		assertFalse(list.isEmpty());
		//test add multiple elements to stack
		testAdd = "test added 2nd element to queue";
		list.enqueue(testAdd);
		testAdd = "test added 3rd element to queue";
		list.enqueue(testAdd);
		//test remove single element from queue
		assertEquals(list.dequeue(), "test added 1st element to queue");
		//test remove multiple elements from queue
		assertEquals(list.dequeue(), "test added 2nd element to queue");
		assertEquals(list.dequeue(), "test added 3rd element to queue");
		//test remove last element from the queue
		
		//test interleaved inserts and removes
		
		//test remove an element from an empty queue
		list = new ArrayQueue<Object>();
		assertTrue(list.isEmpty());
		try{
			list.dequeue();
			fail();
		} catch(NoSuchElementException e){
			assertTrue(list.isEmpty());
		}
	}
	
	
	
}
