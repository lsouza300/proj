package br.com.cert6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TesteFiles {

	/**
	 * File eh uma representacao do arquivo. Pode testar sua existencia, tentar
	 * criar um arq ou diretorio, testa a existencia de um dos dois, etc.
	 */
	void testeFile() {
		File f = new File("a.txt");
		if (!f.isDirectory()) {
			System.out.println(f.getName() + " nao eh um diretorio!");
		}

		if (!f.isFile()) {
			System.out.println(f.getName()
					+ " nao eh um arquivo (nao existe em memoria).");
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (f.isFile()){
				System.out.println(f.getName() + " agora existe em memoria (foi criado).");
				
			}
		}
	}
	
	void testeDirectory() throws IOException{
		File dir = new File("diretorioMeu");
		if (!dir.isDirectory()) {
			System.out.println(dir.getName() + " nao eh um diretorio!");
			System.out.println("Vai tentar criar um diretorio...");
			if (dir.mkdir()){
				System.out.println("Diretorio foi criado.");
			}
		}
		else {
			System.out.println("Diretorio existe.");
			System.out.println("Caminho: " + dir.getPath() + System.getProperty("file.separator") + "b.txt");
		}
		
		System.out.println("Verificar existencia de file...");
		File f = new File(dir.getPath() + System.getProperty("file.separator") + "b.txt"); 
		if (f.exists()){
			System.out.println("Arquivo " + f.getPath() + " ja existe...");
		}
		else {
			System.out.println("Arquivo " + f.getPath() + " nao existe, vai tentar cria-lo...");
			if (f.createNewFile()){
				System.out.println("Arquivo " + f.getName() + " criado com sucesso!");
			}
		}
	}
	
	/**
	 * FileReader e FileWriter sao de nivel baixo
	 * FileReader consegue ler uma sequencia de caracteres isolados ou todo o stream de caracteres
	 * FileWriter escreve em arquivos de caracter, geralmente utilizando writer() 
	 * Sao normalmente encapsulados (wrapped) -> FileReader por BufferReader, FileWriter por BufferedWriter ou PrintWriter
	 * @throws IOException 
	 */
	void testeFileReaderWriter() throws IOException{
		File f = new File("a.txt");
		FileWriter fw = new FileWriter(f);
		fw.write("Teste do Leandro");
		fw.flush();
		fw.close();
		
		FileReader fr = new FileReader(f);
		
		int tam = fr.read();
		System.out.println("tamanho: " + tam);
		char[] leitura = new char[tam];
		fr.read(leitura);
		fr.close();
		System.out.print(leitura);
		//for (int x = 0; x < tam; x++){
			//System.out.print(fr.read(target))
		//}
	}
	
	void testeBufferReaderAndWriter() throws IOException{
		File f = new File("a.txt");
		
		PrintWriter pw = new PrintWriter(f);
		pw.write("Em uma linha eu escrevo isso... \n");
		pw.write("Em outra linha eu escrevo aquilo...\n");
		pw.write("No final eu tenho um texto completo...");
		pw.flush();
		pw.close();
		
		FileReader fr = new FileReader(f); // exige FileNotFoundException
		BufferedReader br = new BufferedReader(fr);
		String x;
		while ( (x = br.readLine()) != null){
			System.out.println(x);
		}
		br.close();
		fr.close();
		

		//PrintWriter p = new PrintWriter(f);
		pw.append("Esqueci de escrever essa linha, entao utilizo o append... ");
		pw.flush();
		pw.close();

		System.out.println("\nIrei realizar a leitura novamente...\n");
		fr = new FileReader(f); // exige FileNotFoundException
		br = new BufferedReader(fr);
		while ( (x = br.readLine()) != null){
			System.out.println(x);
		}
		br.close();
		
	}
	

	public static void main(String[] args) throws IOException {
		//new TesteFiles().testeFileReaderWriter();
		//new TesteFiles().testeDirectory();
		new TesteFiles().testeBufferReaderAndWriter();
		
	}
}
