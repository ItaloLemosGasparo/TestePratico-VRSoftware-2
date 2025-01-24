package com.vrsoftware.checkout.repository.sale;

import com.vrsoftware.checkout.model.sale.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
}
