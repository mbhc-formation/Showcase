package tn.mbhc.tudev.designpatterns.process.chain;

import java.util.Optional;

import tn.mbhc.tudev.designpatterns.process.chain.impl.AcceptedShoppingOrderProcessorImpl;
import tn.mbhc.tudev.designpatterns.process.chain.impl.InPreparationShoppingOrderProcessorImpl;
import tn.mbhc.tudev.designpatterns.process.chain.impl.FinishedShoppingOrderProcessorImpl;
import tn.mbhc.tudev.designpatterns.process.chain.impl.ValidatedShoppingOrderProcessorImpl;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder;

public class ShoppingOrderProcessChain {

	private IShoppingOrderProcessor<ShoppingOrder> acceptedOrderStep = new AcceptedShoppingOrderProcessorImpl();
	private IShoppingOrderProcessor<ShoppingOrder> inPreparationOrderStep = new InPreparationShoppingOrderProcessorImpl();
	private IShoppingOrderProcessor<ShoppingOrder> validatedOrderStep = new ValidatedShoppingOrderProcessorImpl();
	private IShoppingOrderProcessor<ShoppingOrder> finishedOrderStep = new FinishedShoppingOrderProcessorImpl();
	
	public ShoppingOrderProcessChain() {
		initChaine();
	}
	
	private void initChaine() {
		acceptedOrderStep.setNextProcessor(Optional.of(inPreparationOrderStep));
		inPreparationOrderStep.setNextProcessor(Optional.of(validatedOrderStep));
		validatedOrderStep.setNextProcessor(Optional.of(finishedOrderStep));
	}

	public ShoppingOrder processShoppingOrder(final ShoppingOrder shoppingOrder) {
		return acceptedOrderStep.process(shoppingOrder);
	}

}
