 package database;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;
import java.util.stream.Collectors;

import wsp.*;
import utils.*;

/**
 * The Database class represents the storage for various entities in the system.
 */
public class Database implements Serializable {

    private static Database INSTANCE;

    private static final long serialVersionUID = 4496003716159423929L;

    private Vector<Admin> admins = new Vector<Admin>();

    private Vector<User> users = new Vector<User>();

    private Vector<Student> students = new Vector<Student>();
    private Vector<Employee> employees = new Vector<Employee>();
    private Vector<Course> courses = new Vector<Course>();
    private Vector<News> news = new Vector<News>();
    private Vector<Request> requests = new Vector<Request>();
    private Vector<FinanceManager> financeManagers = new Vector<FinanceManager>();
    private Vector<FinanceOffice> financeOffices = new Vector<>();
    private HashMap<User, Vector<Log>> userLogs = new HashMap<User, Vector<Log>>();
    private Vector<Researcher> researchers = new Vector<Researcher>();
    private Vector<ResearchJournal> journals = new Vector<ResearchJournal>();
    private Vector<Organisation> organisations = new Vector<Organisation>();
    private Vector<ResearchPaper> papers = new Vector<ResearchPaper>();
    private Vector<ResearchProject> projects = new Vector<ResearchProject>();

    /**
    * Static block to initialize the singleton instance of the Database.
    * If the serialized database file exists, it is loaded. Otherwise, a new instance is created.
    */
    static{
        if(new File("database.ser").exists()) {
            try {
                INSTANCE = loadDatabase();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else {
            INSTANCE = new Database();
            INSTANCE.initializeDefaultAdmin();
        }
    }


    private Database() {
    }

    /**
     * Retrieves the singleton instance of the Database.
     * 
     * @return The singleton instance of the Database.
     */
    public static Database getInstance() {
        return INSTANCE;
    }
    
    /**
     * Loads the serialized database from the file.
     * 
     * @return The deserialized Database instance.
     * @throws IOException            If an I/O error occurs while reading the file.
     */
    private static Database loadDatabase() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("database.ser"));
        return (Database) ois.readObject();
    }
    
    /**
     * Saves the current state of the database by serializing it to a file.
     * 
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public void saveDatabase() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("database.ser"));
        oos.writeObject(INSTANCE);
        oos.close();
    }
    
    /**
    * This method is automatically called during the initialization of the Database singleton.
    * The default administrator is added only if the database is empty.
    */
    private void initializeDefaultAdmin() {
        Admin defaultAdmin = new Admin("Admin", "KBTU", "AdminName", "AdminSurname");
        addAdmin(defaultAdmin);
    }
    
    /**
     * The method for logging in system
     */
    public void login() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        User authentificatedUser = null;

        authentification:
        while(true) {
            try {
                System.out.println("Введите имя пользоваля: ");
                String username = reader.readLine();

                System.out.println("Введите пароль: ");
                String password = reader.readLine();

                for(User u : this.users) {
                    if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
                        authentificatedUser = u;
                        break authentification;
                    }
                }

                System.out.println("Логин или пароль неверные!");

            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }

        authentificatedUser.authentification();

    }
    
    /**
     * Method to get all users without admin
     * @return all users without admin
     */
    public Vector<User> getUsers() {
    	Vector<User> withoutAdmin = (Vector<User>) this.users.clone();
    	withoutAdmin.removeAll(this.admins);
        return withoutAdmin;
    }
    public Student getStudentByUsername(String username) {
        for (Student student : this.students) {
            if (student.getUsername().equals(username)) {
                return student;
            }
        }
        return null; // Return null if no student with the given username is found
    }
    

    public Vector<Student> getStudents() {
        return students;
    }

    public Vector<Employee> getEmployees() {
        return employees;
    }

    public Vector<Course> getCourses() {
        return courses;
    }

    public Vector<News> getNews() {
    	
        return news;
    }

    public Vector<Request> getRequests() {
        return requests;
    }

//    public Vector<Order> getOrders() {
//        return orders;
//    }

    public Vector<Researcher> getResearchers() {
        return researchers;
    }
    
    /**
     * Method to get the most cited researcher
     * @return Top cited researcher
     */
    public Researcher getTopCitedResearcher() {
    	Collections.sort(this.researchers, new ResearcherCitationsComparator());
    	if(researchers.isEmpty()) {
    		return null;
    	}
    	return researchers.lastElement();
    }
    
    /**
     * Retrieves and prints the list of research papers based on the user's sorting preference.
     * The user is prompted to choose the sorting order:
     * 1. Sorted by date
     * 2. Sorted by citations
     * 3. Sorted by the number of pages
     * The sorted list of papers is then printed to the console.
     */
    public void getAllPapers() {
    	System.out.println("In which order do you want to get papers?");
    	System.out.println("1. Sorted by date");
    	System.out.println("2. Sorted by citations");
    	System.out.println("3. Sorted by number of pages");
    	
    	int choice = StaticMethods.validate(1, 3);
    	
    	if(choice == 1) {
    		Collections.sort(this.papers, new PaperDateComparator());
    		StaticMethods.printList(papers);
    		return;
    	}
    	if(choice == 2) {
    		Collections.sort(this.papers, new PaperCitationsComparator());
    		StaticMethods.printList(papers);
    		return;
    	}
    	if(choice == 3) {
    		Collections.sort(this.papers, new PaperPagesComparator());
    		StaticMethods.printList(papers);
    		return;
    	}
    }
    public Employee getEmployeeByUsername(String username) {
        for (Employee employee : this.employees) {
            if (employee.getUsername().equals(username)) {
                return employee;
            }
        }
        return null; // Return null if no student with the given username is found
    }
    public Vector<Teacher> getTeachers(){
        Vector<Teacher> teachers = employees.stream()
                .filter(employee -> employee instanceof Teacher)
                .map(employee -> (Teacher) employee)
                .collect(Collectors.toCollection(Vector::new));

        return teachers;
    }

    public Vector<Dean> getDeans() {
        Vector<Dean> deans = employees.stream()
                .filter(employee -> employee instanceof Dean)
                .map(employee -> (Dean) employee)
                .collect(Collectors.toCollection(Vector::new));

        return deans;
    }

    public Vector<FinanceManager> getFinanceManager() {
        Vector<FinanceManager> financeManagers = employees.stream()
                .filter(employee -> employee instanceof FinanceManager)
                .map(employee -> (FinanceManager) employee)
                .collect(Collectors.toCollection(Vector::new));

        return financeManagers;
    }

    
    public Vector<FinanceOffice> getFinanceOffices() {
        return financeOffices;
    }


    public Vector<Organisation> getOrganisations() {
        return organisations;
    }

    public Vector<Admin> getAdmins(){
        return admins;
    }
    
    public Vector<ResearchJournal> getJournals(){
    	return journals;
    }
    
    public Vector<ResearchProject> getProjects(){
    	return projects;
    }
    
    /**
     * Retrieves a vector of research papers that do not have the specified researcher as an author.
     * 
     * @param The researcher for whom papers are not to be included.
     * @return A vector of research papers without the specified researcher as an author.
     */
    public Vector<ResearchPaper> getPapersWithoutThis(Researcher r){
    	Vector<ResearchPaper> p = new Vector<ResearchPaper>();
    	
    	for(ResearchPaper rp : this.papers) {
    		if(!rp.getAuthors().contains(r)) {
    			p.add(rp);
    		}
    	}
    	
    	return p;
    }

    public void addUser(User u) {
        this.users.add(u);
    }

    public boolean addStudent(Student s) {
    	if(this.users.contains((User)s)) {
    		System.out.println("Student is not unique");
    		return false;
    	}
        this.students.add(s);
        addUser(s);
        return true;
    }

    public boolean addEmployee(Employee e) {
    	
    	if(this.users.contains((User)e)) {
    		System.out.println("Employee is not unique");
    		return false;
    	}
        this.employees.add(e);
        addUser(e);
        return true;
    }

    public boolean addCourse(Course c) {
    	if(this.courses.contains(c)) {
    		System.out.println("Course is not unique");
    		return false;
    	}
        this.courses.add(c);
        return true;
    }

    public void addNews(News n) {
        this.news.add(n);
    }

    public void addRequest(Request r) {
        this.requests.add(r);
    }

//    public void addOrder(Order o) {
//        this.orders.add(o);
//    }
    
    public void addJournal(ResearchJournal rj) {
    	this.journals.add(rj);
    }

    public void addResearcher(Researcher r) {
        this.researchers.add(r);
    }
    
    public void addPaper(ResearchPaper rp) {
    	this.papers.add(rp);
    }
    
    public void addProject(ResearchProject rp) {
    	this.projects.add(rp);
    }

    public void addOrganisation(Organisation or) {
        this.organisations.add(or);
    }

    public void addAdmin(Admin a) {
        this.admins.add(a);
        addUser(a);
    }
    
    /**
     * Adds a log entry for a user to the database.
     * If the user already has existing logs, the new log entry is appended to the existing logs.
     * 
     * @param u The user for whom the log entry is being added.
     * @param l The log entry to be added.
     */
    public void addLog(User u, Log l) {
    	Vector<Log> logs;
    	if (this.userLogs.get(u) == null) {
            logs = new Vector<>();
        }
    	else {
    		logs = this.userLogs.get(u);
    	}
         
        logs.add(l);
        this.userLogs.put(u, logs);
    }
    
    public Vector<Log> seeLogs(User u){
    	return userLogs.get(u);
    }
    
    /**
     * Checks if the specified user is associated with a researcher in the database.
     * If a researcher with the specified user is found, the corresponding researcher
     * object is returned; otherwise, null is returned.
     * 
     * @param u The user for whom the association with a researcher is checked.
     * @return The researcher associated with the user, or null if no association is found.
     */
    public Researcher isResearcher(User u) {
		for(Researcher r : researchers) {
			if(r.getUser() == u) {
				return r;
			}
		}
		return null;
	}
}
