package lab5;

public class Practice extends AbstractTest {
	
	/**
	 * Constructor
	 */
	public Practice() {
		System.out.println("現在開始準備隨堂練習考卷");
	}

	/**
	 * Go to test
	 */
	@Override
	public void test() {
		System.out.println("現在開始進行隨堂練習");
	}

	/**
	 * Go over test
	 */
	@Override
	public void goOverTest() {
		System.out.println("現在開始進行隨堂練習的閱卷");
	}

}
