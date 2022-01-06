package leetCode.algorithm;

import java.util.Arrays;

public class SelectionSort {

    public static void swap(int[] swapArray, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = swapArray[i];
        swapArray[i] = swapArray[j];
        swapArray[j] = temp;
    }

    public static void main(String[] args) {

        int[] sortArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastIndex = sortArray.length - 1; lastIndex > 0; lastIndex--) {
            int largest = 0;
            for (int i = 1; i < lastIndex; i++) {

                if (sortArray[i] > sortArray[largest]) {
                    largest = i;

                }
            }
            swap(sortArray, largest, lastIndex);
        }
        System.out.println(Arrays.toString(sortArray));
    }
}
