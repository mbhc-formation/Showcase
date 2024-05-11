package tn.mbhc.tudev.spring.rest.core.parser;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import tn.mbhc.tudev.spring.rest.data.Product;

/**
 * Class for parsing {@link Product} objects from a JSON file or JSON text content.
 */
public class ProductsParser {
	
	private static final Logger LOGGER = Logger.getLogger(ProductsParser.class.getSimpleName());
	
	private final ObjectMapper objectMapper;
	
	/**
	 * Reflection helper
	 */
	private final ProductObjectReflectionHelper productObjectReflectionHelper;
	
	/**
	 * Creates an instance of the helper, which initializes an object mapper and an object reader for json parsing.
	 */
	public ProductsParser() {
		objectMapper = new ObjectMapper();
		productObjectReflectionHelper= new ProductObjectReflectionHelper();
	}
	
	/**
	 * Returns a list of {@link Product} objects parsed from the given file.
	 * @param jsonFileContent
	 * @return
	 */
	public List<Product> loadProductsFromContent(final String jsonFileContent) {
		
		if(jsonFileContent == null || jsonFileContent.isBlank()) return Collections.emptyList();
		
		try {
			return parseProductsFromContent(jsonFileContent)
					.stream()
					.map(obj -> (Product) obj)
					.filter(product -> !productObjectReflectionHelper.objectWithOnlyNullFieldsValues(product))
					.collect(Collectors.toList());
			
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			// In case of any error
			return Collections.emptyList();
		}
	}

	/**
	 * Renturns a list of objects from the given file, an empty list otherwise (file is null or non-readeable)
	 * @param content
	 * @return
	 * @throws IOException 
	 */
	private List<Object> parseProductsFromContent(final String content) throws IOException {
		return objectMapper
				.reader()
				.forType(Product.class)
				.readValues(content)
				.readAll()
				.stream()
				.map(obj -> (Product) obj)
				.collect(Collectors.toList());
	}

	
}
