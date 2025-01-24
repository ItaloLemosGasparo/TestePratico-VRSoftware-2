package com.vrsoftware.checkout.model.sale;

import com.vrsoftware.checkout.model.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SaleItems")
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull(message = "A quantidade não pode ser nula")
    @DecimalMin(value = "1", message = "A quantidade deve ser no mínimo 1")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull(message = "O preço unitário não pode ser nulo")
    @DecimalMin(value = "0.01", message = "O preço unitário deve ser maior que zero")
    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    @NotNull(message = "O valor total do item não pode ser nulo")
    @DecimalMin(value = "0.01", message = "O valor total do item deve ser maior que zero")
    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;
}
