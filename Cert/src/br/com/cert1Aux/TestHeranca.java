package br.com.cert1Aux;

import br.com.cert1.Heranca;

public class TestHeranca extends Heranca {

	Heranca h2 = new Heranca();
	
	void teste(){
		// not visible (pacote diferente)
		// h2.a = 4;
		
		// not visible (mesmo sendo protected, so pode ser acessado via heranca e nao instancia da classe)
		// h2.b = 5;
		
		// correto
		this.b = 6;
		
		// not visible (default diferente de protected)
		// this.a = 3;
	}
	
	Object teste2(){
		int a [] = {3,4,5};
		int b = 3;
		return b;
	}
}
