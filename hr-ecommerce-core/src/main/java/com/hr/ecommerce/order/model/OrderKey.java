package com.hr.ecommerce.order.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OrderKey")
public class OrderKey {
	private String orderId;
	private long sequence;

	public long getSequence() {
		return sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	

}
