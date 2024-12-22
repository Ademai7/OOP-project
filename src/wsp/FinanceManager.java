package wsp;

import database.Log;
import utils.StaticMethods;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import enums.Status;
import database.Database;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import database.Database;
import database.Log;
import utils.*;
import wsp.*;
import enums.*;

/**
 * The FinanceManager class represents a finance manager in the academic system.
 * It handles the management of student payments, scholarships, and employee salaries.
 * It interacts with the FinanceOffice to manage financial transactions and status updates.
 * Inherits from Employee class and implements Serializable for saving and loading data.
 */
public class FinanceManager extends Employee implements Serializable {
    
    private static final long serialVersionUID = 6056773483142436294L;

    // List to store students who receive scholarships
    private List<Student> scholarshipStudents;
    
    // List to store employees who receive salaries
    private List<Employee> salariedEmployees;
    
    // Map to store payment status for each student
    private Map<Student, Boolean> studentFeesPaid;
    
    // Static fee for student payment
    static int fee = 5000;
    
    // Static amount for scholarship
    static int scholarship = 47543;

    /**
     * Constructor for creating a FinanceManager instance with username, password, first name, and last name.
     * Initializes the lists for scholarship students, salaried employees, and the map for student payment statuses.
     * 
     * @param username the username of the finance manager
     * @param password the password for the finance manager
     * @param firstName the first name of the finance manager
     * @param lastName the last name of the finance manager
     */
    public FinanceManager(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
        this.scholarshipStudents = new ArrayList<>();
        this.salariedEmployees = new ArrayList<>();
        this.studentFeesPaid = new HashMap<>();
    }

    /**
     * Updates the payment status of a student.
     * 
     * @param student the student whose payment status is being updated
     * @param status the new payment status for the student
     */
    public void updatePaymentStatus(Student student, boolean status) {
        studentFeesPaid.put(student, status);
        this.getLanguage().updatePaymentStatus();
        System.out.println(getUsername());
    }

    /**
     * Checks if a student has paid their fee.
     * 
     * @param student the student whose payment status is being checked
     * @return true if the student has paid the fee, false otherwise
     */
    public boolean isFeePaid(Student student) {
        return studentFeesPaid.getOrDefault(student, false);
    }

    /**
     * Handles the check for a student's fee payment status and displays the result.
     * 
     * @param student the student whose fee payment status is being checked
     */
    public void handleCheckFeeStatus(Student student) {
        boolean isPaid = isFeePaid(student);
        if (isPaid) {
            this.getLanguage().handleCheckFeeStatusTrue();
        } else {
            this.getLanguage().handleCheckFeeStatusFalse();
        }
    }

    /**
     * Gives a scholarship to a student if their marks are above 70 in all subjects.
     * 
     * @param student the student who is being considered for the scholarship
     * @param financialOffice the finance office used to add the scholarship to the student's account
     * @param scholarshipAmount the amount of the scholarship to be given
     */
    public void giveScholarship(Student student, FinanceOffice financialOffice, double scholarshipAmount) {
        // Check if all marks are above 70
        boolean allMarksAbove70 = student.getTranscript().values().stream().allMatch(mark -> mark.getMark() > 70);
        
        if (allMarksAbove70) {
            // Add scholarship to student's account via financial office
            financialOffice.addFunds(student, scholarshipAmount);
            this.getLanguage().giveScholarshipd();
            System.out.println(student.getUsername());
        } else {
            this.getLanguage().notGiveScholarshipd();
            System.out.println(student.getUsername());
        }
    }

    /**
     * Distributes salary to an employee.
     * 
     * @param employee the employee who is receiving the salary
     */
    public void distributeSalary(Employee employee) {
        Scanner scanner = new Scanner(System.in);
        this.getLanguage().distributeSalary();
        double amount = scanner.nextDouble();
        
        // Check if employee is in the list of salaried employees
        if (salariedEmployees.contains(employee)) {
            // Call the method to receive salary for the employee
            employee.receiveSalary(amount);
            this.getLanguage().haveSalary();
            System.out.println(employee.getUsername());
        } else {
            System.out.println(employee.getUsername());
            this.getLanguage().haveNotSalary();
        }
    }

    /**
     * Displays the menu for the FinanceManager, allowing them to interact with various options
     * such as viewing orders, checking fees, assigning scholarships, and distributing salaries.
     * It also provides an option to interact with the researcher menu if the finance manager is also a researcher.
     */
    public void viewMenu() {
        String[] options;
        
        // Check if the finance manager is also a researcher
        Researcher researcher = Database.getInstance().isResearcher(this);
        
        if(researcher == null) {
            options = this.getLanguage().FinanceManagerMenu();
        }
        else {
            options = this.getLanguage().FinanceManagerResearcherMenu();
        }
        
        while(true) {
            this.getLanguage().FinanceManagerHeader();
            
            StaticMethods.printList(List.of(options));
            
            this.getLanguage().enterYourChoice();
            int choice = StaticMethods.validate(1, options.length);
            
            // Handle various menu options for the finance manager
            if(choice == 1) {
                // Update payment status for student
                Scanner scanner = new Scanner(System.in);
                this.getLanguage().enterStudentUsername();
                String username = scanner.nextLine();
                Student student = Database.getInstance().getStudentByUsername(username); // Find student
                if (student != null) {
                    this.updatePaymentStatus(student, true);
                } else {
                    this.getLanguage().studentNotFound();
                }
            } 
            else if(choice == 2) {
                // Check fee status for student
                Scanner scanner = new Scanner(System.in);
                this.getLanguage().enterStudentUsername();
                String username = scanner.nextLine();
                Student student = Database.getInstance().getStudentByUsername(username); // Find student
                if (student != null) {
                    this.handleCheckFeeStatus(student);
                } else {
                    this.getLanguage().studentNotFound();
                }
            }
            else if(choice == 3) {
                // Give scholarship to student
                Scanner scanner = new Scanner(System.in);
                this.getLanguage().enterStudentUsername();
                String username = scanner.nextLine();
                Student student = Database.getInstance().getStudentByUsername(username); // Find student
                if (student != null) {
                    System.out.print("Enter scholarship amount: ");
                    double scholarshipAmount = scanner.nextDouble();
                    FinanceOffice financialOffice = new FinanceOffice(); // Create FinanceOffice instance
                    this.giveScholarship(student, financialOffice, scholarshipAmount);
                } else {
                    this.getLanguage().studentNotFound();
                }
            }
            else if(choice == 4) {
                // Distribute salary to employee
                Scanner scanner = new Scanner(System.in);
                this.getLanguage().enterEmployeeUsername();
                String username = scanner.nextLine();
                Employee employee = Database.getInstance().getEmployeeByUsername(username); // Find employee
                if (employee != null) {
                    this.distributeSalary(employee);
                } else {
                    this.getLanguage().employeeNotFound();
                }
            }
            else if(choice == 5) {
                // Display all papers in the database
                Database.getInstance().getAllPapers();
            }
            else if(choice == 6) {
                // Change language setting
                this.changeLanguage();
            }
            else if(choice == 7) {
                // Subscribe to a journal
                StaticMethods.subscribeJournal(this);
            }
            else if(choice == 8) {
                // Unsubscribe from a journal
                StaticMethods.unsubscribeJournal(this);
            }
            else if(choice == 9) {
                // Save the database
                try {
                    Database.getInstance().saveDatabase();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            
            // If finance manager is a researcher, provide an additional menu option
            else if(researcher != null) {
                if(choice == 10) {
                    researcher.viewMenu();
                    Database.getInstance().addLog(this, new Log("FinanceManager " + this.getUsername() + " went to the researcher menu"));
                }
            }
        }
    }

    /**
     * Returns a string representation of the FinanceManager object.
     * 
     * @return a string containing the finance manager's information
     */
    public String toString() {
        return "FinanceManager " + super.toString();
    }
}
