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
"customerAddress",
"dateCreated",
"lastUpdated"
})
public class Customer {

@JsonProperty("customerAddress")
private CustomerAddress customerAddress;
@JsonProperty("dateCreated")
private String dateCreated;
@JsonProperty("lastUpdated")
private String lastUpdated;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("customerAddress")
public CustomerAddress getCustomerAddress() {
return customerAddress;
}

@JsonProperty("customerAddress")
public void setCustomerAddress(CustomerAddress customerAddress) {
this.customerAddress = customerAddress;
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