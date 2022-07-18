package com.lifeng.java.day15.demo.String;

public class Demo02 {
	public static void main(String[] args) {
		/*String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		System.out.println(s1 == s2);//true
		System.out.println(s1 == s3);//false*/
		
		/*String s1 = "abc";
		String s2 = "ab";
		String s3 = s2 + "c";
		System.out.println(s1 == s3);//false*/
		
		String s1 = "abc";
		String s2 = "ab" + "c";
		System.out.println(s1 == s2);//true
	}
}
