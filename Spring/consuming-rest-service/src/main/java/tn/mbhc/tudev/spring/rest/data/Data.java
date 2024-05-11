package tn.mbhc.tudev.spring.rest.data;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import tn.mbhc.tudev.spring.rest.core.serialization.BigDecimalDeserializer;
import tn.mbhc.tudev.spring.rest.core.serialization.BigDecimalSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

	@JsonAlias("Color")
	private String color;
	
	@JsonAlias("Description")
	private String description;
	
	@JsonAlias("Capacity")
	private String capacity;
	
	@JsonProperty("capacity GB")
	private Integer capacityGB;
	
	@JsonSerialize(using = BigDecimalSerializer.class)
    @JsonDeserialize(using = BigDecimalDeserializer.class)
	@JsonAlias("Price")
	private BigDecimal price;
	
	@JsonAlias("Generation")
	private String generation;

	@JsonAlias("CPU model")
	private String cpuModel;
	
	@JsonAlias("Hard disk size")
	private String hardDiskSize;
	
	@JsonAlias("Strap Colour")
	private String strapColor;
	
	@JsonAlias("Case Size")
	private String caseSize;
	
	private Integer year;

	@JsonAlias("Screen size")
	private Double screenSize;

	/*
	 * Accessors
	 */
	public String getColor() {
		return color;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getCapacity() {
		return capacity;
	}

	public Integer getCapacityGB() {
		return capacityGB;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public String getGeneration() {
		return generation;
	}

	public String getCpuModel() {
		return cpuModel;
	}

	public String getHardDiskSize() {
		return hardDiskSize;
	}

	public String getStrapColor() {
		return strapColor;
	}

	public String getCaseSize() {
		return caseSize;
	}

	public Integer getYear() {
		return year;
	}
	
	public Double getScreenSize() {
		return screenSize;
	}

	/*
	 * Builder methods
	 */
	public Data withColor(final String color) {
		this.color = color;
		return this;
	}
	
	public Data withDescription(final String description) {
		this.description = description;
		return this;
	}
	
	public Data withCapacity(final String capacity) {
		this.capacity = capacity;
		return this;
	}
	
	public Data withCapacityGB(final Integer capacityGB) {
		this.capacityGB = capacityGB;
		return this;
	}
	
	public Data withPrice(final BigDecimal price) {
		this.price = price;
		return this;
	}
	
	public Data withGeneration(final String generation) {
		this.generation = generation;
		return this;
	}
	
	public Data withCpuModel(final String cpuModel) {
		this.cpuModel = cpuModel;
		return this;
	}
	
	public Data withHardDiskSize(final String hardDiskSize) {
		this.hardDiskSize = hardDiskSize;
		return this;
	}
	
	public Data withStrapColor(final String strapColor) {
		this.strapColor = strapColor;
		return this;
	}
	
	public Data withCaseSize(final String caseSize) {
		this.caseSize = caseSize;
		return this;
	}
	
	public Data withYear(final Integer year) {
		this.year = year;
		return this;
	}
	
	public Data withScreenSize(final Double screenSize) {
		this.screenSize = screenSize;
		return this;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacity, capacityGB, caseSize, color, cpuModel, generation, hardDiskSize, price,
				screenSize, strapColor, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		return Objects.equals(capacity, other.capacity) && Objects.equals(capacityGB, other.capacityGB)
				&& Objects.equals(caseSize, other.caseSize) && Objects.equals(color, other.color)
				&& Objects.equals(cpuModel, other.cpuModel) && Objects.equals(generation, other.generation)
				&& Objects.equals(hardDiskSize, other.hardDiskSize) && Objects.equals(price, other.price)
				&& Objects.equals(screenSize, other.screenSize) && Objects.equals(strapColor, other.strapColor)
				&& Objects.equals(year, other.year);
	}

	@Override
	public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append(" [");
        appendField(sb, "color", color);
        appendField(sb, "description", description);
        appendField(sb, "capacity", capacity);
        appendField(sb, "capacityGB", capacityGB);
        appendField(sb, "price", price);
        appendField(sb, "generation", generation);
        appendField(sb, "cpuModel", cpuModel);
        appendField(sb, "hardDiskSize", hardDiskSize);
        appendField(sb, "strapColor", strapColor);
        appendField(sb, "caseSize", caseSize);
        appendField(sb, "year", year);
        appendField(sb, "screenSize", screenSize);
        // Remove trailing ", " if any
        int length = sb.length();
        if (length > 2 && sb.charAt(length - 2) == ',') {
            sb.delete(length - 2, length);
        }
        sb.append("]");
        return sb.toString();
    }

    private void appendField(StringBuilder sb, String fieldName, Object fieldValue) {
        if (fieldValue != null) {
            sb.append(fieldName).append("=").append(fieldValue).append(", ");
        }
    }
	
}
