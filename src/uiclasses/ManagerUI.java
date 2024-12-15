package uiclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Vector;
import java.util.stream.Collectors;

import courses.Courses;
import enums.Faculty;
import main.Database;
import unisystem2023.Message;
import unisystem2023.News;
import users.Manager;
import users.Researcher;
import users.Teacher;
import users.User;

public class ManagerUI extends EmployeeUI{
  private Manager manager;

  public ManagerUI(){}

  public ManagerUI(Manager manager){
    super(manager);
    this.manager = manager;
  }

  public void viewMessages() throws IOException{
    Vector <Message> messages = ((Manager)user).getMessages();
    while(true){
      print("0. Exit");
      int count = 1;
      for(Message cur: messages){
        print(count + "." + cur);
        count++;
      }
      String ans = reader.readLine();
      if(ans.equals("0")){
        return;
      }
      try{
        viewMessage(messages.get(Integer.parseInt(ans) - 1));
      }
      catch (IndexOutOfBoundsException iofe){
        print("Wrong answer");
      }
      catch (NumberFormatException nfe){
        print("Not a number");
      }
    }
  }


  public void sendMessage() throws IOException{
    System.out.println("Write User's login to send message: ");
    User receiver;
    String name = reader.readLine();
    while(true){
      try{
        receiver = Database.getInstance().getAllUsers().stream()
       // .filter(u-> u instanceof User) ?????? нада обдумать нормски
        .filter(e -> e.getLogin().equals(name))
        .collect(Collectors.toList()).get(0);
        break;
      }
      catch (IndexOutOfBoundsException ioofe){
        print("No such user");
      }
    }
    print("Insert message theme: ");
    String theme = reader.readLine();
    print("Insert message text: ");
    String text = reader.readLine();
    ((Manager)user).sendMessage((Manager)receiver, theme, text);
  }
  
  public void addCourse() throws IOException {
	    while (true) {
	        print("Insert course idCode or 0 to exit: ");
	        String idCode = reader.readLine();
	        if (idCode.equals("0")) {
	            return;
	        }

	        print("Insert number of credits for the course:");
	        int credits = Integer.parseInt(reader.readLine());

	        print("Insert course name:");
	        String name = reader.readLine();

	        print("Insert faculty:\nSITE\nBS\nISE\nSAM");
	        String facultyInput = reader.readLine();
	        Faculty faculty = Faculty.valueOf(facultyInput);

	        try {
	            Courses course = new Courses(name, idCode, credits, faculty);
	            Database.getInstance().addCourse(course);
	            print("Course created successfully");
	        } catch (Exception e) {
	            print("Something went wrong while creating the course.");
	            e.printStackTrace();
	        }
	    }
	}
  
  
  public void deleteCourse() throws IOException {
	    while (true) {
	        print("Select a course to delete or enter 0 to exit:");
	        Vector<Courses> courses = Database.getInstance().getCourses();
	        for (int i = 0; i < courses.size(); i++) {
	            print((i + 1) + ". " + courses.get(i));
	        }
	        int choice = Integer.parseInt(reader.readLine());

	        if (choice == 0) {
	            return;
	        } else if (choice > 0 && choice <= courses.size()) {
	            Courses courseToDelete = courses.get(choice - 1);
	            Database.getInstance().deleteCourse(courseToDelete);
	            print("Course deleted successfully");
	        } else {
	            print("Invalid choice. Please select a valid option.");
	        }
	    }
	}



  public void researchersMenu() {
      Vector<Researcher> researchers = Database.getInstance().getResearchers();
      if (researchers.isEmpty()) {
          Manager manager = (Manager) user; // Assuming 'user' is an Employee type
          researchers.add(new Researcher(manager)); // Create a new Researcher instance using the employee
          Database.getInstance().setResearchers(researchers); // Set the updated list of researchers in the database
      }
      new ResearcherUI().main(); // Instantiate the ResearcherView and call its main method
  }
  
  public void viewCourses() throws IOException {
	    Vector<Courses> courses = Database.getInstance().getCourses();
	    if (courses.isEmpty()) {
	        System.out.println("No courses");
	        return;
	    }

	    System.out.println("Courses:\n");
        for (int i = 0; i < courses.size(); i++) {
            print((i + 1) + ". " + courses.get(i));
        }
	}
  
  
  public void addNews() throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    
	    System.out.println("Enter news title:");
	    String newsTitle = reader.readLine();
	    
	    System.out.println("Enter news' details:");
	    String details = reader.readLine();
	    
	    News newsItem = new News(newsTitle, details);
	    Database.getInstance().addNews(newsItem);
	    
	    System.out.println("News added successfully!");
	} 
  
  
  public void assignTeacherToCourse() throws IOException {
	    Vector<Courses> courses = Database.getInstance().getCourses();
	    if (courses.isEmpty()) {
	        System.out.println("No courses available to assign teachers");
	        return;
	    }

	    System.out.println("Available Courses:");
	    for (int i = 0; i < courses.size(); i++) {
	        System.out.println((i + 1) + ". " + courses.get(i));
	    }

	    System.out.println("Enter the number of the course to assign teachers:");
	    int courseNumber = Integer.parseInt(reader.readLine());

	    if (courseNumber > 0 && courseNumber <= courses.size()) {
	        Courses selectedCourse = courses.get(courseNumber - 1);
	        
	        // Display available teachers
	        Vector<Teacher> availableTeachers = Database.getInstance().getTeachers();
	        if (availableTeachers.isEmpty()) {
	            System.out.println("No teachers available to assign");
	            return;
	        }
	        
	        System.out.println("Available Teachers:");
	        for (int i = 0; i < availableTeachers.size(); i++) {
	            System.out.println((i + 1) + ". " + availableTeachers.get(i).getLogin());
	        }

	        // Prompt for lector selection
	        System.out.println("Select lector for the course:");
	        int lectorNumber = Integer.parseInt(reader.readLine());
	        if (lectorNumber > 0 && lectorNumber <= availableTeachers.size()) {
	            Teacher lector = availableTeachers.get(lectorNumber - 1);
	            HashMap<Courses,Teacher> teacherTocourse = Database.getInstance().someMethod();
	            Database.getInstance().setTeacherToCourse(selectedCourse, lector, teacherTocourse);
	        } else {
	            System.out.println("Invalid lector number.");
	            return;
	        }

	        // Prompt for practice teacher selection
	        System.out.println("Select practice teacher for the course:");
	        int practiceTeacherNumber = Integer.parseInt(reader.readLine());
	        if (practiceTeacherNumber > 0 && practiceTeacherNumber <= availableTeachers.size()) {
	            Teacher practiceTeacher = availableTeachers.get(practiceTeacherNumber - 1);
	            selectedCourse.setPracticeTeacher(practiceTeacher);
	        } else {
	            System.out.println("Invalid practice teacher number.");
	            return;
	        }

	        System.out.println("Teachers assigned to the course successfully.");
	        Database.getInstance().setTeachers(availableTeachers);
	    } else {
	        System.out.println("Invalid course number. Please enter a valid course number.");
	    }
	}
  
  public void viewTeachersCourse() {
	    Vector<Courses> courses = Database.getInstance().getCourses();

	    if (courses.isEmpty()) {
	        System.out.println("No courses available.");
	    } else {
	        for (Courses course : courses) {
	            String courseName = course.getCoursesName();
	            Teacher lector = course.getLector();
	            Teacher practiceTeacher = course.getPracticeTeacher();

	            System.out.println("Course: " + courseName);

	            if (lector != null) {
	                System.out.println("Lector: " + lector.getName());
	            } else {
	                System.out.println("Lector: Not assigned");
	            }

	            if (practiceTeacher != null) {
	                System.out.println("Practice Teacher: " + practiceTeacher.getName());
	            } else {
	                System.out.println("Practice Teacher: Not assigned");
	            }

	            System.out.println();
	        }
	    }
	}
  
  public double getAverageRating() throws NumberFormatException, IOException {
	    Vector<Teacher> availableTeachers = Database.getInstance().getTeachers();
	    if (availableTeachers.isEmpty()) {
	        System.out.println("No teachers available to assign");
	        return 0;
	    }

	    System.out.println("Available Teachers:");
	    for (int i = 0; i < availableTeachers.size(); i++) {
	        System.out.println((i + 1) + ". " + availableTeachers.get(i).getLogin());
	    }

	    int lectorNumber;
	    while (true) {
	        try {
	            System.out.println("Enter the number of the teacher to get their average rating:");
	            lectorNumber = Integer.parseInt(reader.readLine());
	            if (lectorNumber > 0 && lectorNumber <= availableTeachers.size()) {
	                break;
	            } else {
	                System.out.println("Invalid teacher number. Please enter a valid teacher number.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a number.");
	        }
	    }

	    Teacher lector = availableTeachers.get(lectorNumber - 1);

	    // Get the average rating using the Database method
	    double averageRating = 0.0; // Default value

	    try {
	        averageRating = Database.getInstance().getAverageRating(lector);
	        if (averageRating > 0) {
	            System.out.println("Average rating for " + lector.getLogin() + ": " + averageRating);
	        } else {
	            System.out.println("No rating available for " + lector.getLogin());
	        }
	    } catch (NullPointerException ex) {
	        System.out.println("Error: Unable to retrieve the average rating. The rating system might be unavailable.");
	        ex.printStackTrace(); // Handle or log the exception based on your requirements
	    }

	    return averageRating;
	}





  public void main() {
	    while (true) {
	        try {
	            print("0. Exit");
	            print("1. View news");
	            print("2. Change password");
	            print("3. View messages");
	            print("4. Send message");
	            print("5. Delete course");
	            print("6. Add course");
	            print("7. View courses");
	            print("8. View teacher's courses");
	            print("9. Add news");
	            print("10. Assign Teachers to course");
	            print("11. Get teacher rating");
	            String ans = reader.readLine();
	            switch (ans) {
	                case "0":
	                    return;
	                case "1":
	                    viewNews();
	                    break;
	                case "2":
	                    changePassword();
	                    break;
	                case "3":
	                    viewMessages();
	                    break;
	                case "4":
	                    sendMessage();
	                    break;
	                case "5":
	                    deleteCourse();
	                    break;
	                case "6":
	                    addCourse();
	                    break;
	                case "7":
	                    viewCourses(); 
	                    break;
	                case "8":
	                    viewTeachersCourse(); 
	                    break;	                    
	                case "9":
	                    addNews(); 
	                    break;
	                case "10":
	                	assignTeacherToCourse();
	                    break;
	                case "11":
	                	getAverageRating();
	                    break;
	                    
	                default:
	                    print("No such option");
	                    break;
	            }
	        } catch (IOException ioe) {
	            System.out.println("Error");
	        }
	    }
	}

}
