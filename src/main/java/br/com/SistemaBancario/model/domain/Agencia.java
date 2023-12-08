package br.com.SistemaBancario.model.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "agencias")
@Getter
@Setter
public class Agencia implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agencia")
    private Long idAgencia;

    private String nome;
    
    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContaCorrente> contaCorrentes;
    
    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContaPoupanca> contaPoupanca;
}
