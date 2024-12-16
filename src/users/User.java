package project_oop;
import java.util.*;


abstract class User {
    private int userId;
    private String login;
    private String password;
    private String role;
    private Language language;
    private List<ResearchPaper> researchPapers = new ArrayList<>();
    private List<ResearchProject> researchProjects = new ArrayList<>();
    private Researcher Researcher;

    public User(int id, String login, String password, String role, Language language) {
        this.userId = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.language = language;
    }

    public int getId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
    	this.language = language;
    }
    

    public List<ResearchPaper> getResearchPapers() {
        return researchPapers;
    }

    public List<ResearchProject> getResearchProjects() {
        return researchProjects;
    }

    public void addResearchPaper1(ResearchPaper paper) {
        researchPapers.add(paper);
    }

    public void addResearchProject1(ResearchProject project) {
        researchProjects.add(project);
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }

    public abstract void displayInfo1();

    public boolean isResearcher() {
        // Если пользователь - профессор, он всегда исследователь
        if (role.equals("Professor")) {
            return true;
        }

        // Если это студент, проверим наличие хотя бы одного исследовательского проекта и статьи
        if (role.equals("Student")) {
            return !researchProjects.isEmpty() && !researchPapers.isEmpty();
        }

        // Работники (не преподаватели и не студенты) могут быть исследователями, если у них есть проекты и статьи
        if (role.equals("Employee")) {
            return !researchProjects.isEmpty() && !researchPapers.isEmpty();
        }

        // В случае других ролей (например, Tutor, SeniorLecturer) исследователями могут быть те, кто имеет проекты и статьи
        return !researchProjects.isEmpty() && !researchPapers.isEmpty();
    }

    public boolean isEligibleForResearch() {
        // Профессор и работник (не преподаватель) могут быть исследователями, если у них есть проекты и статьи
        if (role.equals("Professor") || role.equals("Employee")) {
            return true;
        }

        // Студенты могут быть исследователями только если у них есть проекты и статьи
        return role.equals("Student") && !researchProjects.isEmpty() && !researchPapers.isEmpty();
    }

    public void addResearchPaper(ResearchPaper paper) {
        researchPapers.add(paper);
    }

    public void addResearchProject(ResearchProject project) {
        researchProjects.add(project);
    }

  
    public void displayInfo() {
		System.out.println("User ID: " + userId);
        System.out.println("Login: " + login);
        System.out.println("Role: " + role);
        System.out.println("Language: " + language);
    }


    public void printPapers(Comparator<ResearchPaper> comparator) {
        researchPapers.sort(comparator);
        for (ResearchPaper paper : researchPapers) {
            System.out.println(paper);
        }
    }
}
