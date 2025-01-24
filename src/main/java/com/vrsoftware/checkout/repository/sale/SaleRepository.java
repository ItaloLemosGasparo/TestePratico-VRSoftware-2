package com.vrsoftware.checkout.repository.sale;

import com.vrsoftware.checkout.model.Sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
