package tn.mbhc.tudev.telldontaskkata.useCase;


import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

import tn.mbhc.tudev.telldontaskkata.domain.Category;
import tn.mbhc.tudev.telldontaskkata.domain.Order;
import tn.mbhc.tudev.telldontaskkata.domain.OrderItem;
import tn.mbhc.tudev.telldontaskkata.domain.Product;
import tn.mbhc.tudev.telldontaskkata.doubles.InMemoryProductCatalog;
import tn.mbhc.tudev.telldontaskkata.doubles.TestOrderRepository;
import tn.mbhc.tudev.telldontaskkata.repository.ProductCatalog;
import tn.mbhc.tudev.telldontaskkata.useCase.exceptions.UnknownProductException;
import tn.mbhc.tudev.telldontaskkata.useCase.requests.ItemSellRequest;
import tn.mbhc.tudev.telldontaskkata.useCase.requests.OrderRequst;
import tn.mbhc.tudev.telldontaskkata.util.PricingUtils;

public class OrderCreationUseCaseTest {

	private final TestOrderRepository orderRepository = new TestOrderRepository();

	private static Category food = new Category("food", new BigDecimal(10));

	private static final Product SALAD = new Product() {{
		setName("salad");
		setPrice(new BigDecimal(3.56));
		setCategory(food);
	}};

	private static final Product TOMATO = new Product() {{
		setName("tomato");
		setPrice(new BigDecimal(4.65));
		setCategory(food);
	}};

	private final ProductCatalog productCatalog = new InMemoryProductCatalog(Arrays.asList(SALAD, TOMATO));
	private final OrderCreationUseCase useCase = new OrderCreationUseCase(orderRepository, productCatalog);

	@Test
	public void sellMultipleItems() throws Exception {

		// ARRANGE
		OrderItem expectedSaladOrderItem = new OrderItem(SALAD, 2);
		OrderItem expectedTomatoOrderItem = new OrderItem(TOMATO, 3);

		Order expectedOrder = new Order.OrderBilder().withDefaultIdAndStatus()
				.withTotal(PricingUtils.scaleTwoHalfUp(new BigDecimal(23.20)))
				.withTax(PricingUtils.scaleTwoHalfUp(new BigDecimal(2.13)))
				.withCurrency("EUR")
				.withItems(Arrays.asList(expectedSaladOrderItem, expectedTomatoOrderItem))
				.build();

		ItemSellRequest saladRequest = new ItemSellRequest();
		saladRequest.setProductName("salad");
		saladRequest.setQuantity(2);

		ItemSellRequest tomatoRequest = new ItemSellRequest();
		tomatoRequest.setProductName("tomato");
		tomatoRequest.setQuantity(3);

		OrderRequst request = new OrderRequst().withAll(saladRequest, tomatoRequest);
		useCase.run(request);

		final Order insertedOrder = orderRepository.getSavedOrder();

		assertOrder(expectedOrder, insertedOrder);
		assertOrderExactlyContainsItems(insertedOrder.items(), expectedSaladOrderItem, expectedTomatoOrderItem);
	}

	@Test(expected = UnknownProductException.class)
	public void unknownProduct() throws Exception {
		ItemSellRequest unknownProductRequest = new ItemSellRequest();
		unknownProductRequest.setProductName("unknown product");
		OrderRequst request = new OrderRequst().withOne(unknownProductRequest);
		useCase.run(request);
	}

	private void assertOrder(Order expectedOrder, final Order insertedOrder) {
		assertEquals(expectedOrder.itemsCount(), insertedOrder.itemsCount());
		assertEquals(expectedOrder.status(), insertedOrder.status());
		assertEquals(expectedOrder.total(), insertedOrder.total());
		assertEquals(expectedOrder.tax(), insertedOrder.tax());
		assertEquals(expectedOrder.currency(), insertedOrder.currency());
	}

	private void assertOrderItem(OrderItem expected, OrderItem actual) {
		assertEquals(expected.getProduct(), actual.getProduct());
		assertEquals(expected.getQuantity(), actual.getQuantity());
	}

	private void assertOrderExactlyContainsItems(Collection<OrderItem> actualItems, OrderItem... expectedItems) {
		assertEquals(actualItems.size(), expectedItems.length);
		Iterator<OrderItem> iterator = actualItems.iterator();
		int nextExpecteItemIndex = 0;
		while(iterator.hasNext()) {
			OrderItem actual = iterator.next();
			OrderItem expected = expectedItems[nextExpecteItemIndex];

			assertOrderItem(expected, actual);
			nextExpecteItemIndex++;
		}
	}
}
