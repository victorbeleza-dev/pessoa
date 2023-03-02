package br.com.pessoa.repository;

import br.com.pessoa.model.Pessoa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PessoaRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    public void testFindByCpf() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fulano");
        pessoa.setCpf("12345678900");
        entityManager.persist(pessoa);
        entityManager.flush();

        Optional<Pessoa> pessoaEncontrada = pessoaRepository.findByCpf(pessoa.getCpf());
        assertTrue(pessoaEncontrada.isPresent());
        assertEquals("Fulano", pessoaEncontrada.get().getNome());
        assertEquals("12345678900", pessoaEncontrada.get().getCpf());
    }
}

