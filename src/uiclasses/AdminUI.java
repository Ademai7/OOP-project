package uiclasses ;

import java.io.IOException;
import java.util.stream.Collectors;

import main.Database;
import enums.UserRole;
import users.Admin;
import users.User;
import users.UserFactory;

public class AdminUI extends UserUI{

	protected AdminUI(){}

	public AdminUI(Admin admin){
		super(admin);
	}

	public void createUser() throws IOException{
		UserRole type;
		String password;
		String login = "Default";
		print("Choose kind of user you want to create:");
		for(UserRole ut: UserRole.values()){
			print(ut.toString());
		}
		while(true){
			try {
				type = UserRole.valueOf(reader.readLine());
				break;
			}
			catch (IllegalArgumentException iae){
				print("No such option ");
			}
		}
		while(true){
			print("Insert login:");
			login = reader.readLine();
			final String hislogin = login;
			if(Database.getInstance().getAllUsers().stream()
				   .filter(u -> hislogin.equals(u.getLogin()))
				   .collect(Collectors.toList()).isEmpty()){
				break;
			}
			print("Username is already used, try another");
		}
		print("Insert password:");
		password = reader.readLine();
		UserFactory.getUser(login, password, type);
	}

	public void main() {
	    while (true) {
	        try {
	            print("0. Exit");
	            print("1. View news");
	            print("2. Change password");
	            print("3. View users");
	            print("4. Create user");
	            print("5. Delete user");
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
	                    viewUsers();
	                    break;
	                case "4":
	                    createUser();
	                    break;
	                case "5":
	                    deleteUser();
	                    break;
	                default:
	                    print("No such option");
	            }
	        } catch (IOException ioe) {
	            System.out.println("Error");
	        }
	    }
	}


	public void viewUsers() throws IOException{
		for(User user: Database.getInstance().getAllUsers()){
			print(user.toString());
		}
	}

	public void deleteUser() throws IOException{
		viewUsers();
		while(true){
			print("Insert login of user you want to delete or 0 to exit");
			final String login = reader.readLine();
			if(login.equals("0")){
				return;
			}
			try{
				User user = Database.getInstance().getAllUsers().stream()
							.filter(s -> s.getLogin().equals(login))
							.collect(Collectors.toList()).get(0);
				Database.getInstance().deleteUser(user);
				return;
			}
			catch (Exception e){
				print("No such option");
			}
		}	
	}

}