/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.SistemaBancario.model.domain;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author alunos
 */
@Getter
@Setter
public abstract class Usuario{
    
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;

}
