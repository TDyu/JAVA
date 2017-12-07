package lab5;

public class Exam extends AbstractTest {
	
	/**
	 * Constructor
	 */
	public Exam() {
		System.out.println("現在開始準備正式考試考卷");
	}

	/**
	 * Go to test
	 */
	@Override
	public void test() {
		System.out.println("現在開始進行正式考試");
	}

	/**
	 * Go over test
	 */
	@Override
	public void goOverTest() {
		System.out.println("現在開始進行正式考試的閱卷");
	}

}
