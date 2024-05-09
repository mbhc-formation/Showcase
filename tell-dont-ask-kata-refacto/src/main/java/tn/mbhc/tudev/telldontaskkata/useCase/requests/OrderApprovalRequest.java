package tn.mbhc.tudev.telldontaskkata.useCase.requests;

public class OrderApprovalRequest {

	public final Long orderId;

	OrderApprovalRequest(final Long orderId) {
		this.orderId = orderId;
	}

	public final boolean isApproved() {
		return this instanceof OrderApprovalAcceptedRequest;
	}

}
