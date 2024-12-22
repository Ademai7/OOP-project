package wsp;

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
 * The Teacher class represents a teacher in the system. Teachers are associated
 * with a specific faculty and can teach multiple courses. They can also conduct lessons
 * and provide marks to students.
 */
public class Teacher extends Employee implements Serializable {

    private TeacherTitle typeTeacher;
    private Vector <Course> courses = new Vector<Course>();
    private Faculty faculty;
    private Map<Course, Vector<Lesson>> lessons = new HashMap <Course, Vector<Lesson>>();
    private Vector<Double> rate;

    
    /**
     * Constructs a Teacher object with the specified attributes.
     * if the created teacher is a professor, then a researcher is automatically added.
     *
     * @param username    The username of the teacher.
     * @param password    The password of the teacher.
     * @param firstName   The first name of the teacher.
     * @param lastName    The last name of the teacher.
     * @param typeTeacher The title of the teacher (e.g., TUTOR, PROFESSOR).
     * @param faculty     The faculty to which the teacher belongs.
     */
    public Teacher(String username, String password, String firstName, String lastName, TeacherTitle typeTeacher,
                   Faculty faculty) {
        super(username, password, firstName, lastName);
        this.typeTeacher = typeTeacher;
        if(typeTeacher == TeacherTitle.PROFESSOR) {
        	Researcher<Teacher> researcher = new Researcher<>(this);
            Database.getInstance().addResearcher(researcher);
        }
        this.faculty = faculty;
        this.rate = new Vector<>();
    }


    public TeacherTitle getTypeTeacher() {
        return typeTeacher;
    }
    
    /**
     * Gets the courses taught by the teacher.
     *
     * @return A vector containing the courses taught by the teacher.
     */
    public Vector<Course> getCourses() {
        return courses;
    }

    
    /**
     * Gets the faculty to which the teacher belongs.
     *
     * @return The faculty of the teacher.
     */
    public Faculty getFaculty() {
        return faculty;
    }

    
    /**
     * Gets the lessons conducted by the teacher for each course.
     *
     * @return A map where each course is associated with a vector of lessons.
     */
    public Map<Course, Vector<Lesson>> getLessons() {
        return lessons;
    }
    
    
    /**
     * Gets the average rating of the teacher.
     *
     * @return The average rating of the teacher.
     */
    public double getRate() {
    	double sum = 0;
    	for(Double i : this.rate) {
    		sum += i;
    	}
        return sum/this.rate.size();
    }

    public void setTypeTeacher(TeacherTitle typeTeacher) {
        this.typeTeacher = typeTeacher;
    }

    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setLessons(Map<Course, Vector<Lesson>> lessons) {
        this.lessons = lessons;
    }
    
    /**
     * Adds a rating to the teacher's list of ratings.
     *
     * @param rate The rating to be added.
     */
    public void setRate(double rate) {
        this.rate.add(rate);
    }

    
    /**
     * Displays the courses taught by the teacher.
     */
    public void viewCourses() {
    	this.getLanguage().courseTaughtBy(this.getFirstName());
        for (Course course : courses) {
            System.out.println("- " + course.getName());
        }
        Database.getInstance().addLog(this, new Log("Teacher " + this.getUsername() + " viewed his courses"));
    }
    
    
    /**
     * Displays the students enrolled in a specific course taught by the teacher.
     */
    public void viewStudents() {
        if (courses.isEmpty()) {
        	this.getLanguage().noCourses();
            return;
        }
        
        this.getLanguage().enterTheCourse();
        for (int i = 0; i<courses.size(); i++) {
    		Course c = courses.get(i);
    		System.out.println((i + 1) + ". " + c.getName());
    	}
    	System.out.println();

    	this.getLanguage().enterYourChoice();
    	this.getLanguage().enterReturnBack();
        int courseChoice = StaticMethods.validate(courses.size());

        if (courseChoice == 0) {
            return;
        }

        Course selectedCourse = courses.get(courseChoice-1);

        Vector<Student> students = Database.getInstance().getStudents();

        this.getLanguage().studentsEnrolledIn(selectedCourse.getName());
        for (Student student : students) {
            if (student.getCourses().contains(selectedCourse)) {
                System.out.println("- " + student.getUsername());
            }
        }
        Database.getInstance().addLog(this, new Log("Teacher " + this.getUsername() + " viewed students by course " + selectedCourse.getName()));
    }
    
    
    /**
	 * Displays the marks for the course taught by the teacher.
	 */
    public void viewMarks() {
        if(courses.isEmpty()) {
        	this.getLanguage().noCourses();
            return;
        }
        
        this.getLanguage().enterYourChoice();
        StaticMethods.printList(courses);
        
        this.getLanguage().enterReturnBack();
        int courseChoice = StaticMethods.validate(courses.size());
        
        if(courseChoice == 0) {
        	return;
        }
        
        Course selectedCourse = courses.get(courseChoice-1);
        viewMarks(selectedCourse);


    }

	
    /**
	 * Changes the information of the teacher such as username, password, first name, or last name.
	 */
    public void changeInfo() {
    	this.getLanguage().whatDoYouWantToChange();
		
		String[] options = this.getLanguage().changeInfoOptions();
		
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

    
    /**
	 * Displays the marks for a specific course taught by the teacher.
	 *
	 * @param selectedCourse The course for which to display the marks.
	 */
    public void viewMarks(Course selectedCourse) {

        if (!lessons.containsKey(selectedCourse)) {
        	this.getLanguage().noLessonsForThisCourse();
            return;
        }
        
        this.getLanguage().marksFor(selectedCourse.getName());
        for (Student student : Database.getInstance().getStudents()) {
            if (student.getCourses().contains(selectedCourse)) {
                Mark mark = student.getTranscript().get(selectedCourse);
                System.out.println(student.getUsername() + ": " + (mark != null ? mark.toString() : "No marks"));
            }
        }
        Database.getInstance().addLog(this, new Log("Teacher " + this.getUsername() + " viewed marks by course " + selectedCourse.getName()));
    }

    
    /**
	 * Allows the teacher to input marks for students in a specific course.
	 */
    public void putMarks() {
    	this.getLanguage().selectSCourseToInputMarks();
    	
    	if(courses.isEmpty()) {
    		this.getLanguage().yourAreNotAssignedToAnyCourses();
    		return;
    	}

    	for (int i = 0; i<courses.size(); i++) {
    		Course c = courses.get(i);
    		System.out.println((i + 1) + ". " + c.getName());
    	}
    	System.out.println();
    	
    	int courseChoice = StaticMethods.validate(courses.size());
    	
    	if (courseChoice == 0) {
    		return;
    	}
    	Course selectedCourse = courses.get(courseChoice-1);
    	
    	Vector <Lesson> courseLessons = lessons.get(selectedCourse);
    	if (courseLessons.isEmpty()) {
    		this.getLanguage().noLessonsRecordedForTheCourse();
    		return;
    	}
    	
    	
    	Vector <Student> students = Database.getInstance().getStudents().stream()
    			.filter(s -> s.getCourses().contains(selectedCourse))
    			.collect(Collectors.toCollection(Vector::new));
    			
    	if(students.isEmpty()) {
    		this.getLanguage().noStudentEnrolledIn(selectedCourse.getName());
    		return;
    	}
    	
    	this.getLanguage().selectAStudentToInputMarks();
    	this.getLanguage().studentsEnrolledIn(selectedCourse.getName());
    	
    	StaticMethods.printList(students);
    	
    	this.getLanguage().chooseAStudentOrExit();
    	int studentChoice = StaticMethods.validate(students.size());
    	
    	if (studentChoice == 0) {
    		return;
    	}
    	Student selectedStudent = Database.getInstance().getStudents().get(studentChoice-1);
    	
    	Mark previousMark = selectedStudent.getTranscript().get(selectedCourse);
    	
    	if(previousMark.getAtt() != null) {
    		this.getLanguage().previousMarksForStudent(selectedStudent.getFirstName(), previousMark.toString());
    	}
    	else {
    		this.getLanguage().newMarksForStudents(selectedStudent.getFirstName());
    		
    		Scanner input = new Scanner(System.in);
    		
        	while(true) {
        		try {
        			this.getLanguage().firstAttestation();
            		double attestation1 = Math.abs(input.nextDouble());
            		
            		this.getLanguage().secondAttestation();
            		double attestation2 = Math.abs(input.nextDouble());
            		
            		this.getLanguage().finalExam();
            		double finalExam = Math.abs(input.nextDouble());
            		
            		if(attestation1 + attestation2 > 60 || finalExam > 40) {
            			this.getLanguage().ErrorPleaseEnterMarksCorrectly();
            		}
            		else {
            			Mark newMark = new Mark(attestation1, attestation2, finalExam);
            			selectedStudent.getTranscript().put(selectedCourse, newMark);
            			this.getLanguage().theMarksHaveBennSubmittedSuccesfully();
                        Database.getInstance().addLog(this, new Log("Teacher " + this.getUsername() + " gave the student " + selectedStudent.getUsername() + " by course " + selectedCourse.getName()));
            			break;
            		}
        		}
        		catch(InputMismatchException e) {
        			this.getLanguage().ErrorPleaseEnterMarksCorrectly();
        			input.nextLine();
        		}	
        	}
    	}
    }
    
    
    /**
     * Displays the teacher's menu, allowing them to perform various actions such as viewing courses, students,
     * marks, putting marks, viewing rate, viewing news, sending orders and requests, viewing papers, and exiting.
     * If the teacher is also a researcher, an additional option to view the researcher menu is available.
     */
    @Override
    public void viewMenu() {
    	
    	String[] options;
    	
    	Researcher researcher = Database.getInstance().isResearcher(this);
    	
    	
    	
    	
    	while (true) {
    		
    		if(researcher == null) {
        		options = this.getLanguage().teacherMenu();
        	}
        	else {
        		options = this.getLanguage().teacherResearcherMenu();
        	}
    		
    		System.out.println();
    		this.getLanguage().teacherHeader();
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
    		else if (choice == 5) {
    			viewRate();
    		}
    		else if (choice == 6) {
    			viewOneNews();
                Database.getInstance().addLog(this, new Log("Teacher " + this.getUsername() + " viewed a one News"));
    		}
    		else if (choice == 7) {
    			sendRequest();
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
    		}
    		else if(researcher != null) {
				if(choice == 13) {
					researcher.viewMenu();
                    Database.getInstance().addLog(this, new Log("Teacher " + this.getUsername() + " went to the researcher menu"));
				}
			}
    	}
    }

    /**
     * Displays the teacher's rating.
     */
    public void viewRate() {
        this.getLanguage().teachersRating(getRate());
    }


	@Override
	public String toString() {
		return "Teacher [typeTeacher=" + typeTeacher + " courses=" + lessons + ", faculty=" + this.faculty + "] " + super.toString();
	}

    
    

}
