import static br.ce.wcaquino.core.DriverFactory.getDriver;
import static br.ce.wcaquino.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.wcaquino.core.DSL;

public class TestePrime {
	private DSL dsl;

	@Before
	public void inicializa() {
		
		dsl = new DSL();
	}

	@After
	public void finaliza() {
		killDriver();
	}

	@Test
	public void deveInteragirComRadioPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		//Xbox One
		dsl.clicarRadio(By.xpath(".//input[@id='j_idt639:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt639:console:0"));
		//PS4
		dsl.clicarRadio(By.xpath("//label[.='PS4']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt639:console:1"));
	}
	@Test
	public void deveInteragirComSelectPrime(){
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt639:console", "PS4");
		Assert.assertEquals("PS4", dsl.obterTexto("j_idt639:console_label"));

	}
	
}









