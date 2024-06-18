package tn.mbhc.tudev.spring.rest.consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatList;
import static tn.mbhc.tudev.spring.rest.consumer.helpers.FilesHelperUtils.getStringContentFromFileWithUtf8Charset;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tn.mbhc.tudev.spring.rest.consumer.helpers.ProductsParserDataHelper;
import tn.mbhc.tudev.spring.rest.core.parser.ProductsParser;
import tn.mbhc.tudev.spring.rest.data.Product;

/**
 * Test case for parsing {@link Product} objects from a JSON file (as a test resource).
 */
public class ProductsParserTest {
	
	/*
	 * Helpers for processing and generating test doubles.
	 */
	private static ProductsParserDataHelper productsParserDataHelper;
	
	/*
	 * SUT
	 */
	private ProductsParser productsParserUnderTest;
	
	@BeforeAll
	public static void beforeAll() {
		productsParserDataHelper = new ProductsParserDataHelper();
	}
	
	@BeforeEach
	public void beforeEach() {
		productsParserUnderTest = new ProductsParser();
	}
	
	@AfterEach
	public void afterEach() {
		productsParserUnderTest = null;
	}
	
	@AfterAll
	public static void after() {
		productsParserDataHelper = null;
	}
	
	@Test
	public void shouldReturnAnEmptyListOfObjectsIfGivenJsonContentIsNull() throws IOException {
		// Arrange
		String content = null;
		
		// Act
		List<Product> parsedProducts = productsParserUnderTest.loadProductsFromContent(content);
		
		// Assert
		assertThat(parsedProducts).isEmpty();
	}
	
	@Test
	public void shouldReturnAnEmptyListOfObjectsIfGivenJsonContentIsEmpty() throws IOException {
		// Arrange
		String content = "";
		
		// Act
		List<Product> parsedProducts = productsParserUnderTest.loadProductsFromContent(content);
		
		// Assert
		assertThat(parsedProducts).isEmpty();
	}
	
	@Test
	public void shouldReturnAnEmptyListOfObjectsIfGivenJsonFileIsEmpty() throws IOException {
		// Arrange (do nothing)
		String content = getStringContentFromFileWithUtf8Charset("empty.json");

		// Act
		List<Product> parsedProducts = productsParserUnderTest.loadProductsFromContent(content);
		
		// Assert
		assertThat(parsedProducts).isEmpty();
	}
	
	@Test
	public void shouldReturnAnEmptyListOfObjectsIfGivenJsonFileIsNotParsable() throws IOException {
		// Arrange (do nothing)
		String content = getStringContentFromFileWithUtf8Charset("non_parsable.json");

		// Act
		List<Product> parsedProducts = productsParserUnderTest.loadProductsFromContent(content);
		
		// Assert
		assertThat(parsedProducts).isEmpty();
	}
	
	@Test
	public void parsedProductsListFromJsonFileShouldBeEqualToExpectedDummyProductsList() throws IOException {
		// Arrange
		List<Product> expectedProducts = productsParserDataHelper.createDummyProducts();
		String content = getStringContentFromFileWithUtf8Charset("products.json");

		// Act
		List<Product> parsedProducts = productsParserUnderTest.loadProductsFromContent(content);
		
		// Assert
		assertThat(parsedProducts)
			.isNotEmpty()
			.hasSize(expectedProducts.size());
		
		assertThatList(parsedProducts)
			.usingRecursiveFieldByFieldElementComparator()
			.containsAll(expectedProducts);
	}
	
}
