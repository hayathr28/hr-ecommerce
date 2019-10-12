
package com.hr.ecommerce.rquest.beans;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"productCode",
"quantity"
})

public class AddToCartRequest {

@JsonProperty("productCode")
@NotEmpty(message="product code can not be empty")
private String productCode;
@JsonProperty("quantity")
@NotEmpty(message="Quantity can not be empty")
private String quantity;

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

}