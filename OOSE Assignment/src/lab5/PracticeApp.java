package lab5;

/*
 * Real creator for practice
 */
public class PracticeApp extends AbstractExamApp {

	/**
	 * Create real practice
	 */
	@Override
	public AbstractTest prepareTest() {
		return new Practice();
	}
}
