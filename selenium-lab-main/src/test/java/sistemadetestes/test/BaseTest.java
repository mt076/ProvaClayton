package sistemadetestes.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

	protected static WebDriver driver;
	private static final String PATH_DRIVE = "src/test/resources/chromedriver";
	private static final String URL_LOGIN = "file:///home/esc/eclipse-workspace/selenium-lab/sistema/login.html";
	private static final String URL_PRODUTOS = "file:///home/esc/eclipse-workspace/selenium-lab/sistema/produtos.html";

	@BeforeClass
	public static void iniciar() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL_LOGIN);
	}

	@AfterClass
	public static void finalizar() {
		driver.quit();
	}
}