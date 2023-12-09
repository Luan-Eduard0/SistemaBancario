package br.com.SistemaBancario.core.view;

import br.com.SistemaBancario.model.dao.FuncionarioDao;
import br.com.SistemaBancario.model.domain.Funcionario;
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
public class BeanFuncionario implements Serializable{

   
    private Funcionario funcionario;
    private String confirmarSenha;
    private List<Funcionario> funcionarios;

    @PostConstruct
    public void init() {
        this.funcionario = new Funcionario();
        buscar();
    }

    public void novo() {
        this.funcionario = new Funcionario();
    }

    public void buscar() {
        funcionarios = new FuncionarioDao().findAll();
    }
    public void editar(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void cancelar() {
        funcionario = null;
    }
    public void salvar() {
        if (!funcionario.getSenha().equals(confirmarSenha)) {
            ExceptionHandler.erro(FacesContext.getCurrentInstance(), "As senhas informadas não conferem!");
            return;
        }
        new FuncionarioDao().save(funcionario);

        ExceptionHandler.erro(FacesContext.getCurrentInstance(), "Funcionário salvo com sucesso!");

        novo();
        buscar();
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
     private String login;
    private String senha;

    public void logar() {
        var usuario = new FuncionarioDao().buscarFuncionarioPorLogin(login);
        if (usuario == null || !usuario.getSenha().equals(senha)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Login e/ou senha não encontrados", login));
            return;
        }

        
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        HttpSession session = request.getSession();

        session.setAttribute("funcionarioLogado", usuario);

        try {
            FacesContext.getCurrentInstance()
                    .getExternalContext().redirect(request.getContextPath() + "/pages_adm/index.jsf");
        } catch (IOException ex) {
            Logger.getLogger(BeanCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void logout() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute("funcionarioLogado");
        session.invalidate();
        try {
            FacesContext.getCurrentInstance()
                    .getExternalContext().redirect(request.getContextPath());
        } catch (IOException ex) {
            Logger.getLogger(BeanCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
