package lab4;

import java.text.DecimalFormat;

/**
 * 周年慶價格
 */
public class AnniversaryPrice extends PricePolicy {
	
	/**
	 * 周年慶折扣
	 * 預設0.85
	 */
	private double anniversaryDiscount = 0.85;

	/**
	 * Constructor
	 * 需有目前價格
	 * @param price
	 */
	public AnniversaryPrice(double basePrice) {
		super(basePrice);
	}
	
	/**
	 * Constructor
	 * 周年慶折扣可有可無(預設0.85)
	 * @param basePrice
	 * @param discount
	 */
	public AnniversaryPrice(double basePrice, double anniversaryDiscount) {
		super(basePrice);
		this.anniversaryDiscount = anniversaryDiscount;
	}
	
	/**
	 * 設定周年慶折扣
	 * @param discount
	 */
	public void setDiscount(double discount) {
		this.anniversaryDiscount = discount;
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
		double price = Double.parseDouble(decimalFormat.format(super.getPrice() * anniversaryDiscount));

		return price;
	}
}
