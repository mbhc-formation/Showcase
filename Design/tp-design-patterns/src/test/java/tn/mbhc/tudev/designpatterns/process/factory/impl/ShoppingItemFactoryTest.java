package tn.mbhc.tudev.designpatterns.process.factory.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import tn.mbhc.tudev.designpatterns.process.factory.IModelFactory;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingItem;

@RunWith(BlockJUnit4ClassRunner.class)
public class ShoppingItemFactoryTest {

	private IModelFactory<ShoppingItem> factoryUnderTest;

	@Before
	public void before() {
		factoryUnderTest = new ShoppingItemFactoryImpl();
	}
	
	@Test
	public void testCreateNewShoppingItemWithZeroInitialQuantity() {
		// Act
		ShoppingItem shoppingItem = factoryUnderTest.create();
		
		// Assert
		assertNotNull(shoppingItem.getReference());
		assertEquals(0, shoppingItem.getQuantity());
	}

	@Test
	public void testCreateNewShoppingItemWithQuantityUpdate() {
		// Act
		ShoppingItem shoppingItem = factoryUnderTest.create();
		shoppingItem.increaseQuantity();

		// Assert
		assertEquals(1, shoppingItem.getQuantity());
		
		// Act 2
		shoppingItem.increaseQuantity();
		
		// Assert 2
		assertEquals(2, shoppingItem.getQuantity());
	}

}
