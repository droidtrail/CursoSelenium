import static br.ce.wcaquino.core.DriverFactory.getDriver;

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

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;

public class TesteSincronismo {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {
		
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		getDriver().manage().window().setSize(new Dimension(1200, 765));
		dsl = new DSL();
	}

	@After
	public void finaliza() {
		//getDriver().quit();
	}

	@Test
	public void deveUtilizarEsperaImplicita() {
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dsl.clicarBotao("buttonDelay");
		dsl.escrever("novoCampo", "Leandro");
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
//	@Test
//	public void deveInteragirComRespostaDemorada() {
//		
//		dsl.clicarBotao("buttonDelay");
//		dsl.escrever("novoCampo", "Leandro");
//	}
	@Test
	public void deveUtilizarEsperaExplicita() {
		dsl.clicarBotao("buttonDelay");
		WebDriverWait wait = new WebDriverWait(getDriver(),30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		dsl.escrever("novoCampo", "Leandro");
	}

}
