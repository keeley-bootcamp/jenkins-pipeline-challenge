package com.qa;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
       addInts(100, 200);
       addInts(99, 2453);
       addInts(4, 15);
       addInts(19, 228);
    }

    public static void addInts(int a, int b) {
        int result = a + b;
        System.out.println("The result of " + a + " + " + b + " is " + result);
    }
}
