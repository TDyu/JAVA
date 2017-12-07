package h2;

import java.util.*;

/**
 * 成績系統
 */
public class GradeBook {

	/**
     * GradeBook封裝一群學生
     */
    private ArrayList<Student> students;

    /**
     * Default constructor
     */
    public GradeBook(ArrayList<Student> students) {
    	this.students = students;
    }


    /**
     * 用學生ID取得某學生的平均成績 
     * @param studentID 
     * @return 
     */
    public double getStudentAvg(int studentID) {
        // 找出是哪個學生
    	Student student = null;
    	for (int i = 0; i < students.size(); i++) {
        	if (studentID == students.get(i).getStudentID()) {
        		student = students.get(i);
        	}
        }
    	
    	/* 再以此學生取得其平均成績 */
    	// 獲取其成績列表
    	int[] grades = student.getGrades();
    	// 計算平均並回傳
        int totalGrades = 0;
        for (int i = 0; i < grades.length; i++) {
        	totalGrades += grades[i];
        }
        double average = totalGrades / grades.length;
        return average;
    }

    /**
     * 用學生ID取得某學生的成績列表
     * @param studentID 
     * @return
     */
    public int[] getStudentGrade(int studentID) {
    	// 找出是哪個學生
    	Student student = null;
    	for (int i = 0; i < students.size(); i++) {
        	if (studentID == students.get(i).getStudentID()) {
        		student = students.get(i);
        	}
        }
    	// 再獲取其成績列表並回傳
        return student.getGrades();
    }

    /**
     * 用科目ID取得某科目的平均成績
     * @param courseID 
     * @return
     */
    public double getSubjectAvg(int courseID) {
    	// 該科加總成績
    	int totalGrade = 0;
        // 輪流各個學生該科成績
    	for (int i = 0; i < students.size(); i++) {
    		totalGrade += students.get(i).getGrade(courseID);
    	}
    	// 計算平均並回傳
        double average = totalGrade / students.size();
        return average;
    }

}