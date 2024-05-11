package tn.mbhc.tudev.spring.rest.core.provider;

import java.util.List;
import java.util.Optional;

import tn.mbhc.tudev.spring.rest.data.Product;

public interface DataProvider {

	/**
	 * Fetches a list of product from the REST API.
	 * <b>
	 * @return
	 */
	List<Product> getList();

	/**
	 * Fetches a product from the REST API.
	 * <b>
	 * @return
	 */
	Optional<Product> getOne();

}
