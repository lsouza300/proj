package br.com.cert5;

import java.io.IOException;
import java.text.ParseException;

/**
 * Por default, assert eh desabilitado
 * Para habilitar eh necessario passar para execucao o argumento
 * -ea ou -enableassertions
 * 
 * Para ser executado pelo Eclipse, basta ir em 
 * Run Configuration -> VM arguments
 * e adicionar -ea ou -enableassertions
 * 
 * @author leandro.asouza
 *
 */
public class Assertivas {
	
	/*
	 * A partir de Java 1.4, assert tornou-se palavra-chave portanto nao pode ser 
	 * utilizado como nome de var, method, etc como foi inserido logo abaixo
	 * int assert = 2;
	 */
	
	
	/**
	 * O uso ADEQUADO de assert eh que sejam utilizados somente em metodos private
	 * Pois um metodo publico que eh chamado de forma "externa" a propria classe
	 * pode ser que nao tenha o conhecimento necessario sobre os argumentos corretos
	 * para serem enviados corretamente.
	 * 
	 * No caso de metodos publicos, deve haver um lancamento de excecao do tipo
	 * IllegalArgumentException conforme metodo go2
	 * @param a
	 */
	private void go(int a){
		assert (a > 3) : "A não é maior que 3. Interrupcao via assert.";
		
		System.out.println("Como 'a' estah ok, a execucao chega ate aqui em go().");
	}
	
	public void go2(int a) throws IllegalArgumentException{
		if (a <= 3){
			throw new IllegalArgumentException("Var com valor incorreto");
		}
		System.out.println("Como 'a' estah ok, a execucao chega ate aqui em go2().");
		
		/*
		 * Caso seja declarado a condicao abaixo lancando ParseException por exemplo, que eh
		 * descendente de java.lang.Exception, neste caso seria OBRIGATORIO a utilizacao de 
		 * throws ParseException e tambem de try/catch ou a propagacao com throws nos metodos
		 * que chamam go2(int)
		 * 
		 * Para realizar um teste basta decomentar o bloco de codigo logo abaixo
		 */
		/*int b = 1;
		if (b == 1){
			throw new ParseException("Numero incorreto", 1);
		}*/
	}
	
	/**
	 * Este metodo nao estah sendo utilizado
	 * Serve apenas para lembrar que, mesmo ccom a declaracao 'throws IllegalArgumentException' 
	 * no metodo go2(), nao eh necessario declarar try/catch nem propagar a Exception, devido
	 * a IllegalArgumentException SER DESCENDENTE de RuntimeException
	 * 
	 */
	public void testaGo2(){
		go2(2);
	}
	
	public static void main(String[] args) {
		Assertivas a = new Assertivas();
		a.go(4);
		a.go2(2);
	}
	
	
	/**
	 * O que pode vir apos assert?
	 */
	
	void aposAssert(){
		int x = 4;
		int y = 1;
		assert(x > 3): "";
		assert(x > 3): new Integer("5");
		assert(x > 3): metodoQualquer();
		assert(x > 3): y = 2;
		
		// invalido
		// assert(x > 3): int yy = 2;
	}
	
	Object metodoQualquer() { return new Object(); }
}
