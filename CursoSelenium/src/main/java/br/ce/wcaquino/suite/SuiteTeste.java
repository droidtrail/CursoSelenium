package br.ce.wcaquino.suite;
import static br.ce.wcaquino.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.test.TesteCadastro;
import br.ce.wcaquino.test.TesteCampoTreinamento;
import br.ce.wcaquino.test.TesteRegrasCadastro;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastro.class,
	TesteRegrasCadastro.class	
})
public class SuiteTeste {

	@AfterClass
	public static void finalizatudo() {	
		killDriver();	
	}
}
