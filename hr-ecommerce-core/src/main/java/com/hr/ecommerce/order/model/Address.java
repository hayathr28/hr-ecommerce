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
"addressId",
"firstName",
"lastName",
"organizationName",
"address1",
"address2",
"address3",
"city",
"state",
"pinCode",
"country",
"phoneNumber",
"mobileNumber",
"email"
})
public class Address {

@JsonProperty("addressId")
private String addressId;
@JsonProperty("firstName")
private String firstName;
@JsonProperty("lastName")
private String lastName;
@JsonProperty("organizationName")
private String organizationName;
@JsonProperty("address1")
private String address1;
@JsonProperty("address2")
private String address2;
@JsonProperty("address3")
private String address3;
@JsonProperty("city")
private String city;
@JsonProperty("state")
private String state;
@JsonProperty("pinCode")
private String pinCode;
@JsonProperty("country")
private String country;
@JsonProperty("phoneNumber")
private String phoneNumber;
@JsonProperty("mobileNumber")
private String mobileNumber;
@JsonProperty("email")
private String email;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("addressId")
public String getAddressId() {
return addressId;
}

@JsonProperty("addressId")
public void setAddressId(String addressId) {
this.addressId = addressId;
}

@JsonProperty("firstName")
public String getFirstName() {
return firstName;
}

@JsonProperty("firstName")
public void setFirstName(String firstName) {
this.firstName = firstName;
}

@JsonProperty("lastName")
public String getLastName() {
return lastName;
}

@JsonProperty("lastName")
public void setLastName(String lastName) {
this.lastName = lastName;
}

@JsonProperty("organizationName")
public String getOrganizationName() {
return organizationName;
}

@JsonProperty("organizationName")
public void setOrganizationName(String organizationName) {
this.organizationName = organizationName;
}

@JsonProperty("address1")
public String getAddress1() {
return address1;
}

@JsonProperty("address1")
public void setAddress1(String address1) {
this.address1 = address1;
}

@JsonProperty("address2")
public String getAddress2() {
return address2;
}

@JsonProperty("address2")
public void setAddress2(String address2) {
this.address2 = address2;
}

@JsonProperty("address3")
public String getAddress3() {
return address3;
}

@JsonProperty("address3")
public void setAddress3(String address3) {
this.address3 = address3;
}

@JsonProperty("city")
public String getCity() {
return city;
}

@JsonProperty("city")
public void setCity(String city) {
this.city = city;
}

@JsonProperty("state")
public String getState() {
return state;
}

@JsonProperty("state")
public void setState(String state) {
this.state = state;
}

@JsonProperty("pinCode")
public String getPinCode() {
return pinCode;
}

@JsonProperty("pinCode")
public void setPinCode(String pinCode) {
this.pinCode = pinCode;
}

@JsonProperty("country")
public String getCountry() {
return country;
}

@JsonProperty("country")
public void setCountry(String country) {
this.country = country;
}

@JsonProperty("phoneNumber")
public String getPhoneNumber() {
return phoneNumber;
}

@JsonProperty("phoneNumber")
public void setPhoneNumber(String phoneNumber) {
this.phoneNumber = phoneNumber;
}

@JsonProperty("mobileNumber")
public String getMobileNumber() {
return mobileNumber;
}

@JsonProperty("mobileNumber")
public void setMobileNumber(String mobileNumber) {
this.mobileNumber = mobileNumber;
}

@JsonProperty("email")
public String getEmail() {
return email;
}

@JsonProperty("email")
public void setEmail(String email) {
this.email = email;
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