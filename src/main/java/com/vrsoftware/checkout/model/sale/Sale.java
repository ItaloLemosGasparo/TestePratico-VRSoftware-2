package com.vrsoftware.checkout.model.sale;

import com.vrsoftware.checkout.model.client.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleItem> saleItems;

    @NotNull(message = "A data da venda não pode ser nula")
    @Column(name = "sale_date", nullable = false)
    private LocalDate saleDate;

    @NotNull(message = "O valor total da venda não pode ser nulo")
    @DecimalMin(value = "0.01", inclusive = true, message = "O valor total deve ser maior que zero")
    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @PrePersist
    @PreUpdate
    public void prePersistOrUpdate() {
        calculateSaleTotal();
    }

    public void calculateSaleTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (SaleItem item : saleItems)
            total = total.add(item.getTotalAmount());

        this.totalAmount = total;
    }

}
