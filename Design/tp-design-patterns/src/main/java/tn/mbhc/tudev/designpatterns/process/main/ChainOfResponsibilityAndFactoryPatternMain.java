package tn.mbhc.tudev.designpatterns.process.main;

import tn.mbhc.tudev.designpatterns.process.chain.ShoppingOrderProcessChain;
import tn.mbhc.tudev.designpatterns.process.factory.IModelFactory;
import tn.mbhc.tudev.designpatterns.process.factory.impl.ShoppingItemFactoryImpl;
import tn.mbhc.tudev.designpatterns.process.factory.impl.CustomerFactoryImpl;
import tn.mbhc.tudev.designpatterns.process.factory.impl.ShoppingOrderFactoryImpl;
import tn.mbhc.tudev.designpatterns.process.model.Customer;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingItem;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder;

public class ChainOfResponsibilityAndFactoryPatternMain {

	private static IModelFactory<ShoppingOrder> shoppingOrderFactory = new ShoppingOrderFactoryImpl();
	private static IModelFactory<ShoppingItem> articleFactory = new ShoppingItemFactoryImpl();
	private static IModelFactory<Customer> customerFactory = new CustomerFactoryImpl();
	
	public static void main(String[] args) {

		Customer customer = customerFactory.create();
		customer.updateDetails("Mohamed", "BH");
		
		ShoppingItem item = articleFactory.create();
		item.increaseQuantity();
		
		ShoppingOrder cmd = shoppingOrderFactory.create();
		cmd.attachCustomer(customer);
		cmd.addItem(item);
		
		// Process
		new ShoppingOrderProcessChain().processShoppingOrder(cmd);
	}

}
