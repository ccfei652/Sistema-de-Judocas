package org.fpij.jitakyoei.model.beans;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProfessorTest {

    @Test
    public void professorToStringReturnsFiliadoNome() {
        Professor professor = new Professor();
        Filiado filiado = new Filiado();
        filiado.setNome("Professor A");
        professor.setFiliado(filiado);
        assertEquals("Professor A", professor.toString());
    }

    @Test
    public void professorShouldAddEntidadeToList(){
        Professor professor = new Professor();

        Entidade entidade = new Entidade();
        entidade.setNome("Academia 2");
        entidade.setTelefone1("(011)1234-5432");

        professor.getEntidades().add(entidade);

        assertEquals(1, professor.getEntidades().size());
    }

}
