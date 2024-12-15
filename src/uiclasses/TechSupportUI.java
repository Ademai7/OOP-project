package uiclasses;

import java.io.IOException;
import java.util.Map;
import enums.OrderStatus;
import users.TechSupportSpecialist;
import main.Database;

public class TechSupportUI extends UserUI {

    private TechSupportSpecialist techSupportSpecialist;

    public TechSupportUI() {
        super();
    }

    public TechSupportUI(TechSupportSpecialist techSupportSpecialist) {
        super(techSupportSpecialist);
        this.techSupportSpecialist = techSupportSpecialist;
    }

    public void changeAvailability() throws IOException {
        print("Insert your availability status. '0' is exit. '1' if available. '2' if busy.");
        String availabilityStatus = reader.readLine();
        if (availabilityStatus.equals("0")) {
            return;
        } else if (availabilityStatus.equals("1")) {
            techSupportSpecialist.changeAvailability(true);
        } else if (availabilityStatus.equals("2")) {
            techSupportSpecialist.changeAvailability(false);
        }
        print("Availability is changed");
    }

    public void addTask() throws IOException {
        print("Insert your task name. '0' is exit");
        String taskName = reader.readLine();
        if (taskName.equals("0")) {
            return;
        }
        techSupportSpecialist.addTask(taskName, OrderStatus.NEW);
        print("Task is added");
    }

    public void changeTaskStatus() throws IOException {
    	Map<String, OrderStatus> tasks = Database.getInstance().getTasks();
        print("Insert your task name. '0' is exit");
        String taskName = reader.readLine();
        if (taskName.equals("0")) {
            return;
        }
        if (tasks.containsKey(taskName)) {
            print("What status do you want to put? 1 is NEW, 2 is INPROGRESS, 3 is SEEN, 4 is DONE");
            String orderStatus = reader.readLine();
            if (orderStatus.equals("1")) {
                tasks.replace(taskName, OrderStatus.NEW);
                print("Task status is updated to NEW");
            } else if (orderStatus.equals("2")) {
                tasks.replace(taskName, OrderStatus.INPROGRESS);
                print("Task status is updated to INPROGRESS");
            } else if (orderStatus.equals("3")) {
                tasks.replace(taskName, OrderStatus.SEEN);
                print("Task status is updated to SEEN");
            } else if (orderStatus.equals("4")) {
                tasks.replace(taskName, OrderStatus.DONE);
                print("Task status is updated to DONE");
            } else {
                print("Invalid input.");
            }
        } else {
            print("Task is not found.");
        }
    }

    public void removeTask() throws IOException {
        print("Insert your task name. '0' is exit");
        String taskName = reader.readLine();
        if (taskName.equals("0")) {
            return;
        }
        techSupportSpecialist.removeTask(taskName);
    }

    public void viewAllTasks() {
        techSupportSpecialist.viewAllTasks();
    }

    public void main() {
        while (true) {
            try {
                System.out.println("0. Exit");
                System.out.println("1. View news");
                System.out.println("2. Change password");
                System.out.println("3. Change availability");
                System.out.println("4. Add a task");
                System.out.println("5. Change task status");
                System.out.println("6. Remove a task");
                System.out.println("7. View tasks");
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
                        changeAvailability();
                        break;
                    case "4":
                        addTask();
                        break;
                    case "5":
                        changeTaskStatus();
                        break;
                    case "6":
                        removeTask();
                        break;
                    case "7":
                        viewAllTasks();
                        break;
                    default:
                        System.out.println("Not found");
                }
            } catch (IOException ioe) {
                System.out.println("Something is wrong");
            }
        }
    }
}
