package br.com.cert9;


/**
 * 
 * @author leandro.asouza
 *
 * Estados da Thread
 * 1. Novo: n�o foi chamado o start() ainda.
 * 2. Execut�vel: j� foi chamado o start(). Portanto o sheduler pode lev�-lo ao estado ativo a qualquer momento
 * 3. Ativo (Executando): estado do thread em execu��o. �quele que foi chamado pelo sheduler e est� executando. 
 * 
 * Meios de "tentar" (n�o h� garantias) de retirar um Thread de execu��o:
 * yield() -> solicita que o sheduler retire o thread em execu��o para coloc�-lo no modo execut�vel
 * sleep() -> solicita um tempo de sleep para o thread atual (deve ser inserido dentro de um bloco try/catch com exception do tipo InterruptedException)
 * 
 * Meio garantido
 * join() -> determina que um Thread s� pode ser executado ap�s a conclus�o de outro 
 * Verificar o m�todo abaixo testeJoin() para verificar o funcionamento
 */
public class Testthread implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 200; i++){
			System.out.println("Executando a thread " + Thread.currentThread().getName() + " i = " + i);
			
			// metodo yield()
			// Nao garantias, mas o metodo yield() tenta fazer com que o Thread corrente 
			// d� lugar a outro thread
			//Thread.yield();
			
			/*
			 * dando um sleep de 1 segundo (parametro passado em mil�ssimos de segundos)
			 */
			/*try {
				Thread.sleep(1000 * 1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}
	
	public static void main(String[] args) {
		testeJoin();
	}
	

	/**
	 * ao iniciar esta execu��o, mesmo estabelecendo prioridades,
	 * n�o h� garantias
	 */
	public static void rodandoThreads(){
		for (int i = 0; i < 10; i++){
			Testthread test = new Testthread();
			Thread t = new Thread(test);
			int priority = (i!=0) ? i : 1;
			//t.setPriority(priority);
			t.start();
		}
	}

	/**
	 * Uma vez iniciada uma thread, ela JAMAIS ser� iniciada novamente
	 * Lan�ar� java.lang.IllegalThreadStateException mas a Thread executar� uma vez normalmente
	 */
	public static void iniciarSomenteUmaVez(){
		Testthread test = new Testthread();
		Thread t = new Thread(test);
		t.start();
		t.start();
	}
	
	public static void testeJoin(){
		Testthread t1 = new Testthread();
		Testthread t2 = new Testthread();
		Thread T1 = new Thread(t1);
		Thread T2 = new Thread(t2);
		try {
			// tradu��o do join() abaixo: T2, junte-se ao final de T1. Enquanto T1 n�o
			// acabar, n�o "volte" a executar (ou n�o inicie caso n�o tenha startado ainda).
			// Interessante observar que se T2.start() for feito primeiro uma parte de T2
			// poder� executar antes de iniciar T1. Quando T1 for iniciado, a� sim T2 s� 
			// voltar� a ser executado ao final de T1
			T2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		T1.start();
		T2.start();
	}
}
