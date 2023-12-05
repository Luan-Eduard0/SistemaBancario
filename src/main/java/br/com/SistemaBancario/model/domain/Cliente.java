package br.com.SistemaBancario.model.domain;

import jakarta.persistence.*;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;
    
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;


    @Column(nullable = false)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "id_agencia")
    private Agencia agencia;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private ContaCorrente contaCorrente;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private ContaPoupanca contaPoupanca;
    
     @Transient
    public boolean isNew() {
        return idCliente == null;
    }
}
