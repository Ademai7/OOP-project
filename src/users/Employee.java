package users;

import java.util.Vector;

import enums.UserRole;
import unisystem2023.Message;

public abstract class Employee extends User implements CanBeResearcher{

	private static final long serialVersionUID = 1L;
	private Vector<Message> messages = new Vector<Message>();
    private double salary;

    public Employee() {
        super();
    }
    public Employee(String login, String password){
		super(login, password);
	}
    
  /*  public Employee(String login, String password, String name){
		super(login, password, name);
	}*/

    public Employee(Long id, String login, String password, String name, String surname, String phoneNumber, String email, double salary) {
        super(id, login, password, name, surname, phoneNumber, email);
        this.salary = salary;
    }
    

    public void addMessage(Message message) {
        messages.add(message);
    }

    public Vector<Message> getMessages() {
        return messages;
    }

    public void sendMessage(Employee poluchatel, String theme, String text) {
    	poluchatel.addMessage(new Message(this, theme, text));
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    
    public String getName() {
        return super.getName();
    }
    
    public String toString() {
		return getRole()+ ": " + "Login: " + super.getLogin() + ", password: " + super.getPassword();
	}
}
