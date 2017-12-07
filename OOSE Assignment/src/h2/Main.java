package h2;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		/* 有三科科目成績Eng, Math, Physical, 所以先創建這三個科目 */
		// 假定英文課ID為1
		Course english = new Course("Eng", 1);
		// 假定數學課ID為2
		Course math = new Course("Math", 2);
		// 假定物理課ID為3
		Course physical = new Course("Physical", 3);
		ArrayList<Course> courses = new ArrayList<Course>(Arrays.asList(english, math, physical));
		
		/* 創建一群學生 必須修有上面三個科目 (假定學生ID從1開始) */
		Student student1 = new Student(1, "A", courses);
		Student student2 = new Student(2, "B", courses);
		Student student3 = new Student(3, "C", courses);
		ArrayList<Student> students = new ArrayList<Student>(Arrays.asList(student1, student2, student3));
		
		/* 創建GradeBook 封裝一群學生(沒有學生則GradeBook也沒有意義, 但學生獨立(沒有GradeBook學生依舊存在)) */
		GradeBook gradeBook = new GradeBook(students);
		
		/* 填假設成績 (課程ID, 成績) */
		// 學生1
		student1.setGrade(1, 100);
		student1.setGrade(2, 90);
		student1.setGrade(3, 85);
		// 學生2
		student2.setGrade(1, 80);
		student2.setGrade(2, 55);
		student2.setGrade(3, 79);
		// 學生3
		student3.setGrade(1, 60);
		student3.setGrade(2, 70);
		student3.setGrade(3, 30);
		
		/* 用學生ID取得某學生的平均成績 */
		System.out.println("用學生ID取得某學生的平均成績");
		System.out.println();
		// 取得學生A(學生ID: 1)平均成績
		System.out.println(student1 + " 平均成績:  " + gradeBook.getStudentAvg(1));
		// 取得學生B(學生ID: 2)平均成績
		System.out.println(student2 + " 平均成績:  " + gradeBook.getStudentAvg(2));
		// 取得學生C(學生ID: 3)平均成績
		System.out.println(student3 + " 平均成績:  " + gradeBook.getStudentAvg(3));
		System.out.println();
		System.out.println("===================================================");
		
		/* 用學生ID取得某學生的成績列表 */
		System.out.println();
		System.out.println("用學生ID取得某學生的成績列表");
		System.out.println();
		int[] grades;
		// 取得學生A(學生ID: 1)成績列表
		grades = gradeBook.getStudentGrade(1);
		System.out.println(student1 + "成績列表:");
		for (int i = 0; i < courses.size(); i++) {
			System.out.println(courses.get(i) + ", Grade: " + grades[i]);
		}
		System.out.println();
		// 取得學生B(學生ID: 2)成績列表
		grades = gradeBook.getStudentGrade(2);
		System.out.println(student2 + "成績列表:");
		for (int i = 0; i < courses.size(); i++) {
			System.out.println(courses.get(i) + ", Grade: " + grades[i]);
		}
		System.out.println();
		// 取得學生C(學生ID: 3)成績列表
		grades = gradeBook.getStudentGrade(3);
		System.out.println(student3 + "成績列表:");
		for (int i = 0; i < courses.size(); i++) {
			System.out.println(courses.get(i) + ", Grade: " + grades[i]);
		}
		System.out.println();
		System.out.println("===================================================");
		
		/* 用科目ID取得某科目的平均成績 */
		System.out.println();
		System.out.println("用科目ID取得某科目的平均成績");
		System.out.println();
		// 取得Eng(課程ID: 1)平均成績
		System.out.println(english + " 平均成績: " + gradeBook.getSubjectAvg(1));
		// 取得Math(課程ID: 2)平均成績
		System.out.println(math + " 平均成績: " + gradeBook.getSubjectAvg(2));
		// 取得Physical(課程ID: 3)平均成績
		System.out.println(physical + " 平均成績: " + gradeBook.getSubjectAvg(3));
	}

}
