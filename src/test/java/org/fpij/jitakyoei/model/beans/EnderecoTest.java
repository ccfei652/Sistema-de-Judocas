package org.fpij.jitakyoei.model.beans;

import org.junit.Test;

import static org.junit.Assert.*;

public class EnderecoTest {

    @Test
    public void enderecoToStringFormatsCorrectly() {
        Endereco endereco = new Endereco();
        endereco.setRua("Rua dos Pinheiros");
        endereco.setNumero("476");
        endereco.setBairro("Pinheiros");
        endereco.setCidade("São Paulo");
        endereco.setEstado("SP");
        endereco.setCep("05422-001");

        String expected = "\nRua: Rua dos Pinheiros" +
            "\nNumero: 476" +
            "\nBairro: Pinheiros" +
            "\nCidade: São Paulo" +
            "\nEstado: SP" +
            "\nCep: 05422-001";
        assertEquals(expected, endereco.toString());
    }

    @Test
    public void enderecoShouldHaveCEPWithOnlyNumbers() {
        Endereco endereco = new Endereco();
        endereco.setCep("05422-P01");
        assertTrue(endereco.getCep().matches("\\d{5}-?\\d{3}"));
    }

    @Test
    public void enderecoShouldHaveNumeroWithOnlyNumbers() {
        Endereco endereco = new Endereco();
        endereco.setNumero("476P");
        assertTrue(endereco.getNumero().matches("\\d+"));
    }
}