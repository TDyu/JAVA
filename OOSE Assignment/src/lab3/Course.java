package lab3;

import java.util.*;

/**
 * 課程
 */
public class Course {
	
	/**
     * 課程名稱
     */
    private String name;
    /**
     * 課程成績單
     */
    private GradeBook gradeBook; 

    /**
     * Default constructor
     */
    public Course(String name) {
    	this.name = name;
    	gradeBook = new GradeBook();
    }

    /**
     * 顯示第一名的
     */
    public void showTop() {
    	// 先拿到所有學生和成績
    	ArrayList<Student> students = gradeBook.getStudents();
    	ArrayList<Integer> grades = gradeBook.getGrades();
        int maxIndex = -1;
        // 找出最高分的index
        for (int i = 0; i < grades.size(); i++) {
        	if (grades.get(i) > maxIndex) {
        		maxIndex = i;
        	}
        }
        System.out.println("Top 1 is " + students.get(maxIndex).getName() + "'s " + grades.get(maxIndex));
    }

    /**
     * 顯示未及格的
     */
    public void showNoPass() {
    	// 先拿到所有學生和成績
    	ArrayList<Student> students = gradeBook.getStudents();
    	ArrayList<Integer> grades = gradeBook.getGrades();
        ArrayList<Integer> noPassIndexs = new ArrayList<Integer>();
        // 找出所有未及格的 index
        for (int i = 0; i < grades.size(); i++) {
        	if (grades.get(i) < 60) {
        		noPassIndexs.add(i);
        	}
        }
        // 顯示所有未及格
        for (int i = 0; i < noPassIndexs.size(); i++) {
        	System.out.println("[Name: " + students.get(i).getName() + ", Grade: " + grades.get(i));
        }
    }

    /**
     * 顯示所有成績
     */
    public void showGrades() {
    	// 先拿到所有學生和成績
    	ArrayList<Student> students = gradeBook.getStudents();
    	ArrayList<Integer> grades = gradeBook.getGrades();
        for (int i = 0; i < students.size(); i++) {
        	System.out.println("[Name: " + students.get(i).getName() + ", Grade: " + grades.get(i) + "]");
        }
    }
    
    /**
     * 將選課學生加入此門課的學生名單中
     * @param student
     */
    public void addStudent(Student student) {
    	// 將學生加生此門課成績單的學生名單中
    	gradeBook.addStudent(student);
    }
    
    /**
     * 更改成績
     * @param student
     * @param grade
     */
    public void setGrade(Student student, int grade) {
    	// 先拿到所有學生和成績
    	gradeBook.setGrade(student, grade);
    }

	@Override
	public String toString() {
		return "Course name: " + name;
	}

}