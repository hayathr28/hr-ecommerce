package com.hr.ecommerce.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"productId",
"productCode",
"productName",
"productImage",
"description",
"productAttributes"
})
public class CreateProductRequest {

@JsonProperty("productId")
private String productId;
@JsonProperty("productCode")
private String productCode;
@JsonProperty("productName")
private String productName;
@JsonProperty("productImage")
private String productImage;
@JsonProperty("description")
private String description;
@JsonProperty("buyable")
private boolean buyable;
@JsonProperty("inventory")
private String inventory;
@JsonProperty("productAttributes")
private ProductAttributes productAttributes;

@JsonProperty("productId")
public String getProductId() {
return productId;
}

@JsonProperty("productId")
public void setProductId(String productId) {
this.productId = productId;
}

@JsonProperty("productCode")
public String getProductCode() {
return productCode;
}

@JsonProperty("productCode")
public void setProductCode(String productCode) {
this.productCode = productCode;
}

@JsonProperty("productName")
public String getProductName() {
return productName;
}

@JsonProperty("productName")
public void setProductName(String productName) {
this.productName = productName;
}

@JsonProperty("productImage")
public String getProductImage() {
return productImage;
}

@JsonProperty("productImage")
public void setProductImage(String productImage) {
this.productImage = productImage;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

@JsonProperty("productAttributes")
public ProductAttributes getProductAttributes() {
return productAttributes;
}

@JsonProperty("productAttributes")
public void setProductAttributes(ProductAttributes productAttributes) {
this.productAttributes = productAttributes;
}

@JsonProperty("buyable")
public boolean isBuyable() {
	return buyable;
}
@JsonProperty("buyable")
public void setBuyable(boolean buyable) {
	this.buyable = buyable;
}

@JsonProperty("inventory")
public String getInventory() {
	return inventory;
}
@JsonProperty("inventory")
public void setInventory(String inventory) {
	this.inventory = inventory;
}

}