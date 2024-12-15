package unisystem2023;

import java.io.Serializable;

public class Mark implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double att1;
	private double att2;
	private double finalExam;
	
	public Mark() {
		
	}
	
    // Getters and setters

    public double getAtt1() {
        return att1;
    }

    public void setAtt1(double att1) {
        this.att1 = att1;
    }

    public double getAtt2() {
        return att2;
    }

    public void setAtt2(double att2) {
        this.att2 = att2;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mark other = (Mark) obj;
		if (Double.doubleToLongBits(att1) != Double.doubleToLongBits(other.att1))
			return false;
		if (Double.doubleToLongBits(att2) != Double.doubleToLongBits(other.att2))
			return false;
		if (Double.doubleToLongBits(finalExam) != Double.doubleToLongBits(other.finalExam))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Mark [att1=" + att1 + ", att2=" + att2 + ", finalExam=" + finalExam + "]";
	}
}
