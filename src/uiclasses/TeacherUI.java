package uiclasses;

import java.io.IOException;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

import main.Database;
import courses.Courses;
import exceptions.AttMarksOutOfRangeException;
import exceptions.FinalExamMarkOutOfRangeException;
import unisystem2023.Mark;
import users.Researcher;
import users.Student;
import users.Teacher;

public class TeacherUI extends EmployeeUI{

	public TeacherUI(){
		super();
	}

	public TeacherUI(Teacher teacher){
		super(teacher);
	}
	public List<Courses> viewCourses() throws IOException {
	    List<Courses> courses = Database.getInstance().getTeacherCourses((Teacher) user);
	    for (Courses cur : courses) {
	        String lectorOrPractice = "";
	        if (cur.getLector() != null && cur.getLector().equals((Teacher) user)) {
	            lectorOrPractice += "Lector";
	        }
	        if (cur.getPracticeTeacher() != null && cur.getPracticeTeacher().equals((Teacher) user)) {
	            if (!lectorOrPractice.isEmpty()) {
	                lectorOrPractice += " / Practice Teacher";
	            } else {
	                lectorOrPractice += "Practice Teacher";
	            }
	        }
	        if (!lectorOrPractice.isEmpty()) {
	            lectorOrPractice = " (" + lectorOrPractice + ")";
	        }
	        print(cur.toString() + lectorOrPractice);
	    }
	    return courses;
	}



	public List<Student> viewStudents(Courses c) throws IOException {
	    List<Student> students = Database.getInstance().getAllUsers().stream()
	            .filter(u -> u instanceof Student && ((Student) u).getCourses().containsKey(c))
	            .map(s -> (Student) s)
	            .collect(Collectors.toList());

	    for (Student s : students) {
	        print(s.toString());
	    }
	    return students;
	}

	
    public void researcherMenu() {
        Vector<Researcher> researchers = Database.getInstance().getResearchers();
        int index = researchers.indexOf(user);
        Researcher r;
        if (index == -1) {
            r = new Researcher((Teacher) user);
        } else {
        	r = researchers.get(index);
        }
        new ResearcherUI(r).main();
    }

    public void putMark() throws IOException {
        Courses course;
        while (true) {
            List<Courses> courses = viewCourses();
            print("Insert your course name. Insert 0 to exit");
            final String ans = reader.readLine();
            if (ans.equals("0")) {
                return;
            }
            try {
                course = courses.stream()
                        .filter(c -> c.getCoursesName().equals(ans))
                        .collect(Collectors.toList()).get(0);
                break;
            } catch (IndexOutOfBoundsException ioobe) {
                print("No such course");
            }
        }
        while (true) {
            List<Student> students = viewStudents(course);
            print("Insert student's login to put mark to. Insert 0 to exit");
            final String ans = reader.readLine();
            if (ans.equals("0")) {
                return;
            }
            Student student;
            try {
                student = students.stream()
                        .filter(s -> s.getLogin().equals(ans))
                        .collect(Collectors.toList()).get(0);
            } catch (IndexOutOfBoundsException ioobe) {
                print("No such student");
                continue;
            }

            // Check if the student has a mark for the course; if not, initialize it
            if (!student.getCurrentMarks().containsKey(course)) {
                student.getCurrentMarks().put(course, new Mark());
            }

            print("Insert marks");
            double points = Double.parseDouble(reader.readLine());
            print("Insert 0 to put first attestation");
            print("Insert 1 to put second attestation");
            print("Insert 2 to put final exam's mark");
            String choose = reader.readLine();
            switch (choose) {
                case "0":
                    try {
                        checkMarkRange(points);
                        student.getCurrentMarks().get(course).setAtt1(points);
                    } catch (AttMarksOutOfRangeException e) {
                        print(e.getMessage());
                    }
                    break;
                case "1":
                    try {
                        checkMarkRange(points);
                        student.getCurrentMarks().get(course).setAtt2(points);
                    } catch (AttMarksOutOfRangeException e) {
                        print(e.getMessage());
                    }
                    break;
                case "2":
                    try {
                        checkFinalExamRange(points);
                        student.getCurrentMarks().get(course).setFinalExam(points);
                    } catch (FinalExamMarkOutOfRangeException e) {
                        print(e.getMessage());
                    }
                    break;
                default:
                    print("Error. Try again");
            }
        }
    }

	
	private void checkMarkRange(double marks) throws AttMarksOutOfRangeException {
        if (marks > 30) {
            throw new AttMarksOutOfRangeException("Marks should not exceed 30.");
        }
    }

    private void checkFinalExamRange(double finalExamMark) throws FinalExamMarkOutOfRangeException {
        if (finalExamMark > 40) {
            throw new FinalExamMarkOutOfRangeException("Final exam mark should not exceed 40.");
        }
    }
    
    
    
    
    
    
    

	public void main(){
		while(true){
			try{
				print("0. Exit");
				print("1. View news");
				print("2. Change password");
				print("3. View messages");
				print("4. Send message");
				print("5. View courses");
                print("6. Put mark");
                print("7. Become a reseracher");
				String ans = reader.readLine();
				switch(ans){
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
						viewCourses();
						break;
                    case "6":
						putMark();
						break;
                    case "7":
						researcherMenu();
						break;
					default:
						print("No such option");
				}
			}
			catch (IOException ioe){
				System.out.println("Error");
			}
		}
	}

}

