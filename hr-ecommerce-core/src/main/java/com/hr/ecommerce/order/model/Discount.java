package com.hr.ecommerce.order.model;

public class Discount {
	private String discountCode;
	private String orderDiscount;
	private String shippingDiscount;
	private String totalDiscount;
	
	public String getDiscountCode() {
		return discountCode;
	}
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	public String getOrderDiscount() {
		return orderDiscount;
	}
	public void setOrderDiscount(String orderDiscount) {
		this.orderDiscount = orderDiscount;
	}
	public String getShippingDiscount() {
		return shippingDiscount;
	}
	public void setShippingDiscount(String shippingDiscount) {
		this.shippingDiscount = shippingDiscount;
	}
	public String getTotalDiscount() {
		return totalDiscount;
	}
	public void setTotalDiscount(String totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

}
