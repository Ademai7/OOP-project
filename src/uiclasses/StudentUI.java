package uiclasses;

import java.io.IOException;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

import main.Database;
import courses.Courses;
import users.Researcher;
import users.Student;
import users.Teacher;

public class StudentUI extends UserUI {

    public StudentUI() {
        super();
    }

    public StudentUI(Student student) {
        super(student);
    }

    public void viewAttendance() throws IOException {
        // если успеем...
    }

    public void researcherMenu() {
        Vector<Researcher> researchers = Database.getInstance().getResearchers();
        int index = researchers.indexOf(user);
        Researcher r;
        if (index == -1) {
            r = new Researcher((Student) user);
        } else {
        	r = researchers.get(index);
        }
        new ResearcherUI(r).main();
    }

    public void register() throws IOException {
        Set<Courses> studentCourses = ((Student) user).getCourses().keySet();
        while (true) {
            Set<Courses> registration = Database.getInstance()
                    .getCourses().stream()
                    .filter(c -> !studentCourses.contains(c))
                    .collect(Collectors.toSet());
            for (Courses c : registration) {
                System.out.println(c.toString());
            }
            System.out.println("Insert name of course you want to register or 0 to exit");
            final String courseString = reader.readLine();
            if (courseString.equals("0")) {
                return;
            }
            try {
                Courses course = registration.stream()
                        .filter(c -> c.getCoursesName().equals(courseString))
                        .collect(Collectors.toList()).get(0);
                if (((Student) user).register(course)) {
                    System.out.println("Registered successfully");
                } else {
                    System.out.println("Cannot register");
                }
            } catch (IndexOutOfBoundsException ioobe) {
                System.out.println("No such course");
            }
        }
    }

    public void viewMarks() throws IOException {
        for (Courses c : ((Student) user).getCourses().keySet()) {
            System.out.println(c.toString() + ((Student) user).getCurrentMarks().get(c).toString());
        }
    }

    public void dropCourse() throws IOException {
        while (true) {
            System.out.println("Here is the list of your courses: ");
            Set<Courses> courses = ((Student) user).getCourses().keySet();
            for (Courses cur : courses) {
                System.out.println(cur.toString());
            }
            System.out.println("Insert name of course you want to drop or 0 to exit");
            final String ans = reader.readLine();
            if (ans.equals("0")) {
                return;
            }
            try {
                Courses course = courses.stream()
                        .filter(c -> c.getCoursesName().equals(ans))
                        .collect(Collectors.toList()).get(0);
                ((Student) user).dropCourse(course);
                System.out.println("Course dropped successfully");
            } catch (IndexOutOfBoundsException ioobe) {
                System.out.println("No such option");
            }
        }
    }
    
    public void rateTeacher() throws IOException {
        Vector<Teacher> teachers = Database.getInstance().getTeachers();
        if (teachers.isEmpty()) {
            System.out.println("No teachers available to rate.");
            return;
        }

        System.out.println("Available Teachers:");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i + 1) + ". " + teachers.get(i).getLogin());
        }

        System.out.println("Select the number of the teacher to rate:");
        int teacherNumber = Integer.parseInt(reader.readLine());

        if (teacherNumber > 0 && teacherNumber <= teachers.size()) {
            Teacher teacher = teachers.get(teacherNumber - 1);
            int rating;

            try {
                System.out.println("Enter your rating for " + teacher.getLogin() + " (out of 10):");
                rating = Integer.parseInt(reader.readLine());

                if (rating < 0 || rating > 10) {
                    System.out.println("Invalid rating. Please enter a number between 0 and 10.");
                    return;
                }

                // Call the appropriate method to handle rating in the Teacher class
                Database.getInstance().setTeacherRatings(teacher, rating);
                

                System.out.println("Rating submitted successfully.");
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } else {
            System.out.println("Invalid teacher number.");
        }
    }
    
    public void viewCourses() {
        Set<Courses> studentCourses = ((Student) user).getCourses().keySet();
        Set<Courses> registeredCourses = Database.getInstance().getCourses().stream()
                .filter(c -> studentCourses.contains(c))
                .collect(Collectors.toSet());

        if (registeredCourses.isEmpty()) {
            System.out.println("No registered courses available.");
        } else {
            System.out.println("Registered Courses:");
            for (Courses course : registeredCourses) {
                System.out.println(course.toString());
            }
        }
    }


    public void main() {
        while (true) {
            try {
                System.out.println("0. Exit");
                System.out.println("1. View news");
                System.out.println("2. Change password");
                System.out.println("3. View courses");
                System.out.println("4. Register to a course");
                System.out.println("5. Drop course");
                System.out.println("6. View marks");
                System.out.println("8. Become a researcher");
                System.out.println("9. Rate teacher");
                
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
                    	viewCourses();
                        break;
                    case "4":
                        register();
                        break;
                    case "5":
                        dropCourse();
                        break;
                    case "6":
                        viewMarks();
                        break;
                    case "8":
                        researcherMenu();
                        break;
                    case "9":
                        rateTeacher();
                        break;
                    default:
                        System.out.println("Not found");
                }
            } catch (IOException ioe) {
                System.out.println("Something is wrong");
            }
        }
    }
}
