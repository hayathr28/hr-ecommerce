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
"productName",
"imageName",
"seoUrl",
"parentProductCode",
"startDate",
"endDate",
"listPrice",
"salePrice"
})
public class Product {

@JsonProperty("productCode")
private String productCode;
@JsonProperty("productName")
private String productName;
@JsonProperty("imageName")
private String imageName;
@JsonProperty("seoUrl")
private String seoUrl;
@JsonProperty("parentProductCode")
private String parentProductCode;
@JsonProperty("startDate")
private String startDate;
@JsonProperty("endDate")
private String endDate;
@JsonProperty("listPrice")
private Float listPrice;
@JsonProperty("salePrice")
private Float salePrice;
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

@JsonProperty("productName")
public String getProductName() {
return productName;
}

@JsonProperty("productName")
public void setProductName(String productName) {
this.productName = productName;
}

@JsonProperty("imageName")
public String getImageName() {
return imageName;
}

@JsonProperty("imageName")
public void setImageName(String imageName) {
this.imageName = imageName;
}

@JsonProperty("seoUrl")
public String getSeoUrl() {
return seoUrl;
}

@JsonProperty("seoUrl")
public void setSeoUrl(String seoUrl) {
this.seoUrl = seoUrl;
}

@JsonProperty("parentProductCode")
public String getParentProductCode() {
return parentProductCode;
}

@JsonProperty("parentProductCode")
public void setParentProductCode(String parentProductCode) {
this.parentProductCode = parentProductCode;
}

@JsonProperty("startDate")
public String getStartDate() {
return startDate;
}

@JsonProperty("startDate")
public void setStartDate(String startDate) {
this.startDate = startDate;
}

@JsonProperty("endDate")
public String getEndDate() {
return endDate;
}

@JsonProperty("endDate")
public void setEndDate(String endDate) {
this.endDate = endDate;
}

@JsonProperty("listPrice")
public Float getListPrice() {
return listPrice;
}

@JsonProperty("listPrice")
public void setListPrice(Float listPrice) {
this.listPrice = listPrice;
}

@JsonProperty("salePrice")
public Float getSalePrice() {
return salePrice;
}

@JsonProperty("salePrice")
public void setSalePrice(Float salePrice) {
this.salePrice = salePrice;
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