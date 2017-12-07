package lab3;

import java.util.ArrayList;

/**
 * 學校
 */
public class University {
	
	/**
     * 校名
     */
    private String name;
    /**
     * 成員列表(老師&學生)
     */
    private ArrayList<Member> members;
    /**
     * 所開課程列表
     */
    private ArrayList<Course> courses;

    /**
     * Default constructor
     */
    public University(String name) {
    	this.name = name;
    	members = new ArrayList<Member>();
    	courses = new ArrayList<Course>();
    }

    /**
     * 聘僱老師, 並設定其教師ID
     * @param teacher
     * @param ID
     */
    public void hire(Teacher teacher, String ID) {
        // 將老師加入學校成員列表中, 並給予其在這學校的ID
    	Teacher newTeacher = new Teacher(teacher.getName(), ID);
    	members.add(newTeacher);
    }

    /**
     * 顯示所有成員
     */
    public void showMenbers() {
        for (int i = 0; i < members.size(); i++) {
        	members.get(i).show();
        }
    }

    /**
     * 顯示所有課程
     */
    public void showCourses() {
    	for (int i = 0; i < courses.size(); i++) {
        	courses.get(i).toString();
        }
    }

    /**
     * 列出所有成績
     */
    public void listGrade() {
        for (int i = 0; i < courses.size(); i++) {
        	System.out.println(courses.get(i).toString());
        	courses.get(i).showGrades();
        }
    }

    /**
     * 列出所有班級第一名
     */
    public void showTop() {
    	for (int i = 0; i < courses.size(); i++) {
        	System.out.println(courses.get(i).toString());
        	courses.get(i).showTop();
        }
    }

    /**
     * 列出所有班級未及格的人
     */
    public void showNoPass() {
    	for (int i = 0; i < courses.size(); i++) {
        	System.out.println(courses.get(i).toString());
        	courses.get(i).showNoPass();
        }
    }
    
    /**
     * 加入新學生到成員列表, 並給予學生ID
     * @param name
     * @param ID
     */
    public void addStudent(String name, String ID) {
    	// 將學生加入學校成員列表中, 並給予其在這學校的ID
    	Student newStudent = new Student(name, ID);
    	members.add(newStudent);
    }
    
    /**
     * 當有老師開課時, 將其加入學校課程列表
     * @param course
     */
    public void addCourse(Course course) {
    	courses.add(course);
    }
    
    public String getName() {
    	return name;
    }

}