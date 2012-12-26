package br.com.cert9;

public class ContaBancaria {

	private int saldo = 500;
	
	public int getSaldo(){
		return saldo;
	}
	
	public void sacar(int valor){
		saldo = saldo - valor;
	}
}
