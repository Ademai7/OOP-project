package wsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import database.Database;
import java.util.Optional;

import UIclasses.UIManager;

/**
 * Класс для тестирования функционала системы, включая аутентификацию пользователя
 * и отображение соответствующего меню в зависимости от его роли.
 */
public class Tester {

    /**
     * Основной метод, который выполняет загрузку базы данных, аутентификацию
     * пользователя и выводит соответствующее меню в зависимости от его роли.
     * 
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        // Загрузка базы данных
        Database database = Database.getInstance();
        System.out.println("Database loaded successfully!");

        // Ввод логина и пароля
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String username = null;
        String password = null;

        try {
            // Запрос логина
            System.out.print("Enter username: ");
            username = reader.readLine();
            
            // Запрос пароля
            System.out.print("Enter password: ");
            password = reader.readLine();
        } catch (IOException e) {
            // Обработка ошибок ввода
            System.err.println("Error reading input: " + e.getMessage());
            return;
        }

        // Поиск пользователя в базе данных по логину и паролю
        for (User user : database.getUsers()) {  
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {  
                System.out.println("Login successful! Welcome, " + username + "!");  

                if (user instanceof Admin) {  
                    System.out.println("Redirecting to Admin System...");  
                    Admin admin = (Admin) user;  
                    new UIAdmin(admin).run();  
                } else if (user instanceof Manager) {  
                    new UIManager(database).run();  
                } else if (user instanceof Student) {  
                    new UIStudent().run();  
                } else if (user instanceof Teacher) {  
                    Teacher teacher = (Teacher) user;  
                    new UITeacher(teacher).run();  
                } else {  
                    System.out.println("No specific demo available for this user type.");  
                    // Add more conditions here for other user types, if needed.  
                }  
                return;  
            }  
        }  


       
		User user;
		// Приветствие пользователя
        System.out.println("Welcome, " + user.getFirstName());

        // Определение типа пользователя и вызов соответствующего меню
        if (user instanceof Admin) {
            Admin admin = (Admin) user;
            System.out.println("You are logged in as Admin.");
            admin.viewMenu();  // Открыть меню администратора
        } else if (user instanceof Dean) {
            Dean dean = (Dean) user;
            System.out.println("You are logged in as Dean.");
            dean.viewMenu();  // Открыть меню декана
        } else if (user instanceof FinanceManager) {
            FinanceManager financeManager = (FinanceManager) user;
            System.out.println("You are logged in as Finance Manager.");
            financeManager.viewMenu();  // Открыть меню финансового менеджера
        } else if (user instanceof Manager) {
            Manager manager = (Manager) user;
            System.out.println("You are logged in as Manager.");
            manager.viewMenu();  // Открыть меню менеджера
        } else if (user instanceof Student) {
            Student student = (Student) user;
            System.out.println("You are logged in as Student.");
            student.viewMenu();  // Открыть меню студента
        } else if (user instanceof Teacher) {
            Teacher teacher = (Teacher) user;
            System.out.println("You are logged in as Teacher.");
            teacher.viewMenu();  // Открыть меню преподавателя
        } else {
            System.out.println("Unknown user type.");
        }

        // Сохранение базы данных перед завершением программы
        try {
            Database.getInstance().saveDatabase();
            System.out.println("Database saved successfully!");
        } catch (IOException e) {
            // Обработка ошибок при сохранении базы данных
            System.err.println("Error saving database: " + e.getMessage());
        }

        // Вывод сообщения о завершении работы программы
        System.out.println("Exiting the system. Goodbye!");
    }
}
