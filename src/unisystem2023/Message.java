package unisystem2023;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

import users.Employee;

public class Message implements Serializable, Externalizable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String theme;
	private String text;
	private Employee sender;

	public Message(){
		super();
	}

	public Message(Employee sender, String theme, String text){
		this.sender = sender;
		this.theme = theme;
		this.text = text;
	}

	public void setTheme(String theme){
		this.theme = theme;
	}

	public void setText(String text){
		this.text = text;
	}
	public void setSender(Employee sender) {
		this.sender = sender;
	}
	public String getTheme() {
		return theme;
	}

	public String getText() {
		return text;
	}

	public Employee getSender() {
		return sender;
	}
	
	
	public String toString() {
		return "Message: theme=" + theme + "\nsender: " + sender.getLogin();
	}

	public String getMessage(){
		return "Sender: " + sender + '\n' + theme + '\n' + text;
	}

	@Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // Write the fields of the object to the output stream
        out.writeObject(theme);
        out.writeObject(text);
        out.writeObject(sender);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // Read the fields of the object from the input stream
        theme = (String) in.readObject();
        text = (String) in.readObject();
        sender = (Employee) in.readObject();
    }
	
}

