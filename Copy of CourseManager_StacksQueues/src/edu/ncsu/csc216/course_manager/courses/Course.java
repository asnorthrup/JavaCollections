/**
 * 
 */
package edu.ncsu.csc216.course_manager.courses;

import java.util.ArrayList;

import edu.ncsu.csc216.course_manager.users.Student;
import edu.ncsu.csc216.course_manager.users.User;
import edu.ncsu.csc216.course_manager.utils.LinkedQueue;

/**This is a class that creates a course with a waitlist.
 * @author SarahHeckman
 *
 */
public class Course implements Enrollable {
	
	//Add your data structure for the Course wait list here.
	/** Students who would like to enroll in the course */
	private LinkedQueue<User> waitlist;
	//I chose to use the queue because a waitlist is a first in first out type operation. Therefore
	//a queue seemed more appropriate. I used the linked list version because after the optimization it is just as efficient to
	//put something at the back as the front of the new linked list. Therefore, while it was not required for this assignment,
	//if someone were to be moved to the front of the waitlist or the end (which is typical), both operations would be as efficient.
	
	/** Course name */
	private String name;
	/** Course credit hours */
	private int credits;
	/** Course capacity */
	private int capacity;
	/** Students enrolled in the course */
	private ArrayList<User> enrolledStudents;
	/** Minimum credit hours for a course */
	public static final int MIN_HOURS = 1;
	/** Maximum credit hours for a course */
	public static final int MAX_HOURS = 4;
	/** Maximum number of students on waitlist*/
	public static final int MAX_WAITLIST = 5;
	
	/**
	 * Creates a Course with the given name and credit hours.
	 * @param name course name
	 * @param credits course credit hours
	 * @param capacity course capacity
	 */
	public Course(String name, int credits, int capacity) {
		super();
		enrolledStudents = new ArrayList<User>();
		setName(name);
		setCredits(credits);
		setCapacity(capacity);
		waitlist = new LinkedQueue<User>();
	}

	/**
	 * Returns the course name.
	 * @return the course name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the course name to the given name.  An IllegalArgumentException is
	 * thrown if the name is null or an empty string.
	 * @param name the course name
	 */
	public void setName(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	/**
	 * Returns the course's credit hours.
	 * @return the course's credit hours
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * Sets the course credit hours to the given value.  An IllegalArgumentException is
	 * thrown if the value is less than MIN_HOUR and greater than MAX_HOURS.
	 * @param credits the course's credit hours
	 */
	public void setCredits(int credits) {
		if (credits < MIN_HOURS || credits > MAX_HOURS) {
			throw new IllegalArgumentException();
		}
		this.credits = credits;
	}

	/**
	 * Returns the course's capacity.
	 * @return the course's capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Sets the course's capacity to the given value.  An IllegalArgumentException is
	 * thrown if the value is less than 1 or if the new capacity is less than the 
	 * number of students currently enrolled in the course.
	 * @param capacity course's capacity
	 */
	public void setCapacity(int capacity) {
		if (capacity < 1  || capacity < enrolledStudents.size()) {
			throw new IllegalArgumentException();
		} 
		this.capacity = capacity;
	}

	/**
	 * Returns the enrolled students as an array.
	 * @return enrolled students
	 */
	public Student [] getEnrolledStudents() {
		Student [] s = new Student[enrolledStudents.size()];
		return enrolledStudents.toArray(s);
	}
	
	/**
	 * Returns true if there is capacity to add a user to the course and the 
	 * user is not already enrolled.
	 * @param user User to add to the course
	 * @return true if there is capacity
	 */
	public boolean canEnroll(User user) {
		if (enrolledStudents.size() < capacity) {
			if (user instanceof Student) {
				Student s = (Student) user;
				for (int i = 0; i < enrolledStudents.size(); i++) {
					if (enrolledStudents.get(i).equals(s)) {
						return false;
					}
				}
				return true;
			}
			return false;
		}
		return false;
	}
	
	/**
	 * Enroll the user in the course if there is room.
	 * @param user user to enroll
	 * @return true if user is enrolled.
	 */
	public boolean enroll(User user) {
		if(studentOnWaitlist(user) || studentInClass(user)){ return false; }
		if(!canEnroll(user) && (waitlist == null || waitlist.size() < 5)) {
			waitlist.enqueue(user);
			return true; //not sure if return true or false
		} else{ 
			return canEnroll(user) && enrolledStudents.add(user);
		}
	}
	/**
	 * Gets the size of the waitlist which is used for testing
	 * @return int for the size of the waitlist.
	 */
	public int getWaitlistSize(){
		if (waitlist != null) { return waitlist.size(); }
		return 0;
	}
	
	//private method to check and see if user is on waitlist
	private boolean studentOnWaitlist(User user){
		if(waitlist.size() == 0){ return false; }
		int origWaitSize = waitlist.size();
		ArrayList<User> arrayOfWaitlist = new ArrayList<User>();
		boolean onList = false;
		User tempUser;
		for(int i = 0; i < origWaitSize; i++){
			//if(waitlist.size() == 0){break;}
			tempUser = waitlist.dequeue();
			if (tempUser != user){
				arrayOfWaitlist.add(tempUser);
			} else{
				if(i == 0){
					arrayOfWaitlist.add(tempUser);
				}
				onList = true;
			}
		}
		for(int i = 0; i < arrayOfWaitlist.size(); i++){
			waitlist.enqueue(arrayOfWaitlist.get(i));
		}
		return onList;
	}
	
	//private method to see if student is already in class
	private boolean studentInClass(User user){
		for (int i = 0; i < enrolledStudents.size(); i++) {
			if (enrolledStudents.get(i).equals(user)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Drops the student from the course. Takes student from waitlist and enrolls them into class
	 * @param user student to drop
	 * @return true if the student is dropped
	 */
	public boolean drop(User user) {
		if (enrolledStudents.remove(user)) {
			if(waitlist != null && waitlist.size() > 0){
			enroll(waitlist.dequeue());
			return true;
			}
		return true;
		} else{
			return false;
		}
	}

	/**
	 * Returns the hashCode for a course from the course's fields.
	 * @return the hashCode for the course
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Compares courses by their name.  
	 * @param obj object to check for equality of
	 * @return true if objects are the same
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name + "," + credits + "," + capacity;
	}

}
