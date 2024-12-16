package users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.UserRole;
import main.Database;
import additional.LogFile;

public class Admin extends User implements Serializable {

    private static final long serialVersionUID = 1L;
    static final UserRole role = UserRole.ADMIN;
    private static Admin instance;

    private List<User> users;

    // Приватный конструктор, чтобы предотвратить создание объекта извне
    private Admin(String login, String password) {
        super(login, password, role.name()); // передаем имя роли как строку
        this.users = new ArrayList<>();
    }

    // Статический метод для получения экземпляра Admin (Singletone)
    public static Admin getInstance(String login, String password) throws Exception {
        if (instance == null) {
            instance = new Admin(login, password);
        }
        return instance;
    }

    // Добавление пользователя в базу данных
    public void addUser(User user) {
        Database.getInstance().addUser(user);  // Добавление в базу данных
        users.add(user);

        // Создание лога о добавлении пользователя
        Database.getInstance().addLog(new LogFile(
            new Date(),
            "USER_ADDED",
            "Admin added user with ID: " + user.getId(),
            this.getLogin()
        ));
    }

    // Удаление пользователя из базы данных
    public boolean removeUser(Long userId) {
        User userToRemove = getUserById(userId);
        if (userToRemove != null) {
            Database.getInstance().deleteUser(userToRemove);  // Удаляем из базы данных
            users.remove(userToRemove);

            // Создание лога о удалении пользователя
            Database.getInstance().addLog(new LogFile(
                new Date(),
                "USER_REMOVED",
                "Admin removed user with ID: " + userId,
                this.getLogin()
            ));

            return true;
        }
        return false;
    }

    // Обновление данных пользователя
    public boolean updateUserInfo(Long userId, User newInfo) {
        User userToUpdate = getUserById(userId);
        if (userToUpdate != null) {
            int index = users.indexOf(userToUpdate);
            users.set(index, newInfo);

            // Логирование обновления данных
            Database.getInstance().addLog(new LogFile(
                new Date(),
                "USER_UPDATED",
                "Admin updated user with ID: " + userId,
                this.getLogin()
            ));

            return true;
        }
        return false;
    }

    // Управление пользователем (добавление, удаление, обновление)
    public void manageUser(String action, User user) {
        switch (action.toLowerCase()) {
            case "add":
                addUser(user);
                break;
            case "remove":
                removeUser(user.getId());
                break;
            case "update":
                updateUserInfo(user.getId(), user);
                break;
            default:
                System.out.println("Invalid action");

                // Логирование неверного действия
                Database.getInstance().addLog(new LogFile(
                    new Date(),
                    "INVALID_ACTION",
                    "Admin attempted invalid action: " + action,
                    this.getLogin()
                ));
        }
    }

    // Просмотр всех логов
    public List<LogFile> viewLogFiles() {
        return Database.getInstance().getLogFiles();
    }

    // Сброс пароля пользователя
    public void resetUserPassword(User user, String newPassword) {
        user.changePassword(newPassword);  // Устанавливаем новый пароль

        Database.getInstance().addLog(new LogFile(
            new Date(),
            "PASSWORD_RESET",
            "Admin reset password for user with ID: " + user.getId(),
            this.getLogin()
        ));
    }

    // Генерация отчетов
    public void generateReports() {
        System.out.println("Generating reports...");

        Database.getInstance().addLog(new LogFile(
            new Date(),
            "REPORT_GENERATED",
            "Admin generated reports.",
            this.getLogin()
        ));
    }

    // Просмотр данных пользователя
    public void viewUserDetails(User user) {
        System.out.println(user);

        Database.getInstance().addLog(new LogFile(
            new Date(),
            "VIEW_USER_DETAILS",
            "Admin viewed details for user with ID: " + user.getId(),
            this.getLogin()
        ));
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String toString() {
        return super.toString().replace("User", "Admin");
    }

    public UserRole getRole() {
        return role;
    }

    // Метод для получения пользователя по ID
    public User getUserById(Long userId) {
        for (User user : users) {
            if (user.getId().equals(Long.valueOf(userId))) {
                return user;
            }
        }
        return null;
    }
}
