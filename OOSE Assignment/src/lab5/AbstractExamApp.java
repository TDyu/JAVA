package lab5;

/**
 * Abstract exam application creator
 */
public abstract class AbstractExamApp {

	// abstract test product
	private AbstractTest test;
	
	/**
	 * Examination process.
	 */
	public void doTest() {
		// generate test product
		test = prepareTest();
		// go to test
		test.test();
		// go over test
		test.goOverTest();
	}
	
	/**
	 * Factory method for generate test product.
	 * @return
	 */
	public abstract AbstractTest prepareTest();
}
