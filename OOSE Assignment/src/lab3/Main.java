package lab3;

public class Main {

	public static void main(String[] args) {
		
		// 創建測試學校實體
		University fcu = new University("FCU");
		// 創建測試課程實體
		Course java = new Course("Java");
		// 創建測試老師實體
		Teacher nick = new Teacher("Nick");
		// 創建測試學生實體
		Student albert = new Student("Albert");
		Student jie = new Student("Jie");
		
		// 學校可以聘僱老師, 給予老師在這學校的老師ID: t01
		fcu.hire(nick, "t01");
		
		// 老師可以開課
		nick.offer(java);
		// 課程會被加入課程列表
		fcu.addCourse(java);
		
		// 學生可以進入學校, 同時獲得在這學校的學生ID
		albert.enter(fcu, "s01");
		jie.enter(fcu, "s02");
		
		// 學校可以列出所有成員
		fcu.showMenbers();
		
		// 學校可以列出所有所開課程
		fcu.showCourses();
		
		// 學生可以選課
		albert.takeCourse(java);
		jie.takeCourse(java);
		
		// 老師可以給學生打分數
		nick.score(java, jie, 90);
		nick.score(java, albert, 100);
		
		// 學校可以列出所有成績
		fcu.listGrade();
		
		// 學校可以列出所有班級不及格的學生
		fcu.showNoPass();
		
		// 學校可以列出所有班級第一名的學生
		fcu.showTop();
	}

}
