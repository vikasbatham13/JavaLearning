package leetCode.strings;

import java.util.Arrays;

public class ReverseString {

   /* public static void main(String[] args) {
        String reverseString = "VikaS BathaM";

        char [] input = reverseString.toCharArray();
        for (int i = input.length-1; i>=0;i--){
            System.out.print(input[i]);
        }
    }*/

    public static void main(String[] args) {
        String reverseString = "VikaS BathaM";

       // StringBuilder builder = new StringBuilder();
       // builder.append(reverseString);
       // builder.reverse();
       // System.out.println(builder);

        StringBuilder builder = new StringBuilder();
        builder.append(reverseString);
        builder.reverse();
        System.out.println(builder);
    }

}
