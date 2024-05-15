package tn.mbhc.tudev.designpatterns.strategy.components.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import tn.mbhc.tudev.designpatterns.strategy.components.TaxComputingService;

@RunWith(BlockJUnit4ClassRunner.class)
public class TaxComputingServiceTest {

	private TaxComputingService service = new TaxesComputingServiceImpl();

	@Test
	public void computeTaxedPrice() {
		BigDecimal actual = service.computeTaxedPrice(BigDecimal.valueOf(10.0), 0.05);
		BigDecimal expected = BigDecimal.valueOf(10.5).setScale(2);
		assertEquals(expected, actual);
	}

}
