package leetCode.array;

import java.util.Arrays;

public class MoveZeros {


    public void moveZeroes(int[] nums) {


        int j =0;
        for(int i=0; i < nums.length;i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
     while (j<nums.length){
         nums[j] =0;
         j++;
     }
    }

    public static void main(String[] args) {

        int[] nums = {1, 0, 3, 1,0,5,0,9};
        MoveZeros moveZeros = new MoveZeros();

        moveZeros.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("Test");
    }
}
