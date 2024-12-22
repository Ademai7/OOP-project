package wsp;
import java.io.IOException;

import database.Database;


public class Tester {
    public static void main(String[] args) {
        // Загрузка базы данных
        Database database = Database.getInstance();
        System.out.println("Database loaded successfully!");

        // Создание объекта Admin
        Admin admin = new Admin("admin", "password123", "Arai", "Kabykenova");
        System.out.println("Welcome, " + admin);

        // Открытие меню администратора
        admin.viewMenu();

        // Сохранение базы данных перед завершением
        try {
            Database.getInstance().saveDatabase();
            System.out.println("Database saved successfully!");
        } catch (IOException e) {
            System.err.println("Error saving database: " + e.getMessage());
        }

        System.out.println("Exiting the system. Goodbye!");
    }
}