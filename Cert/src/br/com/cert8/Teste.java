package br.com.cert8;

public class Teste {
	static class Abc{
		public int e = 1;
	}
	
	void go(){
		Abc a = new Abc();
		System.out.println(a.e);
	}
	
	public static void main(String[] args) {
		new Teste().go();
	}
	
}

