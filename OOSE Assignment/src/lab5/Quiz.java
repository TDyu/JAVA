package lab5;

public class Quiz extends AbstractTest {
	
	/**
	 * Constructor
	 */
	public Quiz() {
		System.out.println("現在開始準備小考考卷");
	}

	/**
	 * Go to test
	 */
	@Override
	public void test() {
		System.out.println("現在開始進行小考");
	}

	/**
	 * Go over test
	 */
	@Override
	public void goOverTest() {
		System.out.println("現在開始進行小考的閱卷");
	}

}
