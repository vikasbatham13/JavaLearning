package com.Learning.array;

import java.util.Arrays;

public class LeftRotateArray {


    public static int[] rotateBy(int d, int[] input){
        int inputLength = input.length;
        for (int i = 0; i < d; i++){
            int temp = input[0];
            for(int j = 0; j < inputLength - 1; j++){
                input[j] = input[j + 1];
            }
            input[inputLength - 1] = temp;
        }
        return input;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] output = LeftRotateArray.rotateBy(1, arr);
        System.out.println(Arrays.toString(output));
    }
}


