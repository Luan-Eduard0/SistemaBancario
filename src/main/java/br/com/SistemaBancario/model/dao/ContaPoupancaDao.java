package br.com.SistemaBancario.model.dao;

import br.com.SistemaBancario.model.domain.ContaPoupanca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ContaPoupancaDao extends GenericDao<ContaPoupanca, Long>{
    @PersistenceContext
    private EntityManager entityManager;

    public List<ContaPoupanca> findContaPoupancaByClienteId(Long clienteId) {
        String jpql = "SELECT cp FROM ContaPoupanca cp WHERE cp.cliente.idCliente = :clienteId";
        TypedQuery<ContaPoupanca> query = entityManager.createQuery(jpql, ContaPoupanca.class);
        query.setParameter("clienteId", clienteId);
        return query.getResultList();
    }
}
