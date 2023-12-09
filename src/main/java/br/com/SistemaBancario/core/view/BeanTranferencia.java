package br.com.SistemaBancario.core.view;

import br.com.SistemaBancario.model.dao.TransferenciaDao;
import br.com.SistemaBancario.model.domain.Transferencia;
import br.com.SistemaBancario.utils.filter.ExceptionHandler;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

public class BeanTranferencia {
    @ManagedBean
    @ViewScoped
    public class TransferenciaBean {

        private Transferencia transferencia;
        private List<Transferencia> transferencias;

        @PostConstruct
        public void init() {
            this.transferencia = new Transferencia();
            buscarTransferencias();
        }

        public void novaTransferencia() {
            this.transferencia = new Transferencia();
        }

        public void buscarTransferencias() {
            transferencias = new TransferenciaDao().findAll();
        }

        public void editarTransferencia(Transferencia transferencia) {
            this.transferencia = transferencia;
        }

        public void cancelarTransferencia() {
            transferencia = null;
        }

        public void removerTransferencia(Transferencia transferencia) {
            new TransferenciaDao().delete(transferencia.getId());
            buscarTransferencias();
        }

        public void salvarTransferencia() {
            new TransferenciaDao().save(transferencia);

            ExceptionHandler.erro(FacesContext.getCurrentInstance(), "Transferência salva com sucesso!");

            novaTransferencia();
            buscarTransferencias();
        }

        // Getters e Setters
        public Transferencia getTransferencia() {
            return transferencia;
        }

        public List<Transferencia> getTransferencias() {
            return transferencias;
        }

    }
}