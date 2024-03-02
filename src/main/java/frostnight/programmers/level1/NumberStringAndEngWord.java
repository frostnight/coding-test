package frostnight.programmers.level1;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class NumberStringAndEngWord {

	public static void main(String[] args){
		String s = "123";
		System.out.println("s = " + solution(s));
	}

	public static int solution(String s) {
		int answer = 0;
		StringBuffer result = new StringBuffer();

		StringBuffer sBuff = new StringBuffer();
		String pattern = "^[0-9]+$";

		Map<String, String> wordDictionary = numberDictionary();

		for(int i=0; i < s.length(); i++){

			String extractStr = s.substring(i, i+1);

			// 숫자면 바로 저장
			if(Pattern.matches(pattern, extractStr)){
				result.append(extractStr);
				continue;
			}

			sBuff.append(extractStr);

			if(wordDictionary.containsKey(sBuff.toString())){
				result.append(wordDictionary.get(sBuff.toString()));
				sBuff = null;
				sBuff = new StringBuffer();
			}
		}
		answer = Integer.parseInt(result.toString());
		return answer;
	}

	public static Map<String, String> numberDictionary(){
		Map<String, String> result = new HashMap<>();
		result.put("zero", "0");
		result.put("one", "1");
		result.put("two", "2");
		result.put("three", "3");
		result.put("four", "4");
		result.put("five", "5");
		result.put("six", "6");
		result.put("seven", "7");
		result.put("eight", "8");
		result.put("nine", "9");
		return result;
	}
}
