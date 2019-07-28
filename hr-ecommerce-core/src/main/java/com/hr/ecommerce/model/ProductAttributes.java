package com.hr.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"dimensions",
"color",
"ram",
"chipset",
"batteryCapacity"
})
public class ProductAttributes {

@JsonProperty("dimensions")
private String dimensions;
@JsonProperty("color")
private String color;
@JsonProperty("ram")
private String ram;
@JsonProperty("chipset")
private String chipset;
@JsonProperty("batteryCapacity")
private String batteryCapacity;

@JsonProperty("dimensions")
public String getDimensions() {
return dimensions;
}

@JsonProperty("dimensions")
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

/**
 * @return the ram
 */
@JsonProperty("ram")
public String getRam() {
	return ram;
}

/**
 * @param ram the ram to set
 */
@JsonProperty("ram")
public void setRam(String ram) {
	this.ram = ram;
}

}
