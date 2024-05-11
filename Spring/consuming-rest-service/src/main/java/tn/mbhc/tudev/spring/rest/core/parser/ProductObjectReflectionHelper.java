package tn.mbhc.tudev.spring.rest.core.parser;

import java.lang.reflect.Field;
import java.util.Arrays;

import tn.mbhc.tudev.spring.rest.data.Product;

class ProductObjectReflectionHelper {

	/**
	 * Checks if the given object has only fields with null values.
	 * @param product
	 * @return
	 */
	boolean objectWithOnlyNullFieldsValues(final Product product) {
		long nullFieldsCount = Arrays
				.asList(product.getClass().getDeclaredFields())
				.stream()
				.filter(field -> isFieldWithNullValue(product, field))
				.count();
		return nullFieldsCount == product.getClass().getDeclaredFields().length;
	}

	/**
	 * Checks if the given field of the given object has a null value.
	 * @param product
	 * @param field
	 * @return
	 */
	private boolean isFieldWithNullValue(final Product product, final Field field) {
		field.setAccessible(true);
		try {
			return field.get(product) == null;
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// do nothing with the exception -> consider field non-readeable
			return false;
		}
	}
	
}
