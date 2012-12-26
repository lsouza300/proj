package br.com.cert3;

/*
 * Regra 1:
 * todos os blocos static na arvore da heranca sao executados primeiro
 * 
 * Regra 2: os blocos de instancia sao executados imediatamente depois do construtor pai ser chamado
 * (apos super() ser chamado dentro do construtor)
 */
public class BlocosInicializacao {

	public BlocosInicializacao(){
		System.out.println("constructor of BlocosInicializacao");
	}
	
	static {
		System.out.println("Static of BlocosInicializacao");
	}
	
	{
		System.out.println("instance of BlocosInicializacao");
	}
}

class A extends BlocosInicializacao{
	
	public A(){
		System.out.println("constructor of A");
	}
	
	static {
		System.out.println("Static of A");
	}
	
	{
		System.out.println("instance of A");
	}
}

class B extends A{
	
	public B(){
		System.out.println("constructor of B");
	}
	
	static {
		System.out.println("Static of B");
	}
	
	{
		System.out.println("instance of B");
	}
	
	public static void main(String[] args) {
		new B();
	}
}