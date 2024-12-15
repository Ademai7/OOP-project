package main;

import java.util.Scanner;

import uiclasses.UserUI;
import users.TechSupportSpecialist;
import users.User;

public class Application {
	
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		String login = scanner.next();
		String password = scanner.next();
		User user = Database.getInstance().getUser(login, password);
		UserUI ui = UIFactory.getUi(user);
		ui.main();
		
	/*	Admin admin = new Admin("admin", "admin"); // Create Admin object
        Database.getInstance().addUser(admin);
        Database.saveDB();
        System.out.println("Done");
        
		TechSupportSpecialist tech = new TechSupportSpecialist("tech", "parol"); // Create Admin object
        Database.getInstance().addUser(tech);
        Database.saveDB();
        System.out.println("Done");*/
	}

}
