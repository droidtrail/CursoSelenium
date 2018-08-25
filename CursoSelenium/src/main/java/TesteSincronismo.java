import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteSincronismo {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "e:\\GeckoDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().setSize(new Dimension(1200, 765));
		dsl = new DSL(driver);
	}

	@After
	public void finaliza() {
		//driver.quit();
	}

	@Test
	public void deveUtilizarEsperaImplicita() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dsl.clicarBotao("buttonDelay");
		dsl.escrever("novoCampo", "Leandro");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	@Test
	public void deveInteragirComRespostaDemorada() {
		
		dsl.clicarBotao("buttonDelay");
		dsl.escrever("novoCampo", "Leandro");
	}
	@Test
	public void deveUtilizarEsperaExplicita() {
		dsl.clicarBotao("buttonDelay");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		dsl.escrever("novoCampo", "Leandro");
	}

}
