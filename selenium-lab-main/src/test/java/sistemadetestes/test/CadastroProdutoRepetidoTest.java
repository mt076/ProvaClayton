package sistemadetestes.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import sistemadetestes.pageObject.LoginPO;
import sistemadetestes.pageObject.ProdutoPO;

public class CadastroProdutoRepetidoTest extends BaseTest {

    private static ProdutoPO produtoPage;
    private static LoginPO loginPage;
    private static final String CODIGO_REPETIDO = "PROD123";

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
        produtoPage = new ProdutoPO(driver);

        // 1. Realizar login
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        driver.get("http://127.0.0.1:5500/produtos.html");

        // 2. Cadastrar produto inicial com código que será repetido
        produtoPage.abrirFormulario();
        produtoPage.cadastrarProduto("Produto Inicial", "100", CODIGO_REPETIDO, "5");
    }

    @Test
    public void deveImpedirCadastroProdutoComCodigoRepetido() {
        // 3. Tentar cadastrar produto com mesmo código
        produtoPage.abrirFormulario();
        produtoPage.cadastrarProduto("Novo Produto", "200", CODIGO_REPETIDO, "10");

        // 4. Verificar mensagem de erro
        String mensagem = produtoPage.obterMensagem();
        assertEquals("Mensagem de código repetido incorreta",
                "Código de produto já existe no sistema", mensagem);
    }
}