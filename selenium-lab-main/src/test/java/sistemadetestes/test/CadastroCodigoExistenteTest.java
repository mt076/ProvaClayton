package sistemadetestes.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import sistemadetestes.pageObject.LoginPO;
import sistemadetestes.pageObject.ProdutoPO;

/**
 * Teste para verificar o comportamento do sistema ao tentar cadastrar
 * um produto com código já existente
 */
public class CadastroCodigoExistenteTest extends BaseTest {

    private static ProdutoPO produtoPage;
    private static LoginPO loginPage;
    private static final String CODIGO_EXISTENTE = "PROD001";

    @BeforeClass
    public static void prepararTestes() {
        // Inicializa as Page Objects
        loginPage = new LoginPO(driver);
        produtoPage = new ProdutoPO(driver);

        // Realiza login no sistema
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        // Navega para a página de produtos
        driver.get("file:///home/esc/eclipse-workspace/selenium-lab/sistema/produtos.html");

        // Cadastra um produto inicial com o código que será repetido
        produtoPage.abrirFormulario();
        produtoPage.cadastrarProduto(
                "Produto Original",  // nome
                "100.00",           // valor
                CODIGO_EXISTENTE,   // código
                "10"                // quantidade
        );
    }

    @Test
    public void deveImpedirCadastroComCodigoExistente() {
        // 1. Abre o formulário de cadastro
        produtoPage.abrirFormulario();

        // 2. Tenta cadastrar novo produto com código existente
        produtoPage.cadastrarProduto(
                "Novo Produto",     // nome
                "200.00",           // valor
                CODIGO_EXISTENTE,   // mesmo código
                "5"                 // quantidade
        );

        // 3. Obtém a mensagem do sistema
        String mensagem = produtoPage.obterMensagem();

        // 4. Verifica se a mensagem é a esperada
        assertEquals("O sistema deve impedir cadastro com código repetido",
                "Código já cadastrado no sistema", mensagem);
    }
}