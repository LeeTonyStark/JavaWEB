package com.lifeng.java.day15.demo.String;

public class Demo06 {
	public static void main(String[] args) {
		/*//public int length()
		System.out.println("".length());
		System.out.println("a".length());
		System.out.println("abc".length());*/
		
		/*//public String replace(char oldChar,char newChar)
		String s = "abcde";
		String newS = s.replace('c', 's');
		System.out.println(s);
		System.out.println(newS);*/
		
		/*//public String replace(String target,String replacement)
		String s = "abcde";
		s = s.replace("ab", "ss");
		System.out.println(s);*/
		
		//public String[] split(String regex)
		/*String s = "a-b-c-d-e";
		String[] strs = s.split("-");
		for(int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}*/
		
		//String s = "a_b_c_d_e";
		//String s = "a.b.c.d.e";
		//String s = "a*b*c*d*e";
		String s = "D:\\develop\\jdk1.8";
		//String[] strs = s.split("_");
		//String[] strs = s.split("\\.");
		//String[] strs = s.split("\\*");
		String[] strs = s.split("\\\\");
		for(int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
	}
}
