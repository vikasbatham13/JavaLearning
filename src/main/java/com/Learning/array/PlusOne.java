package com.Learning.array;

import java.util.Arrays;

public class PlusOne {

   public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                if (i == 0) {
                    digits[0] = 0;
                    int[] newDigits = new int[digits.length + 1];
                    newDigits[0] = 1;
                    return newDigits;
                } else {
                    digits[i] = 0;
                }
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1, 1};

        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(arr1)));


    }
}
