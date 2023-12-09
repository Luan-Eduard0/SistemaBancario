package br.com.SistemaBancario.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.ManyToOne;


import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "transferencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transferencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_transferencia;
    private Double valor;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "id_conta_origem")
    private ContaCorrente conta_origem;

    @ManyToOne
    @JoinColumn(name = "id_conta_destino")
    private ContaCorrente conta_destino;

}
