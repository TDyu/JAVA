package lab5;

/**
 * Real creator for quiz
 */
public class QuizApp extends AbstractExamApp {

	/**
	 * Create real quiz
	 */
	@Override
	public AbstractTest prepareTest() {
		return new Quiz();
	}

}
