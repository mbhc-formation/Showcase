package tn.mbhc.tudev.designpatterns.process.chain.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import tn.mbhc.tudev.designpatterns.process.chain.IShoppingOrderProcessor;
import tn.mbhc.tudev.designpatterns.process.factory.IModelFactory;
import tn.mbhc.tudev.designpatterns.process.factory.impl.CustomerFactoryImpl;
import tn.mbhc.tudev.designpatterns.process.factory.impl.ShoppingOrderFactoryImpl;
import tn.mbhc.tudev.designpatterns.process.model.Customer;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder.Status;

@RunWith(BlockJUnit4ClassRunner.class)
public class CommandeAccepteeProcessorTest {

	private IModelFactory<ShoppingOrder> commandeFactory = new ShoppingOrderFactoryImpl();
	private IModelFactory<Customer> clientFactory = new CustomerFactoryImpl();
	
	@Test
	public void testProcessCommandeAcceptee() {
		// On crée une commande
		ShoppingOrder cmd = commandeFactory.create();
		assertEquals(Status.INITIALIZED, cmd.getStatus());
		
		// on lui affecte un client par défaut
		Customer customer = clientFactory.create();
		customer.updateDetails("TestNOM", "TestPRENOM");
		cmd.attachCustomer(customer);
		
		// Traitement de la commande
		IShoppingOrderProcessor<ShoppingOrder> processor = new AcceptedShoppingOrderProcessorImpl();
		ShoppingOrder newCmd = processor.process(cmd);
		
		// Le statut doit passer de INITIALISEE à ACCEPTEE
		assertEquals(Status.ACCEPTED, newCmd.getStatus());
	}
	
}
