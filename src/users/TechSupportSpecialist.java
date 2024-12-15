package users;

import java.io.Serializable;
import java.util.Map;

import enums.OrderStatus;
import enums.UserRole;
import main.Database;

public class TechSupportSpecialist extends User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final UserRole role = UserRole.TECHSUPPORTSPECIALIST;
    private boolean availability;
    private OrderStatus taskStatus;

    public TechSupportSpecialist() { 
        super(); 
    } 

    public TechSupportSpecialist(String login, String password){ 
        super(login, password); 
    } 

    public OrderStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(OrderStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public boolean isAvailability() {
        return availability;
    }
    
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void changeAvailability(boolean newAvailability) {
        this.availability = newAvailability;
        System.out.println("Availability changed to: " + newAvailability);
    }

    public void addTask(String taskName, OrderStatus taskStatus) {
        Database.getInstance().getTasks().put(taskName, taskStatus);
        System.out.println("Task added: " + taskName);
    }
    
    public void removeTask(String taskName) {
        Map<String, OrderStatus> tasks = Database.getInstance().getTasks();
        if (tasks.containsKey(taskName)) {
            tasks.remove(taskName);
            System.out.println("Task removed: " + taskName);
        } else {
            System.out.println("Task does not exist: " + taskName);
        }
    }

    public void viewAllTasks() {
        Map<String, OrderStatus> tasks = Database.getInstance().getTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks assigned.");
        } else {
            System.out.println("Tasks:");
            for (Map.Entry<String, OrderStatus> entry : tasks.entrySet()) {
                System.out.println("Task: " + entry.getKey() + ", Status: " + entry.getValue());
            }
        }
    }

    public UserRole getRole() {
        return role;
    }
}
