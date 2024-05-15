package tn.mbhc.tudev.designpatterns.process.chain.impl;

import java.util.Optional;

import tn.mbhc.tudev.designpatterns.process.chain.IShoppingOrderProcessor;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder.Status;

public class FinishedShoppingOrderProcessorImpl implements IShoppingOrderProcessor<ShoppingOrder> {

	@Override
	public ShoppingOrder process(ShoppingOrder commande) {
		
		System.out.println(String.format("[FinishedShoppingOrderProcessorImpl] -- Processing ShoppingOrder [status = %s]", commande.getStatus()));
		commande.updateStatus(Status.FINISHED);
		System.out.println(String.format("[FinishedShoppingOrderProcessorImpl] -- Updating ShoppingOrder status to [%s]", commande.getStatus()));
		
		System.out.println("End of processing");
		return commande;
	}

	@Override
	public void setNextProcessor(Optional<IShoppingOrderProcessor<ShoppingOrder>> nextProcessor) {
		// Rien faire car c'est la dernière étape
	}

}
