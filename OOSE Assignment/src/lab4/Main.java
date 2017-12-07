package lab4;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		/* 基本定價情況 */
		// 創建測試 PricePolicy, 此時為基本定價
		PricePolicy motherBoardPricePolicy = new PricePolicy(16090);
		PricePolicy memoryPricePolicy = new PricePolicy(7699);
		PricePolicy CPUPricePolicy = new PricePolicy(12900);
		PricePolicy graphicCardPricePolicy = new PricePolicy(6290);
		
		// 創建測試零件商品
		MotherBoard motherBoard = new MotherBoard(motherBoardPricePolicy, "主機板");
		Memory memory = new Memory(memoryPricePolicy, "記憶體");
		CPU cpu = new CPU(CPUPricePolicy, "CPU");
		GraphicCard graphicCard = new GraphicCard(graphicCardPricePolicy, "顯示卡");
		Part[] all = {motherBoard, memory, cpu, graphicCard};
		
		// 測試印出目前單品價格與總價, 應為定價, 價格四捨五入到小數點後第二位
		System.out.println("=== Base Price Policy ===");
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
		calculate(all);
		System.out.println();

		/* 折扣售價情況 */
		// 制定折扣售價, 如未設定折扣預設為1(=沒折扣)
		PricePolicy motherBoardSalePrice = new SalePrice(motherBoard.getPrice(), 0.89);
		PricePolicy memorySalePrice = new SalePrice(memoryPricePolicy.getPrice(), 0.79);
		PricePolicy CPUSalePrice = new SalePrice(CPUPricePolicy.getPrice(), 0.69);
		PricePolicy graphicCardSalePrice = new SalePrice(graphicCardPricePolicy.getPrice());
		
		// 設定目前價格策略
		motherBoard.setPricePolicy(motherBoardSalePrice);
		memory.setPricePolicy(memorySalePrice);
		cpu.setPricePolicy(CPUSalePrice);
		graphicCard.setPricePolicy(graphicCardSalePrice);
		
		// 測試印出目前單品價格與總價, 應為折扣後售價, 價格四捨五入到小數點後第二位
		System.out.println("=== Sale Price Policy ===");
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
		calculate(all);
		System.out.println();
		
		/* 周年慶售價情況 */
		// 制定周年慶售價, 如未設定折扣預設為0.85
		PricePolicy motherBoardAnniversaryPrice = new AnniversaryPrice(motherBoard.getPrice(), 0.69);
		PricePolicy memoryAnniversaryPrice = new AnniversaryPrice(memoryPricePolicy.getPrice(), 0.75);
		PricePolicy CPUAnniversaryPrice = new AnniversaryPrice(CPUPricePolicy.getPrice(), 0.65);
		PricePolicy graphicCardAnniversaryPrice = new AnniversaryPrice(graphicCardPricePolicy.getPrice());
		
		// 設定目前價格策略
		motherBoard.setPricePolicy(motherBoardAnniversaryPrice);
		memory.setPricePolicy(memoryAnniversaryPrice);
		cpu.setPricePolicy(CPUAnniversaryPrice);
		graphicCard.setPricePolicy(graphicCardAnniversaryPrice);
		
		// 測試印出目前單品價格與總價, 應為周年慶售價, 價格四捨五入到小數點後第二位
		System.out.println("=== Anniversary Price Policy ===");
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
		calculate(all);
		System.out.println();
		
	}
	
	/**
	 * 計算總價格
	 * @param all
	 */
	public static void calculate(Part[] all) {
		double allPrice = 0;
		for (int i = 0; i < all.length; i++) {
			allPrice += all[i].getPrice();
		}

		// format for 四捨五入到小數點後第二位
		DecimalFormat decimalFormat = new DecimalFormat("##.00");
		// 印出四捨五入到小數點後第二位的總價
		System.out.println("總價: " + Double.parseDouble(decimalFormat.format(allPrice)));
	}
}
