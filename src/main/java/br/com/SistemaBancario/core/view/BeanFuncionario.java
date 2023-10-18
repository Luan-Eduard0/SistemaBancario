/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.SistemaBancario.core.view;

import br.com.SistemaBancario.model.domain.Funcionario;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author funcionarios
 */
public class BeanFuncionario {
    private Funcionario funcionario;
    private List<Funcionario> funcionarios;
    private boolean editando = false;

    public BeanFuncionario() {
        funcionario = new Funcionario();
    }

    @PostConstruct
    public void init() {
        buscar();
    }

    public void salvar() {
        new FuncionarioDao().save(funcionario);
        buscar();
        cancelar();
        editando = false;
    }

    /*public void remover(Livro livro) {
        LivroDao livroDao = new LivroDao();
        var livroPersist = livroDao.findLivroId(livro.getId());
        System.out.println(livroPersist);
        if (livroPersist != null) {
            new LivroDao().delete(livroPersist);
        }
        buscar();
    }*/
    
     public void remover(Funcionario id){
        new FuncionarioDao().delete(id.getId());
         buscar();
    }

    public void buscar() {
        this.funcionarios = new FuncionarioDao().findAll();
    }

    public void novo() {
        this.funcionario = new Funcionario();
    }

    public void cancelar() {
        this.funcionario = null;
    }

    public void editar(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

   
}
