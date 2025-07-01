package sistemadetestes.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO {

    @FindBy(id = "btn-adicionar")
    public WebElement buttonAdicionar;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(css = "div.alert>span")
    public WebElement spanMensagem;

    @FindBy(id = "data-validade")
    public WebElement inputDataValidade;

    public ProdutoPO(WebDriver driver) {
        super(driver);
    }

    public void abrirFormulario() {
        buttonAdicionar.click();
    }

    public void cadastrarProduto(String nome, String valor, String codigo, String quantidade) {
        escrever(inputNome, nome);
        escrever(inputValor, valor);
        escrever(inputCodigo, codigo);
        escrever(inputQuantidade, quantidade);
        buttonSalvar.click();
    }

    public String obterMensagem() {
        return spanMensagem.getText();
    }

    private void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto);
    }
}
