package com.hr.ecommerce.order.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "orderId", "totalProduct", "totalShipping", "totalShippingDiscount", "totalNetShipping",
		"totalDiscount", "totalTax", "totalBeforeTaxes", "orderTotal", "orderStatus", "orderItems", "customer","appliedPayments" })
@Document(collection = "Order")
public class Order {
	@Transient
	public static final String SEQUENCE_NAME = "order_sequence";
	@Id
	@JsonProperty("orderId")
	private long orderId;
	@JsonProperty("totalProduct")
	private String totalProduct;
	@JsonProperty("totalShipping")
	private String totalShipping;
	@JsonProperty("totalShippingDiscount")
	private String totalShippingDiscount;
	@JsonProperty("totalNetShipping")
	private String totalNetShipping;
	@JsonProperty("totalDiscount")
	private String totalDiscount;
	@JsonProperty("totalTax")
	private String totalTax;
	@JsonProperty("totalBeforeTaxes")
	private String totalBeforeTaxes;
	@JsonProperty("orderTotal")
	private String orderTotal;
	@JsonProperty("orderStatus")
	private String orderStatus;
	@JsonProperty("orderItems")
	private List<OrderItem> orderItems = null;
	@JsonProperty("customer")
	private Customer customer;
	@JsonProperty("appliedPayments")
	private List<AppliedPayment> appliedPayments;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("orderId")
	public long getOrderId() {
		return orderId;
	}

	@JsonProperty("orderId")
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@JsonProperty("totalProduct")
	public String getTotalProduct() {
		return totalProduct;
	}

	@JsonProperty("totalProduct")
	public void setTotalProduct(String totalProduct) {
		this.totalProduct = totalProduct;
	}

	@JsonProperty("totalShipping")
	public String getTotalShipping() {
		return totalShipping;
	}

	@JsonProperty("totalShipping")
	public void setTotalShipping(String totalShipping) {
		this.totalShipping = totalShipping;
	}

	@JsonProperty("totalShippingDiscount")
	public String getTotalShippingDiscount() {
		return totalShippingDiscount;
	}

	@JsonProperty("totalShippingDiscount")
	public void setTotalShippingDiscount(String totalShippingDiscount) {
		this.totalShippingDiscount = totalShippingDiscount;
	}

	@JsonProperty("totalNetShipping")
	public String getTotalNetShipping() {
		return totalNetShipping;
	}

	@JsonProperty("totalNetShipping")
	public void setTotalNetShipping(String totalNetShipping) {
		this.totalNetShipping = totalNetShipping;
	}

	@JsonProperty("totalDiscount")
	public String getTotalDiscount() {
		return totalDiscount;
	}

	@JsonProperty("totalDiscount")
	public void setTotalDiscount(String totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	@JsonProperty("totalTax")
	public String getTotalTax() {
		return totalTax;
	}

	@JsonProperty("totalTax")
	public void setTotalTax(String totalTax) {
		this.totalTax = totalTax;
	}

	@JsonProperty("totalBeforeTaxes")
	public String getTotalBeforeTaxes() {
		return totalBeforeTaxes;
	}

	@JsonProperty("totalBeforeTaxes")
	public void setTotalBeforeTaxes(String totalBeforeTaxes) {
		this.totalBeforeTaxes = totalBeforeTaxes;
	}

	@JsonProperty("orderTotal")
	public String getOrderTotal() {
		return orderTotal;
	}

	@JsonProperty("orderTotal")
	public void setOrderTotal(String orderTotal) {
		this.orderTotal = orderTotal;
	}

	@JsonProperty("orderStatus")
	public String getOrderStatus() {
		return orderStatus;
	}

	@JsonProperty("orderStatus")
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@JsonProperty("orderItems")
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	@JsonProperty("orderItems")
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@JsonProperty("customer")
	public Customer getCustomer() {
		return customer;
	}

	@JsonProperty("customer")
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
	@JsonProperty("appliedPayments")
	public List<AppliedPayment> getAppliedPayments() {
		return appliedPayments;
	}
	@JsonProperty("appliedPayments")
	public void setAppliedPayments(List<AppliedPayment> appliedPayments) {
		this.appliedPayments = appliedPayments;
	}

}