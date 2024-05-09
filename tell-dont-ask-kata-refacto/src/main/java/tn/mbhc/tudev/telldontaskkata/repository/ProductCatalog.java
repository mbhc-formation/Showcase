package tn.mbhc.tudev.telldontaskkata.repository;

import tn.mbhc.tudev.telldontaskkata.domain.Product;

public interface ProductCatalog {
    Product getByName(String name);
}
