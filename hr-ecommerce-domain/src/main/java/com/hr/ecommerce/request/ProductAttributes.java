package com.hr.ecommerce.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Dimensions",
"color",
"RAM",
"chipset",
"batteryCapacity"
})
public class ProductAttributes {

@JsonProperty("Dimensions")
private String dimensions;
@JsonProperty("color")
private String color;
@JsonProperty("RAM")
private String rAM;
@JsonProperty("chipset")
private String chipset;
@JsonProperty("batteryCapacity")
private String batteryCapacity;

@JsonProperty("Dimensions")
public String getDimensions() {
return dimensions;
}

@JsonProperty("Dimensions")
public void setDimensions(String dimensions) {
this.dimensions = dimensions;
}

@JsonProperty("color")
public String getColor() {
return color;
}

@JsonProperty("color")
public void setColor(String color) {
this.color = color;
}

@JsonProperty("RAM")
public String getRAM() {
return rAM;
}

@JsonProperty("RAM")
public void setRAM(String rAM) {
this.rAM = rAM;
}

@JsonProperty("chipset")
public String getChipset() {
return chipset;
}

@JsonProperty("chipset")
public void setChipset(String chipset) {
this.chipset = chipset;
}

@JsonProperty("batteryCapacity")
public String getBatteryCapacity() {
return batteryCapacity;
}

@JsonProperty("batteryCapacity")
public void setBatteryCapacity(String batteryCapacity) {
this.batteryCapacity = batteryCapacity;
}

}