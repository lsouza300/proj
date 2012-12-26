package br.com.cert9;

public class Sincronizacao implements Runnable{

	public class ContaBancaria{

		private int saldo = 10000;
		private String nome;

		/**
		 * metodo synchronized - nao deixa 2 threads executarem ao mesmo tempo 
		 * @param x
		 */
		public synchronized void sacar(int x){
			this.saldo = this.saldo - x;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getNome() {
			return nome;
		}
		
	}
	
	@Override
	public void run() {
		
	}

	public static void main(String[] args) {
		Sincronizacao s = new Sincronizacao();
		ContaBancaria c1 = s.new ContaBancaria();
		
		Thread t1 = new Thread(s);
		c1.sacar(30);
		
	}
}
