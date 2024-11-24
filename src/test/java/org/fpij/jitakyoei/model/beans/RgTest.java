package org.fpij.jitakyoei.model.beans;

import org.junit.Test;

import static org.junit.Assert.*;

public class RgTest {
    @Test
    public void entidadeEqualsAndHashCodeWorkCorrectly() {
        Rg rg1 = new Rg("12345678", "SSP");
        Rg rg2 = new Rg("12345678", "SSP");

        assertTrue(rg1.equals(rg2));
        assertEquals(rg1.hashCode(), rg2.hashCode());

        rg2.setNumero("87654321");
        assertFalse(rg1.equals(rg2));
        assertNotEquals(rg1.hashCode(), rg2.hashCode());
    }

    @Test
    public void rgShouldHaveNumeroWithOnlyNumbers() {
        Rg rg = new Rg();
        rg.setNumero("12.345.678-9");
        assertTrue(rg.getNumero().matches("\\d{2}\\.?\\d{3}\\.?\\d{3}-?\\d"));

        rg.setNumero("12.345.678-A");
        assertTrue(rg.getNumero().matches("\\d{2}\\.?\\d{3}\\.?\\d{3}-?\\d"));
    }

    @Test
    public void rgShouldHaveOrgaoExpeditorOnlyWithLetters() {
        Rg rg = new Rg();
        rg.setOrgaoExpedidor("SSP");
        assertTrue(rg.getOrgaoExpedidor().matches("[a-zA-Z]+"));

        rg.setOrgaoExpedidor("SSP1");
        assertTrue(rg.getOrgaoExpedidor().matches("[a-zA-Z]+"));
    }
}
