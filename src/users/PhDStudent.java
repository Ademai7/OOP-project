package users;

import java.util.List;

import enums.UserRole;
import main.Database;
import unisystem2023.ResearchPaper;

public class PhDStudent extends Student implements CanBeResearcher {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final UserRole role = UserRole.PHDSTUDENT;
	private Researcher researchSupervisor;
    private List<ResearchPaper> works;

    public Researcher getResearchSupervisor() {
        return this.researchSupervisor;
    }
    
    public void setResearchSupervisor(Researcher researchSupervisor) {
        this.researchSupervisor = researchSupervisor;
    }
    
    public List<ResearchPaper> getWorks() {
        return this.works;
    }

    public void setWorks(List<ResearchPaper> works) {
        this.works = works;
    }

   /* public void teachAsPracticant() {
        PhDStudent currentPhDStudent = 
        
        if (currentPhDStudent != null) {
            Database database = Database.getInstance();
            currentPhDStudent.setTeachingAsPracticant(true);
            database.updatePhDStudent(currentPhDStudent);
            
            System.out.println("Teaching duties as a practicant performed successfully.");
        } else {
            System.out.println("Ph.D. student not found or logged in.");
        }
    }*/

    
    public String writeDiploma(String topic, String sphere) {
        String diplomaText = "Writing the diploma on the topic '" + topic + "' in the sphere of '" + sphere + "'.";

        return diplomaText;
    }

    
    public Researcher becomeaResearcher(){
		return new Researcher(this);
	}
    public UserRole getRole() {
        return role;
    }
}
