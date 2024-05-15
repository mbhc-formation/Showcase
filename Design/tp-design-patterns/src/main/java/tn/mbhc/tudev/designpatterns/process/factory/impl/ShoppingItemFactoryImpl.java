package tn.mbhc.tudev.designpatterns.process.factory.impl;

import tn.mbhc.tudev.designpatterns.process.factory.IModelFactory;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingItem;

public class ShoppingItemFactoryImpl implements IModelFactory<ShoppingItem> {

	@Override
	public ShoppingItem create() {
		return new ShoppingItem();
	}

}
