package tn.mbhc.tudev.spring.rest.data;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

	private Long id;
	private String name;
	private Data data;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Data getData() {
		return data;
	}

	public Product withId(final Long id) {
		this.id = id;
		return this;
	}

	public Product withName(final String name) {
		this.name = name;
		return this;
	}

	public Product withData(final Data data) {
		this.data = data;
		return this;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(data, other.data) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append(" [");
        if (id != null) {
            sb.append("id=").append(id).append(", ");
        }
        if (name != null) {
            sb.append("name=").append(name).append(", ");
        }
        if (data != null) {
            sb.append("data=").append(data);
        }
        // Remove trailing ", " if any
        int length = sb.length();
        if (length > 2 && sb.charAt(length - 2) == ',') {
            sb.delete(length - 2, length);
        }
        sb.append("]");
        return sb.toString();
	}
	
}
