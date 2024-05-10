package tn.mbhc.tudev.telldontaskkata.doubles;

import java.util.ArrayList;
import java.util.List;

import tn.mbhc.tudev.telldontaskkata.domain.Order;
import tn.mbhc.tudev.telldontaskkata.repository.OrderRepository;

public class TestOrderRepository implements OrderRepository {
	private Order insertedOrder;
	private List<Order> orders = new ArrayList<>();

	public Order getSavedOrder() {
		return insertedOrder;
	}

	@Override
	public void save(Order order) {
		this.insertedOrder = order;
	}

	@Override
	public Order getById(Long orderId) {
		return orders.stream().filter(o -> o.isOrderIdEqualtTo(orderId)).findFirst().get();
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}
}
