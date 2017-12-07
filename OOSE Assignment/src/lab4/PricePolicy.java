package lab4;

/**
 * 目前價格
 * 價格策略經常波動，我們就將之抽象為一個物件，透過擴充來處理
 */
public class PricePolicy {
	
	// 目前價格
	private double basePrice;
	
	/**
	 * Constructor
	 * 強制要求制定時就必須給定價(不給default constructor)
	 * @param basePrice 基本定價
	 */
	public PricePolicy(double basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * 設定目前價格
	 * @param price 目前價格
	 */
	public void setPrice(double price) {
		basePrice = price;
	}

	/**
	 * 獲取目前價格
	 * @return
	 */
	public double getPrice() {
		return basePrice;
	}
}
