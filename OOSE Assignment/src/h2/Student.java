package h2;

import java.util.*;

/**
 * 學生
 */
public class Student {
	
	private int studentID;
	private String name;
	private ArrayList<Course> courses;
	// 對應課程做成績紀錄
	private int[] grades;
	
	public Student(int studentID, String name, ArrayList<Course> courses) {
		this.studentID = studentID;
		this.name = name;
		this.courses = courses;
		// courses有幾個 grades就該有幾個
		this.grades = new int[courses.size()];
	}
	
	/**
	 * 取得學生ID
	 * @return
	 */
	public int getStudentID() {
		return studentID;
	}
	
	/**
	 * 取得修習課程
	 * @return
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	/**
	 * 取得成績列表
	 * @return
	 */
	public int[] getGrades() {
		return grades;
	}
	
	/**
	 * 用課程ID取得某科成績
	 * @param courseID
	 * @return
	 */
	public int getGrade(int courseID) {
		// 找出對應課程ID的index
		int courseIndex = 0;
		for (int i = 0; i < courses.size(); i++) {
			if (courseID == courses.get(i).getCourseID()) {
				courseIndex = i;
			}
		}
		// 回傳該科目對應的index的成績
		return grades[courseIndex];
	}
	
	/**
	 * 用課程ID修改分數
	 * @param courseID
	 * @param grade is new grade
	 */
	public void setGrade(int courseID, int grade) {
		// 找出對應課程ID的index
		int courseIndex = 0;
		for (int i = 0; i < courses.size(); i++) {
			if (courseID == courses.get(i).getCourseID()) {
				courseIndex = i;
			}
		}
		// 修改該科目對應的index的成績
		grades[courseIndex] = grade;
	}

	@Override
	public String toString() {
		return "Student ID: " + studentID + ", Student name: " + name;
	}
}