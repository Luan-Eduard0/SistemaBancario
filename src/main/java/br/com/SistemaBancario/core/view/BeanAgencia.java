package br.com.SistemaBancario.core.view;

import br.com.SistemaBancario.model.dao.AgenciaDao;
import br.com.SistemaBancario.model.dao.ClienteDao;
import br.com.SistemaBancario.model.dao.ContaCorrenteDao;
import br.com.SistemaBancario.model.domain.Agencia;
import br.com.SistemaBancario.model.domain.Cliente;
import br.com.SistemaBancario.model.domain.ContaCorrente;
import br.com.SistemaBancario.utils.filter.ExceptionHandler;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;


@Getter
@ManagedBean
@ViewScoped
@Setter
public class BeanAgencia implements Serializable{
    
    private Agencia agencia;
    private String confirmarSenha;
    private List<Agencia> agencias;

    @PostConstruct
    public void init() {
        this.agencia = new Agencia();
        buscar();
    }

    public void novo() {
        this.agencia = new Agencia();
    }

    public void buscar() {
        agencias = new AgenciaDao().findAll();
    }

    public void editar(Agencia agencia) {
        this.agencia = agencia;
    }

    public void cancelar() {
        agencia = null;
    }
    
       public void remover(Agencia id){
        new AgenciaDao().delete(id.getIdAgencia());
         buscar();
    }

    public void salvar() {
        new AgenciaDao().save(agencia);

        ExceptionHandler.erro(FacesContext.getCurrentInstance(), "Agencia salvo com sucesso!");

        novo();
        buscar();
    }

    // Getters e Setters
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public void setAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
    }
    
    public List<Cliente> getClientes() {
        return new ClienteDao().findAll();
    }
    public List<ContaCorrente> getContaC() {
        return new ContaCorrenteDao().findAll();
    }
}
