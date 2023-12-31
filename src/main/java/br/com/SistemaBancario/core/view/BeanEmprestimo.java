package br.com.SistemaBancario.core.view;

import br.com.SistemaBancario.model.dao.EmprestimoDao;
import br.com.SistemaBancario.model.domain.Emprestimo;
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
public class BeanEmprestimo implements Serializable{
   
    private Emprestimo emprestimo;
    private List<Emprestimo> emprestimos;

    @PostConstruct
    public void init() {
        this.emprestimo = new Emprestimo();
        buscar();
    }

    public void novo() {
        this.emprestimo = new Emprestimo();
    }

    public void buscar() {
        emprestimos = new EmprestimoDao().findAll();
    }
    public void editar(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public void cancelar() {
        emprestimo = null;
    }
     public void salvar() {
        new EmprestimoDao().save(emprestimo);
        cancelar();
    }
      
   
    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    
    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
}
