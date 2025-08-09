package frostnight.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class DivideString {

	public int solution(String s) {
		// 기준글자 count, 그 외 글자 count, 현재 index
		// 문자열을 하나씩 쪼개서 기준 글자와 비교해서 일치하지 않을 때 횟수가 같으면 해당 index까지 분리해서 저장
		char[] target = s.toCharArray();
		int standardCount = 0;
		int eitherCount = 0;
		int startIndex = 0;
		List<String> splitStrings = new ArrayList<>();
		Character standardChar = null;
		for (int i = 0; i < target.length; i++) {
			if (standardChar == null) {
				// 기준 글자에 대해서 신규 저장
				standardChar = target[i];
				standardCount++;
				continue;
			}
			// 기준 글자 또는 그 외 글자 카운트
			if (standardChar == target[i]) {
				standardCount++;
			} else {
				eitherCount++;
			}

			if (standardCount == eitherCount) {
				// 기준글자, 그 외 글자 카운트가 같은 경우
				// 문자를 추출해서 저장
				standardChar = null;
				splitStrings.add(s.substring(startIndex, i + 1));
				startIndex = i + 1;
				standardCount = 0;
				eitherCount = 0;
			}
		}

		if (standardChar != null) {
			// 만약 진행 중 쪼개지 못하고 끝나면 마지막 후처리
			splitStrings.add(s.substring(startIndex));
		}

		return splitStrings.size();
	}

	public static void main(String[] args) {
		DivideString divideString = new DivideString();
		String[] input = {"banana", "abracadabra", "aaabbaccccabba"};
		int[] except = {3, 6, 3};

		for (int i = 0; i < input.length; i++) {
			int result = divideString.solution(input[i]);
			if (result != except[i]) {
				System.out.println("except: " + except[i]);
				System.out.println("result: " + result);
				break;
			}
			System.out.println("success");
		}
	}
}
