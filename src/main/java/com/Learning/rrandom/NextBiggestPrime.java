package com.Learning.rrandom;

public class NextBiggestPrime {
    public Boolean isPrime(int n) {

        if (n <= 1) {
            return false;
        }
        if (n == 2)
            return true;

        if (n % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
            if (n / i == 0) {
                return false;
            }
        }

        return true;
    }

 /*   public int nextPrime(int n) {

    }*/
    public static void main(String[] args) {
     //   NextBiggestPrime nbp = new NextBiggestPrime();
    //    System.out.println(nbp.nextPrime(50));

        }


    }

