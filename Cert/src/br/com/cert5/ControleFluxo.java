package br.com.cert5;

public class ControleFluxo {

	/*
	 * switch pode avaliar: byte, short, int, char, e a partir de Java 5, ENUM
	 */
	static void testeSwitch(){
		int a = 4;

		switch(a){
			default: System.out.println("Nenhum");
			case 1: System.out.println("1"); break;
			case 2: System.out.println("2"); break;
			case 3: System.out.println("3"); break;

		}
		switch(a){
			case 1: System.out.println("1"); break;
			default: System.out.println("Nenhum");
			case 2: System.out.println("2"); break;
			case 3: System.out.println("3"); break;
		}
		switch(a){
			case 1: System.out.println("1"); break;
			case 2: System.out.println("2"); break;
			case 3: System.out.println("3"); break;
			default: System.out.println("Nenhum");
		}
		
		
		/*
		 * alguns casos invalidos
		 */
		byte b = 1;
		switch(b) {
			case 1:
			case 2:
			case 3: System.out.println("b vale 3");
			
			// nao incluir case esta incorreto
			// 4: System.out.println("caso 4");
			
			// colocar chaves ao inves dos dois pontos, esta incorreto
			/*case 4 {
				int j = 1;
			}*/
			
			// porem lembrar do caso abaixo (valido) - apos os dois pontos, ter as chaves separando
			case 10: {System.out.println("oi");}
				
			// muito grande para ser byte
			// Type mismatch: cannot convert from int to byte
			//case 128:
		}
	}
		
	

	static void testeSwitchComEnum(){
		
		Cor c = Cor.amarelo;
		
		switch(c){
			case verde: System.out.println("verde"); break;
			case amarelo: System.out.println("amarelo");
			case vermelho: System.out.println("vermelho"); break;
		}
		
		/*
		 * no case acima nao eh possivel colocar Cor.amarelo
		 * apenas amarelo, verde, ... eh permitido
		 * diferentemente do if, que aceita Cor.algumaCor e rejeita (c == amarelo)
		 * mesmo se o enum for declarado dentro ou fora da classe atual
		 */
		if (c == Cor.amarelo){
			System.out.println("amarelo");
		}
	}
	
	/**
	 * Testa alguns "for" que a principio sao estranhos em sua declaracao  
	 */
	static void forEstranhos(){
		int x = 0;
		for (;x < 10;){
			System.out.println("x = " + x);
			x++;
		}
		
		for (int a = 1; a < 10; a++);
		
		// atua como loop infinito - compila e executa normalmente
		/*for (; ;){
			
		}*/
		
		// tomar cuidado com codigos de for que tentam redefinir uma var
		// nao eh possivel - erro de compilacao
		/*for (int x=0; x<2; x++){
			
		}*/
		
		// loop for aprimorado
		int[] a = new int[]{1,3,5,7,9};
		
		for (int y : a){
			
			// instrucao continue: faz com que a iteracao atual seja interrompida e o
			// programa pula para a proxima iteracao
			if (y == 5){
				continue;
			}
			System.out.println("for aprim: y = " + y);
		}
		
	}
	
	static void whilesRotulados(){
		bloco1: 
			for (int i = 1; i < 10; i=i+2){
				
				System.out.println("dentro do bloco 1 ... i = " + i);
				
				bloco2:
					for (int x = 2; x < 10; x = x+2){
						System.out.println("dentro do bloco 2 ... x = " + x);
						if (x == 4){
							break bloco2;
						}
					}
			}
	}

	public static void main(String[] args) {
		testeSwitch();
		testeSwitchComEnum();
		forEstranhos();
		whilesRotulados();
	}
}

enum Cor { verde, azul, vermelho, amarelo };
