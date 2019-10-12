
package com.hr.ecommerce.rquest.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"productCode",
"quantiry"
})
public class AddToCartRequest {

@JsonProperty("productCode")
private String productCode;
@JsonProperty("quantiry")
private String quantiry;

@JsonProperty("productCode")
public String getProductCode() {
return productCode;
}

@JsonProperty("productCode")
public void setProductCode(String productCode) {
this.productCode = productCode;
}

@JsonProperty("quantiry")
public String getQuantiry() {
return quantiry;
}

@JsonProperty("quantiry")
public void setQuantiry(String quantiry) {
this.quantiry = quantiry;
}

}