package br.com.SistemaBancario.core.view;

import br.com.SistemaBancario.model.dao.FuncionarioDao;
import br.com.SistemaBancario.model.domain.Funcionario;
import br.com.SistemaBancario.utils.filter.ExceptionHandler;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@Getter
@ManagedBean
@ViewScoped
@Setter
public class BeanFuncionario {

    // Getters e Setters
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
}
