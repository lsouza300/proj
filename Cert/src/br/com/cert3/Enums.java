package br.com.cert3;

public class Enums {

	
	public static void main(String[] args) {
		Teste t = Teste.A;
		// pontos eh visivel porque enum esta declarado dentro da classe
		// se fosse declarado fora da classe, nao seria visivel
		System.out.println(t.pontos);
		
		System.out.println("Pontos: ");
		for (Teste t1 : Teste.values()){
			System.out.println(t1 + ": " + t1.pontos);
		}
		
		System.out.println("Opcao: ");
		for (Teste t1 : Teste.values()){
			System.out.println(t1 + ": " + t1.getOpcao());
		}
	}
	
	public enum Teste{
		A(1), B(2) { public int getOpcao() { return 3; } }, C(3);
		
		private int pontos;
		
		Teste(int v){
			this.pontos = v;
		}
		
		public int getOpcao(){
			return 4;
		}
	}
}

