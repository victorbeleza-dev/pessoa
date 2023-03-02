package br.com.pessoa.controller;

import br.com.pessoa.model.Pessoa;
import br.com.pessoa.service.PessoaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@RunWith(MockitoJUnitRunner.class)
public class PessoaControllerTest {

    @Mock
    private PessoaService pessoaService;

    @InjectMocks
    private PessoaController pessoaController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = standaloneSetup(pessoaController).build();
    }

    @Test
    public void testListar() throws Exception {
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

        when(pessoaService.listar()).thenReturn(pessoas);

        mockMvc.perform(get("/pessoas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nome", is("Fulano")))
                .andExpect(jsonPath("$[0].cpf", is("12345678900")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].nome", is("Beltrano")))
                .andExpect(jsonPath("$[1].cpf", is("98765432100")));

        verify(pessoaService, times(1)).listar();
    }

    @Test
    public void testBuscarPorCpf() throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Fulano");
        pessoa.setCpf("12345678900");

        when(pessoaService.buscarPorCpf("12345678900")).thenReturn(pessoa);

        mockMvc.perform(get("/pessoas/12345678900"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Fulano")))
                .andExpect(jsonPath("$.cpf", is("12345678900")));
    }

    @Test
    public void testCadastrar() throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Fulano");
        pessoa.setCpf("12345678900");

        when(pessoaService.cadastrar(any(Pessoa.class))).thenReturn(pessoa);

        mockMvc.perform(post("/pessoas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\": \"Fulano\", \"cpf\": \"12345678900\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Fulano")))
                .andExpect(jsonPath("$.cpf", is("12345678900")));

        verify(pessoaService, times(1)).cadastrar(any(Pessoa.class));
    }

    @Test
    public void testAtualizarPessoa() throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Fulano");
        pessoa.setCpf("12345678900");

        String json = "{ \"nome\": \"Beltrano\", \"cpf\": \"98765432100\" }";

        when(pessoaService.atualizar(eq(1L), any(Pessoa.class))).thenReturn(pessoa);

        mockMvc.perform(put("/pessoas/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Fulano")))
                .andExpect(jsonPath("$.cpf", is("12345678900")));

        verify(pessoaService, times(1)).atualizar(eq(1L), any(Pessoa.class));
    }
}