package leetCode.array;

import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int arrayLength = nums.length;
        for(int i=0;i<arrayLength ; i++){
            for(int j = i+1;j<arrayLength ; j++){
                if((nums[i]+nums[j]) == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

        TwoSum twoSumObj = new TwoSum();

        int[] arr = {0, 2, 3, 4, 5};

        System.out.println(Arrays.toString(twoSumObj.twoSum(arr,6)));

    }
}
