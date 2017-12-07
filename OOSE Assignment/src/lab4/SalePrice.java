package lab4;

import java.text.DecimalFormat;

/**
 * 售價
 */
public class SalePrice extends PricePolicy {
	
	/**
	 * 售價折扣
	 * 預設為1 = 沒有折扣
	 */
	private double discount = 1;
	
	/**
	 * Constructor
	 * 需有目前價格
	 * @param basePrice
	 */
	public SalePrice(double basePrice) {
		super(basePrice);
	}
	
	/**
	 * Constructor
	 * 售價折扣可有可無(預設1)
	 * @param basePrice
	 * @param discount
	 */
	public SalePrice(double basePrice, double discount) {
		super(basePrice);
		this.discount = discount;
	}

	/**
	 * 設定售價折扣, 四捨五入到小數點後第二位
	 * @param discount
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	/**
	 * 獲得折扣策略後售價, 四捨五入到小數點後第二位
	 * @return 實際售價
	 */
	@Override
	public double getPrice() {
		// format for 四捨五入到小數點後第二位
		DecimalFormat decimalFormat = new DecimalFormat("##.00");
		// 售價為目前價格 * 售價折扣, 再四捨五入到小數點後第二位
		double price = Double.parseDouble(decimalFormat.format(super.getPrice() * discount));

		return price;
	}
}
