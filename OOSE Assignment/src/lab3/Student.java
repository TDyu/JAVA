package lab3;

/**
 * 學生
 */
public class Student extends Member {

    /**
     * Default constructor
     */
    public Student(String name) {
    	super(name);
    }

    /**
     * 有進入學校時, 獲得ID成為學校成員的Constructor
     * @param name
     * @param ID
     */
    public Student(String name, String ID) {
    	super(name, ID);
    }

    /**
     * 學生進入學校, 同時擁有在此的學生ID
     * @param university 
     * @param ID
     */
    public void enter(University university, String ID) {
        // 學校將其加入成員列表
    	university.addStudent(this.getName(), ID);
    }

    /**
     * 選課
     * @param course
     */
    public void takeCourse(Course course) {
        // 此課程把學生加入學生名單中
    	course.addStudent(this);
    }

}