package edu.ncsu.csc216.course_manager.courses;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.course_manager.courses.Course;
import edu.ncsu.csc216.course_manager.users.Student;

/**
 * Tests for Course.  
 * @author SarahHeckman
 */
public class CourseTest {

	/**
	 * Tests the Course constructor.
	 */
	@Test
	public void testCourse() {
		//Test correct path
		Course c = new Course("CSC216", 3, 10);
		assertEquals("CSC216", c.getName());
		assertEquals(3, c.getCredits());
		assertEquals(10, c.getCapacity());
		
		//Test null name
		c = null;
		try {
			c = new Course(null, 3, 10);
			fail("A course with a null name should throw an IllegalArgumentException.");
		} catch (IllegalArgumentException e) {
			assertNull(c);
		}
		
		//Test empty string name
		c = null;
		try {
			c = new Course("", 3, 10);
			fail("A course with a null name should throw an IllegalArgumentException.");
		} catch (IllegalArgumentException e) {
			assertNull(c);
		}
		
		//Test credit min boundary
		c = null;
		try {
			c = new Course("CSC216", Course.MIN_HOURS - 1, 10);
			fail("A course with a null name should throw an IllegalArgumentException.");
		} catch (IllegalArgumentException e) {
			assertNull(c);
		}
		
		c = new Course("CSC216", Course.MIN_HOURS, 10);
		assertEquals("CSC216", c.getName());
		assertEquals(Course.MIN_HOURS, c.getCredits());
		assertEquals(10, c.getCapacity());
		
		//Test credit max boundary
		c = null;
		try {
			c = new Course("CSC216", Course.MAX_HOURS + 1, 10);
			fail("A course with a null name should throw an IllegalArgumentException.");
		} catch (IllegalArgumentException e) {
			assertNull(c);
		}
		
		c = new Course("CSC216", Course.MAX_HOURS, 10);
		assertEquals("CSC216", c.getName());
		assertEquals(Course.MAX_HOURS, c.getCredits());
		assertEquals(10, c.getCapacity());
		
		//Test negative capacity
		c = null;
		try {
			c = new Course("CSC216", 3, -1);
			fail("A negative capacity should throw an IllegalArgumentException.");
		} catch (IllegalArgumentException e) {
			assertNull(c);
		}	
	}
	
	/**
	 * Tests setName() after a valid course object is created.
	 */
	@Test
	public void testSetName() {
		//Test correct path
		Course c = new Course("CSC216", 3, 10);
		assertEquals("CSC216", c.getName());
		assertEquals(3, c.getCredits());
		assertEquals(10, c.getCapacity());
		
		//Set name to null
		try {
			c.setName(null);
			fail();
		} catch (IllegalArgumentException e) {
			//No changes
			assertEquals("CSC216", c.getName());
			assertEquals(3, c.getCredits());
			assertEquals(10, c.getCapacity());
		}
		
		//Set name to empty string
		try {
			c.setName("");
			fail();
		} catch (IllegalArgumentException e) {
			//No changes
			assertEquals("CSC216", c.getName());
			assertEquals(3, c.getCredits());
			assertEquals(10, c.getCapacity());
		}
		
		//Change name
		c.setName("CSC116");
		assertEquals("CSC116", c.getName());
		assertEquals(3, c.getCredits());
		assertEquals(10, c.getCapacity());
	}
	
	/**
	 * Tests setCredits() after a valid course object is created.
	 */
	@Test
	public void testSetCredits() {
		//Test correct path
		Course c = new Course("CSC216", 3, 10);
		assertEquals("CSC216", c.getName());
		assertEquals(3, c.getCredits());
		assertEquals(10, c.getCapacity());
		
		//Set credits to MIN_HOURS - 1
		try {
			c.setCredits(Course.MIN_HOURS - 1);
			fail();
		} catch (IllegalArgumentException e) {
			//No changes
			assertEquals("CSC216", c.getName());
			assertEquals(3, c.getCredits());
			assertEquals(10, c.getCapacity());
		}
		
		//Set credits to MAX_HOURS + 1
		try {
			c.setCredits(Course.MAX_HOURS + 1);
			fail();
		} catch (IllegalArgumentException e) {
			//No changes
			assertEquals("CSC216", c.getName());
			assertEquals(3, c.getCredits());
			assertEquals(10, c.getCapacity());
		}
		
		//Change credits to MIN_HOURS
		c.setCredits(Course.MIN_HOURS);
		assertEquals("CSC216", c.getName());
		assertEquals(Course.MIN_HOURS, c.getCredits());
		assertEquals(10, c.getCapacity());
		
		//Change credits to MAX_HOURS
		c.setCredits(Course.MAX_HOURS);
		assertEquals("CSC216", c.getName());
		assertEquals(Course.MAX_HOURS, c.getCredits());
		assertEquals(10, c.getCapacity());
	}
	
	/**
	 * Test setCapacity() after a valid course object is created.
	 */
	@Test
	public void testSetCapacity() {
		//Test correct path
		Course c = new Course("CSC216", 3, 10);
		assertEquals("CSC216", c.getName());
		assertEquals(3, c.getCredits());
		
		//Set capacity to 0
		try {
			c.setCapacity(0);
			fail();
		} catch (IllegalArgumentException e) {
			//No changes
			assertEquals("CSC216", c.getName());
			assertEquals(3, c.getCredits());
			assertEquals(10, c.getCapacity());
		}
	}
	
	
	/**
	 * Tests enroll().
	 */
	@Test
	public void testEnroll() {
		//Add a student to a course
		Course c = new Course("CSC216", 3, 1);
		Student s1 = new Student("first1", "last1", "flast1", "1first_last@ncsu.edu", "1pw");
		assertTrue(c.enroll(s1));
		
		//Set capacity to 1 so that the attempt to enroll a second student should fail
		c.setCapacity(1);
		Student s2 = new Student("first", "last", "flast", "first_last@ncsu.edu", "pw");
		assertTrue(c.enroll(s2)); //because will be added to waitlist
		
		//Attempt to enroll a student in the same course
		c.setCapacity(2);
		assertFalse(c.enroll(s1));
		
		//canEnroll() is tested through enroll()
	}
	/**
	 * Tests waitlist.
	 */
	@Test
	public void testWaitlist(){
		Course c = new Course("CSC216", 3, 1);
		assertEquals(c.getWaitlistSize(), 0);
		Student s1 = new Student("first1", "last1", "flast1", "1first_last@ncsu.edu", "1pw");
		assertTrue(c.enroll(s1));
		assertEquals(c.getWaitlistSize(), 0);
		Student s2 = new Student("first2", "last2", "flast2", "2first_last@ncsu.edu", "2pw");
		assertTrue(c.enroll(s2));
		assertEquals(c.getWaitlistSize(), 1);
		c.enroll(s2);
		assertEquals(c.getWaitlistSize(), 1); //shouldn't be added to waitlist
		Student s3 = new Student("first3", "last3", "flast3", "3first_last@ncsu.edu", "3pw");
		assertTrue(c.enroll(s3));
		assertEquals(c.getWaitlistSize(), 2);
		Student s4 = new Student("first4", "last4", "flast4", "4first_last@ncsu.edu", "4pw");
		assertTrue(c.enroll(s4));
		assertEquals(c.getWaitlistSize(), 3);
		Student s5 = new Student("first5", "last5", "flast5", "5first_last@ncsu.edu", "5pw");
		assertTrue(c.enroll(s5));
		assertEquals(c.getWaitlistSize(), 4);
		Student s6 = new Student("first6", "last6", "flast6", "6first_last@ncsu.edu", "6pw");
		assertTrue(c.enroll(s6));
		assertEquals(c.getWaitlistSize(), 5);
		Student s7 = new Student("first7", "last7", "flast7", "7first_last@ncsu.edu", "7pw");
		assertFalse(c.enroll(s7));
		assertEquals(c.getWaitlistSize(), 5);
		
		//start dropping
		assertTrue(c.drop(s1));
		assertEquals(c.getWaitlistSize(), 4);
		assertEquals(c.getEnrolledStudents()[0], s2);
		assertFalse(c.drop(s4));
		assertEquals(c.getWaitlistSize(), 4);
	}
	
	/**
	 * Tests drop().
	 */
	@Test
	public void testDrop() {
		//Attempt to drop a student not enrolled in the course
		Course c = new Course("CSC216", 3, 1);
		Student s1 = new Student("first", "last", "flast", "first_last@ncsu.edu", "pw");
		assertFalse(c.drop(s1));
		
		assertTrue(c.enroll(s1));
		assertEquals(1, c.getEnrolledStudents().length);
		assertTrue(c.drop(s1));
		assertEquals(0, c.getEnrolledStudents().length);
	}
	
	/**
	 * Test hashCode and equals.
	 */
	@Test
	public void testEquals() {
		Course c1 = new Course("CSC216", 4, 10);
		Course c2 = new Course("CSC216", 4, 10);
		Course c3 = new Course("CSC216", 3, 10);
		Course c4 = new Course("CSC116", 4, 10);
		
		assertTrue(c1.equals(c2));
		assertTrue(c1.equals(c3));
		assertFalse(c1.equals(c4));
		assertTrue(c1.equals(c1));
		
		assertEquals(c1.hashCode(), c2.hashCode());
		assertEquals(c1.hashCode(), c3.hashCode());
		assertNotEquals(c1.hashCode(), c4.hashCode());
	}

}
