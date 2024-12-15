package users;

import enums.UserRole;

public class UserFactory{

	public static User getUser(UserRole type) {
		if(type == UserRole.ADMIN){
			return new Admin();
		}
		if(type == UserRole.MANAGER){
			return new Manager();
		}
		if(type == UserRole.TEACHER){
			return new Teacher();
		}
		if(type == UserRole.STUDENT){
			return new Student();
		}
		return null;
	}
	
	public static User getUser(String login, String password, UserRole type){
		if(type == UserRole.ADMIN){
			return new Admin(login, password);
		}
		if(type == UserRole.MANAGER){
			return new Manager(login, password);
		}
		if(type == UserRole.STUDENT){
			return new Student(login, password);
		}
		if(type == UserRole.TEACHER){
			return new Teacher(login, password);
		}
		return null;
	}
	
}

