package leetCode.algorithm;

import java.util.Arrays;

public class BubbleShort {

    public static void swapArray(int[] intArray, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = intArray[i];
        intArray[i] = intArray[j];
        intArray[j] = temp;
    }

    public static void main(String[] args) {
        int[] sortArray = {20, 35, -15, 7, 55, 1, -22};

        for(int lastIndex = sortArray.length-1; lastIndex >0 ;lastIndex--){

            for (int i =0 ; i<lastIndex; i++){
                if (sortArray[i] > sortArray[i+1]){
                    swapArray(sortArray,i,i+1);
                }
            }
        }

        System.out.println(Arrays.toString(sortArray));
    }
}
