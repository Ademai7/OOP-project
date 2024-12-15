package users;

import java.io.Serializable;

import enums.AcademicDegree;
import enums.Faculty;
import main.Database;


public class TeacherTest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
	    Database database = Database.getInstance();
	    Teacher teacher = (Teacher) database.getUser("t_mustafin@kbtu.kz", "parol");
	    if (teacher != null) {
	    	teacher.setFaculty(Faculty.SITE);
	    	teacher.setAcademicDegree(AcademicDegree.DOCTORATE);
	        try {
	            Database.saveDB();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    } else {
	        System.out.println("Teacher not found!");
	    }
	}
}

