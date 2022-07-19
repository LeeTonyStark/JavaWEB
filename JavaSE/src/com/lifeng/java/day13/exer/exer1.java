package com.lifeng.java.day13.exer;

/**
 * @author lifeng
 * @create 2022-07-06 9:06
 */
public class exer1 {
    public static void main(String[] args) {

        String s = "fasfafFSFSFSFw2221";
        char c = s.charAt(5);
        System.out.println(c);

        int i = "SD".compareTo(s);
        System.out.println(i);

        String concat = "ccc".concat(s);
        System.out.println(concat);

        boolean a = s.contains("a");
        System.out.println(a);

        System.out.println(s.endsWith("221"));

        System.out.println(s.startsWith("fas"));

        System.out.println(s.equals("aaa"));

        byte[] bytes = s.getBytes();
        for (int i1 = 0; i1 < bytes.length-1; i1++) {
            System.out.println(bytes[i1]);
        }

        int i1 = s.indexOf("s");
        System.out.println(i1);

        int i2 = s.lastIndexOf("F");
        System.out.println(i2);

        System.out.println(s.length());

        System.out.println(s.replace("1", "3"));

        String[] fs = s.split("F");
        for (int i3 = 0; i3 < fs.length - 1; i3++) {
            System.out.println(fs);
        }

        String substring = s.substring(5);
        System.out.println(substring);

        char[] chars = s.toCharArray();
        for (int i3 = 0; i3 < chars.length -1; i3++) {
            System.out.println(chars[i3]);
        }

        System.out.println(s.toUpperCase());

        String s1 = s.toLowerCase();
        System.out.println(s1);

        String s3 = "   sas  sas ";
        String trim = s3.trim();
        System.out.println(trim);

    }
}
