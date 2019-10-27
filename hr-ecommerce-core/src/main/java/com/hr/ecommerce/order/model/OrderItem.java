package com.hr.ecommerce.order.model;

import java.util.HashMap;
import java.util.Map;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"recipientaddressId",
"orderItemId",
"itemInfo",
"product",
"address",
"orderItemstatus",
"dateCreated",
"lastUpdated"
})
public class OrderItem {

@JsonProperty("recipientaddressId")
private String recipientaddressId;
@JsonProperty("orderItemId")
private String orderItemId;
@JsonProperty("itemInfo")
private ItemInfo itemInfo;
@JsonProperty("product")
private Product product;
@JsonProperty("address")
private Address address;
@JsonProperty("orderItemstatus")
private String orderItemstatus;
@JsonProperty("dateCreated")
private String dateCreated;
@JsonProperty("lastUpdated")
private String lastUpdated;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public OrderItem() {
	this.orderItemId = ObjectId.get().toString();
}

@JsonProperty("recipientaddressId")
public String getRecipientaddressId() {
return recipientaddressId;
}

@JsonProperty("recipientaddressId")
public void setRecipientaddressId(String recipientaddressId) {
this.recipientaddressId = recipientaddressId;
}

@JsonProperty("orderItemId")
public String getOrderItemId() {
return orderItemId;
}

@JsonProperty("orderItemId")
public void setOrderItemId(String orderItemId) {
this.orderItemId = orderItemId;
}

@JsonProperty("itemInfo")
public ItemInfo getItemInfo() {
return itemInfo;
}

@JsonProperty("itemInfo")
public void setItemInfo(ItemInfo itemInfo) {
this.itemInfo = itemInfo;
}

@JsonProperty("product")
public Product getProduct() {
return product;
}

@JsonProperty("product")
public void setProduct(Product product) {
this.product = product;
}

@JsonProperty("address")
public Address getAddress() {
return address;
}

@JsonProperty("address")
public void setAddress(Address address) {
this.address = address;
}

@JsonProperty("orderItemstatus")
public String getOrderItemstatus() {
return orderItemstatus;
}

@JsonProperty("orderItemstatus")
public void setOrderItemstatus(String orderItemstatus) {
this.orderItemstatus = orderItemstatus;
}

@JsonProperty("dateCreated")
public String getDateCreated() {
return dateCreated;
}

@JsonProperty("dateCreated")
public void setDateCreated(String dateCreated) {
this.dateCreated = dateCreated;
}

@JsonProperty("lastUpdated")
public String getLastUpdated() {
return lastUpdated;
}

@JsonProperty("lastUpdated")
public void setLastUpdated(String lastUpdated) {
this.lastUpdated = lastUpdated;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}