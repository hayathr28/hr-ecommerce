package com.hr.ecommerce.common;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"logonId",
"password",
"profileType",
"organization"
})
public class Profile {

@JsonProperty("logonId")
private String logonId;
@JsonProperty("password")
private String password;
@JsonProperty("profileType")
private String profileType;
@JsonProperty("organization")
private String organization;

@JsonProperty("logonId")
public String getLogonId() {
return logonId;
}

@JsonProperty("logonId")
public void setLogonId(String logonId) {
this.logonId = logonId;
}

@JsonProperty("password")
public String getPassword() {
return password;
}

@JsonProperty("password")
public void setPassword(String password) {
this.password = password;
}

@JsonProperty("profileType")
public String getProfileType() {
return profileType;
}

@JsonProperty("profileType")
public void setProfileType(String profileType) {
this.profileType = profileType;
}

@JsonProperty("organization")
public String getOrganization() {
return organization;
}

@JsonProperty("organization")
public void setOrganization(String organization) {
this.organization = organization;
}

}