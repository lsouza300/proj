package br.com.cert1;

/**
 * Convencoes de codigo:
 */

/*
 * Classes e interfaces: iniciam com letra maiuscula
 * 		Ex.: Pessoa, CustomerController
 */
public class Identificadores {

	/*
	 * Identificadores legais comecam com
	 * - uma letra
	 * - underscore (_)
	 * - ou o cifrao ($)
	 */
	private int a;
	private long $3aaaaaaa;
	private String ______3;

	/*
	 * Variaveis: primeira letra minuscula. Padrao camelCase.
	 */
	private int idadeMaior;
	
	/*
	 *  Constantes: Letras maiusculas
	 */
	public static int MAIOR_IDADE = 18;
	
	/* 
	 * Metodos: primeira letra minuscula. Padrao camelCase.
	 */ 
	public int getA() { 
		return a; 
	}
	
	
}
