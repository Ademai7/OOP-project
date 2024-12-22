package utils;

import java.io.Serializable;
import java.util.Vector;

/**
 * The ResearchProject class represents a research project that consists of multiple research papers.
 */
public class ResearchProject implements Serializable {
	
	private String name;
	
	private Vector<ResearchPaper> papers;
	
	/**
     * Creates a new research project with an empty list of research papers.
     */
    public ResearchProject(String name) {
    	this.name = name;
        this.papers = new Vector<>();
    }
    
    public void addPaperToProject(ResearchPaper rp) {
    	this.papers.add(rp);
    }
    
    public String getName() {
    	return name;
    }
    
    public String toString() {
    	return "Project " + name + " Number of papers: " + papers.size();
    }
}
