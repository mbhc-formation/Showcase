package tn.mbhc.tudev.designpatterns.process.factory.impl;

import tn.mbhc.tudev.designpatterns.process.factory.IModelFactory;
import tn.mbhc.tudev.designpatterns.process.model.Customer;

public class CustomerFactoryImpl implements IModelFactory<Customer> {

	@Override
	public Customer create() {
		return new Customer();
	}

}
