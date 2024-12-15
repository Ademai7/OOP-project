package uiclasses;

import java.io.IOException;
import java.util.Vector;
import java.util.stream.Collectors;

import main.Database;
import unisystem2023.Message;
import users.Employee;
import users.Researcher;
import users.User;

public class EmployeeUI extends UserUI {

	public EmployeeUI(){}

	public EmployeeUI(Employee employee){
		super(employee);
	}

	public void viewMessages() throws IOException{
		Vector <Message> messages = ((Employee)user).getMessages();
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

	public void viewMessage(Message message) throws IOException {
	    if (message != null) {
	        print(message.getMessage());
	    } else {
	        print("No messages yet");
	    }
	}


	public void sendMessage() throws IOException{
		System.out.println("Insert Employee's login to send message to: ");
		User receiver;
		String name = reader.readLine();
		while(true){
			try{
				receiver = Database.getInstance().getAllUsers().stream()
				.filter(u-> u instanceof Employee)
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
		((Employee)user).sendMessage((Employee)receiver, theme, text);
	}



//я тут поменяла окда
	public void researchersMenu() {
	    if (Database.getInstance().getResearchers().isEmpty()) {
	        Employee employee = (Employee) user;
	        Database.getInstance().getResearchers().add(new Researcher(employee));
	    }
	    new ResearcherUI().main();
	}


	public void main(){
		while(true){
			try{
				print("0. Exit");
				print("1. View news");
				print("2. Change password");
				print("3. View messages");
				print("4. Send message");
				print("5. Become a researcher");
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
						researchersMenu();
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
