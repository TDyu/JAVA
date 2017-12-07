package lab5;

/**
 * Real creator for exam
 */
public class ExamApp extends AbstractExamApp {

	/**
	 * Create real exam
	 */
	@Override
	public AbstractTest prepareTest() {
		return new Exam();
	}
}
