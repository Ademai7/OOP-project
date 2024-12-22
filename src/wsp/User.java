package wsp;

import java.io.Serializable;
import utils.*;
import java.util.Objects;
import java.util.Vector;
import java.util.Scanner;

import database.Database;
import language.*;

/**
 * The User class is an abstract class representing a generic user in the system.
 * It provides common functionality for all roles in system, such as viewing
 * top researchers, news, notifications, and journals. It also handles comments on news
 * and defines an abstract method for viewing the user-specific menu and changing user information.
 */
public abstract class User implements Serializable {
	
	private static final long serialVersionUID = -2636065254513175824L;
	
	private int id = 1;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Vector<String> notifications;
	private Vector<ResearchJournal> journals;
	private LanguageInterface language = new EnglishLanguage();
	
	
	/**
     * Retrieves the vector containing notifications for the user.
     *
     * @return The vector of notifications for the user.
     */
	public Vector<String> getNotifications(){
		return notifications;
	}
	
	
	/**
     * Retrieves the vector containing journals subscribed by the user.
     *
     * @return The vector of journals subscribed by the user.
     */
	public Vector<ResearchJournal> getJournals() {
		return journals;
	}
	
	
	/**
     * Displays the top cited researcher among all researchers along with their total citations.
     */
	public void viewTopResearcher() {
		System.out.println("----Top Cited Researcher----");
		int citations = 0;
		Researcher r = Database.getInstance().getTopCitedResearcher();
		if(r == null) {
			return;
		}
		Vector<ResearchPaper> papers = r.getPapers();
		for(ResearchPaper rp : papers) {
			citations += rp.getCitations();
		}
		User u = (User)r.getUser();
		System.out.println(u.getFirstName() + " " + u.getLastName() + " Citations = " + citations);
		System.out.println();
	}
	
	/**
     * Displays and clears new notifications for the user.
     */
	public void viewNotifications() {
		this.getLanguage().newNotifications();
		if(notifications.isEmpty()) {
			System.out.println("No new notifications.");
			return;
		}
		StaticMethods.printList(notifications);
		notifications.clear();
		System.out.println();
	}
	
	/**
	 * Changes language of system for specific user.
	 */
	public void changeLanguage() {
		System.out.println(" 1 - Русский\n 2 - Қазақша\n 3 - English");
		
		int choice = StaticMethods.validate(1, 3);
		
		if(choice == 1) {
			this.setLanguage(new RussianLanguage());
		}
		else if(choice == 2) {
			this.setLanguage(new KazakhLanguage());
		}
		else if(choice == 3) {
			this.setLanguage(new EnglishLanguage());
		}
	}
	
	
	/**
     * Adds a new notifications to the user's notifications vector.
     *
     * @param message The notification to be added.
     */
	public void addNotification(String mes) {
		this.notifications.add(mes);
	}
	
	
	/**
     * Handles an event related to a new research paper in subscribed research journal, adding a notification
     * to the user's messages vector.
     *
     * @param paper The research paper related to the event.
     * @param The research journal related to the event.
     */
	public void handleEvent(ResearchPaper paper, ResearchJournal rj) {
		this.addNotification(this.getLanguage().handleEventUser(paper.toString(), rj.getName(), firstName, lastName));
	}
	
	
	/**
     * Constructs a new `User` with the specified username, password, first name, and last name.
     * Auto increment id of new user to ensure users have unique ids.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     */
	public User(String username, String password, String firstName, String lastName) {
		if(Database.getInstance().getUsers().isEmpty()) {
			this.id = 1;
		}
		else {
			int nextid = Database.getInstance().getUsers().lastElement().id;
			this.id = ++nextid;
		}
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.notifications = new Vector<>();
		this.journals = new Vector<>();
	}

	public int getId(){
        return id;
    }	
	
	
	/**
	 * Authenticates the user by displaying information about top researchers, news,
	 * notifications, and the user-specific menu. This method serves as an entry point
	 * for users to interact with the system after successful login.
	 */
	public void authentification() {
		this.viewTopResearcher();
		this.viewNews();
		this.viewNotifications();
		this.viewMenu();
	}
	
	
	/**
     * Displays news available in the system.
     */
	public void viewNews() {
		Vector <News> news = Database.getInstance().getNews();
		this.getLanguage().news();
		
		for (int i = 0; i < news.size(); i++) {
			News n = news.get(i);
			System.out.println((i + 1) + ". " + "Topic: " + n.getTopic());
			System.out.println("   "+n.getTitle());
			System.out.println();
		}
	}
	
	
	/**
     * Displays detailed information about a selected news item, including comments.
     * Provides the option to add a comment.
     */
	public void viewOneNews() {
		Vector <News> news = Database.getInstance().getNews();
		
		if(news.isEmpty()) {
			this.getLanguage().noNews();
			return;
		}
		
		this.getLanguage().news();
		
		for (int i = 0; i < news.size(); i++) {
			News n = news.get(i);
			System.out.println((i + 1) + ". " + n.getTopic());
			System.out.println("   " + n.getTitle());
			System.out.println();
		}
		
		this.getLanguage().enterTheNumberOfTheNews();
		int choice = StaticMethods.validate(news.size());

		if (choice == 0) {
			System.out.println();
		}
		else {
			News selectedNews = news.get(choice-1);
			this.getLanguage().selectedNews();
			System.out.println(selectedNews.toString());
			System.out.println();
				
			viewComments(selectedNews);
			
			Scanner in = new Scanner(System.in);
				
			this.getLanguage().doYouWantToAddAComment();
			String answer = in.nextLine();
	
		    if (answer.equals("+")) {
		        addComment(selectedNews);
		    }
		    else {
		    	this.getLanguage().yourDecidedThatNoWant();
		    }
		}
	}
	
	/**
     * Displays comments for a specific news article.
     *
     * @param n The news article for which to display comments.
     */
	public void viewComments(News n) {
		Vector <String> comments = n.getComments();
		
		if(comments.isEmpty()) {
			this.getLanguage().noCommentsAvailable();
			
		}
		else {
			this.getLanguage().comments();
			for (String comment : comments) {
				System.out.println(" - " + comment);
			}
		}
	}
	
	
	/**
     * Displays the list of journals subscribed by the user.
     */
	public void viewJournals() {
		StaticMethods.printList(journals);
	}
	
	
	/**
     * Adds a comment to a specific news.
     *
     * @param n The news article to which the comment will be added.
     */
	public void addComment(News n) {
		this.getLanguage().enterYourComment();
		
		Scanner input = new Scanner(System.in);
		String comment = input.nextLine();
		n.getComments().add(comment);
		this.getLanguage().commentAddSuccesfully();
		
	}
	
	
	/**
     * Abstract method to be implemented by subclasses for displaying
     * the user-specific menu in the system.
     */
	public abstract void viewMenu();
	
	/**
     * Abstract method to be implemented by subclasses for allowing users
     * to change their information in the system.
     */
	public abstract void changeInfo();
	
	
	public String getUsername() {
		return username;
	}

	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getPassword() {
		return password;
	}
	
	public LanguageInterface getLanguage() {
		return language;
	}
	
	public void setLanguage(LanguageInterface language) {
		this.language = language;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return "[id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		User other = (User) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	
	
}
