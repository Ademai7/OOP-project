package utils;

import java.io.Serializable;
import java.util.Vector;

import wsp.*;


/**
 * The Organisation class represents an organization with a name, a head (student), and members.
 */
public class Organisation implements Serializable {
	
	private String name;
	private Student head;
	private Vector<Student> members;
	
	public Organisation(){
    }
	
	/**
     * Constructs a new organization with the given name and head.
     *
     * @param name The name of the organization.
     * @param head The head (student) of the organization.
     */
	public Organisation(String name, Student head) {
		this.name = name;
		this.head = head;
		this.members = new Vector<Student>();
	}


	@Override
	public String toString() {
		return "Organisation [name=" + name + ", head=" + head.getFirstName()  + ", members=" + members.size() + "]";
	}

	/**
     * Adds a member to the organization.
     *
     * @param student The student to be added as a member.
     */
    public void addMember(Student student) {
        members.add(student);
    }
    
    /**
     * Removes a member from the organization.
     *
     * @param student The student to be removed from the organization.
     */
    public void removeMember(Student student) {
        members.remove(student);
    }

    public String getName() {
        return name;
    }
}