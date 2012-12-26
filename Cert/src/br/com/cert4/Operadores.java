package br.com.cert4;

public class Operadores {

	int index = 0;
	
	void prePosIncremento(){
		int[][] a = new int[][]{ {2,5}, {7,9} };
		
		System.out.println("valor: " + a[index++][index++]);
		System.out.println("index: " + index);
	}
	
	public static void main(String[] args) {
		new Operadores().prePosIncremento();
	}
}
