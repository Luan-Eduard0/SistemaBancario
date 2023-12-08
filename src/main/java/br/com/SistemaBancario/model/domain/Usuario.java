package br.com.SistemaBancario.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Usuario{
    
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;

}
