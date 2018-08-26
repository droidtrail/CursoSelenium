package br.ce.wcaquino.core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = false;
	
	public static Browsers browser = Browsers.INTERNETEXPLORER;
	
	public enum Browsers{
		CHROME,
		FIREFOX,
		SAFARI,
		EDGE,
		INTERNETEXPLORER
	}
}
