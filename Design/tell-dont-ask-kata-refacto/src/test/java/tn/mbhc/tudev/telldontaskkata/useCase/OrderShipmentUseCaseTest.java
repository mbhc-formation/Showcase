package tn.mbhc.tudev.telldontaskkata.useCase;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tn.mbhc.tudev.telldontaskkata.domain.Order;
import tn.mbhc.tudev.telldontaskkata.domain.OrderStatus;
import tn.mbhc.tudev.telldontaskkata.doubles.TestOrderRepository;
import tn.mbhc.tudev.telldontaskkata.doubles.TestShipmentService;
import tn.mbhc.tudev.telldontaskkata.useCase.exceptions.OrderCannotBeShippedException;
import tn.mbhc.tudev.telldontaskkata.useCase.exceptions.OrderCannotBeShippedTwiceException;
import tn.mbhc.tudev.telldontaskkata.useCase.requests.OrderShipmentRequest;

public class OrderShipmentUseCaseTest {

	private static final Long DEFAULT_ORDER_ID = Long.valueOf(1);
	private final OrderShipmentRequest request = new OrderShipmentRequest(DEFAULT_ORDER_ID);

	private final TestOrderRepository orderRepository = new TestOrderRepository();
	private final TestShipmentService shipmentService = new TestShipmentService();
	private final OrderShipmentUseCase useCase = new OrderShipmentUseCase(orderRepository, shipmentService);

	@Test
	public void shipApprovedOrder() throws Exception {
		Order initialOrder = new Order.OrderBilder().withId(DEFAULT_ORDER_ID).withStatus(OrderStatus.APPROVED).build();
		orderRepository.addOrder(initialOrder);

		OrderShipmentRequest request = new OrderShipmentRequest(DEFAULT_ORDER_ID);

		useCase.run(request);

		assertTrue(orderRepository.getSavedOrder().isShipped());
		assertThat(shipmentService.getShippedOrder(), is(initialOrder));
	}

	@Test(expected = OrderCannotBeShippedException.class)
	public void createdOrdersCannotBeShipped() throws Exception {
		Order initialOrder = new Order.OrderBilder().withDefaultIdAndStatus().build();
		orderRepository.addOrder(initialOrder);

		useCase.run(request);

		assertThat(orderRepository.getSavedOrder(), is(nullValue()));
		assertThat(shipmentService.getShippedOrder(), is(nullValue()));
	}

	@Test(expected = OrderCannotBeShippedException.class)
	public void rejectedOrdersCannotBeShipped() throws Exception {
		Order initialOrder = new Order.OrderBilder().withId(DEFAULT_ORDER_ID).withStatus(OrderStatus.REJECTED).build();
		orderRepository.addOrder(initialOrder);

		useCase.run(request);

		assertThat(orderRepository.getSavedOrder(), is(nullValue()));
		assertThat(shipmentService.getShippedOrder(), is(nullValue()));
	}

	@Test(expected = OrderCannotBeShippedTwiceException.class)
	public void shippedOrdersCannotBeShippedAgain() throws Exception {
		Order initialOrder = new Order.OrderBilder().withId(DEFAULT_ORDER_ID).withStatus(OrderStatus.SHIPPED).build();
		orderRepository.addOrder(initialOrder);

		useCase.run(request);

		assertThat(orderRepository.getSavedOrder(), is(nullValue()));
		assertThat(shipmentService.getShippedOrder(), is(nullValue()));
	}
}
