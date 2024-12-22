package wsp;

import java.io.IOException;
import java.io.Serializable;

import database.Log;
import enums.Faculty;
import enums.Status;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import database.Database;
import utils.Request;
import utils.StaticMethods;

/**
 * The Dean class represents a dean user in the system.
 * Deans have the ability to manage requests, sign emergency requests, view news, and perform other dean-specific tasks.
 */
public class Dean extends Teacher implements Serializable {

	private static final long serialVersionUID = 3623621447508671844L;
	private Vector<Request> requests = new Vector<>();

    public Dean(String username, String password, String firstName, String lastName, Faculty faculty) {
        super(username, password, firstName, lastName, null, faculty);
    }

    public Vector<Request> getRequests() {
        return requests;
    }

    public void setRequests(Vector<Request> requests) {
        this.requests = requests;
    }
    
    /**
     * Changes specific information of the dean, such as username, password, first name, last name, and faculty.
     */
    public void changeInfo() {
    	this.getLanguage().whatDoYouWantToChange();
		
		String[] options = new String[] {
				"Username", "Password", "First name", "Last name", "Faculty"
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
		else if(choice == 5) {
			this.getLanguage().chooseFaculty();
	        
	        Faculty[] optionsFaculty = Faculty.values();
	        
	        StaticMethods.printList(List.of(optionsFaculty));
	        
	        int facultyChoice = StaticMethods.validate(options.length);
	        
	        Faculty faculty = optionsFaculty[facultyChoice-1];
	        
	        this.setFaculty(faculty);
		}
    }
    
    /**
     * Displays all requests in the system.
     */
    public void viewRequests() {
    	StaticMethods.printList(Database.getInstance().getRequests());
        Database.getInstance().addLog(this, new Log("Dean " + this.getUsername() + " view all requests "));
    }
    
    /**
     * Signs emergency requests by accepting them and removing them from the list of pending requests.
     */
    public void signRequests() {

        if (requests.isEmpty()) {
        	this.getLanguage().noRequests();
            return;
        }

        this.getLanguage().emergencyRequests();
        
        StaticMethods.printList(requests);

        this.getLanguage().enterTheRequestNumberToSign();

        int choice = StaticMethods.validate(requests.size());
        
        if(choice == 0) {
        	return;
        }

        Request selectedRequest = requests.get(choice-1);
        selectedRequest.setStatus(Status.ACCEPTED);
        requests.remove(selectedRequest);
        
        this.getLanguage().deanSignedRequest(selectedRequest.toString());
        this.getLanguage().TheRequestWasSuccesfully();
        Database.getInstance().addLog(this, new Log("Dean " + this.getUsername() + " signed request"));
    
    }
    
    /**
     * Displays the dean's menu, allowing them to view requests, sign requests, view news, view papers, exit, and
     * optionally view the researcher menu if they are also a researcher.
     */
    public void viewMenu() {
    	String[] options;
    	
    	Researcher researcher = Database.getInstance().isResearcher(this);
    	
    	if(researcher == null) {
    		 options = this.getLanguage().deanMenu();
    	}
    	else {
    		 options = this.getLanguage().deanResearcherMenu();
    	}
       

        while (true) {
            System.out.println();
            this.getLanguage().deanHeader();
            StaticMethods.printList(List.of(options));

            int choice = StaticMethods.validate(1, options.length);
            
            if (choice == 1) {
    			viewCourses();
    		}
    		else if(choice == 2) {
    			viewStudents();
    		}
    		else if (choice == 3) {
    			viewMarks();
    		}
    		else if (choice == 4) {
    			putMarks();
    		}
            if(choice == 5) {
            	viewRequests();
            }
            if (choice == 6) {
                signRequests();
            } 
            else if (choice == 7) {
            	viewOneNews();
                Database.getInstance().addLog(this, new Log("Dean " + this.getUsername() + " viewed a one News"));
            }
            else if(choice == 8) {
            	Database.getInstance().getAllPapers();
            }
            else if(choice == 9) {
            	this.changeLanguage();
            }
            else if(choice == 10) {
            	StaticMethods.subscribeJournal(this);
            }
            else if(choice == 11) {
            	StaticMethods.unsubscribeJournal(this);
            }
            else if (choice == 12) {
                try {
                    Database.getInstance().saveDatabase();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            else if(researcher != null) {
				if(choice == 13) {
					researcher.viewMenu();
                    Database.getInstance().addLog(this, new Log("Dean " + this.getUsername() + " went to the researcher menu"));
				}
			}
        }
    }

    public void addRequest(Request request) {
        requests.add(request);
    }

    /**
     * Adds a request to the list of requests associated with the Dean.
     */
    @Override
    public String toString() {
        return "Dean " + super.toString();
    }
}
