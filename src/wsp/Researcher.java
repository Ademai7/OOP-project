package wsp;

import java.io.Serializable;
import java.util.*;

import database.Database;
import utils.*;

/**
 * The Researcher class represents a researcher in the academic system.
 * It provides functionalities for viewing papers, creating papers, viewing projects,
 * viewing journals, and adding papers to a journal.
 *
 * @param <T> The type of user associated with the researcher.
 */
public class Researcher<T> implements Serializable {
	
    private static final long serialVersionUID = -8619146448875960868L;
    
	private T user;
	private Vector<ResearchProject> projects;
	private Vector<ResearchPaper> papers;
	private int hIndex = 0;
	
	/**
     * Constructs a Researcher object with the specified user.
     *
     * @param user The user associated with the researcher.
     */
	public Researcher(T user) {
		this.user = user;
		this.papers = new Vector<ResearchPaper>();
		this.projects = new Vector<ResearchProject>();
	}

	/**
     * Gets the user associated with the researcher.
     *
     * @return The user associated with the researcher.
     */
	public T getUser() {
		return user;
	}

	/**
     * Sets the user associated with the researcher.
     *
     * @param user The new user to set.
     */
	public void setUser(T user) {
		this.user = user;
	}
	
	
	/**
     * Gets the h-index of the researcher.
     *
     * @return The h-index of the researcher.
     */
    public int gethIndex(){
        return hIndex;
    }
	
    /**
     * Gets the list of papers associated with the researcher.
     *
     * @return The list of papers associated with the researcher.
     */
	public Vector<ResearchPaper> getPapers() {
		return papers;
	}

    public int calculatehIndex(){
        Vector<Integer> citations = new Vector<Integer>();

        if(this.papers == null){
            User u = (User)this.getUser();
            u.getLanguage().noPapers();
        }
        else{
            Comparator<ResearchPaper> citaComparator = new PaperCitationsComparator();
            this.papers.sort(citaComparator);
            for(int i = 0; i < this.papers.size(); i++){
                ResearchPaper researchPaper = this.papers.get(i);
                citations.add(researchPaper.getCitations());
            }
        }
        for (int i = 0; i < citations.size(); i++) {
            if (citations.get(i) >= hIndex + 1) {
                hIndex++;
            } else {
                break;
            }
        }
        return hIndex;

    }
	public void viewPapers() {
		
		if(papers.isEmpty()) {
			User u = (User)this.getUser();
            u.getLanguage().noPapers();
			return;
		}
		
		System.out.println("In which order do you want to get papers?");
    	System.out.println("1. Sorted by date");
    	System.out.println("2. Sorted by citations");
    	System.out.println("3. Sorted by number of pages");
    	
    	int choice = StaticMethods.validate(1, 3);
    	
    	if(choice == 1) {
    		Collections.sort(this.papers, new PaperDateComparator());
    		StaticMethods.printList(papers);
    		return;
    	}
    	if(choice == 2) {
    		Collections.sort(this.papers, new PaperCitationsComparator());
    		StaticMethods.printList(papers);
    		return;
    	}
    	if(choice == 3) {
    		Collections.sort(this.papers, new PaperPagesComparator());
    		StaticMethods.printList(papers);
    		return;
    	}
		
		StaticMethods.printList(papers);
	}
	
	
	/**
     * Views the projects associated with the researcher.
     */
	public void viewProjects() {
		
		if(projects.isEmpty()) {
			User u = (User)this.getUser();
            u.getLanguage().noProjects();
			return;
		}
		
		StaticMethods.printList(projects);
	}
	
	
	/**
     * Adds a paper to a research journal.
     */
	public void addPaperToJournal() {
		
		User u = (User)this.getUser();
		
		Vector<ResearchJournal> journals = Database.getInstance().getJournals();
		
		if(journals.isEmpty()) {
			
            u.getLanguage().noJournals();
			return;
		}
		
		u.getLanguage().enterReturnBack();
		u.getLanguage().chooseTheJournal();
		
		StaticMethods.printList(journals);
		
		int choice = StaticMethods.validate(journals.size());
		
		if(choice == 0) {
			return;
		}
		
		ResearchJournal journal = journals.get(choice-1);
		
		if(papers.isEmpty()) {
			u.getLanguage().noPapers();
			return;
		}
		u.getLanguage().choosePaperToAdd();
		
		StaticMethods.printList(papers);
		
		int choicePaper = StaticMethods.validate(1, papers.size());
		
		ResearchPaper paper = papers.get(choicePaper-1);
		
		journal.addPaper(paper);
		
		u.getLanguage().addedTo(paper.toString(), journal.getName());
	}
	
	
	/**
     * Views the research journals in the system.
     */
	public void viewJournals() {
		StaticMethods.printList(Database.getInstance().getJournals());
	}
	
	/**
	 * Researcher can create new project
	 */
	public void createProject() {
		User u = (User)this.getUser();
		u.getLanguage().enterReturnBack();
		u.getLanguage().enterTheName();
		
		Scanner in = new Scanner(System.in);
		
		String name = in.nextLine();
		
		if(name.equals("0")) {
			return;
		}
		
		
		ResearchProject newProject = new ResearchProject(name);
		
		this.projects.add(newProject);
		
		Database.getInstance().addProject(newProject);
		
		System.out.println("Project was created " + newProject);
		
	}
	
	
	/**
	 * Add some paper of this researcher to existing project
	 */
	public void addPaperToProject() {
		if(papers.isEmpty()) {
			System.out.println("No papers");
			return;
		}
		System.out.println("---------");
		Vector<ResearchProject> projects = Database.getInstance().getProjects();
		if(projects.isEmpty()) {
			System.out.println("No projects");
			return;
		}
		StaticMethods.printList(projects);
		int projectChoice = StaticMethods.validate(projects.size());
		if(projectChoice == 0) {
			return;
		}
		ResearchProject project = projects.get(projectChoice-1);
		System.out.println("---------");
		StaticMethods.printList(papers);
		
		int paperChoice = StaticMethods.validate(1, papers.size());
		
		ResearchPaper paper = papers.get(paperChoice-1);
		
		project.addPaperToProject(paper);
		
		System.out.println(paper + " added to " + project);
	}
	
	
	/**
     * Views the menu for the researcher, providing options to view papers, create papers, view projects,
     * view journals, and add papers to a journal.
     */
	public void viewMenu() {
		
		User u = (User)this.getUser();
		
		while(true) {

			String[] options = u.getLanguage().researcherMenu();
			
			System.out.println(u.getLanguage().researcherHeader());
			StaticMethods.printList(List.of(options));
			
			int choice = StaticMethods.validate(1, options.length);
			
			if(choice == 1) {
				viewPapers();
			}
			else if(choice == 2) {
				createPaper();
			}
			else if(choice == 3) {
				viewProjects();
			}
			else if(choice == 4) {
				viewJournals();
			}
			else if(choice == 5) {
				addPaperToJournal();
			}
			else if(choice == 6) {
				createProject();
			}
			else if(choice == 7) {
				addPaperToProject();
			}
			else if(choice==8) {
				break;
			}
		}
		
	}


	/**
     * Creates a new research paper. Asks the researcher for paper details such as name, pages, and DOI.
     */
	private void createPaper() {
		User u = (User)this.getUser();
		u.getLanguage().enterReturnBack();
		u.getLanguage().enterTheName();
		
		Scanner in = new Scanner(System.in);
		
		String name = in.nextLine();
		
		if(name.equals("0")) {
			return;
		}
		
		Vector<Researcher> authors = new Vector<Researcher>();
		authors.add(this);
		
		u.getLanguage().enterTheNumberOfPages();
	
		int pages;
		while(true) {
			try {
				pages = in.nextInt();
				while(pages<=0) {
					
					u.getLanguage().enterValidNumberOfPages();
					pages = in.nextInt();
					
				}
				in.nextLine();
				break;
			}
			catch(InputMismatchException e) {
				u.getLanguage().enterValidNumber();
				in.nextLine();
			}
		}
		
		u.getLanguage().enterTheDoi();
		
		String doi = in.nextLine();
		
		if(!Database.getInstance().getPapersWithoutThis(this).isEmpty()) {
			
			System.out.println("Do you want to cite?\n1-Yes \n2-No");
			
			int choice = StaticMethods.validate(1, 2);
			
			if(choice == 1) {
				System.out.println("Which paper do you want to cite?");
				
				Vector<ResearchPaper> papers = Database.getInstance().getPapersWithoutThis(this);
				
				StaticMethods.printList(papers);
				
				int paperChoice = StaticMethods.validate(1, papers.size());
				
				ResearchPaper paper = papers.get(paperChoice-1);
				
				paper.increaseCitations();
				
			}
		}
		
		ResearchPaper newPaper = new ResearchPaper(name, authors, pages, doi);
		
		this.papers.add(newPaper);
		
		Database.getInstance().addPaper(newPaper);
		
		u.getLanguage().newPaperAdded(newPaper.toString());
		
	}


	@Override
	public String toString() {
		return "Researcher [user=" + user + ", hIndex=" + hIndex + "]";
	}
	
	
}
