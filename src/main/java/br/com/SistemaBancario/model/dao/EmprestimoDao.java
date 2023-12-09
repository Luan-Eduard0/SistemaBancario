package br.com.SistemaBancario.model.dao;

import br.com.SistemaBancario.model.domain.Emprestimo;
import jakarta.transaction.Transactional;

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
            @Transactional
            public void fimEmprestimo(int quantidadeParcelas, Emprestimo emprestimo) {
            if (quantidadeParcelas == 0 && emprestimo.getAtivo() == true) {
                emprestimo.setAtivo(false);
                save(emprestimo);
            }
            else if(quantidadeParcelas > 0 && emprestimo.getAtivo() == true) {
                 String sa = "Emprestimo ainda ativo";
            }

        }
    }

