package br.com.pessoa.controller;

import br.com.pessoa.model.Pessoa;
import br.com.pessoa.service.PessoaService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    @CrossOrigin
    public List<Pessoa> listar() {
        return pessoaService.listar();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public Pessoa findpyId(@PathVariable Long id) {
        return pessoaService.findById(id);
    }

    @PostMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa cadastrar(@RequestBody Pessoa pessoa) {
        return pessoaService.cadastrar(pessoa);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        pessoaService.deletar(id);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public Pessoa atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        return pessoaService.atualizar(id, pessoa);
    }

    @GetMapping("/cpf/{cpf}")
    @CrossOrigin
    public Pessoa buscarPorCpf(@PathVariable String cpf) {
        return pessoaService.buscarPorCpf(cpf);
    }
}