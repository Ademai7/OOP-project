package uiclasses;

import java.util.Scanner;

import main.Database;
import users.Admin;
import users.Manager;
import users.Student;
import users.Teacher;
import users.TechSupportSpecialist;
import users.User;
public class Test {
    
    public static UserUI consoleUI;
    public static Scanner scanner = new Scanner(System.in);

    public static void setView(User user){
        if(user instanceof Admin){
            consoleUI = new AdminUI(((Admin)user));
        }
        if(user instanceof Teacher){
        	consoleUI = new TeacherUI(((Teacher)user));
        }
        if(user instanceof Student){
        	consoleUI = new StudentUI(((Student)user));
        }
        if(user instanceof Manager){
        	consoleUI = new ManagerUI((Manager)user);
        }
        if(user instanceof TechSupportSpecialist){
        	consoleUI = new TechSupportUI((TechSupportSpecialist)user);
        }
    }

    public static void login(){
        User user;
        while(true){
            System.out.println("Insert your login: ");
            String login = scanner.next();
            System.out.println("Insert your password: ");
            String password = scanner.next();
            try{
                user = Database.getInstance().getUser(login, password); //юда нужно добавить езе имя, фам, номер тел, но это же по сути ступид
                if(user == null){
                	System.out.println("Wrong username of password. Try again.");
                	continue;
                }
                System.out.println("Login was successfull! Welcome, " + user.getRole());
                setView(user);
                return;
            }
            catch (Exception e){
                System.out.println("Wrong username or password. Try again.");
            }
        }
    }

    public static void main(String args[]){
        login(); // Вызываем метод для аутентификации пользователя
        if (consoleUI != null) {
        	consoleUI.main(); // Вызываем основной метод представления, если представление установлено
        }
        try {
            Database.saveDB(); // Сохраняем базу данных
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
