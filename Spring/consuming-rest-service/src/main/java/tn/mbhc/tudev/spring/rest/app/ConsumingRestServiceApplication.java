package tn.mbhc.tudev.spring.rest.app;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import tn.mbhc.tudev.spring.rest.core.parser.ProductsParser;
import tn.mbhc.tudev.spring.rest.core.provider.DataProvider;
import tn.mbhc.tudev.spring.rest.core.provider.RestDataProviderImpl;
import tn.mbhc.tudev.spring.rest.data.Product;
import tn.mbhc.tudev.spring.rest.utils.LocalStringUtils;

//The app class is not in the base backage 
@ComponentScan(basePackages = "tn.mbhc.tudev")
@SpringBootApplication
public class ConsumingRestServiceApplication {

	private static final Logger LOGGER = Logger.getLogger(ConsumingRestServiceApplication.class.getSimpleName());
	private static final String SEPARATOR_REPEAT = LocalStringUtils.repeat("-", 80);
	
	/**
	 * Launcher function
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestServiceApplication.class, args);
	}

	/*
	 * Properties
	 */
	@Value("${spring.application.data.provider.one_product_rest_url}")
	private String oneProductRestUrl;
	
	@Value("${spring.application.data.provider.list_of_product_rest_url}")
	private String listOfProductsRestUrl;
	
	/*
	 * Beans
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public DataProvider dataProvider(RestTemplate restTemplate) {
		return new RestDataProviderImpl(restTemplate, productsParser());
	}
	
	@Bean
	public ProductsParser productsParser() {
		return new ProductsParser();
	}

	@Bean
	@Profile("!test")
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			DataProvider dataProvider = dataProvider(restTemplate);
			
			LOGGER.info(MessageFormat.format("Fetching products from REST Api : {0}", oneProductRestUrl));
			LOGGER.info(SEPARATOR_REPEAT);
			
			Optional<Product> optionalProduct = dataProvider.getOne();
			optionalProduct.ifPresent(value -> LOGGER.info(MessageFormat.format("One product (ignoring null fields) : {0} ", optionalProduct.get())));
			
			LOGGER.info(SEPARATOR_REPEAT);
			
			LOGGER.info(MessageFormat.format("Fetching a list of products (ignoring null fields) : {0}", listOfProductsRestUrl));
			LOGGER.info(SEPARATOR_REPEAT);
			
			List<Product> products = dataProvider.getList();
			LOGGER.info("List of Products : ");
			products.forEach(product -> LOGGER.info(MessageFormat.format("{0}", product)));
		};
	}
}
