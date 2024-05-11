package tn.mbhc.tudev.spring.rest.consumer.helpers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import tn.mbhc.tudev.spring.rest.data.Data;
import tn.mbhc.tudev.spring.rest.data.Product;

public class ProductsParserDataHelper {

	/**
	 * Creates a list of {@link Product}.
	 * @return
	 */
	public List<Product> createDummyProducts() {
		
		Product first = new Product()
				.withId(1L)
				.withName("Google Pixel 6 Pro")
				.withData(new Data()
						.withColor("Cloudy White")
						.withCapacity("128 GB"));
		
		Product second = new Product()
				.withId(2L)
				.withName("Apple iPhone 12 Mini, 256GB, Blue");
		
		Product third = new Product()
				.withId(3L)
				.withName("Apple iPhone 12 Pro Max")
				.withData(new Data()
						.withColor("Cloudy White")
						.withCapacityGB(512));
		
		Product fourth = new Product()
				.withId(4L)
				.withName("Apple iPhone 11, 64GB")
				.withData(new Data()
						.withPrice(fromDoubleAndHalfEvenRounded(389.99))
						.withColor("Purple"));
		
		Product fifth = new Product()
				.withId(5L)
				.withName("Samsung Galaxy Z Fold2")
				.withData(new Data()
						.withPrice(fromDoubleAndHalfEvenRounded(689.99))
						.withColor("Brown"));
		
		Product sixth = new Product()
				.withId(6L)
				.withName("Apple AirPods")
				.withData(new Data()
						.withGeneration("3rd")
						.withPrice(fromDoubleAndHalfEvenRounded(120.00)));
		
		Product seventh = new Product()
				.withId(7L)
				.withName("Apple MacBook Pro 16")
				.withData(new Data()
						.withYear(2019)
						.withPrice(fromDoubleAndHalfEvenRounded(1849.99))
						.withCpuModel("Intel Core i9")
						.withHardDiskSize("1 TB"));
		
		Product eighth = new Product()
				.withId(8L)
				.withName("Apple Watch Series 8")
				.withData(new Data()
						.withStrapColor("Elderberry")
						.withCaseSize("41mm"));
		
		Product ninth = new Product()
				.withId(9L)
				.withName("Beats Studio3 Wireless")
				.withData(new Data()
						.withColor("Red")
						.withDescription("High-performance wireless noise cancelling headphones"));
		
		Product tenth = new Product()
				.withId(10L)
				.withName("Apple iPad Mini 5th Gen")
				.withData(new Data()
						.withCapacity("64 GB")
						.withScreenSize(7.9));
		
		Product eleventh = new Product()
				.withId(11L)
				.withName("Apple iPad Mini 5th Gen")
				.withData(new Data()
						.withCapacity("254 GB")
						.withScreenSize(7.9));
		
		Product twelvth = new Product()
				.withId(12L)
				.withName("Apple iPad Air")
				.withData(new Data()
						.withGeneration("4th")
						.withPrice(fromDoubleAndHalfEvenRounded(419.99))
						.withCapacity("64 GB"));
		
		Product thirteenth = new Product()
				.withId(13L)
				.withName("Apple iPad Air")
				.withData(new Data()
						.withGeneration("4th")
						.withPrice(fromDoubleAndHalfEvenRounded(519.99))
						.withCapacity("256 GB"));
		
		return Arrays.asList(first, second, third, fourth, fifth, sixth, 
				seventh, eighth, ninth, tenth, eleventh, twelvth, thirteenth);
	}
	
	/**
	 * Converts the given double value to a rounded scaled (2) {@link BigDecimal}
	 * @param value
	 * @return
	 */
	private BigDecimal fromDoubleAndHalfEvenRounded(final double value) {
		return new BigDecimal(value).setScale(2, RoundingMode.HALF_EVEN);
	}
	
}
