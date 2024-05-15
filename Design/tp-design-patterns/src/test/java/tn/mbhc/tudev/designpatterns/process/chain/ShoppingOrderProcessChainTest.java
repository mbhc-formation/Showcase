package tn.mbhc.tudev.designpatterns.process.chain;

import static org.junit.Assert.*;

import org.junit.Test;

import tn.mbhc.tudev.designpatterns.process.factory.IModelFactory;
import tn.mbhc.tudev.designpatterns.process.factory.impl.CustomerFactoryImpl;
import tn.mbhc.tudev.designpatterns.process.factory.impl.ShoppingItemFactoryImpl;
import tn.mbhc.tudev.designpatterns.process.factory.impl.ShoppingOrderFactoryImpl;
import tn.mbhc.tudev.designpatterns.process.model.Customer;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingItem;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder;

public class ShoppingOrderProcessChainTest {

	private static final String TEST_FIRST_NAME = "firstName";
	private static final String TEST_LAST_NAME = "lastName";
	
	private IModelFactory<ShoppingOrder> shoppingOrderFactory = new ShoppingOrderFactoryImpl();
	private IModelFactory<ShoppingItem> itemFactory = new ShoppingItemFactoryImpl();
	private IModelFactory<Customer> customerFactory = new CustomerFactoryImpl();
	
	@Test
	public void testProcessShoppingOrder() {
		// Arrange
			// Attach a customer to the order
			Customer customer = customerFactory.create();
			customer.updateDetails(TEST_FIRST_NAME, TEST_LAST_NAME);
			
			ShoppingItem item = itemFactory.create();
			item.increaseQuantity();
			
			// Create a shopping order without a customer
			ShoppingOrder order = shoppingOrderFactory.create();
			order.attachCustomer(customer);
			order.addItem(item);
			
			assertEquals(order.getStatus(), ShoppingOrder.Status.INITIALIZED);
			
		// Act
		ShoppingOrderProcessChain chain = new ShoppingOrderProcessChain();
		ShoppingOrder updatedOrder = chain.processShoppingOrder(order);
		
		// Assert
		assertEquals(updatedOrder.getStatus(), ShoppingOrder.Status.FINISHED);
	}

}
