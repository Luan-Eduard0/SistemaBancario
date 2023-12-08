package br.com.SistemaBancario.core.view;

import br.com.SistemaBancario.model.dao.ClienteDao;
import br.com.SistemaBancario.model.domain.Cliente;
import br.com.SistemaBancario.utils.filter.ExceptionHandler;
import java.io.IOException;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Getter
@ManagedBean
@ViewScoped
@Setter
public class BeanCliente implements Serializable{

    private Cliente cliente;
    private String confirmarSenha;
    private List<Cliente> clientes;

    @PostConstruct
    public void init() {
        this.cliente = new Cliente();
        buscar();
    }

    public void novo() {
        this.cliente = new Cliente();
    }

    public void buscar() {
        clientes = new ClienteDao().findAll();
    }

    public void editar(Cliente cliente) {
        this.cliente = cliente;
    }

    public void cancelar() {
        cliente = null;
    }
    
       public void remover(Cliente id){
        new ClienteDao().delete(id.getIdCliente());
         buscar();
    }

    public void salvar() {
        if (!cliente.getSenha().equals(confirmarSenha)) {
            ExceptionHandler.erro(FacesContext.getCurrentInstance(), "As senhas informadas não conferem!");
            return;
        }

        new ClienteDao().save(cliente);

        ExceptionHandler.erro(FacesContext.getCurrentInstance(), "Cliente salvo com sucesso!");

        novo();
        buscar();
    }

    // Getters e Setters
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    private String login;
    private String senha;

    public void logar() {
        var usuario = new ClienteDao().buscarClientePorLogin(login);
        if (usuario == null || !usuario.getSenha().equals(senha)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Login e/ou senha não encontrados", login));
            return;
        }

        
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        HttpSession session = request.getSession();

        session.setAttribute("clienteLogado", usuario);

        try {
            FacesContext.getCurrentInstance()
                    .getExternalContext().redirect(request.getContextPath() + "/pages/index_cliente.jsf");
        } catch (IOException ex) {
            Logger.getLogger(BeanCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void logout() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute("clienteLogado");
        session.invalidate();
        try {
            FacesContext.getCurrentInstance()
                    .getExternalContext().redirect(request.getContextPath());
        } catch (IOException ex) {
            Logger.getLogger(BeanCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
