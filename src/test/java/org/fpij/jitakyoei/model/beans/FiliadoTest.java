package org.fpij.jitakyoei.model.beans;

import org.fpij.jitakyoei.util.CorFaixa;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;


public class FiliadoTest {

    public static Endereco enderecoTest;

    public static ArrayList<Faixa> faixas;

    public static Date testDate =  new Date("2021/10/01"); // Date: 2021-10-01


    public static Filiado filiadoTest;

    @Before
    public void setUp() {
        enderecoTest = new Endereco();
        enderecoTest.setRua("Rua A");
        enderecoTest.setNumero("123");
        enderecoTest.setBairro("Bairro 1");
        enderecoTest.setCidade("Cidade 1");
        enderecoTest.setEstado("Estado 1");
        enderecoTest.setCep("12345-678");

        filiadoTest = new Filiado();
        filiadoTest.setNome("João");
        filiadoTest.setCpf("123.456.789-00");
        filiadoTest.setRegistroCbj("12345");
        filiadoTest.setDataNascimento(new Date("1999/10/10"));
        filiadoTest.setDataCadastro(new Date());
        filiadoTest.setEmail("joao@example.com");
        filiadoTest.setEndereco(enderecoTest);

        faixas = new ArrayList<>();
        faixas.add(new Faixa(CorFaixa.BRANCA, testDate));
        faixas.add(new Faixa(CorFaixa.LARANJA, testDate));

        filiadoTest.setFaixas(faixas);
    }

    @Test
    public void filiadoToStringFormatsCorrectly() {
        String expected = "Nome: João\nRegistroCbj: 12345\nDataNasc: Sun Oct 10 00:00:00 BRST 1999\nE-mail: joao@example.com\nCPF: 123.456.789-00";
        assertEquals(expected, filiadoTest.toString());
    }

    @Test
    public void filiadoEqualsAndHashCodeWorkCorrectly() {
        Filiado filiado1 = new Filiado();
        filiado1.setNome("João");

        Filiado filiado2 = new Filiado();
        filiado2.setNome("João");

        assertTrue(filiado1.equals(filiado2));
        assertEquals(filiado1.hashCode(), filiado2.hashCode());

        filiado2.setNome("Maria");
        assertFalse(filiado1.equals(filiado2));
        assertNotEquals(filiado1.hashCode(), filiado2.hashCode());
    }

    @Test
    public void filiadoShouldHaveCPFWithOnlyNumbers() {
       Filiado filiado = new Filiado();
       filiado.setCpf("123.456.789-00");
       assertTrue(filiado.getCpf().matches("\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}"));

       filiado.setCpf("12345678900");
       assertTrue(filiado.getCpf().matches("\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}"));

        filiado.setCpf("123456789P0");
        assertTrue(filiado.getCpf().matches("\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}"));
    }

    @Test
    public void filiadoShouldReturnListOfFaixas() {
        Filiado filiado = new Filiado();
        filiado.setFaixas(faixas);
        assertEquals(faixas, filiado.getFaixas());
    }

    @Test
    public void filiadoShouldAddFaixaToList() {
        faixas.add(new Faixa(CorFaixa.MARROM, new Date()));
        filiadoTest.setFaixas(faixas);
        assertEquals(faixas, filiadoTest.getFaixas());
    }

    @Test
    public void filiadoCopyPropertiesCopiesAllFields() {
        Filiado filiado = new Filiado();
        filiado.copyProperties(filiadoTest);

        assertEquals(filiadoTest.getNome(), filiado.getNome());
        assertEquals(filiadoTest.getCpf(), filiado.getCpf());
        assertEquals(filiadoTest.getRegistroCbj(), filiado.getRegistroCbj());
        assertEquals(filiadoTest.getDataNascimento(), filiado.getDataNascimento());
        assertEquals(filiadoTest.getDataCadastro(), filiado.getDataCadastro());
        assertEquals(filiadoTest.getEmail(), filiado.getEmail());
        assertEquals(filiadoTest.getEndereco(), filiado.getEndereco());
        assertEquals(filiadoTest.getFaixas(), filiado.getFaixas());
    }
}
