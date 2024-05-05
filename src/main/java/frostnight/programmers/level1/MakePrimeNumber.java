package frostnight.programmers.level1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MakePrimeNumber {

	public static void main(String args[]) {
		int[] nums = {1,2,3,4};
		int result = solution(nums);
		System.out.println("result = " + result);
	}

	static public int solution(int[] nums) {
        int answer = 0;
		Set<String> checkNumbers = new HashSet<>();

        for(int i=0; i < nums.length; i++) {
			for(int j=0; j < nums.length; j++) {
				if(i == j) continue;
				for(int k=0; k < nums.length; k++) {
					if(j == k || i == k) continue;
					List<Integer> nums_ = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
					Collections.sort(nums_);
					String primeKey = String.join(",", nums_.stream().map(n -> String.valueOf(n)).collect(Collectors.toList()));

					if(checkNumbers.contains(primeKey)) continue;

					if(findPrimeNumber(nums[i] + nums[j] + nums[k])) {
						checkNumbers.add(primeKey);
						answer++;
					}
				}
			}
        }

        return answer;
    }

	static boolean findPrimeNumber(int num){
		return !IntStream.range(2, num).filter(n -> num % n == 0).findAny().isPresent();
	}

}
