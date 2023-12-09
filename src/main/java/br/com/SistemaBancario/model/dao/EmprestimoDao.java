package br.com.SistemaBancario.model.dao;

import br.com.SistemaBancario.model.domain.Cliente;
import br.com.SistemaBancario.model.domain.Emprestimo;
import br.com.SistemaBancario.model.domain.Usuario;
import jakarta.persistence.Query;

import java.util.List;

public class EmprestimoDao extends GenericDao<Emprestimo, Long> {
    public void NumeroParcelas(Emprestimo emprestimo) {
        int quantidadeParcelas = emprestimo.getParcelas();
        double valorParcela = emprestimo.getValorEmprestimo() / quantidadeParcelas;
        for (int i = 1; i <= quantidadeParcelas; i++) {
            if (quantidadeParcelas <= 48) {
                emprestimo.setParcelas(quantidadeParcelas);
                emprestimo.setValorParcela(valorParcela + 1.0339);
                emprestimo.setAtivo(true);
                save(emprestimo);
                quantidadeParcelas--;

            }
        }
    }
    //
        public List<Emprestimo> buscarIDCliente(Cliente cliente){
            String sql = "FROM emprestimos e WHERE e.id_cliente = :cliente";
        Query query = getEntityManager().createQuery(sql, Emprestimo.class)
                .setParameter("cliente", cliente);
        return query.getResultList();
        }

    }

