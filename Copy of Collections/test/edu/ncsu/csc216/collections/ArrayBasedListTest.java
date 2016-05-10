/**
 * 
 */
package edu.ncsu.csc216.collections;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**Extends tests written by Sarah Heckman for determining
 * ArrayBasedList testing procedures.
 * @author Andrew Northrup
 *
 */
public class ArrayBasedListTest {
	
	private ArrayBasedList<Object> list;

	/**Sets up each test by creating the arraybasedlist of objects
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new ArrayBasedList<Object>();
	}

	/**
	 * Tests that a ArrayBasedList is constructed correctly.  ArrayBasedList of
	 * any generic type should be not null and empty, which implies a size of 0.
	 * Test method for {@link edu.ncsu.csc216.collections.CSC216ArrayList#CSC216ArrayList()}.
	 */
	@Test
	public void testArrayBasedList() {
		//Test that the list field is created correctly.
		assertTrue(list.isEmpty()); //created correctly because it can use an arrayList method
	}

	/**
	 * Tests adding elements to an empty CSC216ArrayList.  Then tests adding elements to the 
	 * front, middle, and back of a CSC216ArrayList.  The size and contents should be checked
	 * after each insertion.  Additionally, the bounds of the list should be checked and null
	 * elements should not be added to the list.  Finally, test that the ArrayList with an
	 * initial capacity of 10 grows when an 11th element is added.
	 * Test method for {@link edu.ncsu.csc216.collections.CSC216ArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntE() {
		//Attempt to add an element to index 1 in an empty list.
		//Check that the element was not added.
		try {
			list.add(1, "apple");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}
		
		//Add element to empty list
		list.add(0, "apple");
		assertEquals(1, list.size());
		assertEquals("apple", list.get(0));
		
		//Add element to the front of a list
		list.add(0, "orange");
		assertEquals(2, list.size());
		assertEquals("orange", list.get(0));
		
		//Add element to the middle of a list
		list.add(1, "pickle");
		assertEquals(3, list.size());
		assertEquals("pickle", list.get(1));
		
		//Add element to the back of a list
		list.add(list.size(), "snickers") ;
		assertEquals(4, list.size()) ;
		assertEquals("snickers", list.get(list.size() - 1));
		//Attempt to add a null element.  Check that the element
		//was not added.
		String s = new String();
		s = null;
		try {
			list.add(1, s);
			fail();
		} catch (NullPointerException e) {
			assertEquals(4, list.size());
		}
		
		//Attempt to add at index -1.  Check that the element was not
		//added.
		try {
			list.add(-1, "orange");
			fail();
		} catch (Exception e) {
			assertEquals(4, list.size());
		}
		
		//Attempt to add at index 5 (since there are 4 elements in the list).
		//Check that the element was not added.
		try {
			list.add(list.size() + 1, "orange");
			fail();
		} catch (Exception e) {
			assertEquals(4, list.size());
		}
		
		//Test adding an 11th element to an ArrayList with an initial 
		//capacity of 10.
		ArrayBasedList<String> caplist = new ArrayBasedList<String>();
		for(int i = 0; i < 10; i++){
			caplist.add("fruit" + i);
		}
		assertEquals(10, caplist.size());
		assertEquals("fruit5", caplist.get(5));
		caplist.add("fruit10");
		assertEquals(11, caplist.size());
	}

	/**
	 * Tests that elements are correctly removed from the front, middle, and back of an 
	 * ArrayList.  Removing the last element should leave an empty list.  The bounds are
	 * checked for the appropriate exceptions.
	 * Test method for {@link edu.ncsu.csc216.collections.CSC216ArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		//Attempt to remove an element from an empty list
		try {
			list.remove(0);
			fail();
		} catch (Exception e) {
			assertEquals(0, list.size());
		}
		
		//Add 4 elements to the list and test that the contents are correct.
		//Reuse code from your testAddIntE.
		list.add(0, "orange");
		list.add(1, "banana");
		list.add(2, "apple");
		list.add(3, "kiwi");
		assertEquals(4, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("banana", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));
		
		//Test that IndexOutOfBoundsException is thrown when remove() is passed
		//a negative index.  Make sure the list is unchanged.
		try {
			list.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}
		
		//Test that IndexOutOfBoundsException is thrown when remove() is passed
		//an index > size() - 1.  Make sure the list is unchanged.
		try {
			list.remove(list.size());
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}
		
		//Remove middle element.  Test that the removed element is correct and
		//that the remaining list is correct after the removal.
		String s1 = (String) list.remove(1);
		assertEquals(s1, "banana");
		assertEquals(3, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("apple", list.get(1));
		assertEquals("kiwi", list.get(2));
		
		//Remove first element
		list.remove(0);
		assertEquals(2, list.size());
		
		//Remove last element
		list.remove(list.size() - 1);
		assertEquals(1, list.size());
		
		//Remove only element
		list.remove(0);
		assertEquals(0, list.size());		
	}

	/**
	 * Tests setting an element in an empty list, the bounds of the list when
	 * using the set() method, and setting an element at the front, middle, and back
	 * of the list.  The set() method is also passed null.
	 * Test method for {@link edu.ncsu.csc216.collections.CSC216ArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetIntE() {
		//Attempt to set a value in an empty list
		try {
			list.set(0, "string");
			fail();
		} catch (Exception e) {
			assertEquals(0, list.size());
		}
		
		//Add 4 elements to the list and test that the contents are correct.
		//Reuse code from your testAddIntE.
		list.add(0, "orange");
		list.add(1, "banana");
		list.add(2, "apple");
		list.add(3, "kiwi");
		assertEquals(4, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("banana", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));
		
		//Test that IndexOutOfBoundsException is thrown when set() is passed
		//a negative index.  Make sure the list is unchanged.
		try {
			list.set(-1, "ham");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}
		
		//Test that IndexOutOfBoundsException is thrown when set() is passed
		//an index > size() - 1.  Make sure the list is unchanged.
		try {
			list.set(list.size(), "ham");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}
		
		//Set middle element.  Test that the element is modified correctly, set() returns the
		//right value, and that the rest of the list is correct.
		String s1 = (String) list.set(1, "strawberry");
		assertEquals(s1, "banana");
		assertEquals(4, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("strawberry", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));
		
		//Set first element
		list.set(0, "snozzberry");
		assertEquals("snozzberry", list.get(0));
		//Set last element
		list.set(list.size() - 1, "huckleberry") ;
		assertEquals("huckleberry", list.get(list.size() - 1));
		
		//Attempt to set an element to null.  Check that the element
		//was not modified.
		String n = new String();
		n = null;
		try {
			list.set(list.size() - 1, n);
			fail();
		} catch (Exception e) {
			assertEquals("huckleberry", list.get(list.size() - 1));
		}

	}

	/**
	 * Main get() functionality is tested in the other test methods.  This method will
	 * focus on testing the exceptions associated with bounds.
	 * Test method for {@link edu.ncsu.csc216.collections.CSC216ArrayList#get(int)}.
	 */
	@Test
	public void testGetInt() {
		//Add 4 elements to the list and test that the contents are correct.
		//Reuse code from your testAddIntE.
		list.add(0, "orange");
		list.add(1, "banana");
		list.add(2, "apple");
		list.add(3, "kiwi");
		assertEquals("orange", list.get(0));
		assertEquals("banana", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));
		assertEquals(4, list.size());
		//Test that IndexOutOfBoundsException is thrown when get() is passed
		//a negative index.  Make sure the list is unchanged.
		try {
			list.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}
		
		//Test that IndexOutOfBoundsException is thrown when get() is passed
		//an index > size() - 1.  Make sure the list is unchanged.
		try {
			list.get(list.size());
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}
	}
	/**
	 * Main functionality of ArrayBasedList is tested in this test method.  This method will
	 * focus on testing the the previously tested methods, but instead with number
	 * objects instead of strings, as previously done.
	 */
	@Test
	public void testIntegerMethods() {
		//Add 5 elements to the list and test that the contents are correct.
		list.add(0, (Integer)10);
		list.add(1, (Integer)11);
		list.add(2, (Integer)12);
		list.add(3, (Integer)13);
		list.add(4, (Integer)14);
		assertEquals((Integer)10, list.get(0));
		assertEquals((Integer)11, list.get(1));
		assertEquals((Integer)12, list.get(2));
		assertEquals((Integer)13, list.get(3));
		assertEquals((Integer)14, list.get(4));
		assertEquals(5, list.size());
		//Test that IndexOutOfBoundsException is thrown when get() is passed
		//a negative index.  Make sure the list is unchanged.
		try {
			list.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(5, list.size());
		}
		
		//Test that IndexOutOfBoundsException is thrown when get() is passed
		//an index > size() - 1.  Make sure the list is unchanged.
		try {
			list.get(list.size());
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(5, list.size());
		}
		//Remove the number at index 2
		assertEquals(list.get(2), list.remove(2)); //3
		assertEquals(list.get(2), 13);
		list.add(list.size(), 15);
		list.add(list.size(), 16); //4
		//remove at index 0
		list.remove(0); //5
		assertEquals(list.size(), 5);
		assertEquals(list.get(0), 11);
		//add 10 back to index 0
		list.add(0, 10); //6
		assertEquals(list.size(), 6);
		assertEquals(list.get(1), 11);
		list.remove(list.size() - 1);
		assertEquals(list.get(list.size() - 1), 15); //7
		list.add(0, 9); //8
		assertEquals(list.get(1), 10);
		list.remove(1); //
		assertEquals(list.get(1), 11);
		for (int i = 0; i < list.size(); i++){
			list.remove(i);
			i--;
		}
		assertEquals(list.size(), 0); //10
		try{
		list.set(0, null);
		fail();
		} catch(NullPointerException e){
			System.out.println("Can't pass a null");
		}
		try{
		list.add(0, null);
		fail();
		} catch(NullPointerException e){
			System.out.println("Can't pass a null");
		}
	}
}
