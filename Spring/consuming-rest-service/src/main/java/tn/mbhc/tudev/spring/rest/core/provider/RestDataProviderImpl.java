package tn.mbhc.tudev.spring.rest.core.provider;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import tn.mbhc.tudev.spring.rest.core.parser.ProductsParser;
import tn.mbhc.tudev.spring.rest.data.Product;

/**
 * Data provider which fetches {@link Product} objects from REST API.
 */
public class RestDataProviderImpl implements DataProvider {

	private static final Logger LOGGER = Logger.getLogger(RestDataProviderImpl.class.getSimpleName());
	
	private final RestTemplate restTemplate;
	private final ProductsParser productsParser;
	
	@Value("${spring.application.data.provider.one_product_rest_url}")
	private String oneProductRestUrl;
	
	@Value("${spring.application.data.provider.list_of_product_rest_url}")
	private String listOfProductsRestUrl;
	
	/**
	 * New instance of the data provider.
	 * @param restTemplate
	 * @param productsParser
	 */
	public RestDataProviderImpl(final RestTemplate restTemplate, final ProductsParser productsParser) {
		this.restTemplate = restTemplate;
		this.productsParser = productsParser;
	}

	/**
	 * Fetches a product from the REST API.
	 * @return
	 */
	@Override
	public Optional<Product> getOne() {
		try {
			String content = restTemplate.getForObject(listOfProductsRestUrl, String.class);
			return productsParser.loadProductsFromContent(content)
					.stream()
					.findFirst();
		} catch(RestClientException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
		return Optional.empty();
	}
	
	/**
	 * Fetches a list of product from the REST API.
	 * @return
	 */
	@Override
	public List<Product> getList() {
		try {
			String content = restTemplate.getForObject(listOfProductsRestUrl, String.class);
			return productsParser.loadProductsFromContent(content);
		} catch(RestClientException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
		return Collections.emptyList();
	}
}
