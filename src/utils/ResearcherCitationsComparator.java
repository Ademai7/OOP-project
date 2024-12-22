package utils;

import java.util.Comparator;
import java.util.Vector;

import wsp.Researcher;

/**
 * The ResearcherCitationsComparator class is a comparator for comparing researchers based on the total number of citations
 * received for their research papers.
 */
public class ResearcherCitationsComparator implements Comparator<Researcher>  {

	@Override
	public int compare(Researcher o1, Researcher o2) {
		int cite1 = 0;
		int cite2 = 0;
		Vector<ResearchPaper> papers1 = o1.getPapers();
		Vector<ResearchPaper> papers2 = o2.getPapers();
		for(ResearchPaper rp : papers1) {
			cite1 += rp.getCitations();
		}
		for(ResearchPaper rp : papers2) {
			cite2 += rp.getCitations();
		}
		
		return Integer.compare(cite1, cite2);
	}

}
