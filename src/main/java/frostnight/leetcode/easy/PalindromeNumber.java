package frostnight.leetcode.easy;

import java.util.Arrays;
import java.util.StringTokenizer;

public class PalindromeNumber {

    public static void main(String[] args){
        int x = 121;
        boolean result = isPalindrome(x);
        System.out.println("result = " + result);
    }

     static public boolean isPalindrome(int x) {
        String input = String.valueOf(x);
        if(new StringBuilder(input).reverse().toString().equals(input)) {
            return true;
        }
        return false;
     }
}
