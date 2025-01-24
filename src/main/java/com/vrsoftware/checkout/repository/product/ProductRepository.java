package com.vrsoftware.checkout.repository.product;

import com.vrsoftware.checkout.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
