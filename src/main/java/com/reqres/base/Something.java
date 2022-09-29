package com.reqres.base;

public class Something {
	public int b;
	String ss="";
	public String calculator(String s) {
		char[] c=s.toCharArray();
		String s1=s;
		for (char ch: c) {
			
			 ss=ch+ss; 
		}
	return ss;
	}
	
public static void main(String[] args) {
	Something ex= new Something();
	System.out.println(ex.calculator("hello"));
}

}
