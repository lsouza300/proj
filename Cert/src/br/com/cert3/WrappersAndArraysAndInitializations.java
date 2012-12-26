package br.com.cert3;

import java.util.ArrayList;
import java.util.List;

public class WrappersAndArraysAndInitializations {

	/*
	 * Ordem de chamada de métodos:
	 * 
	 * Ampliação (Java 4 já existia)
	 * Autoboxing (int para Integer, etc)
	 * Var-args ("última saída")
	 * 
	 * Se tipo primitivo: 
	 * 	1. Tenta correpondencia direta
	 *  2. Tenta ampliar.
	 *  3. Tenta boxing (lembrar que neste caso, pode ir de um primitivo para um Boxing (int -> para Integer) e "casar" com Object
	 *  4. Tenta o var-args
	 *   
	 * Se Wrapper: 
	 * 1. Tenta correpondencia direta
	 * 2. Tenta ampliar via hierarquia de objetos (lembrar que um Wrapper eh um Object)
	 * 3. Tenta o unboxing (ex.: se for Short, ira executar (valor).shortValue() e tentar achar um correpondente short primitivo
	 * 4. Tenta o var-args
	 * 
	 * xxxValue (Wrapper para primitive)
	 * parseXXX (String para primitive)
	 * "Wrapper".valueOf(String) (String para Wrapper - lembra que é quase equivalente a dar "new Wrapper("34")" passando string e retornando o new Wrapper).
	 * 
	 */
	
	void testeArg(short x){
		System.out.println("short x");
	}
	void testeArg(Long x){
		System.out.println("Long x");
	}
	void testeArg(short... x){
		System.out.println("short... x");
	}
	void testeArg(Float a){
		System.out.println("Float a");
	}
	/*void testeArg(Object a){
		System.out.println("Object a");
	}*/
	
	static void executaTesteArgumentos(){
		WrappersAndArraysAndInitializations w = new WrappersAndArraysAndInitializations();
		
		/*int s1 = 22;
		w.testeArg(s1);*/

		Short s2 = 22;
		w.testeArg(s2);
		
		Byte s3 = 22;
		w.testeArg(s3);
		
		/*double s4 = 4.5;
		w.testeArg(s4);*/
		
		float s5 = 4.5F;
		w.testeArg(s5);
		
		// w.testeArg(3);
	}
	
	static void executaTesteParsers(){
		int x = 3;
		Integer inT = Integer.valueOf(x);
		
		// obtendo primitivos
		int i = inT.intValue();
		float f = inT.floatValue();
		double d = inT.doubleValue();
		
		// obtendo primitivos a partir de strings
		int x1 = Integer.parseInt("3");
		float f1 = Float.parseFloat("3.14");
		
		// 4
		Integer a = Integer.valueOf("0100", 2);
		//System.out.println(a);
		
		// 14
		Integer a2 = Integer.valueOf("A4", 16);
		System.out.println("valor: '" + a2 + "'");
	}
	
	static void comparingWrappersAndPrimitives(){
		Integer x = 2;
		Integer y = 2;
		Long l = Long.valueOf(2);
		l = new Long("2");
		System.out.println(x == y);
		System.out.println(x != y);
		System.out.println(x.equals(y));
		
		Boolean a = true;
		if (a){
			System.out.println("Boxing no boolean");
		}
	}
	
	static void testesInicializacao(){
		
		// anonymous array - it isn´t needed specify the size
		int[]a = new int[]{1,2,3,1,2};
		
		// serao inicializados com 0
		int b[] = new int[4];
		
		System.out.println(b[0]);
	}
	
	static void tamanhos(){
		
		// method size() for lists
		List<Integer> l = new ArrayList<Integer>();
		System.out.println(l.size());
		
		// attr lenght for array
		Integer[] list = new Integer[5];
		System.out.println(list.length);
		
	}
	
	static void referenciaArrays(){
		int[] a = {1,2,3};
		int[] b = a;
		b[0] = 0;
		for (int x : a){
			System.out.println("a => " + x);
		}
	}
	
	public static void main(String[] args) {
		executaTesteArgumentos();
	}
}
