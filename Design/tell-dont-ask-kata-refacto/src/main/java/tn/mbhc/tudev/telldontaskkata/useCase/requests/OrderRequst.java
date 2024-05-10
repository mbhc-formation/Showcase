package tn.mbhc.tudev.telldontaskkata.useCase.requests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrderRequst {

	private List<ItemSellRequest> itemRequests = new ArrayList<>();

	public OrderRequst withOne(ItemSellRequest request) {
		this.itemRequests.add(request);
		return this;
	}

	public OrderRequst withAll(ItemSellRequest... requests) {
		this.itemRequests.addAll(Arrays.asList(requests));
		return this;
	}

	public List<ItemSellRequest> items() {
		return Collections.unmodifiableList(itemRequests);
	}
}
