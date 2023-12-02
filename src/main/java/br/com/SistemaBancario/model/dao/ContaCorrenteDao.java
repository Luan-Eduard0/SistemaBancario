package br.com.SistemaBancario.model.dao;

import br.com.SistemaBancario.model.domain.ContaCorrente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ContaCorrenteDao extends GenericDao<ContaCorrente, Long> {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ContaCorrente> findContaCorrenteByClienteId(Long clienteId) {
        String jpql = "SELECT cc FROM ContaCorrente cc WHERE cc.cliente.idCliente = :clienteId";
        TypedQuery<ContaCorrente> query = entityManager.createQuery(jpql, ContaCorrente.class);
        query.setParameter("clienteId", clienteId);
        return query.getResultList();
    }
}
