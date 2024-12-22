package utils;

import java.util.Comparator;

/**
 * The PaperDateComparator class is a comparator for sorting research papers based on the <b>date</b> of papers.
 */
public class PaperDateComparator implements Comparator<ResearchPaper> {

	@Override
	public int compare(ResearchPaper o1, ResearchPaper o2) {
		return o1.getDate().compareTo(o2.getDate());
	}

}
