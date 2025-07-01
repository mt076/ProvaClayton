package sistemadetestes.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPO extends BasePO {

    @FindBy(id = "btn-logout")
    public WebElement botaoLogout;

    public MenuPO(WebDriver driver) {
        super(driver);
    }
}