package tn.mbhc.tudev.spring.rest.core.serialization;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Deserializer class that ensure scaling and rounding from double to
 * BigDecimal.
 */
public class BigDecimalDeserializer extends JsonDeserializer<BigDecimal> {

	@Override
	public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		return new BigDecimal(p.getValueAsString())
				.setScale(2, RoundingMode.HALF_EVEN);
	}

}
