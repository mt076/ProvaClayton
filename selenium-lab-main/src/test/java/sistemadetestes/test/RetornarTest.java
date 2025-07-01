package sistemadetestes.test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import sistemadetestes.pageObject.LoginPO;
import sistemadetestes.pageObject.MenuPO;


/**
 * Testa a funcionalidade de logout do sistema
 */
public class RetornarTest extends BaseTest {

    @Test
    public void deveRealizarLogoutComSucesso() {
        // Realiza login primeiro
        LoginPO loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        // Realiza logout
        MenuPO menuPage = new MenuPO(driver);
        menuPage.botaoLogout.click();

        // Verifica se voltou para a página de login
        String urlAtual = driver.getCurrentUrl();
        assertTrue("Botão voltar não retornou para a página de login",
                urlAtual.contains("login.html"));
    }
}