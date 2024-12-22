package utils;

import java.util.Comparator;

/**
 * The PaperCitationsComparator class is a comparator for sorting research papers based on the <b>number of citations</b>.
 */
public class PaperCitationsComparator implements Comparator<ResearchPaper> {

	@Override
	public int compare(ResearchPaper o1, ResearchPaper o2) {
		return Integer.compare(o1.getCitations(), o2.getCitations());
	}

}
