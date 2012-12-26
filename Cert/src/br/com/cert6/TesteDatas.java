package br.com.cert6;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TesteDatas {

	Locale loc = new Locale("pt", "BR");
	
	// informe a data atual por extenso e em portugues, completa e curta
	public void dataPortugues(){
		
		DateFormat formatFullPtBR = DateFormat.getDateInstance(DateFormat.FULL, loc);
		DateFormat formatShortPtBR = DateFormat.getDateInstance(DateFormat.SHORT, loc);
		
		Date d = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		//cal.add(Calendar.MONTH, 1);
		
		System.out.println(formatFullPtBR.format(cal.getTime()));
		System.out.println(formatShortPtBR.format(cal.getTime()));
		
	}
	
	// imprimir na tela, o valor R$34,50 utilizando NumberFormat e Locale ptBR 
	public void dinheiroPtBr(){

		float valor = 34.51f;
		NumberFormat nf = NumberFormat.getInstance(this.loc);
		String valorStr = nf.format(valor);
		
		NumberFormat nf2 = NumberFormat.getCurrencyInstance(this.loc);
		String valorStr2 = nf2.format(valor);
		
		System.out.println(valorStr);
		System.out.println(valorStr2);
	}
	
	public static void main(String args[]){
		TesteDatas t = new TesteDatas();
		t.dataPortugues();
		t.dinheiroPtBr();
	}
}
