package br.com.cert6;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Carro implements Serializable {

	private String cor;
	private String nome;
	private transient Marca marca;
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	private void writeObject(ObjectOutputStream os) throws IOException{
		os.defaultWriteObject();
		os.writeChar(this.getMarca().getLetra());
		os.flush();
	}
	
	private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException{
		
		is.defaultReadObject();
		char letraMarca = is.readChar();
		System.out.println(letraMarca);
	}
}
