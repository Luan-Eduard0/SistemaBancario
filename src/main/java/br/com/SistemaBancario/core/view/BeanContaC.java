package br.com.SistemaBancario.core.view;

import br.com.SistemaBancario.model.dao.AgenciaDao;
import br.com.SistemaBancario.model.dao.ClienteDao;
import br.com.SistemaBancario.model.dao.ContaCorrenteDao;
import br.com.SistemaBancario.model.domain.Agencia;
import br.com.SistemaBancario.model.domain.Cliente;
import br.com.SistemaBancario.model.domain.ContaCorrente;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
@ManagedBean
@ViewScoped
@Setter
public class BeanContaC implements Serializable{
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

    
    public List<Cliente> getClientes() {
        return new ClienteDao().findAll();
    }
    
    public List<Agencia> getAgencias() {
        return new AgenciaDao().findAll();
    }
}
