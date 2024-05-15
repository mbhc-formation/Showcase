package tn.mbhc.tudev.designpatterns.process.chain.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import tn.mbhc.tudev.designpatterns.process.chain.IShoppingOrderProcessor;
import tn.mbhc.tudev.designpatterns.process.factory.IModelFactory;
import tn.mbhc.tudev.designpatterns.process.factory.impl.ShoppingItemFactoryImpl;
import tn.mbhc.tudev.designpatterns.process.factory.impl.CustomerFactoryImpl;
import tn.mbhc.tudev.designpatterns.process.factory.impl.ShoppingOrderFactoryImpl;
import tn.mbhc.tudev.designpatterns.process.model.Customer;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingItem;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder.Status;

@RunWith(BlockJUnit4ClassRunner.class)
public class CommandeEnCoursProcessorTest {

	private IModelFactory<ShoppingOrder> commandeFactory = new ShoppingOrderFactoryImpl();
	private IModelFactory<ShoppingItem> articleFactory = new ShoppingItemFactoryImpl();
	private IModelFactory<Customer> clientFactory = new CustomerFactoryImpl();

	@Test
	public void testProcessCommandeValidee() {
		// On crée une commande et on lui affecte un client par défaut
		ShoppingOrder cmd = commandeFactory.create();
		Customer customer = clientFactory.create();
		customer.updateDetails("TestNOM", "TestPRENOM");
		cmd.attachCustomer(customer);

		// On ajoute un article
		cmd.addItem(articleFactory.create());

		IShoppingOrderProcessor<ShoppingOrder> processor = new InPreparationShoppingOrderProcessorImpl();
		ShoppingOrder newCmd = processor.process(cmd);

		// Le statut doit passer de ACCEPTEE à EN_COURS
		assertNotNull(newCmd.getStatus());
		assertEquals(Status.IN_PREPARATION, newCmd.getStatus());
	}

}
