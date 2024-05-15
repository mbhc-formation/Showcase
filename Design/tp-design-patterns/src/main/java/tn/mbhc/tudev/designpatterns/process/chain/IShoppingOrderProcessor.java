package tn.mbhc.tudev.designpatterns.process.chain;

import java.util.Optional;

import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder;

public interface IShoppingOrderProcessor<T extends ShoppingOrder> {

	/**
	 * Process the given shopping order.
	 * 
	 * @param order
	 * @return
	 */
	T process(final T order);

	/**
	 * Sets the next order processor.<br>
	 * This can be an empty optional if the current processor is the last to process
	 * the order.
	 * 
	 * @param nextProcessor optional next order processor
	 */
	void setNextProcessor(final Optional<IShoppingOrderProcessor<ShoppingOrder>> nextProcessor);
}
