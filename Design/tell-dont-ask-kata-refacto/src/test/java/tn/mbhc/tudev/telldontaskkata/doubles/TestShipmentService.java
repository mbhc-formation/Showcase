package tn.mbhc.tudev.telldontaskkata.doubles;

import tn.mbhc.tudev.telldontaskkata.domain.Order;
import tn.mbhc.tudev.telldontaskkata.service.ShipmentService;

public class TestShipmentService implements ShipmentService {
    private Order shippedOrder = null;

    public Order getShippedOrder() {
        return shippedOrder;
    }

    @Override
    public void ship(Order order) {
    	order.ship();
        this.shippedOrder = order;
    }
}
