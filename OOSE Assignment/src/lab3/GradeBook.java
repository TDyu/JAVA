package lab3;

import java.util.*;

/**
 * 
 */
public class GradeBook {
	
	/**
     * 所有修課學生
     */
    private ArrayList<Student> students;
    /**
     * 所有成績
     */
    private ArrayList<Integer> grades;

    /**
     * Default constructor
     */
    public GradeBook() {
    	students = new ArrayList<Student>();
    	grades = new ArrayList<Integer>();
    }

    /**
     * 獲取所有學生
     * @return
     */
	public ArrayList<Student> getStudents() {
		return students;
	}

	/**
	 * 添加新學生
	 * 同時要擴充成績名額, 預設為0
	 * @param student
	 */
	public void addStudent(Student student) {
		this.students.add(student);
		this.grades.add(0);
	}

	/**
	 * 獲取所有成績
	 * @return
	 */
	public ArrayList<Integer> getGrades() {
		return grades;
	}

	/**
	 * 更改學生成績
	 * @param student
	 * @param grade
	 */
	public void setGrade(Student student, int grade) {
		// 找到這名學生的index再改相對應的成績欄位
    	for (int i = 0; i < students.size(); i++) {
    		if (students.get(i).getID() == student.getID()) {
    			grades.set(i, grade);
    			break;
    		}
    	}
	}

}