/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.SistemaBancario.core.view;

import br.com.SistemaBancario.model.dao.ClienteDao;
import br.com.SistemaBancario.model.dao.ContaPoupancaDao;
import br.com.SistemaBancario.model.domain.Cliente;
import br.com.SistemaBancario.model.domain.ContaPoupanca;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author contaPoupancas
 */
@Getter
@ManagedBean
@ViewScoped
@Setter
public class BeanContaP implements Serializable{
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
    
     public void remover(ContaPoupanca id){
        new ContaPoupancaDao().delete(id.getId_contaP());
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

    public List<Cliente> getClientes() {
        return new ClienteDao().findAll();
    }
   
}
