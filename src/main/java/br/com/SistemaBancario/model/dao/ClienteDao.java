package br.com.SistemaBancario.model.dao;

import br.com.SistemaBancario.model.domain.Cliente;
import jakarta.persistence.Query;

public class ClienteDao extends GenericDao<Cliente, Long> {
    public Cliente buscarClientePorLogin(String email) {
        String sql = "from Cliente a where a.email = :email";

        Query query = getEntityManager().createQuery(sql, Cliente.class)
                .setParameter("email", email);
        var resultado = query.getResultList();
        return resultado.isEmpty() ? null : (Cliente) resultado.get(0);
    }
    
     public Cliente buscarPorEmail(String email) {
        String sql = "from Cliente where email = :email";
        Query query = getEntityManager().createQuery(sql, Cliente.class)
                .setParameter("email", email);
        var result = query.getResultList();
        return result.isEmpty() ? null : (Cliente) result.get(0);
                
    }
}
