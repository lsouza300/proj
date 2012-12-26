package br.com.cert6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author leandro.asouza
 * 
 * No caso de um atributo transient, ele ira voltar ao valor default (ou null)
 * verificar caso do atributo 'b' na classe Filho
 * 
 * No caso de um atributo na classe Pai que nao eh serializavel, ele ira retornar ao valor
 * atribuido na classe. Verificar caso da variavel 'a' da classe Pai (classe nao serializavel)
 * 
 * No caso do atributo 'nome', ele nao eh transient e seu valor eh persistido e restaurado 
 * posteriormente
 * 
 * Para verificar o overriding, analisar classe Carro.java, e sua serializacao em Principal.java 
 *
 */
public class Serializacao {

	public static void main(String[] args) {
		
		Filho filho = new Filho(3, "Leandro");
		filho.setA(45);
		
		try {
			File file = new File("leandro.bin");
			if (! file.exists()){
				file.createNewFile();
			}
			FileOutputStream f = new FileOutputStream(file);
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(filho);
			o.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			FileInputStream f2 = new FileInputStream("leandro.bin");
			ObjectInputStream o2 = new ObjectInputStream(f2);
			Filho filhoLeitura = (Filho)o2.readObject();
			
			System.out.println("filhoLeitura.getA(): " + filhoLeitura.getA());
			System.out.println("filhoLeitura.getB(): " + filhoLeitura.getB());
			System.out.println("filhoLeitura.getNome(): " + filhoLeitura.getNome());
			
			o2.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
