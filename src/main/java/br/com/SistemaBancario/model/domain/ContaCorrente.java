package br.com.SistemaBancario.model.domain;

import jakarta.persistence.*;

import java.io.Serializable;

import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "conta_correntes")
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ContaCorrente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private double valorCorrente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_agencia", referencedColumnName = "id_agencia")
    private Agencia agencia;



}
