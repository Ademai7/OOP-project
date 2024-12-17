package users;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

import attributes.Course;
import attributes.DataBase;
import attributes.Mark;
import enums.Degree;
import enums.Faculty;
import enums.TypeManager;
import enums.TypeTeacher;
import enums.TypeUser;

public class Tester 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		 try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/users.out"))) {
	            Object obj = ois.readObject();
	            
	            if (obj instanceof HashMap) {
	                HashMap<?, ?> map = (HashMap<?, ?>) obj;
	                System.out.println("Содержимое HashMap: " + map);
	            } else {
	                System.out.println("Неизвестный объект: " + obj);
	            }
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
//		Admin a = new Admin("admin", "Tom", "Holland", 30);
//
//		HashSet <User> admin = new HashSet <User>();
//		admin.add(a);
//
//		DataBase.users.put(TypeUser.ADMIN, admin);
//		
//		DataBase.serializeUsers();
//		DataBase.serializeCourses();
//		DataBase.serializeResearches();
//		DataBase.serializeNews();
//		DataBase.serializeId();
//		Librarian.serializeAvailableBooks();
//		Librarian.serializeGivenBooks();
//		
//		DataBase.deserializeUsers();
//		DataBase.deserializeId();
//		DataBase.deserializeNews();
//		Admin.deserializeLogFiles();
//		Librarian.deserializeAvailableBooks();
//		Librarian.deserializeGivenBooks();
//		DataBase.deserializeCourses();
//		DataBase.deserializeRequests();
//		DataBase.deserializeResearches();
//		
//		Vector <Student> v = new Vector <Student>();
//		Vector <Mark> m = new Vector <Mark>();
//		Student azat = new Student("Azat", null, null, 20, 0, 0, null, null);
//		v.add(azat);
//		Teacher t = new Teacher("John Doe", "T123", null, 0, TypeTeacher.LECTOR, null); 
//		Course oop = new Course("Object-Oriented Programming", 5, null, null);
//		t.getCourses().put(oop,v);
//		azat.getJournal().getJournal().put(oop, m);
		
		UserController.logIn();
		
	
	}
}
