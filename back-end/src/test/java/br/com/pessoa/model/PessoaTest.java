package br.com.pessoa.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaTest {

    @Test
    public void testGetterSetter() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Fulano");
        pessoa.setCpf("12345678900");

        assertEquals(Long.valueOf(1), pessoa.getId());
        assertEquals("Fulano", pessoa.getNome());
        assertEquals("12345678900", pessoa.getCpf());
    }
}
