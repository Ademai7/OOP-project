package utils;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

import database.Database;
import enums.*;
import wsp.*;

/**
 * The Course class represents a course in an educational program.
 * It includes information such as credits, name, type, and faculty.
 */
public class Course implements Serializable {
	private int id;
	private int credits;
	private Vector<Teacher> teachers = new Vector<Teacher>();
	private String name;
	private TypeCourse type;
	private Faculty faculty;

	
	/**
     * Constructs a new Course with the specified credits, name, type, and faculty.
     * Auto increment id of new courses to ensure courses have unique ids.
     *
     * @param credits The number of credits for the course.
     * @param name    The name of the course.
     * @param type    The type of the course (e.g., REQUIRED, MINOR, MAJOR).
     * @param faculty The faculty to which the course belongs.
     */
	public Course(int credits, String name, TypeCourse type, Faculty faculty) {
		if(Database.getInstance().getCourses().isEmpty()) {
			this.id = 1;
		}
		else {
			int nextid = Database.getInstance().getCourses().lastElement().id;
			this.id = ++nextid;
		}
		this.credits = credits;
		this.name = name;
		this.type = type;
		this.faculty = faculty;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return credits == other.credits && faculty == other.faculty && Objects.equals(name, other.name)
				&& type == other.type;
	}


	public String getName() {
		return name;
	}

	public Vector<Teacher> getTeachers() {
		return teachers;
	}
	
	/**
     * Adds a teacher to the course.
     *
     * @param t The teacher to add.
     */
	public void addTeacher(Teacher t) {
		this.teachers.add(t);
	}
	
	public int getCredits() {
		return this.credits;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", credits=" + credits + ", name=" + name + ", type="
				+ type + ", faculty=" + faculty + "]";
	}
	
	
}
