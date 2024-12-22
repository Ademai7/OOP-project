package utils;

import java.io.Serializable;

/**
 * The Mark class represents the mark of course for a student, including two attestations
 * and a final exam.
 */
public class Mark implements Serializable {
	
	
	private static final long serialVersionUID = 7664173347655213766L;
	
	private Double attestation1;
	private Double attestation2;
	private Double finalExam;
	
	
	 /**
     * Constructs a new Mark with default values for attestations and the final exam.
     */
	public Mark() {
		this.attestation1 = null;
		this.attestation2 = null;
		this.finalExam = null;
	}

	/**
     * Constructs a new Mark with the specified values for attestations and the final exam.
     *
     * @param attestation1 The mark for the first attestation.
     * @param attestation2 The mark for the second attestation.
     * @param finalExam    The mark for the final exam.
     */
	public Mark(double attestation1, double attestation2, double finalExam) {
		this.attestation1 = attestation1;
		this.attestation2 = attestation2;
		this.finalExam = finalExam;
	}
	
	/**
     * Calculates and returns the GPA based on the sum of the marks for attestations and the final exam.
     *
     * @return The calculated GPA.
     */
	double sum = attestation1 + attestation2 + finalExam;
	public double getGpa() {
		double sum = attestation1 + attestation2 + finalExam;
		if(sum>=95) {
			return 4.0;
		}
		if(sum>=90) {
			return 3.67;
		}
		if(sum>=85) {
			return 3.33;
		}
		if(sum>=80) {
			return 3.0;
		}
		if(sum>=75) {
			return 2.67;
		}
		if(sum>=70) {
			return 2.33;
		}
		if(sum>=65) {
			return 2.0;
		}
		if(sum>=60) {
			return 1.67;
		}
		if(sum>=55) {
			return 1.33;
		}
		if(sum>=50) {
			return 1.0;
		}
        return 0.0;
	}
	
	/**
     * Returns the mark for the first attestation.
     *
     * @return The mark for the first attestation.
     */
	public Double getAtt() {
		return attestation1;
	}


	@Override
	public String toString() {
		return "Mark [attestation1=" + attestation1 + ", attestation2=" + attestation2 + ", finalExam=" + finalExam
				+ "]";
	}

	public double getMark() {
		return sum;
	}
	
	
}
