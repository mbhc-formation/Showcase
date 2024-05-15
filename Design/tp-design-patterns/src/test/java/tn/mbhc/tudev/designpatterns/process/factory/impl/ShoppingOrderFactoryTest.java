package tn.mbhc.tudev.designpatterns.process.factory.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import tn.mbhc.tudev.designpatterns.process.factory.IModelFactory;
import tn.mbhc.tudev.designpatterns.process.model.Customer;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingItem;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder.Status;

@RunWith(BlockJUnit4ClassRunner.class)
public class ShoppingOrderFactoryTest {

	private static final String TEST_FIRST_NAME = "firstName";
	private static final String TEST_LAST_NAME = "lastName";

	private IModelFactory<ShoppingOrder> shoppingOrderFactory = new ShoppingOrderFactoryImpl();
	private IModelFactory<ShoppingItem> articleFactory = new ShoppingItemFactoryImpl();
	private IModelFactory<Customer> customerFactory = new CustomerFactoryImpl();
	
	@Test
	public void testCreateNewShoppingOrder_WithInitializedStatus_WithoutItems_WithoutCustomer() {
		// Act
		ShoppingOrder order = shoppingOrderFactory.create();
		
		// Assert
		assertNotNull(order.getItems());
		assertFalse(order.hasItems());
		assertEquals(Status.INITIALIZED, order.getStatus());
	}
	
	@Test
	public void testCreateNewShoppingOrder_WithInitializedStatus_WithCustomer_WithoutItems() {
		// Arrange
		ShoppingOrder order = shoppingOrderFactory.create();
		
		// Act : Attach a customer to the order
		Customer customer = customerFactory.create();
		customer.updateDetails(TEST_FIRST_NAME, TEST_LAST_NAME);
		order.attachCustomer(customer);
		
		// Assert
		assertTrue(order.hasValidCustomer());
	}
	
	@Test
	public void testCreateNewShoppingOrder_WithInitializedStatus_WithoutCustomer_WithItems()  {
		// Arrange
		Customer customer = customerFactory.create();
		customer.updateDetails(TEST_FIRST_NAME, TEST_LAST_NAME);
		
		ShoppingOrder order = shoppingOrderFactory.create();
		order.attachCustomer(customer);
		
		// Act : Add an item to the order
		ShoppingItem item = articleFactory.create();
		order.addItem(item);
		
		// Assert
		assertTrue(order.hasItems());
		assertTrue(order.itemsAreValid());
		assertEquals(1, order.itemsCount());
	}
}
