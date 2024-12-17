package users;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import courses.Courses;
import enums.ManagerType;
import enums.UserRole;
import main.Database;
import additional.News;
import additional.Request;

public class Manager extends Employee {

    private static final long serialVersionUID = 1L;
    static final UserRole role = UserRole.MANAGER; // Роль менеджера
    private ManagerType type; // Тип менеджера

    private List<Student> students; // Список студентов
    private List<Teacher> teachers; // Список преподавателей
    private List<Courses> courses; // Список курсов
    private List<News> news; // Список новостей

    public Manager() {
        super(); // Вызов конструктора родительского класса Employee
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.news = new ArrayList<>();
    }

    public Manager(String login, String password, ManagerType type) {
        super(login, password); // Вызов конструктора родительского класса Employee с логином и паролем
        this.type = type;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.news = new ArrayList<>();
    }

    // Геттеры и сеттеры
    public ManagerType getType() {
        return this.type;
    }

    public void setType(ManagerType type) {
        this.type = type;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    // Одобрение регистрации студента на курс
    public void approveStudentRegistration(Student student, Courses course) {
        if (course.isRegistrationOpen()) { // Проверка, открыта ли регистрация
            if (!students.contains(student)) { // Проверка, зарегистрирован ли студент
                students.add(student);
                System.out.println("Student " + student.getName() + " registered for " + course.getCoursesName());
            } else {
                System.out.println("Student already registered.");
            }
        } else {
            System.out.println("Registration for this course is closed.");
        }
    }

    // Добавление курса для регистрации
    public void addCourseForRegistration(Courses course, String major, int year) {
        if (major.equals(course.getMajor()) && year == course.getYear()) {
            courses.add(course);
            System.out.println("Course " + course.getCoursesName() + " added for registration.");
        } else {
            System.out.println("Course does not match the provided major or year.");
        }
    }

    // Назначение преподавателя на курс
    public void assignCourseToTeacher(Courses course, Teacher teacher) {
        course.setLector(teacher);
        System.out.println("Assigned teacher " + teacher.getName() + " to course " + course.getCoursesName());
    }

    // Генерация академического отчета (заглушка)
    public void generateAcademicReport() {
        System.out.println("Generating academic report...");
        // Реализовать логику генерации отчета
    }

    // Добавление новости
    public void addNews(News newsItem) {
        this.news.add(newsItem);
        System.out.println("News added successfully.");
    }

    // Удаление новости
    public void removeNews(News newsItem) {
        if (news.contains(newsItem)) {
            news.remove(newsItem);
            System.out.println("News removed successfully.");
        } else {
            System.out.println("News not found.");
        }
    }

    // Просмотр новостей
    public void viewNews() {
        for (News newsItem : news) {
            System.out.println(newsItem.getTheme() + ": " + newsItem.getText());
        }
    }

    // Просмотр студентов, отсортированных по GPA
    public void viewStudentsSortedByGpa() {
        students.sort(Comparator.comparingDouble(Student::getGpa).reversed()); // Сортировка студентов по GPA//надо дописать
        students.forEach(student -> System.out.println(student.getName() + " - GPA: " + student.getGpa()));//надо дописать
    }

    // Просмотр преподавателей в алфавитном порядке
    public void viewTeachersAlphabetically() {
        teachers.sort(Comparator.comparing(Teacher::getName)); // Сортировка преподавателей по имени
        teachers.forEach(teacher -> System.out.println(teacher.getName()));
    }

    // Добавление студента в список
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student " + student.getName() + " added.");
    }

    // Добавление преподавателя в список
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        System.out.println("Teacher " + teacher.getName() + " added.");
    }

    // Просмотр заявок
    public void viewRequests(List<Request> requests) {
        requests.forEach(request -> System.out.println(request));
    }

    // Просмотр студентов по критериям
    public void viewStudents(List<Student> students, String sortBy) {
        if (sortBy.equals("GPA")) {
            students.sort(Comparator.comparingDouble(Student::getGpa).reversed()); // Сортировка по GPA
        } else if (sortBy.equals("name")) {
            students.sort(Comparator.comparing(Student::getName)); // Сортировка по имени
        }
        students.forEach(student -> System.out.println(student.getName()));
    }

    // Просмотр преподавателей
    public void viewTeachers(List<Teacher> teachers) {
        teachers.forEach(teacher -> System.out.println(teacher.getName()));
    }

    @Override
    public Researcher becomeResearcher() {
        return new Researcher(this); // Превращение менеджера в исследователя
    }

    public UserRole getRole() {
        return role; // Получение роли менеджера
    }
}
