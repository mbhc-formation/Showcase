package tn.mbhc.tudev.telldontaskkata.useCase;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tn.mbhc.tudev.telldontaskkata.domain.Order;
import tn.mbhc.tudev.telldontaskkata.domain.OrderStatus;
import tn.mbhc.tudev.telldontaskkata.doubles.TestOrderRepository;
import tn.mbhc.tudev.telldontaskkata.useCase.exceptions.OrderApprovalException.ApprovedCannotBeRejectedException;
import tn.mbhc.tudev.telldontaskkata.useCase.exceptions.OrderApprovalException.RejectedCannotBeApprovedException;
import tn.mbhc.tudev.telldontaskkata.useCase.exceptions.OrderApprovalException.ShippedOrdersCannotBeChangedException;
import tn.mbhc.tudev.telldontaskkata.useCase.requests.OrderApprovalAcceptedRequest;
import tn.mbhc.tudev.telldontaskkata.useCase.requests.OrderApprovalRejectedRequest;
import tn.mbhc.tudev.telldontaskkata.useCase.requests.OrderApprovalRequest;

public class OrderApprovalUseCaseTest {
	private static final Long DEFAULT_ORDER_ID = Long.valueOf(1);
	private final TestOrderRepository orderRepository = new TestOrderRepository();
	private final OrderApprovalUseCase useCase = new OrderApprovalUseCase(orderRepository);

	@Test
	public void approvedExistingOrder() throws Exception {
		Order initialOrder = new Order.OrderBilder().withDefaultIdAndStatus().build();
		orderRepository.addOrder(initialOrder);

		OrderApprovalRequest request = new OrderApprovalAcceptedRequest(DEFAULT_ORDER_ID);

		useCase.run(request);

		final Order savedOrder = orderRepository.getSavedOrder();
		assertTrue(savedOrder.isApproved());
	}

	@Test
	public void rejectedExistingOrder() throws Exception {
		Order initialOrder = new Order.OrderBilder().withDefaultIdAndStatus().build();
		orderRepository.addOrder(initialOrder);

		OrderApprovalRequest request = new OrderApprovalRejectedRequest(DEFAULT_ORDER_ID);

		useCase.run(request);

		final Order savedOrder = orderRepository.getSavedOrder();
		assertTrue(savedOrder.isRejected());
	}

	@Test(expected = RejectedCannotBeApprovedException.class)
	public void cannotApproveRejectedOrder() throws Exception {
		Order initialOrder = new Order.OrderBilder().withId(DEFAULT_ORDER_ID).withStatus(OrderStatus.REJECTED).build();
		orderRepository.addOrder(initialOrder);

		OrderApprovalRequest request = new OrderApprovalAcceptedRequest(DEFAULT_ORDER_ID);

		useCase.run(request);

		assertThat(orderRepository.getSavedOrder(), is(nullValue()));
	}

	@Test(expected = ApprovedCannotBeRejectedException.class)
	public void cannotRejectApprovedOrder() throws Exception {
		Order initialOrder = new Order.OrderBilder().withId(DEFAULT_ORDER_ID).withStatus(OrderStatus.APPROVED).build();
		orderRepository.addOrder(initialOrder);

		OrderApprovalRequest request = new OrderApprovalRejectedRequest(DEFAULT_ORDER_ID);

		useCase.run(request);

		assertThat(orderRepository.getSavedOrder(), is(nullValue()));
	}

	@Test(expected = ShippedOrdersCannotBeChangedException.class)
	public void shippedOrdersCannotBeApproved() throws Exception {
		Order initialOrder = new Order.OrderBilder().withId(DEFAULT_ORDER_ID).withStatus(OrderStatus.SHIPPED).build();
		orderRepository.addOrder(initialOrder);

		OrderApprovalRequest request = new OrderApprovalAcceptedRequest(DEFAULT_ORDER_ID);

		useCase.run(request);

		assertThat(orderRepository.getSavedOrder(), is(nullValue()));
	}

	@Test(expected = ShippedOrdersCannotBeChangedException.class)
	public void shippedOrdersCannotBeRejected() throws Exception {
		Order initialOrder = new Order.OrderBilder().withId(DEFAULT_ORDER_ID).withStatus(OrderStatus.SHIPPED).build();
		orderRepository.addOrder(initialOrder);

		OrderApprovalRequest request = new OrderApprovalAcceptedRequest(DEFAULT_ORDER_ID);

		useCase.run(request);

		assertThat(orderRepository.getSavedOrder(), is(nullValue()));
	}
}
