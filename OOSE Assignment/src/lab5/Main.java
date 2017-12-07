package lab5;

public class Main {

	public static void main(String[] args) {
		/* Practice */
		// new creator
		AbstractExamApp practiceApp = new PracticeApp();
		// do practice
		practiceApp.doTest();
		System.out.println("=========");
		
		/* Quiz */
		// new creator
		AbstractExamApp quizApp = new QuizApp();
		// do quiz
		quizApp.doTest();
		System.out.println("=========");
				
		/* Exam */
		// new creator
		AbstractExamApp examApp = new ExamApp();
		// do exam
		examApp.doTest();
	}

}
