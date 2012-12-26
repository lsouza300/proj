package br.com.cert8;

import br.com.cert1.InicializacaoVarAndArrays;

public class Innerclass2 {

	static int s = 4;
	private int a;
	private final int b = 9;
	final int e;
	
	public Innerclass2() {
		e = 2;
	}
	
	public Innerclass2(int abc){
		e = a;
	}
	
	void method(){
		int x = b;
	}
	
	class A extends InicializacaoVarAndArrays{
		
		public void teste(){
			
			// acesso a var de instance de extends
			ab = 1;
			
			// acesso a var de instance de outer class
			a = 5;
			
			// acesso (leitura) a var final
			int d = b;
			
			// acesso a var static
			s = 15;
		}
	}
}
