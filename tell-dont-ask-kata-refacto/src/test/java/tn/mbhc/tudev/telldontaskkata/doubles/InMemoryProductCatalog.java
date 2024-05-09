package tn.mbhc.tudev.telldontaskkata.doubles;

import java.util.List;

import tn.mbhc.tudev.telldontaskkata.domain.Product;
import tn.mbhc.tudev.telldontaskkata.repository.ProductCatalog;

public class InMemoryProductCatalog implements ProductCatalog {
    private final List<Product> products;

    public InMemoryProductCatalog(List<Product> products) {
        this.products = products;
    }

    public Product getByName(final String name) {
        return products.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }
}
