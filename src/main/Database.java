package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;
import courses.Courses;
import enums.OrderStatus;
import unisystem2023.Message;
import unisystem2023.News;
import unisystem2023.ResearchPaper;
import users.*;

public final class Database implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Database instance;

    private Vector<User> users;
    private Vector<Employee> employees;
    private Vector<Student> students;
    private Vector<PhDStudent> phdstudents;
    private Vector<Teacher> teachers;
    private Vector<Courses> courses;
    private Vector<Manager> managers;
    private Vector<TechSupportSpecialist> techSupportSpecialists;
    private Admin admin;
    private Vector<News> news;
    private Vector<Researcher> researchers;
    private Vector<Student> registeredStudents;
    private Vector<ResearchPaper> researchPapers;
    private Vector<Message> messages;
    private static HashMap<String, OrderStatus> tasks;
    private HashMap<Courses,Teacher> teacherToCourse;
    private HashMap<Teacher, int[]> teacherRatings;
    
   
    private Database() {
        users = new Vector<>();
        employees = new Vector<>();
        students = new Vector<>();
        teachers = new Vector<>();
        courses = new Vector<>();
        managers = new Vector<>();
        techSupportSpecialists = new Vector<>();
        news = new Vector<>();
        researchers = new Vector<>();
        registeredStudents = new Vector <>();
        messages = new Vector <>();
        researchPapers = new Vector <>();
        tasks = new HashMap<String, OrderStatus>();
        teacherToCourse = new HashMap<>();
        teacherRatings = new HashMap<>();
    }
    public void setTeacherRatings(Teacher teacher, int rate) {
        // Check if the teacherRatings map is null and initialize it if needed
        if (teacherRatings == null) {
            teacherRatings = new HashMap<>();
        }
        
        // Check if the teacher is already in the map
        if (teacherRatings.containsKey(teacher)) {
            // If yes, update the sum and counter
            int[] ratings = teacherRatings.get(teacher);
            ratings[0] += rate; // Update the sum
            ratings[1] += 1;    // Increment the counter
        } else {
            // If no, create a new array with the rate and counter and put it in the map
            int[] ratings = {rate, 1};
            teacherRatings.put(teacher, ratings);
        }
    }


    public double getAverageRating(Teacher teacher) {
        if (teacherRatings.containsKey(teacher)) {
            int[] ratings = teacherRatings.get(teacher);
            return (double) ratings[0] / ratings[1];
        } else {
            return 0.0; // or -1.0 or any other default value as per your requirement
        }
    }


    public static Database getInstance() {
        if (instance == null) {
            if (new File("ourbd.ser").exists()) {
                try {
                    instance = readDB();
                } catch (Exception e) {
                    e.printStackTrace();
                    instance = new Database();
                }
            } else {
                instance = new Database();
            }
        }
        return instance;
    }

    // Getter methods
    public Vector<User> getAllUsers() {
        return users;
    }
    
    public void setTeacherToCourse(Courses course,Teacher teacher, HashMap<Courses,Teacher> teacherToCourse) {
    	teacherToCourse.put(course, teacher);
    }
    public HashMap<Courses,Teacher> someMethod() {
    	return teacherToCourse;
    }
    
    public User getUser(String login, String password) {
        return users.stream()
                .filter(user -> user.verify(login, password))
                .findFirst()
                .orElse(null);
    }
    //гет юзер с именем сделать
    
    
    public Vector<Employee> getEmployees() {
        return employees;
    }

    public Vector<Student> getStudents() {
        return students;
    }

    public Vector<Teacher> getTeachers() {
        return teachers;
    }

    public Vector<Courses> getCourses() {
        return courses;
    }

    public Vector<Manager> getManagers() {
        return managers;
    }

    public Vector<TechSupportSpecialist> getTechSupportSpecialist() {
        return techSupportSpecialists;
    }

    public Admin getAdmin() {
        return admin;
    }

    public Vector<News> getNews() {
        return news;
    }

    public Vector<Researcher> getResearchers() {
        return researchers;
    }
    
    public void addResearcher(Researcher researcher) {
        researchers.add(researcher);
    }
    
    public Vector<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    // Добавить студента в список зарегистрированных
    public void registerStudent(Student student) {
        registeredStudents.add(student);
    }

    // Setter methods
    public void setUsers(Vector<User> users) {
        this.users = users;
    }

    public void setEmployees(Vector<Employee> employees) {
        this.employees = employees;
    }
    
    public void setResearchers(Vector<Researcher> researchers) {
        this.researchers = researchers;
    }


    public void setStudents(Vector<Student> students) {
        this.students = students;
    }

    public void setTeachers(Vector<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setCourses(Vector<Courses> courses) {
        this.courses = courses;
    }

    public void setManagers(Vector<Manager> managers) {
        this.managers = managers;
    }

    public void setTechSupportSpecialist(Vector<TechSupportSpecialist> techSupportSpecialists) {
        this.techSupportSpecialists = techSupportSpecialists;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setNews(Vector<News> news) {
        this.news = news;
    }
    
    public void addTechSupportSpecialist(TechSupportSpecialist techSupportSpecialist) {
        techSupportSpecialists.add(techSupportSpecialist);
        users.add(techSupportSpecialist);
    }

    // Method to remove a TechSupportSpecialist from the database
    public void removeTechSupportSpecialist(TechSupportSpecialist techSupportSpecialist) {
        techSupportSpecialists.remove(techSupportSpecialist);
        users.remove(techSupportSpecialist);
    }


    // Add methods
    public void addUser(User user) {
        users.add(user);
        if (user instanceof Student) students.add((Student) user);
        else if (user instanceof Teacher) teachers.add((Teacher) user);
        else if (user instanceof Manager) managers.add((Manager) user);
        else if (user instanceof Employee) employees.add((Employee) user);
        else if (user instanceof PhDStudent) phdstudents.add((PhDStudent) user);
        else if (user instanceof TechSupportSpecialist) techSupportSpecialists.add((TechSupportSpecialist) user);
        
   
        
        
    }

    public void addCourse(Courses course) {
        courses.add(course);
    }

    public void addNews(News newsItem) {
        news.add(newsItem);
    }

    // Delete methods
    public void deleteUser(User user) {
        users.remove(user);
        if (user instanceof Student) students.remove(user);
        else if (user instanceof Teacher) teachers.remove(user);
        else if (user instanceof Manager) managers.remove((Manager) user);
        else if (user instanceof Employee) employees.remove((Employee) user);
        else if (user instanceof PhDStudent) phdstudents.remove((PhDStudent) user);
        else if (user instanceof TechSupportSpecialist) techSupportSpecialists.remove((TechSupportSpecialist) user);
        
   
        
        
        
        
    }

    public void deleteCourse(Courses course) {
        courses.remove(course);
    }

    public void deleteNews(News newsItem) {
        news.remove(newsItem);
    }

   

    public static synchronized void saveDB() throws Exception {
        FileOutputStream fos = new FileOutputStream("ourbd.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(instance);
        oos.close();
        fos.close();
    }
    private static synchronized Database readDB() throws Exception {
        FileInputStream fis = new FileInputStream("ourbd.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Database system = (Database) ois.readObject();
        ois.close();
        fis.close();
        return system;
    }
    
    public Map<String, OrderStatus> getTasks() {
        if (tasks == null) {
            tasks = new HashMap<>();
        }
        return tasks;
    }

    
    public List<Courses> getTeacherCourses(Teacher t){
    	return courses.stream().filter(c -> c.getLector().equals(t) || c.getPracticeTeacher().equals(t)).collect(Collectors.toList());
    }
}