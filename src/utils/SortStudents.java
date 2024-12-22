package utils;

import java.util.Comparator;
import wsp.*;


/**
 * The SortStudents class is a comparator for sorting students based on their GPA in ascending order.
 */
public class SortStudents implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getGpa(), o2.getGpa());
    }
}
