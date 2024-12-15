package courses;

import java.io.Serializable;
import java.util.HashMap;


import enums.DayWeek;


class Lesson implements Serializable {


	private static final long serialVersionUID = 1L;
	private String lessonName;
    private Courses courseName;
    private HashMap <DayWeek, Time> schedule;
    private int auditorium; // мб экспепшн на номер кабов сделаем
    
    public Lesson() {
        // Default constructor
    }

    public Lesson(String lessonName, Courses courseName) {
        this.lessonName = lessonName;
        this.courseName = courseName;
    }
    
    public Lesson(String lessonName, Courses courseName, HashMap <DayWeek, Time> schedule, int auditorium) {
        this.lessonName = lessonName;
        this.courseName = courseName;
        this.schedule = schedule;
        this.auditorium = auditorium;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public Courses getCourseName() {
        return courseName;
    }

    public void setCourseName(Courses courseName) {
        this.courseName = courseName;
    }

    public HashMap<DayWeek, Time> getSchedule() {
        return schedule;
    }

    public void setSchedule(HashMap<DayWeek, Time> schedule) {
        this.schedule = schedule;
    }

    public int getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(int auditorium) {
        this.auditorium = auditorium;
    }

    
}
