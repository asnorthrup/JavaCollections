/**
 * 
 */
package edu.ncsu.csc216.course_manager.utils;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
/**Tests from Instructor
 * @author SarahHeckman
 *
 */
public class LinkedQueueTest {
	
	private LinkedQueue<String> list;

	/**Sets up tests
	 *@throws java.lang.Exception if cannot create the array list
	 */
	@Before
	public void setUp() throws Exception {
		list = new LinkedQueue<String>();
	}
	//write test cases for Array queue
		/**Tests working with a linked queue
		 * 
		 */
		@Test
		public void testLinkedQueue() {
			//test can add to queue
			String testAdd = new String("test added 1st element to queue");
			assertTrue(list.isEmpty());
			list.enqueue(testAdd);
			assertFalse(list.isEmpty());
			//test add multiple elements to queue
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
			list = new LinkedQueue<String>();
			assertTrue(list.isEmpty());
			try{
				list.dequeue();
				fail();
			} catch(NoSuchElementException e){
				assertTrue(list.isEmpty());
			}
		}
		/** Tests the methods associated with adding elements to queue
		 * 
		 */
		@Test
		public void testEnqueue(){
			//test can add to queue
			String testAdd = new String("test added 1st element to queue");
			assertTrue(list.isEmpty());
			list.enqueue(testAdd);
			assertFalse(list.isEmpty());
			//test add multiple elements to queue
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
			list = new LinkedQueue<String>();
			assertTrue(list.isEmpty());
			try{
				list.dequeue();
				fail();
			} catch(NoSuchElementException e){
				assertTrue(list.isEmpty());
			}
		}
		
		/**Tests removing an element from the queue
		 * 
		 */
		@Test
		public void testDequeue(){
			//test can add to queue
			String testAdd = new String("test added 1st element to queue");
			assertTrue(list.isEmpty());
			list.enqueue(testAdd);
			assertFalse(list.isEmpty());
			//test add multiple elements to queue
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
			list = new LinkedQueue<String>();
			assertTrue(list.isEmpty());
			try{
				list.dequeue();
				fail();
			} catch(NoSuchElementException e){
				assertTrue(list.isEmpty());
			}
			
		}
		
		/**Test to determine if linked queue is empty
		 * 
		 */
		@Test
		public void testIsEmpty(){
			//test can add to queue
			String testAdd = new String("test added 1st element to queue");
			assertTrue(list.isEmpty());
			list.enqueue(testAdd);
			assertFalse(list.isEmpty());
		}
	
	
}
