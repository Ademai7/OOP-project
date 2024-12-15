package main;

import uiclasses.AdminUI;
import uiclasses.EmployeeUI;
import uiclasses.ManagerUI;
import uiclasses.ResearcherUI;
import uiclasses.StudentUI;
import uiclasses.TeacherUI;
import uiclasses.TechSupportUI;
import uiclasses.UserUI;
import users.Admin;
import users.Employee;
import users.Manager;
import users.PhDStudent;
import users.Researcher;
import users.Student;
import users.Teacher;
import users.TechSupportSpecialist;
import users.User;

public class UIFactory {
	
	public static UserUI getUi(User user) {
		if(user.getClass().equals(Admin.class)) {
			return new AdminUI((Admin) user);
		}
		else if(user.getClass().equals(Student.class)) {
			return new StudentUI((Student) user);
		}
	/*	else if(user.getClass().equals(PhDStudent.class)) {
			return new PhDStudentUI((PhDStudent) user);
		}*/
		else if(user.getClass().equals(Manager.class)) {
			return new ManagerUI((Manager) user);
		}
		else if(user.getClass().equals(Teacher.class)) {
			return new TeacherUI((Teacher) user);
		}
		else if(user.getClass().equals(TechSupportSpecialist.class)) {
			return new TechSupportUI((TechSupportSpecialist) user);
		}
		return null;
	}
}
	

