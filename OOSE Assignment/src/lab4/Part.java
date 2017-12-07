package lab4;

/**
 * 每一部分零件統一使用的物件
 */
public class Part {

	/* Part 物件在getPrice() 時，是委由策略物件來做回傳 */
	private PricePolicy pricePolicy;
	// name of this part
	private String name;
	
	/**
	 * Constructor
	 * 強制設定基本定價策略與零件名稱(不給default constructor)
	 * @param pricePolicy
	 * @param name
	 */
	public Part(PricePolicy pricePolicy, String name) {
		this.pricePolicy = pricePolicy;
		this.name = name;
	}
	
	/**
	 * 設定基本定價策略
	 * @param policy
	 */
	public void setPricePolicy(PricePolicy policy) {
		pricePolicy = policy;
	}
	
	/**
	 * 設定基本定價
	 * @param price
	 */
	public void setPrice(double price) {
		// 有PricePolicy才能設定價格
		if (pricePolicy != null) {
			pricePolicy.setPrice(price);
		} else {
			System.out.println("No price policy");
			System.exit(0);
		}
	}
	
	/**
	 * 獲取基本定價
	 * @return
	 */
	public double getPrice() {
		// 有PricePolicy才能獲取價格
		if (pricePolicy != null) {
			return pricePolicy.getPrice();
		} else {
			System.out.println("No price policy");
			System.exit(0);
		}
		return 0;
	}
	
	/**
	 * 修改零件名稱
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 獲取零件名稱
	 * @return
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + ", 目前價格: " + pricePolicy.getPrice();
	}
}
