package br.com.SistemaBancario.model.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "emprestimos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Emprestimo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_emprestimo;


    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;

    private Boolean ativo;
    private Integer parcelas;
    private Double valor;
    private Double valorParcela;
    private Double valorEmprestimo;
    private String dataRealizado;
    private String dataPagamento;
}
