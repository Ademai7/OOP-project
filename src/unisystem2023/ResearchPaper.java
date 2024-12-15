package unisystem2023;

import java.io.Serializable;
import java.util.Objects;

public class ResearchPaper implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private boolean finished;
	private String topic;
	private String studyField;
	private String doi;
	

	public ResearchPaper(){
		super();
	}
	public ResearchPaper(String name, String topic, String studyField, String doi) {
		this.name = name;
		this.topic = topic;
		this.studyField = studyField;
		this.doi = doi;
	}
	public String getName() {
		return name;
	}
	public boolean isFinished() {
		return finished;
	}
	public String gettopic() {
		return topic;
	}
	public String getstudyField() {
		return studyField;
	}
	public boolean equals(Object o) {
		if(o == null) {return false;}
		if(this == o) {return true;}
		if(this.getClass() != o.getClass()) {return false;}
		ResearchPaper r = (ResearchPaper) o;
		return this.name.equals(r.name) && finished == r.finished
				&& this.studyField.equals(r.studyField) && this.topic.equals(r.topic);
	}
	public int hashCode() {
		return Objects.hash(name, finished, studyField, topic);	
	}
	public String toString() {
		return "Research paper's name: " + name
				+ ", The field of study: " + studyField + "Paper's topic:" + topic;
	}

	public void finish(){
		finished = true;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}


}

