package leetCode.strings;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        String reverseString = "VikaS BathaM";

        char [] input = reverseString.toCharArray();
        for (int i = input.length-1; i>=0;i--){
            System.out.print(input[i]);
        }
    }
}
