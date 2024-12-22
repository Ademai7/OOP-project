package wsp;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import wsp.*;
import database.*;
import enums.*;
import utils.*;

/**
 * The Employee class represents an employee user in the system.
 * It extends the User class and provides additional functionalities
 * specific to employees, such as sending requests and orders.
 * 
 * @see User
 */
public class Employee extends User implements Serializable {
	
	private static final long serialVersionUID = 3585353902952762348L;
	private double salaryBalance;

    public Employee(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Sends a message to another user.
     * 
     * @param message The message to be sent.
     * @param user The user to whom the message is sent.
     */
    public void sendMessage(String message, User user) {
        
    }

    
    /**
     * Sends an emergency request to a Dean. The user can choose the Dean, emergency level,
     * and provide a message.
     */
    public void sendRequest() {
    	
    	Vector<Dean> deans = Database.getInstance().getDeans();
    	
    	if(deans.isEmpty()) {
    		this.getLanguage().noDeans();
    		return;
    	}
    	
    	
    	this.getLanguage().chooseTheDean();
    	
    	StaticMethods.printList(deans);
    	
    	int choice = StaticMethods.validate(deans.size());
    	
    	if(choice==0) {
    		return;
    	}
    	
    	Dean dean = deans.get(choice-1);
    	
    	this.getLanguage().enterTheEmergencyLevel();
    	
    	Emergency[] emergencyList = Emergency.values();
    	
    	StaticMethods.printList(List.of(emergencyList));
    	
    	int emergencyChoice = StaticMethods.validate(1, emergencyList.length);
    	
    	Emergency emergency = emergencyList[emergencyChoice-1];
    	
    	this.getLanguage().enterTheMessage();
    	Scanner in = new Scanner(System.in);
    	String message = in.nextLine();
    	
    	Request newRequest = new Request(emergency, message, dean);
    	
        Database.getInstance().addRequest(newRequest);
        
        this.getLanguage().sentSuccesfully(newRequest.toString());

    }
    
    
    /**
     * Sends an order to a Tech Support Specialist. The user can choose the specialist
     * and provide a message.
     */
//    public void sendOrder() {
//    	Vector<TechSupportSpecialist> TechSupportSpecialists = Database.getInstance().getTechSupports();
//    	
//    	if(TechSupportSpecialists.isEmpty()) {
//    		this.getLanguage().noTechSupports();
//    		return;
//    	}
//    	
//    	this.getLanguage().enterReturnBack();
//    	this.getLanguage().chooseTheTechSupport();
//    	
//    	StaticMethods.printList(TechSupportSpecialists);
//    	
//    	int choice = StaticMethods.validate(TechSupportSpecialists.size());
//    	
//    	if(choice==0) {
//    		return;
//    	}
//    	
//    	TechSupportSpecialist techSupport = TechSupportSpecialists.get(choice-1);
//    	
//    	this.getLanguage().enterTheMessage();
//    	Scanner in = new Scanner(System.in);
//    	String message = in.nextLine();
//    	
//    	Order newOrder = new Order(message, techSupport);
//    	
//        Database.getInstance().addOrder(newOrder);
//        this.getLanguage().sentSuccesfully(newOrder.toString());
//    }
    
    /**
     * Displays the employee menu, allowing them to perform various actions such as sending a request, sending an order,
     * viewing one news, viewing all papers, saving the database, and exiting. 
     * If the employee is also a researcher, an additional option to view the researcher menu is available.
     */
	@Override
	public void viewMenu() {
		String[] options;
    	
    	Researcher researcher = Database.getInstance().isResearcher(this);
    	
    	if(researcher == null) {
    		 options = this.getLanguage().employeeMenu();
    	}
    	else {
    		 options = this.getLanguage().employeeResearcherMenu();
    	}
       

        while (true) {
            System.out.println();
            this.getLanguage().employeeHeader();
            StaticMethods.printList(List.of(options));

            int choice = StaticMethods.validate(1, options.length);
            
            if(choice == 1) {
            	sendRequest();
            }
//            else if (choice == 2) {
//                sendOrder();
//            } 
            else if (choice == 3) {
            	viewOneNews();
            }
            else if(choice == 4) {
            	Database.getInstance().getAllPapers();
            }
            else if(choice == 5) {
            	this.changeLanguage();
            }
            else if(choice == 6) {
            	StaticMethods.subscribeJournal(this);
            }
            else if(choice == 7) {
            	StaticMethods.unsubscribeJournal(this);
            }
            else if (choice == 8) {
                try {
                    Database.getInstance().saveDatabase();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            else if(researcher != null) {
				if(choice == 9) {
					researcher.viewMenu();
				}
			}
        }
		
	}

	
	public String toString() {
		return "Employee " + super.toString();
	}
	
	
	/**
     * Allows to change employee's information, such as username, password, first name, and last name.
     */
	public void changeInfo() {
		this.getLanguage().whatDoYouWantToChange();
		
		String[] options = new String[] {
				"Username", "Password", "First name", "Last name"
		};
		
		StaticMethods.printList(List.of(options));
		this.getLanguage().enterReturnBack();
		int choice = StaticMethods.validate(options.length);
		Scanner in = new Scanner(System.in);
		
		if(choice == 0) {
			return;
		}
		else if(choice == 1) {
			this.getLanguage().enterNewUsername();
			String newUsername = in.nextLine();
			this.setUsername(newUsername);
		}
		else if(choice == 2) {
			this.getLanguage().enterNewPassword();
			String newPassword = in.nextLine();
			this.setPassword(newPassword);
		}
		else if(choice == 3) {
			String firstName = StaticMethods.getValidInput(this.getLanguage().enterNewFirstName(), "[a-zA-Z]+");
			this.setFirstName(firstName);
		}
		else if(choice == 4) {
			String lastName = StaticMethods.getValidInput(this.getLanguage().enterNewLastName(), "[a-zA-Z]+");
			this.setLastName(lastName);
		}
    }
    public void receiveSalary(double amount) {
        if (amount > 0) {
            this.salaryBalance += amount;  // Увеличиваем баланс на сумму зарплаты
            System.out.println("Salary of " + amount + " received by employee: " + getUsername());
        } else {
            System.out.println("Invalid salary amount.");
        }
    }
	public double getSalaryBalance() {
        return salaryBalance;
    }
}
