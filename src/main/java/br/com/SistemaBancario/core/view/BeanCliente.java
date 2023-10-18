/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.SistemaBancario.core.view;

import br.com.SistemaBancario.model.domain.Cliente;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author clientes
 */
@Getter
@Setter
@ManagedBean
@SessionScoped
public class BeanCliente {
    private Cliente cliente;
    private List<Cliente> clientes;
    private boolean editando = false;

    public BeanCliente() {
        cliente = new Cliente();
    }

    @PostConstruct
    public void init() {
        buscar();
    }

    public void salvar() {
        new ClienteDao().save(cliente);
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
    
     public void remover(Cliente id){
        new ClienteDao().delete(id.getId());
         buscar();
    }

    public void buscar() {
        this.clientes = new ClienteDao().findAll();
    }

    public void novo() {
        this.cliente = new Cliente();
    }

    public void cancelar() {
        this.cliente = null;
    }

    public void editar(Cliente cliente) {
        this.cliente = cliente;
    }
}
