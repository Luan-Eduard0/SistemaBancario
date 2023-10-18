/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.SistemaBancario.core.view;

import br.com.SistemaBancario.model.domain.ContaCorrente;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author contaCorrentes
 */
public class BeanContaC {
    private ContaCorrente contaCorrente;
    private List<ContaCorrente> contaCorrentes;
    private boolean editando = false;

    public BeanContaC() {
        contaCorrente = new ContaCorrente();
    }

    @PostConstruct
    public void init() {
        buscar();
    }

    public void salvar() {
        new ContaCorrenteDao().save(contaCorrente);
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
    
     public void remover(ContaCorrente id){
        new ContaCorrenteDao().delete(id.getId());
         buscar();
    }

    public void buscar() {
        this.contaCorrentes = new ContaCorrenteDao().findAll();
    }

    public void novo() {
        this.contaCorrente = new ContaCorrente();
    }

    public void cancelar() {
        this.contaCorrente = null;
    }

    public void editar(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

}
