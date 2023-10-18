/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.SistemaBancario.core.view;

import br.com.SistemaBancario.model.domain.ContaPoupanca;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author contaPoupancas
 */
public class BeanContaP {
    private ContaPoupanca contaPoupanca;
    private List<ContaPoupanca> contaPoupancas;
    private boolean editando = false;

    public BeanContaP() {
        contaPoupanca = new ContaPoupanca();
    }

    @PostConstruct
    public void init() {
        buscar();
    }

    public void salvar() {
        new ContaPoupancaDao().save(contaPoupanca);
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
    
     public void remover(ContaPoupanca id){
        new ContaPoupancaDao().delete(id.getId());
         buscar();
    }

    public void buscar() {
        this.contaPoupancas = new ContaPoupancaDao().findAll();
    }

    public void novo() {
        this.contaPoupanca = new ContaPoupanca();
    }

    public void cancelar() {
        this.contaPoupanca = null;
    }

    public void editar(ContaPoupanca contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
    }

   
}
