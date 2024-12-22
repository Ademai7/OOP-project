package wsp;

import database.Database;
import java.io.*;

public class DeserializeTest {
    public static void main(String[] args) {
        try {
            // Десериализация объекта Database из файла
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("database.ser"));
            Database database = (Database) ois.readObject();
            ois.close();
            
            // Отображение содержимого
            System.out.println("Администраторы:");
            database.getAdmins().forEach(admin -> System.out.println(admin));

            System.out.println("\nПользователи:");
            database.getUsers().forEach(user -> System.out.println(user));

            System.out.println("\nСтуденты:");
            database.getStudents().forEach(student -> System.out.println(student));

            System.out.println("\nСотрудники:");
            database.getEmployees().forEach(employee -> System.out.println(employee));

            System.out.println("\nКурсы:");
            database.getCourses().forEach(course -> System.out.println(course));

            System.out.println("\nНовости:");
            database.getNews().forEach(news -> System.out.println(news));

            System.out.println("\nЗапросы:");
            database.getRequests().forEach(request -> System.out.println(request));

   
            System.out.println("\nИсследователи:");
            database.getResearchers().forEach(researcher -> System.out.println(researcher));

            System.out.println("\nЖурналы:");
            database.getJournals().forEach(journal -> System.out.println(journal));

            System.out.println("\nОрганизации:");
            database.getOrganisations().forEach(org -> System.out.println(org));

         
            System.out.println("\nПроекты:");
            database.getProjects().forEach(project -> System.out.println(project));
        } catch (FileNotFoundException e) {
            System.err.println("Файл database.ser не найден.");
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода при чтении файла.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Класс Database не найден.");
            e.printStackTrace();
        }
    }
}
