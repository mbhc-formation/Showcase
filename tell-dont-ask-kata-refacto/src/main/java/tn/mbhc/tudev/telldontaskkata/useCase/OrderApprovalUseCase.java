package tn.mbhc.tudev.telldontaskkata.useCase;

import tn.mbhc.tudev.telldontaskkata.domain.Order;
import tn.mbhc.tudev.telldontaskkata.repository.OrderRepository;
import tn.mbhc.tudev.telldontaskkata.useCase.exceptions.OrderApprovalException;
import tn.mbhc.tudev.telldontaskkata.useCase.exceptions.OrderApprovalException.ApprovedCannotBeRejectedException;
import tn.mbhc.tudev.telldontaskkata.useCase.exceptions.OrderApprovalException.RejectedCannotBeApprovedException;
import tn.mbhc.tudev.telldontaskkata.useCase.exceptions.OrderApprovalException.ShippedOrdersCannotBeChangedException;
import tn.mbhc.tudev.telldontaskkata.useCase.requests.OrderApprovalRequest;

public class OrderApprovalUseCase {
	private final OrderRepository orderRepository;

	public OrderApprovalUseCase(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public void run(OrderApprovalRequest request) throws OrderApprovalException {
		final Order order = orderRepository.getById(request.orderId);
		throwEcxeptionsIfCannotBeApproved(request, order);
		updateOrderStatusDependingOnGivenRequest(request, order);
		orderRepository.save(order);
	}

	private void throwEcxeptionsIfCannotBeApproved(OrderApprovalRequest request, final Order order)
			throws ShippedOrdersCannotBeChangedException, RejectedCannotBeApprovedException,
			ApprovedCannotBeRejectedException {
		throwExceptionIfOrderIsAlreadyShipped(order);
		throwExceptionIfOrderCannotBeApproved(request, order);
		throwExeptionIfCannotBeRejected(request, order);
	}

	private void updateOrderStatusDependingOnGivenRequest(final OrderApprovalRequest request, final Order order) {
		if (request.isApproved()) {
			order.approve();
			return;
		}
		order.reject();
	}

	private void throwExeptionIfCannotBeRejected(OrderApprovalRequest request, final Order order)
			throws ApprovedCannotBeRejectedException {
		if (!request.isApproved() && order.isApproved()) {
			throw new ApprovedCannotBeRejectedException();
		}
	}

	private void throwExceptionIfOrderCannotBeApproved(OrderApprovalRequest request, final Order order)
			throws RejectedCannotBeApprovedException {
		if (request.isApproved() && order.isRejected()) {
			throw new RejectedCannotBeApprovedException();
		}
	}

	private void throwExceptionIfOrderIsAlreadyShipped(final Order order) throws ShippedOrdersCannotBeChangedException {
		if (order.isShipped()) {
			throw new ShippedOrdersCannotBeChangedException();
		}
	}
}
