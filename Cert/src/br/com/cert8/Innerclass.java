package br.com.cert8;

import br.com.cert8.Teste.Abc;

abstract public class Innerclass {

	static class A { public void asd() {System.out.println("A");} }
	
	static class B extends A { public void asd() {System.out.println("B:A");} }
	
	static class C extends B { public void asd() { System.out.println("C:B"); } }
	
	public static void main(String[] args) {
		A a = new C();
		a.asd();
		Abc abc = new Teste.Abc();
		Abc abc2 = new Abc();
	}
	
	public int a = 0;
	
	{ a = 4; }
}
