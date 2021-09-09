package leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterSectionOfTwoArrays {

    public int[] intersect(int[] nums1, int[] nums2) {

        int i = 0;
        int j = 0;
        List<Integer> finalArrayList = new ArrayList();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                finalArrayList.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }

        }
        int[] finalArray = new int[finalArrayList.size()];

        for (int k = 0; k < finalArrayList.size(); k++) {
            finalArray[k] = finalArrayList.get(k);
        }

        return finalArray;
    }

  /*  public int[] intersect(int[] nums1, int[] nums2) {

        int i = 0;
        int j = 0;
        List<Integer> finalArrayList = new ArrayList();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                finalArrayList.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }

        }
        int[] finalArray = new int[finalArrayList.size()];

        for (int k = 0; k < finalArrayList.size(); k++) {
            finalArray[k] = finalArrayList.get(k);
        }

        return finalArray;
    }
*/
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        InterSectionOfTwoArrays interSectionOfTwoArrays = new InterSectionOfTwoArrays();
      //  int[] output = interSectionOfTwoArrays.intersect(arr1, arr2);

        System.out.println(Arrays.toString(interSectionOfTwoArrays.intersect(arr1, arr2)));
    }
}
