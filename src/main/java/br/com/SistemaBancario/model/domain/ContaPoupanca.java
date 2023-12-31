package br.com.SistemaBancario.model.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contas_poupanca")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaPoupanca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_contaP;
    private Double valorDepositado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;
   
    @ManyToOne
    @JoinColumn(name = "id_agencia", referencedColumnName = "id_agencia")
    private Agencia agencia;

    
}
