package tn.mbhc.tudev.designpatterns.process.factory.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import tn.mbhc.tudev.designpatterns.process.factory.IModelFactory;
import tn.mbhc.tudev.designpatterns.process.model.Customer;

@RunWith(BlockJUnit4ClassRunner.class)
public class CustomerFactoryTest {

	private IModelFactory<Customer> factoryUnderTest;

	@Before
	public void before() {
		factoryUnderTest = new CustomerFactoryImpl();
	}
	
	@Test
	public void testCreateNewCustomerWithoutUpdatingHisDetails() {
		
		// Act
		Customer customer = factoryUnderTest.create();
		
		// Assert
		assertNotNull(customer);
		assertNull(customer.getFirstName());
		assertNull(customer.getLastName());
		assertFalse(customer.hasValidDetails());
	}

	@Test
	public void testCreateNewCustomerWithDetailsUpdate() {
		
		// Act
		Customer customer = factoryUnderTest.create();
		customer.updateDetails("john", "DOE");
		
		// Assert
		assertNotNull(customer);
		assertTrue(customer.hasValidDetails());
	}
}
