package br.com.SistemaBancario.model.dao;

import br.com.SistemaBancario.model.domain.ContaCorrente;
import br.com.SistemaBancario.model.domain.ContaPoupanca;
import jakarta.persistence.EntityManager;

import java.util.Set;

public class TransferenciaDao extends GenericDao<Transferencia, Long> {
    public void realizarTransferencia(Long idContaOrigem, Long idContaDestino, Double valorTransferencia) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();

            ContaCorrente contaCorrenteOrigem = entityManager.find(ContaCorrente.class, idContaOrigem);
            ContaPoupanca contaPoupancaDestino = entityManager.find(ContaPoupanca.class, idContaDestino);

            if (contaCorrenteOrigem != null && contaPoupancaDestino != null) {
                Transferencia transferencia = new Transferencia();
                transferencia.setValor(valorTransferencia);
                transferencia.setContasCorrentes(Set.of(contaCorrenteOrigem));
                transferencia.setContasPoupancas(Set.of(contaPoupancaDestino));

                contaCorrenteOrigem.setValorCorrente(contaCorrenteOrigem.getValorCorrente() - valorTransferencia);
                contaPoupancaDestino.setValorDepositado(contaPoupancaDestino.getValorDepositado() + valorTransferencia);

                save(transferencia);
                entityManager.merge(contaCorrenteOrigem);
                entityManager.merge(contaPoupancaDestino);

                entityManager.getTransaction().commit();
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Erro ao realizar a transferência.", e);
        } finally {
            entityManager.close();
        }
    }
}