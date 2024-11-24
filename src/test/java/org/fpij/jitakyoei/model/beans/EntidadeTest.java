package org.fpij.jitakyoei.model.beans;

import org.junit.Test;

import static org.junit.Assert.*;

public class EntidadeTest {

    @Test
    public void entidadeToStringReturnsNome() {
        Entidade entidade = new Entidade();
        entidade.setNome("Academia 1");
        assertEquals("Academia 1", entidade.toString());
    }

    @Test
    public void entidadeEqualsAndHashCodeWorkCorrectly() {
        Entidade entidade1 = new Entidade();
        entidade1.setNome("Academia 1");

        Entidade entidade2 = new Entidade();
        entidade2.setNome("Academia 1");

        assertTrue(entidade1.equals(entidade2));
        assertEquals(entidade1.hashCode(), entidade2.hashCode());

        entidade2.setNome("Academia 2");
        assertFalse(entidade1.equals(entidade2));
        assertNotEquals(entidade1.hashCode(), entidade2.hashCode());
    }

    @Test
    public void entidadeCopyPropertiesCopiesAllFields() {
        Entidade entidade1 = new Entidade();
        entidade1.setNome("Academia 1");
        entidade1.setCnpj("12345678901234");
        entidade1.setTelefone1("(11)1234-5678");
        entidade1.setTelefone2("(11)9876-5678");
        Endereco endereco = new Endereco();
        endereco.setRua("Rua A");
        endereco.setNumero("123");
        endereco.setBairro("Bairro 1");
        endereco.setCidade("Cidade 1");
        endereco.setEstado("Estado 1");
        endereco.setCep("12345-678");
        entidade1.setEndereco(endereco);

        Entidade entidade2 = new Entidade();
        entidade2.copyProperties(entidade1);

        assertEquals(entidade1.getNome(), entidade2.getNome());
        assertEquals(entidade1.getCnpj(), entidade2.getCnpj());
        assertEquals(entidade1.getTelefone1(), entidade2.getTelefone1());
        assertEquals(entidade1.getTelefone2(), entidade2.getTelefone2());
        assertEquals(entidade1.getEndereco(), entidade2.getEndereco());
    }
}