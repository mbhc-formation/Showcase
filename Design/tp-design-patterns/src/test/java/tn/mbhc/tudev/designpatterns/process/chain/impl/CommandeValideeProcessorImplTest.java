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
public class CommandeValideeProcessorImplTest {

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

		// On crée un article avec une qté >= 1
		ShoppingItem article = articleFactory.create();
		article.increaseQuantity();
		
		// On l'ajoute à la commande
		cmd.addItem(article);

		IShoppingOrderProcessor<ShoppingOrder> processor = new ValidatedShoppingOrderProcessorImpl();
		ShoppingOrder newCmd = processor.process(cmd);

		// Le statut doit passer de EN_COURS à VALIDEE
		assertNotNull(newCmd.getStatus());
		assertEquals(Status.VALIDATED, newCmd.getStatus());
	}

}
