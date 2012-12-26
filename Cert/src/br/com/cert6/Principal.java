package br.com.cert6;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.tools.FileObject;

public class Principal {
	
	public void testaDirEFile(){

		File dir = new File("meuDiretorio");
		if (! dir.isDirectory()){
			dir.mkdir();
		}
		
		File f = new File("a.txt");
		if (! f.exists()){
			try {
				f.createNewFile();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void testaFileReaderWriter(){
		
		File f = new File("a.txt");
		
		if (f.exists()) f.delete();
		try {
			f.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			fw.write("Leandro Souza");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		char charLeitura[] = new char[40];
		FileReader fr;
		try {
			fr = new FileReader(f);
			int size = fr.read(charLeitura);
			for (char a : charLeitura){
				System.out.print(a);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testaBufferedReaderPrintWriter(){

		File f = new File("a.txt");
		
		if (f.exists()) f.delete();
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// a partir de Java 5, não preciso criar um FileWriter para intemediar a criação de PrintWriter
		try {
			PrintWriter pw = new PrintWriter(f);
			pw.println("Minha profissao eh... ");
			pw.println("ser programdor JAVA...");
			pw.println("e nao eh que gosto muito disso!");
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		FileReader in;
		try {
			in = new FileReader(f);
			BufferedReader br = new BufferedReader(in);
			String s;
			while ( (s = br.readLine()) != null){
				System.out.println(s);
			}
			br.close();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void testaConsole(){
		Console c = System.console();
		char pw[];
		pw = c.readPassword("%c", "password: ");
		for (char ch : pw){
			c.format("c%", ch);
		}
		c.format("\n");
	}
	
	public void testaSerializacao() throws IOException, ClassNotFoundException{
		this.escritaObjeto();
		this.leituraObjeto();
	}
	
	public void escritaObjeto() throws IOException{
		Marca m = new Marca();
		m.setLetra('A');
		
		Carro carro = new Carro();
		carro.setCor("vermelho");
		carro.setNome("corsa");
		carro.setMarca(m);
		
		File file = new File("a.txt");
		if (file.exists()) file.delete();
		file.createNewFile();
		
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(carro);
		//oos.writeChars(Character.valueOf(m.getLetra()).toString());
		oos.close();
	}
	
	private void leituraObjeto() throws IOException, ClassNotFoundException {
		File file = new File("a.txt");
		if (! file.exists()) file.createNewFile();
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Carro carro = (Carro)ois.readObject();
		System.out.println("Nome: " + carro.getNome());
		System.out.println("Cor: " + carro.getCor());

		ois.close();
	}

	public static void main(String[] args) {
		
		/*try {
			(new Principal()).testaSerializacao();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		
		Principal p = new Principal();
		try {
			p.escritaObjeto();
			p.leituraObjeto();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

	}
}
