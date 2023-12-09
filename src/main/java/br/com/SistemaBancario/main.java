package br.com.SistemaBancario;

import br.com.SistemaBancario.model.dao.FuncionarioDao;
import br.com.SistemaBancario.model.domain.Funcionario;

public class main {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("João");
        funcionario.setCpf("123456789");
        funcionario.setEmail("Teste@gmail.com");
        funcionario.setTelefone("123456789");
        funcionario.setEndereco("Rua teste");
        funcionario.setGerente(true);
        funcionario.setLogin("teste");
        funcionario = new FuncionarioDao().save(funcionario);
    }
}
