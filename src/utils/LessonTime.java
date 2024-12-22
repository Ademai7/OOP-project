package utils;

import java.io.Serializable;

import enums.Day;

/**
 * The `LessonTime` class represents the time for a lesson, including the day of the week,
 * start time, and end time.
 */
public class LessonTime implements Serializable {
	private Day dayOfTheWeek;
	private int startTime;
	private int endTime;
	
	
	public LessonTime(Day dayOfTheWeek, int time) {
		this.dayOfTheWeek = dayOfTheWeek;
		this.startTime = time;
		this.endTime = time + 1;
	}
	
	public String toString() {
		return this.dayOfTheWeek + " " + startTime + ":00 - " + endTime + ":00";
	}
	
}
