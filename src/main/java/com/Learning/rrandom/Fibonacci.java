package com.Learning.rrandom;

public class Fibonacci {

    public static void main(String[] args) {
        int a=1,b=1,c=0;
        System.out.println(a);
        System.out.println(b);
        for (int i=2; i<10; i++){
            c=a+b;
            System.out.println(c);
            a=b;
            b=c;
        }
    }
}
