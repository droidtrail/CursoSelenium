import static br.ce.wcaquino.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;

public class TesteAjax {
	
	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa(){
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		//driver.quit();
	}
	
	@Test
	public void testAjax(){
		dsl.escrever("j_idt638:name", "Deu Certo?");
		dsl.clicarBotao("j_idt638:j_idt641");
		WebDriverWait wait = new WebDriverWait(getDriver(),30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_idt638:j_idt641")));
		//wait.until(ExpectedConditions.textToBe(By.id("j_idt638:j_idt641"), "t"));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt98")));
		Assert.assertEquals("Deu Certo?", dsl.obterTexto("j_idt638:display"));
	}

}
