package br.com.pessoa.service;

import br.com.pessoa.model.Pessoa;

import java.util.List;

public interface PessoaService {

    List<Pessoa> listar();

    Pessoa findById(Long id);

    Pessoa cadastrar(Pessoa pessoa);

    void deletar(Long id);

    Pessoa atualizar(Long id, Pessoa pessoaAtualizada);

    Pessoa buscarPorCpf(String cpf);
}
