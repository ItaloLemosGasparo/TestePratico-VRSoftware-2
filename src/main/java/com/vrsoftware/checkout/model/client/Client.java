package com.vrsoftware.checkout.model.client;

import com.vrsoftware.checkout.model.Sale.Sale;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "O nome do cliente não pode ser vazio")
    @Size(min = 4, max = 60, message = "O nome do cliente deve ter entre 4 e 60 caracteres")
    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @NotNull(message = "O limite de crédito não pode ser nulo")
    @DecimalMin(value = "0.01", inclusive = true, message = "O limite de crédito deve ser maior ou igual a R$ 0,01")
    @Digits(integer = 10, fraction = 2, message = "O limite de crédito deve ser um número válido com até 2 casas decimais")
    @Column(name = "credit_limit", nullable = false)
    private BigDecimal creditLimit;

    @NotNull(message = "O dia de fechamento da fatura não pode ser nulo")
    @Min(value = 5, message = "O dia de fechamento deve ser no mínimo 5")
    @Max(value = 20, message = "O dia de fechamento deve ser no máximo 20")
    @Column(name = "closing_day", nullable = false)
    private Integer closingDay;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Sale> sales;
}
