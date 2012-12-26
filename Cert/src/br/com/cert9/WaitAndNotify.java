package br.com.cert9;

public class WaitAndNotify {

	public static void main(String[] args) {
		
		// cria a inicia a ThreadB
		ThreadB b = new ThreadB();
		b.start();
		System.out.println("Vou solicitar dentro de synchronized, o b.wait() para esperar ele terminar...");
		System.out.println("No metodo run() de B, quando ele termina, é enviado o notify() para que ele avise que terminou...");
		
		/**
		 * Outro teste (descomentar abaixo) e comentar segundo bloco
		 */
		/* PRIMEIRO BLOCO - teste com sleep na thread atual para dar tempo 
		 * de executar parte de B. obs: em cada execução um resultado diferente
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("Total is : " + b.total);
		*/
		
		/* SEGUNDO BLOCO 
		 * Para que B seja executado por completo é feito a comunicação com wait() 
		 * */
		  synchronized (b) {
			try {
				b.wait();
			}
			catch(InterruptedException e){}
			System.out.println("Total is : " + b.total);
		}
		
	}
}

class ThreadB extends Thread {
	long total;
	
	@Override
	public void run() {
		synchronized(this){
			for (long i=0; i<1000000000; i++){
				total += i;
			}
			notify();
		}
	}
}