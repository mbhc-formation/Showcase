package tn.mbhc.tudev.designpatterns.process.factory.impl;

import tn.mbhc.tudev.designpatterns.process.factory.IModelFactory;
import tn.mbhc.tudev.designpatterns.process.model.ShoppingOrder;

public class ShoppingOrderFactoryImpl implements IModelFactory<ShoppingOrder> {

	@Override
	public ShoppingOrder create() {
		return new ShoppingOrder();
	}

}
