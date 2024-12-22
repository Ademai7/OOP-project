package wsp;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import database.Database;
import enums.Faculty;
import enums.TeacherTitle;
import enums.TypeManager;
import utils.StaticMethods;


/**
 * The EmployeeFactory class is responsible for creating different types of employees
 * based on the user's choice. It provides methods to add various types of employees
 * such as regular employees, teachers, managers, finance_manager,finance_office and deans.
 */
public class EmployeeFactory {
	
	
	/**
     * Creates and returns an Employee based on the specified choice.
     * 
     * @param choice The user's choice to determine the type of employee.
     * @return The created Employee object.
     */
	public Employee getEmployee(int choice) {
		
		if(choice == 4) {
			return addEmployee();
		}
		if(choice == 5) {
			return addTeacher();
		}
		if(choice == 6) {
			return addManager();
		}
		if(choice == 7) {
			return addFinanceManager();
		}
		if(choice == 8) {
			return addFinanceManager();
		}
		if(choice == 9) {
			return addDean();
		}
		return null;
	}
	
	/**
     * Adds a regular employee to the system by taking user input for username,
     * password, first name, and last name.
     * 
     * @return The created Employee object.
     */
	public Employee addEmployee() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter username:");
        String username = in.nextLine();

        System.out.println("Enter password:");
        String password = in.nextLine();

        String firstName = StaticMethods.getValidInput("Enter first name:", "[a-zA-Z]+");

        String lastName = StaticMethods.getValidInput("Enter last name:", "[a-zA-Z]+");
        
        Employee newEmployee = new Employee(username, password, firstName, lastName);
		
        if(Database.getInstance().addEmployee(newEmployee)) {
        	System.out.println("Employee added " + newEmployee);
        }
        
        return newEmployee;
        
	}
	
	
	/**
     * Adds a teacher to the system by taking user input for username, password,
     * first name, last name, faculty, and teacher title.
     * 
     * @return The created Teacher object.
     */
	public Employee addTeacher() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter username:");
        String username = in.nextLine();

        System.out.println("Enter password:");
        String password = in.nextLine();

        String firstName = StaticMethods.getValidInput("Enter first name:", "[a-zA-Z]+");

        String lastName = StaticMethods.getValidInput("Enter last name:", "[a-zA-Z]+");
        
        System.out.println("Choose faculty:");
        
        Faculty[] options = Faculty.values();
        
        StaticMethods.printList(List.of(options));
        
        int facultyChoice = StaticMethods.validate(1, options.length);
        
        Faculty faculty = options[facultyChoice-1];
        
        TeacherTitle[] optionsTitle = TeacherTitle.values();
        
        StaticMethods.printList(List.of(optionsTitle));
        
        int titleChoice = StaticMethods.validate(1, optionsTitle.length);
        
        TeacherTitle title = optionsTitle[titleChoice-1];
        
        Teacher newTeacher = new Teacher(username, password, firstName, lastName, title, faculty);
		
        if(Database.getInstance().addEmployee(newTeacher)) {
        	System.out.println("Teacher added " + newTeacher);
        }
        
        return newTeacher;
	}
	
	 /**
     * Adds a manager to the system by taking user input for username, password,
     * first name, last name, and type.
     * 
     * @return The created Manager object.
     */
	public Employee addManager() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter username:");
        String username = in.nextLine();

        System.out.println("Enter password:");
        String password = in.nextLine();

        String firstName = StaticMethods.getValidInput("Enter first name:", "[a-zA-Z]+");

        String lastName = StaticMethods.getValidInput("Enter last name:", "[a-zA-Z]+");
        
        System.out.println("Choose type:");
        
        TypeManager[] options = TypeManager.values();
        
        StaticMethods.printList(List.of(options));
        
        int choice = StaticMethods.validate(options.length);
        
        TypeManager title = options[choice-1];
        
        Manager newManager = new Manager(username, password, firstName, lastName, title);
		
        if(Database.getInstance().addEmployee(newManager)) {
        	System.out.println("Manager added " + newManager);
        }
        
        return newManager;
	}
	
	/**
     * Adds a financeManager to the system by taking user input for
     * username, password, first name, and last name.
     * 
     * @return The created TechSupportSpecialist object.
     */
	public Employee addFinanceManager() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter username:");
        String username = in.nextLine();

        System.out.println("Enter password:");
        String password = in.nextLine();

        String firstName = StaticMethods.getValidInput("Enter first name:", "[a-zA-Z]+");

        String lastName = StaticMethods.getValidInput("Enter last name:", "[a-zA-Z]+");
        
        FinanceManager financeManagerNew = new FinanceManager(username, password, firstName, lastName);
		
        if(Database.getInstance().addEmployee(financeManagerNew)) {
        	System.out.println("Added " + financeManagerNew);
        }

        return financeManagerNew;
	}
	
	/**
     * Adds a dean to the system by taking user input for username, password, first name,
     * last name, and faculty. Checks if a dean for the specified faculty already exists.
     * 
     * @return The created Dean object, or null if a dean for the faculty already exists.
     */
	public Employee addDean() {
		Scanner in = new Scanner(System.in);
		
		Faculty[] options = Faculty.values();
        
        StaticMethods.printList(List.of(options));
        
        int facultyChoice = StaticMethods.validate(options.length);
        
        Faculty faculty = options[facultyChoice-1];
        
        Vector<Employee> employees = Database.getInstance().getEmployees();
        boolean deanExists = employees.stream()
        		.filter(employee -> employee instanceof Dean)
        		.map(employee -> (Dean) employee)
        		.anyMatch(dean -> dean.getFaculty() == faculty);
        
        if(deanExists) {
        	System.out.println("Dean of the " + faculty + " already exists!");
        	return null;
        }
		
		System.out.println("Enter username:");
        String username = in.nextLine();

        System.out.println("Enter password:");
        String password = in.nextLine();

        String firstName = StaticMethods.getValidInput("Enter first name:", "[a-zA-Z]+");

        String lastName = StaticMethods.getValidInput("Enter last name:", "[a-zA-Z]+");
        
        Dean newDean = new Dean(username, password, firstName, lastName, faculty);
		
        if(Database.getInstance().addEmployee(newDean)) {
        	System.out.println("Dean added " + newDean);
        }

        return newDean;
	}
}
