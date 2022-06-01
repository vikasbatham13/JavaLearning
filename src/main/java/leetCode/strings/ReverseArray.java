package leetCode.strings;

import java.util.Arrays;

public class ReverseArray {

 /*   public void reverseString(char[] s) {
        int start=0;
        int end = s.length-1;
        while(start<end)
        {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;

        }
    }*/

    public static void main(String[] args) {
        char[] arr = {'r', 's', 't', 'u', 'v'};

        ReverseArray reverseArray = new ReverseArray();
        reverseArray.reverseString(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;

        while (start<end){
            char tmp = s[start];
            s [start]= s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

}


