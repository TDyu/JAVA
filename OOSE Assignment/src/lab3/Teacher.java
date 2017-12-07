package lab3;

import java.util.*;

/**
 * 老師
 */
public class Teacher extends Member {
	
	/**
     * 所開課程列表
     */
    private ArrayList<Course> courses = new ArrayList<Course>();

    /**
     * Default constructor
     */
    public Teacher(String name) {
    	super(name);
    }
    
    /**
     * 有進入學校時, 獲得ID成為學校成員的Constructor
     * @param name
     * @param ID
     */
    public Teacher(String name, String ID) {
    	super(name, ID);
    }

    /**
     * 老師可以開課
     * @param course
     */
    public void offer(Course course) {
        // 加入課程列表
    	courses.add(course);
    }

    /**
     * 打分
     * @param course 
     * @param student 
     * @param grade
     */
    public void score(Course course, Student student, int grade) {
        course.setGrade(student, grade);
    }

}