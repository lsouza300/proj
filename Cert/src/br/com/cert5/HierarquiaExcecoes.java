package br.com.cert5;

public class HierarquiaExcecoes {

	String s;
	

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
		catch (ExceptionB e){
			e.printStackTrace();
		}
		catch (ExceptionA e){
			e.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	static void go() throws Exception{
		throw new ExceptionA();
	}
	
	
	/*void testeOverridingExcecao() throws ExceptionA{
		
	}*/
	void testeOverridingExcecao(){
		
	}
}

class SubHierarquiaExcecoes extends HierarquiaExcecoes{
	
	/*
	 * Pode declarar uma Exception mais especifica
	 * (non-Javadoc)
	 * @see br.com.cert5.HierarquiaExcecoes#testeOverridingExcecao()
	 */
	/*void testeOverridingExcecao() throws ExceptionB{

	}*/
	
	/*
	 * Pode nao declarar a Exception
	 * (non-Javadoc)
	 * @see br.com.cert5.HierarquiaExcecoes#testeOverridingExcecao()
	 */
	/*void testeOverridingExcecao(){

	}*/
	
	/*
	 * Nao pode declarar Exception mais generica
	 * (non-Javadoc)
	 * @see br.com.cert5.HierarquiaExcecoes#testeOverridingExcecao()
	 */
	/*void testeOverridingExcecao() throws Exception{
		
	}*/
	
	/*void testaOverriding(){
		HierarquiaExcecoes h = new SubHierarquiaExcecoes();
		try {
			h.testeOverridingExcecao();
		} catch (ExceptionA e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	/*
	 * O unico que pode ser adicionado no metodo de overriding sao os do
	 * tipo RuntimeException. Ex.: IllegalArgumentException, NumberFormatException,
	 * RuntimeException
	 * (non-Javadoc)
	 * @see br.com.cert5.HierarquiaExcecoes#testeOverridingExcecao()
	 */
	void testeOverridingExcecao() throws RuntimeException{
		// invalido
		// void testeOverridingExcecao() throws Exception{
	}

}

class ExceptionA extends Exception {
	ExceptionA(){}
}

class ExceptionB extends ExceptionA{

}