package com.lifeng.java.day25.demo;

import java.net.InetAddress;
import java.net.InterfaceAddress;

/**
 * @author lifeng
 * @create 2022-07-23 10:45
 */
public class demo1 {
    public static void main(String[] args) throws Exception{
        InetAddress[] allByName = InetAddress.getAllByName("DESKTOP-OP7SVDB");
        for (InetAddress address : allByName) {
            System.out.println(address);
        }
    }
}
