package leetCode.array;

import java.util.Arrays;

public class RightRotateArray {

    public static int[] rotateBy(int d, int[] inputArray){
        int inputArrayLength = inputArray.length;

        for (int i = 0; i < d; i++){
          int[] tempArray = new int[inputArrayLength];
            for(int j = 0; j < inputArrayLength ; j++){
                int tempItem = inputArray[inputArray.length-1];

                if(j !=  inputArrayLength-1) {
                    tempArray[j+1] = inputArray[j];
                }else{
                    tempArray[0] = tempItem;
                }
            }
            inputArray = tempArray;

        }

        return inputArray;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] output = RightRotateArray.rotateBy(7, arr);
        System.out.println(Arrays.toString(output));
    }
}
