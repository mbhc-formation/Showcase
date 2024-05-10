package tn.mbhc.tudev.telldontaskkata.useCase.exceptions;

public class OrderApprovalException extends OrderException {

	private static final long serialVersionUID = -3329797728749465946L;

	public static class ApprovedCannotBeRejectedException extends OrderApprovalException {
		private static final long serialVersionUID = 892289088686880327L;
	}

	public static class RejectedCannotBeApprovedException extends OrderApprovalException {
		private static final long serialVersionUID = 5481142511295017256L;
	}

	public static class ShippedOrdersCannotBeChangedException extends OrderApprovalException {
		private static final long serialVersionUID = 4087248235368393179L;
	}


}
