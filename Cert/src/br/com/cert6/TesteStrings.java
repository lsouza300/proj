package br.com.cert6;

public class TesteStrings {

	
	// substring
	// begin comeca em 0
	// end comeca em 1
	void testeString(){
		
		// substring
		String a = "0123456789";
		System.out.println("substring:" + a.substring(0,4));
		
		// replace
		String b = "asdfghij";
		String c = "             123             ";
		System.out.println("replace: " + b.replace('d', 'D'));
		System.out.println("lenght: " + b.length());
		System.out.println("charAt: " + b.charAt(4));
		System.out.println("Trim: '" + c.trim() + "'");
	}
	
	// string builder
	void testeStringBuilder(){
		
		// insert: deslocamento inicia em 0
		StringBuilder sb = new StringBuilder("0123456789");
		sb.insert(3, "###");
		System.out.println(sb);
		
		// delete: semelhante a substring
		// begin: inicia em 0
		// end: inicia em 1
		StringBuilder sb2 = new StringBuilder("0123456789");
		sb2.delete(0, 4);
		System.out.println(sb2);
		
		// append
		// pode "concatenar" boolean, char, double, float, int, long, etc
		int b = 1;
		float c = 3.2f;
		double d = 2.3;
		boolean z = false;
		char e = 'e';
		StringBuilder sb3 = new StringBuilder("asdf");
		sb3.append(b);
		sb3.append(c);
		sb3.append(d);
		sb3.append(z);
		sb3.append(e);
		System.out.println(sb3);
	}
	
	public static void main(String[] args) {
		new TesteStrings().testeString();
		//new TesteStrings().testeStringBuilder();
	}
}
