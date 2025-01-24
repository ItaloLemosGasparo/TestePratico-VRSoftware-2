package com.vrsoftware.checkout.model.product;

import com.vrsoftware.checkout.model.sale.SaleItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "A descrição do produto não pode ser vazia")
    @Size(min = 4, max = 1024, message = "A descrição deve ter entre 4 e 1024 caracteres")
    @Column(name = "description", nullable = false, length = 1024)
    private String description;

    @NotNull(message = "O preço do produto não pode ser nulo")
    @DecimalMin(value = "0.01", inclusive = true, message = "O preço deve ser maior que zero")
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<SaleItem> saleItems;

}
