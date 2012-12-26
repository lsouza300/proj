package br.com.cert1;

public class Comparastrings {

	static String s1 = "I am unique!";
	
	public static void main(String[] args) {
		
		String s2 = "I am unique!";
		String s3 = new String(s1);
		
		// false -- new String para s3
		System.out.println(s1 == s3);
		System.out.println(s1 == s2);
		
		System.out.println(s1.getBytes());
		System.out.println(s2.getBytes());
		
		System.out.println(s1.equals(s2));
		System.out.println(s3.equals(s1));
		
		System.out.println(TestClass.s4 == s1);
		
	}
	
}

class TestClass {
	static String s4 = "I am unique!";
}