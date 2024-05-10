package tn.mbhc.tudev.telldontaskkata.repository;

import tn.mbhc.tudev.telldontaskkata.domain.Order;

public interface OrderRepository {
	void save(Order order);

	Order getById(Long orderId);
}
