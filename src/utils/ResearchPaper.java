package utils;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

import wsp.*;

/**
 * The ResearchPaper class represents a research paper with citations, name, number of pages, doi.
 */
public class ResearchPaper implements Serializable {
	
	private static final long serialVersionUID = -3648353719262566497L;
	
	private String name;
	private Vector<Researcher> authors;
	private int citations;
	private int pages;
	private Date date;
	private String doi;
	
	public ResearchPaper(String name, Vector<Researcher> authors, int pages, String doi) {
		this.name = name;
		this.authors = authors;
		this.pages = pages;
		this.date = new Date();
		this.doi = doi;
		this.citations = 0;
	}
	
	/**
	 * @return the authors
	 */
	public Vector<Researcher> getAuthors() {
		return authors;
	}

	/**
	 * @return the citations
	 */
	public int getCitations() {
		return citations;
	}
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * @return the pages
	 */
	public int getPages() {
		return pages;
	}
	
	/**
     * Increases the number of citations for the research paper.
     */
	public void increaseCitations() {
		this.citations++;
	}

	@Override
	public String toString() {
		return "ResearchPaper [name=" + name + ", authors=" + authors.size() + ", citations=" + citations + ", pages=" + pages
				+ ", date=" + date + ", doi=" + doi + "]";
	}
	
	
}
