package br.com.SistemaBancario.model.dao;

import br.com.SistemaBancario.model.domain.Funcionario;
import jakarta.persistence.Query;

import java.util.List;

public class FuncionarioDao extends GenericDao<Funcionario, Long>{
    public Funcionario buscarFuncionarioPorLogin(String login) {
        String jpql = "FROM Funcionario f WHERE f.email = :email";

        Query query = getEntityManager().createQuery(jpql, Funcionario.class)
                .setParameter("email", login);

        List<Funcionario> resultado = query.getResultList();
        return resultado.isEmpty() ? null : resultado.get(0);
    }
}
