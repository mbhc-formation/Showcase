package tn.mbhc.tudev.designpatterns.process.chain.impl;

import java.util.Optional;

import tn.mbhc.tudev.designpatterns.process.chain.IShoppingOrderProcessor;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder.Status;

public class ValidatedShoppingOrderProcessorImpl implements IShoppingOrderProcessor<ShoppingOrder> {

	private Optional<IShoppingOrderProcessor<ShoppingOrder>> nextProcessor = Optional.empty();

	@Override
	public ShoppingOrder process(ShoppingOrder order) {
		
		System.out.println(String.format("[ValidatedShoppingOrderProcessorImpl] -- Processing ShoppingOrder [status = %s]", order.getStatus()));
		
		if(order.itemsAreValid()) {
			
			order.updateStatus(Status.VALIDATED);
			System.out.println(String.format("[InPreparationShoppingOrderProcessorImpl] -- Updating ShoppingOrder status to [%s]", order.getStatus()));
			
			nextProcessor.ifPresent(cmd -> nextProcessor.get().process(order));
		} else {
			System.out.println("Error updating order status to VALIDATED : ShoppingOrder has items with quantity < 1");
		}
		return order;
	}

	@Override
	public void setNextProcessor(Optional<IShoppingOrderProcessor<ShoppingOrder>> nextProcessor) {
		this.nextProcessor = nextProcessor;
	}

}
