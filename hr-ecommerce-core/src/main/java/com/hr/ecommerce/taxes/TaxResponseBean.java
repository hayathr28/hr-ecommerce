package com.hr.ecommerce.taxes;

public class TaxResponseBean {

	private String merchandiseTax;
	private String shippingTax;
	
	
	public String getMerchandiseTax() {
		return merchandiseTax;
	}
	public void setMerchandiseTax(String merchandiseTax) {
		this.merchandiseTax = merchandiseTax;
	}
	public String getShippingTax() {
		return shippingTax;
	}
	public void setShippingTax(String shippingTax) {
		this.shippingTax = shippingTax;
	}

}
