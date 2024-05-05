package frostnight.leetcode.easy;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args){
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = twoSum(nums, target);
        Arrays.stream(result).boxed().forEach(n -> System.out.println("n = " + n));

    }

    static public int[] twoSum(int[] nums, int target) {

        for(int i=0; i < nums.length; i++) {
            for(int j=0; j < nums.length; j++) {
                if(i != j && nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}
