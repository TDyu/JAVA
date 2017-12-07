package h1;

public class NNMultiplication {

	public static void main(String[] args) {
		NNEntity[] xListA = { new NNInteger(2), new NNInteger(3), new NNInteger(5), new NNInteger(6), new NNInteger(10) };
		NNEntity[] yListA = { new NNInteger(7), new NNInteger(2), 	new NNInteger(3), new NNInteger(4), new NNInteger(8) };
		TableDisplayer.multiplyAndShow(xListA, yListA);
		
		NNEntity[] xListB = { new NNString("SNH"), new NNString("Gnz"), new NNString("bej"), new NNString("SHY"), new NNString("CKG") };
		NNEntity[] yListB = { new NNString("TeamS2"), new NNString("TeamN3"), new NNString("TeamB"), new NNString("HJL"), new NNString("news") };
		TableDisplayer.multiplyAndShow(xListB, yListB);
		
		NNEntity[] xListC = { new NNColor("Red"), new NNColor("red"), new NNColor("Ra"), new NNColor("Green"), new NNColor("Blue") };
		NNEntity[] yListC = { new NNColor("Green"), new NNColor("Blue"), new NNColor("Ra"), new NNColor("Blue"), new NNColor("Green") };
		TableDisplayer.multiplyAndShow(xListC, yListC);
	}

}

abstract class NNEntity {
	public abstract NNEntity multiply(NNEntity otherone);
}

class NNInteger extends NNEntity {
	private int number;
	
	/**
	 * 假如不帶參數, 則預設為0
	 */
	public NNInteger() {
		this.number = 0;
	}

	public NNInteger(int number) {
		this.number = number;
	}

	public NNInteger(NNInteger copy) {
		this(copy.number);
	}

	// 數字相乘
	public NNEntity multiply(NNEntity otherone) {
		if (otherone == null) {
			return null;
		} else if (getClass() != otherone.getClass()) {
			return null;
		} else {
			NNInteger otherone2 = (NNInteger) otherone;
			return new NNInteger(this.number * otherone2.number);
		}
	}

	public String toString() {
		return Integer.toString(number);
	}
}

class NNString extends NNEntity {
	private String words;
	
	/**
	 * 假如不帶參數, 則預設為空字串
	 */
	public NNString() {
		this.words = "";
	}

	public NNString(String words) {
		// 預設為若為字母則大寫
		String newWords = "";
		for (int i = 0; i < words.length(); i++) {
			if (Character.isLetter(words.charAt(i))) {
				newWords += Character.toUpperCase(words.charAt(i));
			} else {
				newWords += words.charAt(i);
			}
		}
		this.words = newWords;
	}

	public NNString(NNString copy) {
		this(copy.words);
	}

	// 字串相連
	public NNEntity multiply(NNEntity otherone) {
		if (otherone == null) {
			return null;
		} else if (getClass() != otherone.getClass()) {
			return null;
		} else {
			NNString otherone2 = (NNString) otherone;
			return new NNString(this.words + otherone2.words);
		}
	}

	public String toString() {
		return words;
	}
}

class NNColor extends NNEntity {
	// 外部輸入的原指定顏色字串
	private String color;
	// 真正拿來混合的顏色, 預設為White
	private String toMixColor = WHITE;
	// 外部輸入的是否為空或正確顏色(Red or Blue or Green), 預設為true
	private Boolean isColor = true;
	private final static String WHITE = "White";
	private final static String RED = "Red";
	private final static String BLUE = "Blue";
	private final static String GREEN = "Green";
	private final static String RED_GREEN = "Yellow";
	private final static String RED_BLUE = "Purple";
	private final static String BLUE_GREEN = "Cyan";
	
	/**
	 * 假如不帶參數, 則預設為White
	 */
	public NNColor() {
		this.color = WHITE;
	}

	/**
	 * 假如外部輸入不等於Red、Blue、Green, 則預設為White
	 * @param color
	 */
	public NNColor(String color) {
		// 無論輸入是大小寫, 統一改為首字母大寫其他為小寫
		color = color.toUpperCase().charAt(0) + color.toLowerCase().substring(1);
		this.color = color;

		// 假如不等於White、Red、Blue、Green, 則真正拿來混合的顏色預設為White
		if (!color.equals(RED) && !color.equals(BLUE) && !color.equals(GREEN)) {
			this.isColor = false;
		} else {
			this.toMixColor = color;
		}
	}
	
	public NNColor(NNColor copy) {
		this(copy.color);
	}
	
	/**
	 * 內用輸出答案專用Constructor
	 * @param answerColor
	 * @param isAnswer
	 */
	private NNColor(String answerColor, Boolean isAnswer) {
		if (isAnswer) {
			if (!answerColor.equals(WHITE) && !answerColor.equals(RED) && !answerColor.equals(BLUE) && 
				!answerColor.equals(GREEN) && !answerColor.equals(RED_GREEN) && 
				!answerColor.equals(RED_BLUE) && !answerColor.equals(BLUE_GREEN)) {
				this.color = WHITE;
			} else {
				this.color = answerColor;
			}
		}
	}

	/*
	 * 顏色相混
	 * Red * Blue = Purple
	 * Red * Green = Yellow
	 * Blue * Green = Cyan
	 * White * 任一顏色 = 任一顏色
	 */
	public NNEntity multiply(NNEntity otherone) {
		if (otherone == null) {
			return null;
		} else if (getClass() != otherone.getClass()) {
			return null;
		} else {
			NNColor otherone2 = (NNColor) otherone;
			String answer = "";
			String mixedColor = "";
			if (!this.isColor) {
				mixedColor = this.toMixColor;
			} else {
				mixedColor = this.color;
			}

			if (mixedColor.equals(RED)) {
				switch (otherone2.toMixColor) {
					case RED:
						answer = RED;
						break;
					case BLUE:
						answer = RED_BLUE;
						break;
					case GREEN:
						answer = RED_GREEN;
						break;
					default:
						answer = this.color;
				}
			} else if (mixedColor.equals(BLUE)) {
				switch (otherone2.toMixColor) {
					case RED:
						answer = RED_BLUE;
						break;
					case BLUE:
						answer = BLUE;
						break;
					case GREEN:
						answer = BLUE_GREEN;
						break;
					default:
						answer = this.color;
				}
			} else if (mixedColor.equals(GREEN)) {
				switch (otherone2.toMixColor) {
					case RED:
						answer = RED_GREEN;
						break;
					case BLUE:
						answer = BLUE_GREEN;
						break;
					case GREEN:
						answer = GREEN;
						break;
					default:
						answer = this.color;
				}
			} else {
				answer = otherone2.color;
			}
			return new NNColor(answer, true);
		}
	}

	public String toString() {
		return color;
	}
}

class TableDisplayer {

	/**
	 * 印出適當空格數 + 要印的字串
	 * @param preSpaceNumber: 前置空格數
	 * @param maxLength: 當column最常字串長度
	 * @param answer: 要印出的答案
	 */
	public static void printString(int preSpaceNumber, int maxLength, String printStr) {
		int lengthGap = maxLength - printStr.length();
		
		// 前置的空白
		for (int i = 0; i < preSpaceNumber; i++) {
			System.out.print(" ");
		}
		// 適當的補空白
		for (int i = 0; i < lengthGap; i++) {
			System.out.print(" ");
		}
		// 要印的字串
		System.out.print(printStr);
	}
	
	public static void multiplyAndShow(NNEntity[] xList, NNEntity[] yList) {
		// 在每個column當中最長的字串長度
		int[] maxLength = new int[xList.length];
		// 在yList當中最長的字串長度
		int yListMaxLength = 0;
		// 每個column當中最長的字串長度總長
		int columnTotalLength = 0;
		// 相隔的空白數目
		int preSpaceNumber = 3;
		
		/* Multiply */
		NNEntity[][] table = new NNEntity[yList.length][xList.length];
		for (int i = 0; i < yList.length; i++) {
			for (int j = 0; j < xList.length; j++) {
				table[i][j] = xList[j].multiply(yList[i]);
				// 找在每個column當中最長的字串長度
				if (table[i][j].toString().length() > maxLength[j]) {
					maxLength[j] = table[i][j].toString().length();
				}
			}
			// 找在yList當中最長的字串長度
			if (yList[i].toString().length() > yListMaxLength) {
				yListMaxLength = yList[i].toString().length();
			}
		}
		
		for (int i = 0; i < maxLength.length; i++) {
			// 累計每個column當中最長的字串長度總長
			columnTotalLength += maxLength[i];
		}
		
		/* Show */
		// 印出前置空格
		printString(preSpaceNumber, yListMaxLength + 1, "");
		// 印出xList集適當空格
		for (int i = 0; i < xList.length; i++) {
			printString(preSpaceNumber, maxLength[i], xList[i].toString());
		}
		System.out.println();
		// 印出前置空格
		System.out.print("   ");
		// 印出適當數量的分隔線
		for (int i = 0; i < yListMaxLength + 1 + columnTotalLength + preSpaceNumber * xList.length; i++) {
			System.out.print("-");
		}
		System.out.println();
		for (int i = 0; i < yList.length; i++) {
			// 印出適當空格及yList
			printString(preSpaceNumber, yListMaxLength + 1, yList[i] + "|");
			// 印出適當空格及答案
			for (int j = 0; j < xList.length; j++) {
				printString(preSpaceNumber, maxLength[j], table[i][j].toString());
			}
			System.out.println();
		}
		System.out.println();
	}
}