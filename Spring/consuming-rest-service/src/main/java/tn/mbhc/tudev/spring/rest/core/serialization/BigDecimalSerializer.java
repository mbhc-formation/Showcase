package tn.mbhc.tudev.spring.rest.core.serialization;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Serializer class that ensure scaling and rounding from BigDecimal to json
 * value (double).
 */
public class BigDecimalSerializer extends JsonSerializer<BigDecimal> {
	
	@Override
	public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value.setScale(2, RoundingMode.HALF_EVEN).toString());
	}
}
