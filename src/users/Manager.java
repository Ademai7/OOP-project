package users;

import java.util.Vector;

import courses.Courses;
import enums.ManagerType;
import enums.UserRole;
import main.Database;
import unisystem2023.News;

public class Manager extends Employee{

	private static final long serialVersionUID = 1L;
	static final UserRole role = UserRole.MANAGER;
    private ManagerType type;
    
    public Manager(){
		super();
	}

	public Manager(String login, String password){
		super(login, password);
	}

    

	private ManagerType getType() {
        return this.type;
    }

    private void setType(ManagerType type) {
        this.type = type;
    }
    
    public void CourseToLector(Courses course, Teacher teacher) {
    	course.setLector(teacher);	
	}
	
	public void CourseToPracticer(Courses course, Teacher teacher){
		course.setPracticeTeacher(teacher);
	}

    public Vector<Courses> viewCourses() {
        return Database.getInstance().getCourses();
    }
    
    public void addNews(String newsTitle, String content) {
        News newsItem = new News(newsTitle, content);
        Database.getInstance().addNews(newsItem);
        System.out.println("News added successfully");
    }


    public void deleteNews(News newsTitle) {
        if (Database.getInstance().getNews().contains(newsTitle)) {
            Database.getInstance().deleteNews(newsTitle);
            System.out.println("News deleted successfully");
        } else {
            System.out.println("News not found");
        }
    }
    
    
   
    
    public void openRegistrationForCourse(Courses course) {
        course.setRegistrationOpen(true); // Открыть регистрацию для курса
        System.out.println("Registration for course " + course.getCoursesName() + " is now open.");
    }
    

    public void openRegistration(Courses course) {
        if (Database.getInstance().getCourses().contains(course)) {
            if (!course.isRegistrationOpen()) {
                Vector<Student> registeredStudents = Database.getInstance().getRegisteredStudents();
                if (registeredStudents.size() < 100) {
                    course.setRegistrationOpen(true);
                    System.out.println("Registration for the course '" + course.getCoursesName() + "' is now open.");
                } else {
                    System.out.println("The maximum number of students (100) for this course has been reached. Cannot open registration.");
                }
            } else {
                System.out.println("Registration for the course '" + course.getCoursesName() + "' is already open.");
            }
        } else {
            System.out.println("Course not found in the database.");
        }
    }

    public void closeRegistration(Courses course) {
        if (Database.getInstance().getCourses().contains(course)) {
            if (course.isRegistrationOpen()) {
                course.setRegistrationOpen(false);
                System.out.println("Registration for the course '" + course.getCoursesName() + "' is now closed.");
            } else {
                System.out.println("Registration for the course '" + course.getCoursesName() + "' is already closed.");
            }
        } else {
            System.out.println("Course not found in the database.");
        }
    }

    public void approveRegistration(Courses course, Student student) {
        if (Database.getInstance().getCourses().contains(course)) {
            if (course.isRegistrationOpen()) {
                Vector<Student> registeredStudents = Database.getInstance().getRegisteredStudents();
                if (!registeredStudents.contains(student)) {
                    registeredStudents.add(student);
                    System.out.println("Student '" + student.getName() + "' approved for the course '" + course.getCoursesName() + "'.");
                } else {
                    System.out.println("Student '" + student.getName() + "' is already registered for the course '" + course.getCoursesName() + "'.");
                }
            } else {
                System.out.println("Registration for the course '" + course.getCoursesName() + "' is closed. Cannot approve registration.");
            }
        } else {
            System.out.println("Course not found in the database.");
        }
    }
    
	@Override
	public Researcher becomeResearcher(){
		return new Researcher(this);
	}
	
	public UserRole getRole() {
        return role;
    }
     
}

