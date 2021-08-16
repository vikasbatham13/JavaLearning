package com.Learning.array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

public class SingleNumber {

    public int findSingleNumber(int[] nums){

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num :nums) {
            if (map.containsKey(num)) {
            map.remove(num);
            }else
                map.put(num,1);
        }
        int response = 0;
        Iterator it = map.keySet().iterator();
        if (it.hasNext()){
            response = (int) it.next();
        }
        return response;
    }

    public static void main(String [] args){

        int arr[] = {1,1,2,2,3,3,4,4,5,5,6,6,7};
        SingleNumber sn = new SingleNumber();
        System.out.println(sn.findSingleNumber(arr));

    }

/*    static int findSingle(int ar[], int ar_size) {
        // Do XOR of all elements and return
        int res = ar[0];
        for (int i = 1; i < ar_size; i++) {
            res = res ^ ar[i];
        }
        return res;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        int n = arr.length;
        System.out.println("Element occurring once is " +
            findSingle(arr, n) + " ");
    }*/

}
