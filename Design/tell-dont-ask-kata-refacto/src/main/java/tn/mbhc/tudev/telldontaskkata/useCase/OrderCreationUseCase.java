package tn.mbhc.tudev.telldontaskkata.useCase;

import java.util.Currency;
import java.util.Optional;

import tn.mbhc.tudev.telldontaskkata.domain.Order;
import tn.mbhc.tudev.telldontaskkata.domain.OrderItem;
import tn.mbhc.tudev.telldontaskkata.domain.Product;
import tn.mbhc.tudev.telldontaskkata.repository.OrderRepository;
import tn.mbhc.tudev.telldontaskkata.repository.ProductCatalog;
import tn.mbhc.tudev.telldontaskkata.useCase.exceptions.UnknownProductException;
import tn.mbhc.tudev.telldontaskkata.useCase.requests.OrderRequst;

public class OrderCreationUseCase {

	private static final Currency EUR_CURRENCY = Currency.getInstance("EUR");
	
	private final OrderRepository orderRepository;
	private final ProductCatalog productCatalog;

	public OrderCreationUseCase(OrderRepository orderRepository, ProductCatalog productCatalog) {
		this.orderRepository = orderRepository;
		this.productCatalog = productCatalog;
	}

	public void run(OrderRequst request) {
		Order order = new Order.OrderBilder().createdWithNoId(EUR_CURRENCY).build();

		request.items().forEach(item -> {
			Product product = Optional
					.ofNullable(productCatalog.getByName(item.getProductName()))
					.orElseThrow(UnknownProductException::new);

			order.addItem(new OrderItem(product, item.getQuantity()));
		});
		orderRepository.save(order);
	}
}
