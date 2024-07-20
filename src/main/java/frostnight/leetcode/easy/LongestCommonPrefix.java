package frostnight.leetcode.easy;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args){
		String[] strs = {"flower","flow","flight"};
		System.out.println("longestCommonPrefix(str) = " + longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {
		String commonPrefix = "";

		boolean breakPoint = true;
		int index = 1;

		while(breakPoint) {
			String findPrefixPiece = "";
			for(String str : strs) {
				if (index >= str.length()) {
					breakPoint = false;
					break;
				}

				if (findPrefixPiece.isEmpty()) {
					findPrefixPiece = str.substring(0, index);
				} else if (findPrefixPiece.equals(str.substring(0, index))) {
					continue;
				} else {
					breakPoint = false;
					break;
				}
			}
			if (breakPoint) {
				commonPrefix = findPrefixPiece;
			}
			index++;
		}

        return commonPrefix;
    }
}
