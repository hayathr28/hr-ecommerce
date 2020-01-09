package com.hr.ecommerce.order.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"productCode",
"quantity",
"price",
"totalProduct"
})
public class ItemInfo {

@JsonProperty("productCode")
private String productCode;
@JsonProperty("quantity")
private String quantity;
@JsonProperty("price")
private String price;
@JsonProperty("totalProduct")
private String totalProduct;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("productCode")
public String getProductCode() {
return productCode;
}

@JsonProperty("productCode")
public void setProductCode(String productCode) {
this.productCode = productCode;
}

@JsonProperty("quantity")
public String getQuantity() {
return quantity;
}

@JsonProperty("quantity")
public void setQuantity(String quantity) {
this.quantity = quantity;
}

@JsonProperty("price")
public String getPrice() {
return price;
}

@JsonProperty("price")
public void setPrice(String price) {
this.price = price;
}

@JsonProperty("totalProduct")
public String getTotalProduct() {
return totalProduct;
}

@JsonProperty("totalProduct")
public void setTotalProduct(String totalProduct) {
this.totalProduct = totalProduct;
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