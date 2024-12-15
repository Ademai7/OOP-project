package uiclasses;

import java.io.IOException;
import java.util.Vector;

import unisystem2023.ResearchPaper;
import users.Researcher;

public class ResearcherUI extends UserUI{

	Researcher researcher;

	public ResearcherUI(){
		super();
	}

	public ResearcherUI(Researcher researcher){
		this.researcher = researcher;
	}

	public void startResearch() throws IOException {
	    print("Insert the name of the research (Enter '0' to exit):");
	    String name = reader.readLine();
	    if (name.equals("0")) {
	        return;
	    }

	    print("Insert the theme of the research:");
	    String theme = reader.readLine();

	    print("Insert the field of study:");
	    String fieldStudy = reader.readLine();
	    
	    print("Insert the doi of research paper:");
	    String doi = reader.readLine();

	    ResearchPaper paper = new ResearchPaper(name, theme, fieldStudy, doi);
	    researcher.addResearch(paper);
	    print("Research started!");
	}

	
	
	
	public void dropResearch() throws IOException {
	    print("Enter the name of the research you want to drop (Enter '0' to exit):");
	    String name = reader.readLine();
	    if (name.equals("0")) {
	        return;
	    }

	    print("Enter the theme of the research:");
	    String theme = reader.readLine();

	    print("Enter the field of study:");
	    String fieldStudy = reader.readLine();
	    
	    print("Enter the doi of research paper:");
	    String doi = reader.readLine();

	    ResearchPaper paper = new ResearchPaper(name, theme, fieldStudy, doi);
	    researcher.dropResearch(paper);
	    print("Research dropped successfully!");
	}
	
	
	public void viewResearch() {
	    try {
	        Vector<ResearchPaper> researches = researcher.getResearches();
	        if (researches.isEmpty()) {
	            print("There are no research papers available.");
	        } else {
	            researches.forEach(paper -> {
	                try {
	                    print(paper.toString());
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            });
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


	public void publicResearch() throws IOException {
	    print("Print the name, theme, and field of study of the research by entering each:");
	    String name = reader.readLine();
	    String theme = reader.readLine();
	    String fieldStudy = reader.readLine();
	    String doi = reader.readLine();

	    ResearchPaper needPaper = new ResearchPaper(name, theme, fieldStudy, doi);

	    for (ResearchPaper paper : researcher.getResearches()) {
	        if (paper.equals(needPaper)) {
	            paper.finish();
	            print("The status of the research is finished.");
	            return;
	        }
	    }

	    print("Something is wrong");
	}


	public void main(){
		while(true){
			try{
				print("0. Exit");
				print("1. Start new research");
				print("2. Delete research");
				print("3. View all researches");
				print("4. Public research. Print papers");
				String ans = reader.readLine();
				switch(ans){
					case "0":
						return;
					case "1":
						startResearch();
						break;
					case "2":
						dropResearch();
						break;
					case "3":
						viewResearch();
						break;
					case "4":
						publicResearch();
					default:
						print("No such option");
				}
			}
			catch (IOException ioe){
				System.out.println("Something is wrong");
			}
		}
	}

}

