package tn.mbhc.tudev.designpatterns.process.chain.impl;

import java.util.Optional;

import tn.mbhc.tudev.designpatterns.process.chain.IShoppingOrderProcessor;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder.Status;

public class InPreparationShoppingOrderProcessorImpl implements IShoppingOrderProcessor<ShoppingOrder> {

	private Optional<IShoppingOrderProcessor<ShoppingOrder>> nextProcessor = Optional.empty();

	@Override
	public ShoppingOrder process(ShoppingOrder order) {
		System.out.println(String.format("[InPreparationShoppingOrderProcessorImpl] -- Processing ShoppingOrder [status = %s]", order.getStatus()));
		
		if (order.hasItems()) {

			order.updateStatus(Status.IN_PREPARATION);
			System.out.println(String.format("[InPreparationShoppingOrderProcessorImpl] -- Updating ShoppingOrder status to [%s]", order.getStatus()));

			nextProcessor.ifPresent(cmd -> nextProcessor.get().process(order));
		} else {
			System.out.println("Error updating order status to IN_PREPARATION : no items added to the order");
		}
		return order;
	}

	@Override
	public void setNextProcessor(Optional<IShoppingOrderProcessor<ShoppingOrder>> nextProcessor) {
		this.nextProcessor = nextProcessor;
	}

}
