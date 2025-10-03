package frostnight.programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestSameCharacter {

	public int[] solution(String s) {
		List<Integer> answers = new ArrayList<>();
		Map<String, Integer> stringIndexMap = new HashMap<>();
		String[] compareStrings = s.split("");
		for (int i = 0; i < compareStrings.length; i++) {
			int findIndex = stringIndexMap.getOrDefault(compareStrings[i], -1);
			answers.add(findIndex >= 0 ? i - findIndex : findIndex);
			stringIndexMap.put(compareStrings[i], i);
		}
		return answers.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		NearestSameCharacter runner = new NearestSameCharacter();
		String[] inputs = {"aaabbbccc"};
		int[][] expected = {
//				{-1, -1, -1, 2, 2, 2},
//				{-1, -1, 1, -1, -1, -1},
//				{-1, -1, 1, -1, -1},
				{-1, 1, 1, -1, 1, 1, -1, 1, 1}
		};
		for (int i = 0; i < expected.length; i++) {
			int[] result = runner.solution(inputs[i]);
			if (result.length != expected[i].length) {
				System.out.println("result.length != expected.length");
				break;
			}
			for (int k = 0; k < expected[i].length; k++) {
				if (expected[i][k] != result[k]) {
					System.out.println("expected = " + expected[i][k]);
					System.out.println("not exactly answer: " + result[k]);
				}
			}
		}
	}
}
