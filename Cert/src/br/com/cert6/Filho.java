package br.com.cert6;

import java.io.Serializable;

public class Filho extends Pai implements Serializable{

	transient int b = 100;
	String nome;
		
	Filho(int c, String n){
		this.b = c;
		this.nome = n;
	}
	
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
