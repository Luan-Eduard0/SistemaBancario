
package br.com.SistemaBancario.model.domain;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.com.SistemaBancario.model.domain.Agencia;

/**
 *
 * @author alunos
 */

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;


    @OneToMany(mappedBy = "cliente")
    private Agencia agencia;

    @OneToOne(mappedBy = "conta_correntes")
    private ContaCorrente contaCorrente;

    @OneToOne(mappedBy = "conta_poupancas")
    private ContaPoupanca contaPoupanca;
}
