package br.com.SistemaBancario.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "transferencias")
@Getter
@Setter
public class Transferencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;
    private Date dataTransferencia;

    @ManyToMany
    @JoinTable(
            name = "conta_transferencia",
            joinColumns = @JoinColumn(name = "transferencia_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "conta_corrente_id"),
                    @JoinColumn(name = "conta_poupanca_id")
            }
    )
    private Set<ContaCorrente> contasCorrentes;

    @ManyToMany(mappedBy = "transferenciasRecebidas")
    private Set<ContaPoupanca> contasPoupancas;

}
