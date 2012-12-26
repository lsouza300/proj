package br.com.cert5;

public class Excecoes {

	String s;
	
	static void teste1Excecoes(){
		int x;
		
		/*
		 * bloco catch eh opcional desde que haja o bloco finally
		 * enfim, catch ou finally (1 dos 2) deve haver
		 */
		try{
			x = 0;
		}
		finally {
			x = 5;
		}

		/*
		 * you need to know that .. cannot have some code between try and catch
		 * nao se pode ter codigos entre try e catch
		 */
	}

	/**
	 * 		 HIERARQUIA DE EXCEÇÕES
	 *  
	 * 
	 *                Object
	 *              	|
	 *                  |
	 *              Throwable
	 *            /           \
	 *          /               \
	 *      Error              Exception
	 *      /                    /       \
	 *    /                    /           \
	 *  ...          RuntimeException        ...
	 * 
	 * - Todas as classes Exceptions s�o derivadas de java.lang.Exception
	 * - Erros nao sao excecoes e nao derivam da classe Exception
	 * - Exception, Error, Throwable e RuntimeException podem ser lancados com throw
	 * 
	 */
	static void hierarquiaException(){
		try {
			go();
		}
		catch (ExceptionE e){
			e.printStackTrace();
		}
		catch (ExceptionD e){
			e.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	static void go() throws Exception{
		throw new ExceptionD();
	}

	/** *************************************************************************************** */
	
	
	/**
	 * 		 TIPOS DE EXCEÇÕES
	 *  
	 *  ---> Descendentes de java.lang.RuntimeExceptions:
	 *  As descendentes de RuntimeExceptions sao lancadas pela JVM, e nao necessitam ser declaradas
	 *  apesar que podem ser declaradas na declaracao dos metodos, mas nao serao necessarios blocos
	 *  try/catch ou a propagacao destas Exceptions
	 *  
	 *  Exemplos: ArrayIndexOutOfBoundsException, ClassCastException, NullPointerException
	 *  
	 *  
	 *  ---> Descendentes de java.lang.Exception
	 *  As derivadas de Exceptions sao lancadas programaticamente e devem ser declaradas e
	 *  sua captura deve ser propagada conforme a visao do desenvolvedor
	 *  
	 *  Exemplos: NumberFormatException, IllegalStateException
	 *  
	 */
	
	/**
	 * tipo: ArrayIndexOutOfBoundsException
	 * Na hierarquia, eh descendente de RuntimeException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void tipo1() throws ArrayIndexOutOfBoundsException{
		int[]a = {3,4,3};
		System.out.println(a[4]);
	}
	public void testeTipo1(){
		/*
		 * Nao eh necessario o bloco try, pois mesmo com a declaracao do tipo 
		 * throws ArrayIndexOutOfBoundsException no metodo tipo1(), esta Exception
		 * eh lancada pela JVM
		 */
		tipo1();
	}
	
	/**
	 * tipo: ClassCastException
	 * Na hierarquia, eh descendente de RuntimeException, portanto a JVM quem lanca esta Exception
	 * O compilador nao controla tal situacao abaixo que eh lancada uma ClassCastException
	 * Em uma situacao real, deveria haver um teste de instanceof antes de realizar o Cast
	 * @throws ClassCastException
	 */
	public void tipo2() throws ClassCastException{
		
		// o compilador nao controla tal situacao abaixo que eh lancada uma ClassCastException
		// em um caso real, deveria haver um teste de instance of antes de realizar o Cast
		Integer a = 4;
		Object b = a;
		Excecoes x = (Excecoes)b;
	}
	public void testeTipo2(){
		tipo2();
	}
	
	/**
	 * Outra Exception lancada pela JVM
	 * Portanto na declaracao 
	 * @throws NullPointerException
	 */
	public void tipo3() throws NullPointerException{
		System.out.println(this.s.length());
	}
	public void testeTipo3(){
		tipo3();
	}
	

	public static void main(String[] args) {
		// hierarquiaException();
		
		// new Excecoes().testeTipo1();
		// new Excecoes().testeTipo2();
		new Excecoes().testeTipo3();
	}
}

class ExceptionD extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

class ExceptionE extends ExceptionD{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
