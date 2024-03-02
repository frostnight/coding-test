package frostnight.programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PhoneKetMon {

	public static int solution(int[] nums) {
		int limit = nums.length / 2;
		Set<Integer> pkmSet = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));

		return (pkmSet.size() <= limit) ? pkmSet.size() : limit;
	}

	public static void main(String[] args){
		int[] nums = {1,2,3,3};
		// 폰켓몬 종류가 5가지 마릿수 10마리
		// 폰켓몬 종류가 10가지 마릿수 10마리
		// 폰켓몬 종류가 5가지 마릿수 20마리
		System.out.println("solution(nums) = " + solution(nums));
	}
}
