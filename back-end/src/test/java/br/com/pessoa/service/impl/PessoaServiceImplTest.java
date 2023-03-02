package br.com.pessoa.service.impl;

import br.com.pessoa.model.Pessoa;
import br.com.pessoa.repository.PessoaRepository;
import br.com.pessoa.service.PessoaService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceImplTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaServiceImpl pessoaService;

    @Test
    public void testListar() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setId(1L);
        pessoa1.setNome("Fulano");
        pessoa1.setCpf("12345678900");

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setId(2L);
        pessoa2.setNome("Beltrano");
        pessoa2.setCpf("98765432100");

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);

        when(pessoaRepository.findAll()).thenReturn(pessoas);

        List<Pessoa> pessoasEncontradas = pessoaService.listar();
        assertEquals(2, pessoasEncontradas.size());
        assertEquals(Long.valueOf(1), pessoasEncontradas.get(0).getId());
        assertEquals("Fulano", pessoasEncontradas.get(0).getNome());
        assertEquals("12345678900", pessoasEncontradas.get(0).getCpf());
        assertEquals(Long.valueOf(2), pessoasEncontradas.get(1).getId());
        assertEquals("Beltrano", pessoasEncontradas.get(1).getNome());
        assertEquals("98765432100", pessoasEncontradas.get(1).getCpf());
    }

    @Test
    public void testCadastrar() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fulano");
        pessoa.setCpf("12345678900");

        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        Pessoa pessoaCadastrada = pessoaService.cadastrar(pessoa);
        assertEquals("Fulano", pessoaCadastrada.getNome());
        assertEquals("12345678900", pessoaCadastrada.getCpf());
    }

    @Test
    public void testAtualizar() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Fulano");
        pessoa.setCpf("12345678900");

        when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        Pessoa pessoaAtualizada = pessoaService.atualizar(1L, pessoa);
        assertEquals(Long.valueOf(1), pessoaAtualizada.getId());
        assertEquals("Fulano", pessoaAtualizada.getNome());
        assertEquals("12345678900", pessoaAtualizada.getCpf());
    }

    @Test
    public void testDeletar() {
        Long id = 1L;
        doNothing().when(pessoaRepository).deleteById(id);
        pessoaService.deletar(id);
        verify(pessoaRepository, times(1)).deleteById(id);
    }

    @Test
    public void testBuscarPorCpf() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fulano");
        pessoa.setCpf("12345678900");

        when(pessoaRepository.findByCpf("12345678900")).thenReturn(Optional.of(pessoa));

        Pessoa pessoaEncontrada = pessoaService.buscarPorCpf("12345678900");
        assertNotNull(pessoaEncontrada);
        assertEquals("Fulano", pessoaEncontrada.getNome());
        assertEquals("12345678900", pessoaEncontrada.getCpf());
    }
}
