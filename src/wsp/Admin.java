package wsp;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

import database.*;
import utils.*;
import language.*;

/**
 * The Admin class represents an superuser in the system.
 * Admins have the ability to manage users, create researchers, and perform various administrative tasks.
 */
public class Admin extends User implements Serializable {
	
	private static final long serialVersionUID = 6257279098772643532L;


	public Admin(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
		// TODO Auto-generated constructor stub
	}
	
	/**
     * Adds a researcher, either from an existing user or by creating a new user.
     */
	public void addResearcher() {
		String[] options = this.getLanguage().addResearcherOptions();
		
		StaticMethods.printList(List.of(options));
		
		this.getLanguage().whatDoYouWantToDo();
		int choice = StaticMethods.validate(1, 2);
		
		if(choice == 1) {
			StaticMethods.printList(Database.getInstance().getUsers());
			this.getLanguage().chooseUser();
			
			int userChoice = StaticMethods.validate(1, Database.getInstance().getUsers().size());
			
			Researcher r = new Researcher(Database.getInstance().getUsers().get(userChoice-1));
			
			Database.getInstance().addResearcher(r);
		}
		else if(choice == 2) {
			
			this.getLanguage().whichUserDoYouWantToCreate();
			
			String[] optionsToCreate = this.getLanguage().addResearcherOptionsCreate();
			
			StaticMethods.printList(List.of(optionsToCreate));
			int choiceUser = StaticMethods.validate(1, optionsToCreate.length);
			
			if(choice>=1 && choice<=2) {
				StudentFactory studentFactory = new StudentFactory();
				Student newStudent = studentFactory.getStudent(choiceUser);
				Researcher r = new Researcher(newStudent);
				Database.getInstance().addResearcher(r);
			}
			else if(choice>=3) {
				EmployeeFactory employeeFactory = new EmployeeFactory();
				Employee newEmployee = employeeFactory.getEmployee(choice);
				Researcher r = new Researcher(newEmployee);
				Database.getInstance().addResearcher(r);
			}
		}
	}

	/**
     * Creates a new user based on the chosen user type.
     */
	public void createUser() {
		this.getLanguage().whichUserDoYouWantToCreate();
		String[] options = this.getLanguage().createUserOptions();
		
		StaticMethods.printList(List.of(options));
		this.getLanguage().enterReturnBack();
		int choice = StaticMethods.validate(options.length);
		
		if(choice == 0) {
			return;
		}
		else if(choice>=1 && choice<=2) {
			StudentFactory studentFactory = new StudentFactory();
			studentFactory.getStudent(choice);
		}
		else if(choice == 3) {
			addResearcher();
		}
		else if(choice >= 4) {
			EmployeeFactory employeeFactory = new EmployeeFactory();
			employeeFactory.getEmployee(choice);
		}
	}
	
	/**
     * Displays a list of all users in the system.
     */
	private void seeAllUsers() {
		StaticMethods.printList(Database.getInstance().getUsers());
	}
	
	
	/**
     * Updates the information of selected user.
     */
	public void updateUser() {
		StaticMethods.printList(Database.getInstance().getUsers());
		this.getLanguage().updateUserWhichUserDoYouWantToChange();
		
		int choice = StaticMethods.validate(Database.getInstance().getUsers().size());
		
		if(choice == 0) {
			return;
		}
		
		Database.getInstance().getUsers().elementAt(choice-1).changeInfo();
	}
	
	
	/**
     * Removes a user from the system.
     */
	public void removeUser() {
		this.getLanguage().removeUserChooseUserToDelete();
		
		StaticMethods.printList(Database.getInstance().getUsers());
		
		this.getLanguage().enterReturnBack();
		
		int choice = StaticMethods.validate(Database.getInstance().getUsers().size());
		
		if(choice == 0) {
			return;
		}
		
		System.out.println(Database.getInstance().getUsers().elementAt(choice-1) + " was deleted");
		
		Database.getInstance().getUsers().remove(choice-1);
		
		
	}
	
	
	/**
     * Displays the log files for a selected user.
     */
	public void seeLogFiles() {
		this.getLanguage().enterReturnBack();
		this.getLanguage().seeLogFilesChooseUserToSeeLogs();
		
		Vector<User> users = Database.getInstance().getUsers();
		
		StaticMethods.printList(users);
		
		int choice = StaticMethods.validate(users.size());
		
		if(choice==0) {
			return;
		}
		
		User u = users.get(choice-1);
		
		Vector<Log> logs = Database.getInstance().seeLogs(u);
				
		if(logs==null) {
			this.getLanguage().seeLogFilesNoLogsForThisUser();
			return;
		}
		
		StaticMethods.printList(logs);
	}

	/**
	 * Displays the main menu for administrators, allowing them to perform various actions such as
	 * creating new users, managing user information, viewing log files
	 */
	@Override
	public void viewMenu() {
		
		while(true) {
			
			LanguageInterface userLanguage = this.getLanguage();
			
			String[] options = userLanguage.adminMenu();
			
			System.out.println();
			System.out.println(userLanguage.adminHeader());
			StaticMethods.printList(List.of(options));
			int choice = StaticMethods.validate(options.length);
			
			if(choice == 1) {
				createUser();
			}
			
			else if(choice == 2) {
				seeAllUsers();
			}
			
			else if(choice == 3) {
				updateUser();
			}
			
			else if(choice == 4) {
				removeUser();
			}
			else if (choice == 5) {
				seeLogFiles();
			}
			else if (choice == 6) {
				changeLanguage();
			}
			else if(choice == 7) {
				try {
					Database.getInstance().saveDatabase();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		
		}
		
	}

	
	public String toString() {
		return "Admin " + super.toString();
	}


	@Override
	public void changeInfo() {
	}
	

}
