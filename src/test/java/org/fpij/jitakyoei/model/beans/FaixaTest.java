package org.fpij.jitakyoei.model.beans;

import org.fpij.jitakyoei.util.CorFaixa;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;
public class FaixaTest {

    public static Date testDate =  new Date("2021/10/01"); // Date: 2021-10-01

    @Test
    public void faixaToStringFormatsCorrectly() {
        Faixa faixa = new Faixa(CorFaixa.BRANCA, testDate);
        String expected = "Branca - Fri Oct 01 00:00:00 BRT 2021";
        assertEquals(expected, faixa.toString());
    }

    @Test
    public void faixaHandlesDifferentCorFaixaAndDataEntregaValues() {
        Faixa faixa = new Faixa();
        faixa.setCor(CorFaixa.AZUL);
        faixa.setDataEntrega(testDate);
        assertEquals(CorFaixa.AZUL, faixa.getCor());
        assertEquals(testDate, faixa.getDataEntrega());

        faixa.setCor(CorFaixa.VERDE);
        faixa.setDataEntrega(new Date("2022/10/01")); // Date: 2022-10-01
        assertEquals(CorFaixa.VERDE, faixa.getCor());
        assertEquals(new Date("2022/10/01"), faixa.getDataEntrega());
    }
}
