package wsp;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import enums.*;
import database.*;
import utils.Organisation;
import utils.StaticMethods;


/**
 * The GraduateStudent class represents a graduate student in the academic system.
 * It extends the Student class and implements specific functionalities for graduate students.
 */
public class GraduateStudent extends Student implements Serializable {
	
    private Grade grade;
    
    /**
     * Constructs a GraduateStudent object with the specified parameters.
     * Automatically adds user as a researcher.
     *
     * @param username  The username of the graduate student.
     * @param password  The password of the graduate student.
     * @param firstName The first name of the graduate student.
     * @param lastName  The last name of the graduate student.
     * @param faculty   The faculty to which the graduate student belongs.
     * @param grade     The grade (Master's or PhD) of the graduate student.
     */
    public GraduateStudent(String username, String password, String firstName, String lastName, Faculty faculty, Grade grade) {
        super(username, password, firstName, lastName, faculty);
        this.grade = grade;
        Researcher<GraduateStudent> researcher = new Researcher<>(this);
        Database.getInstance().addResearcher(researcher);
    }

    /**
     * Gets the grade of the graduate student (Master's or PhD).
     *
     * @return The grade of the graduate student.
     */
    public Grade getGrade() {
        return grade;
    }

    
    /**
     * Sets the grade of the graduate student (Master's or PhD).
     *
     * @param grade The new grade to set.
     */
    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraduateStudent that)) return false;
        if (!super.equals(o)) return false;

        return grade == that.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }

    @Override
    public String toString() {
        return "GraduateStudent [grade=" + grade +
                "] " + super.toString();
    }
    
    /**
     * Changes the information of the graduate student, including username, password, first name,
     * last name, and grade. Provides a menu for the user to choose the information to change.
     */
    public void changeInfo() {
    	this.getLanguage().whatDoYouWantToChange();
		
		String[] options = new String[] {
				"Username", "Password", "First name", "Last name", "Grade"
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
			if(this.grade == Grade.MASTER) {
				this.grade = Grade.PHD;
			}
			else {
				this.grade = Grade.MASTER;
			}
			this.getLanguage().newGrade(this.grade.name());
		}
    }

    @Override
    public void joinOrganisation() {
        super.joinOrganisation();
    }

    @Override
    public void leaveOrganisation() {
        super.leaveOrganisation();
    }

    @Override
    public void createOrganisation() {
        super.createOrganisation();
    }

    
    /**
     * Displays the graduate student's menu, allowing them to perform various actions such as viewing transcript, viewing
     * marks for a course, registering for a course, viewing a teacher for a course, viewing all courses, rating teachers,
     * accessing the organization menu, viewing all papers, viewing one news, exiting and additional option to view the researcher menu.
     */
    @Override
    public void viewMenu() {
    	
    	Researcher researcher = Database.getInstance().isResearcher(this);
    	
    	while (true) {
        	String[] options = this.getLanguage().graduateStudentMenu();
			
            System.out.println(this.getLanguage().graduateStudentHeader());
            StaticMethods.printList(List.of(options));

            this.getLanguage().enterYourChoice();
            int choice = StaticMethods.validate(1, options.length);

            if (choice == 1) {
                viewTranscript();
            }
            else if (choice == 2) {
                viewMarks();
            }
            else if (choice == 3) {
                getCourseFromDB();
            }
            else if (choice == 4) {
                viewTeacherForCourse();
            }
            else if (choice == 5) {
                viewCourses();
            } else if (choice == 6) {
                rateTeachers();
            }
            else if (choice == 7) {
                organisationMenu();
            }
            else if(choice == 8) {
            	viewOneNews();
                Database.getInstance().addLog(this, new Log("Graduate Student " + this.getUsername() + " viewed a one News"));  	
            }
            else if (choice == 9) {
            	Database.getInstance().getAllPapers();
            }
            else if (choice == 10) {
            	this.changeLanguage();
            }
            else if(choice == 11) {
            	StaticMethods.subscribeJournal(this);
            }
            else if(choice == 12) {
            	StaticMethods.unsubscribeJournal(this);
            }
            else if (choice == 13) {
                try {
                    Database.getInstance().saveDatabase();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            }
            else if(choice == 14) {
            	researcher.viewMenu();
                Database.getInstance().addLog(this, new Log("Graduate Student " + this.getUsername() + " went to the researcher menu"));
            }
        }
    }

}
