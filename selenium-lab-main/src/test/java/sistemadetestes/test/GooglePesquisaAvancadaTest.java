package sistemadetestes.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import sistemadetestes.pageObject.GooglePO;

/**
 * Classe de teste para pesquisas avançadas no Google
 */
public class GooglePesquisaAvancadaTest extends BaseTest {

    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes() {
        driver.get("https://www.google.com");
        googlePage = new GooglePO(driver);
    }

    @Test
    public void devePesquisarComTermoExato() {
        googlePage.pesquisar("\"teste de software\"");

        String resultado = googlePage.obterResultadoDaPesquisa();
        assertTrue(resultado, resultado.contains("resultados"));
    }

    @Test
    public void devePesquisarExcluindoTermos() {
        googlePage.pesquisar("receita de bolo -laranja");

        String resultado = googlePage.obterResultadoDaPesquisa();
        assertTrue(resultado, resultado.contains("resultados"));
    }
}