package com.Learning.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Duplicates {

    public boolean containsDuplicate(int[] nums) {
        boolean result = false;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }

        return false;
    }
    public static void main(String [] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        Duplicates dup = new Duplicates();
        System.out.println( dup.containsDuplicate(nums));
    }
}
