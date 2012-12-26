package br.com.cert6;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DatasNumerosMoeda {

	static void calendario(){
		Locale ptBR = new Locale("pt", "BR");
		Calendar c = Calendar.getInstance(ptBR);
		c.setTime(new Date());
		
	}
	
	public static void main(String[] args) {
		calendario();
	}
}
