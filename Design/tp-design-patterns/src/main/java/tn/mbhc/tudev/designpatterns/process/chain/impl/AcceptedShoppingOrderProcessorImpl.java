package tn.mbhc.tudev.designpatterns.process.chain.impl;

import java.util.Optional;

import tn.mbhc.tudev.designpatterns.process.chain.IShoppingOrderProcessor;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder;

public class AcceptedShoppingOrderProcessorImpl implements IShoppingOrderProcessor<ShoppingOrder> {

	private Optional<IShoppingOrderProcessor<ShoppingOrder>> nextProcessor = Optional.empty();

	@Override
	public ShoppingOrder process(ShoppingOrder order) {
		System.out.println(String.format("[AcceptedShoppingOrderProcessorImpl] -- Processing a ShoppingOrder with status [%s]", order.getStatus()));
		if(order.hasValidCustomer()) {
			order.updateStatus(ShoppingOrder.Status.ACCEPTED);
			System.out.println("[AcceptedShoppingOrderProcessorImpl] -- Order status updated from INITIALIZED to ACCEPTED");
			nextProcessor.ifPresent(cmd -> nextProcessor.get().process(order));
		} else {
			System.out.println("Error updating order status : "
					+ "either no customer attached or customer has invalid details (first and last name)");
		}
		return order;
	}

	@Override
	public void setNextProcessor(Optional<IShoppingOrderProcessor<ShoppingOrder>> nextProcessor) {
		this.nextProcessor = nextProcessor;
	}

}
