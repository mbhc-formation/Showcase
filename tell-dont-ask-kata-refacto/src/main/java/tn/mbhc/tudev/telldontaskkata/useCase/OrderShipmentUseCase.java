package tn.mbhc.tudev.telldontaskkata.useCase;

import tn.mbhc.tudev.telldontaskkata.domain.Order;
import tn.mbhc.tudev.telldontaskkata.repository.OrderRepository;
import tn.mbhc.tudev.telldontaskkata.service.ShipmentService;
import tn.mbhc.tudev.telldontaskkata.useCase.exceptions.OrderCannotBeShippedException;
import tn.mbhc.tudev.telldontaskkata.useCase.exceptions.OrderCannotBeShippedTwiceException;
import tn.mbhc.tudev.telldontaskkata.useCase.requests.OrderShipmentRequest;

public class OrderShipmentUseCase {
	private final OrderRepository orderRepository;
	private final ShipmentService shipmentService;

	public OrderShipmentUseCase(OrderRepository orderRepository, ShipmentService shipmentService) {
		this.orderRepository = orderRepository;
		this.shipmentService = shipmentService;
	}

	public void run(OrderShipmentRequest request) throws OrderCannotBeShippedTwiceException, OrderCannotBeShippedException {
		final Order order = orderRepository.getById(request.orderId);
		checkForShipment(order);
		shipmentService.ship(order);
		orderRepository.save(order);
	}

	private void checkForShipment(final Order order) throws OrderCannotBeShippedTwiceException, OrderCannotBeShippedException {
		checkCreatedOrRejectedOrElseThrowException(order);
		checkAlreadyShippedOrThrowExcetion(order);
	}

	private void checkAlreadyShippedOrThrowExcetion(final Order order) throws OrderCannotBeShippedTwiceException {
		if (order.isShipped()) {
			throw new OrderCannotBeShippedTwiceException();
		}
	}

	private void checkCreatedOrRejectedOrElseThrowException(final Order order) throws OrderCannotBeShippedException {
		if (order.isCreated() || order.isRejected()) {
			throw new OrderCannotBeShippedException();
		}
	}
}
