package h2;

/**
 * 課程
 */
public class Course {

	private String name;
	private int courseID;
	
	/**
     * Default constructor
     */
	public Course(String name, int courseID) {
		this.name = name;
		this.courseID = courseID;
	}
	
	/**
	 * 取得課程成績
	 * @return
	 */
	public int getCourseID() {
		return courseID;
	}

	@Override
	public String toString() {
		return "Course ID: " + courseID + ", Course name: " + name;
	}

}