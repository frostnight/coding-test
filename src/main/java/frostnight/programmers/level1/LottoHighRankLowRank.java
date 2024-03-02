package frostnight.programmers.level1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

//로또의 최고 순위와 최저 순위
public class LottoHighRankLowRank {

	public static void main(String[] args){
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};

		solution(lottos, win_nums);
	}

	public static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];

		List<Integer> lottosList = Arrays.stream(lottos)
									.boxed()
									.collect(Collectors.toList());
		List<Integer> winNumList = Arrays.stream(win_nums)
									.boxed()
									.collect(Collectors.toList());
		// 0이 있는 index 확인
		Map<Integer, Integer> unknownNumMap = getUnknownNumMap(lottosList);

		System.out.println("unknownNumMap = " + unknownNumMap);

		int correctCount = correctNumberCount(lottosList, winNumList);

		System.out.println("high: "+(correctCount+unknownNumMap.size()));
		System.out.println("low: "+correctCount);

		System.out.println("highRank: "+getRank(correctCount+unknownNumMap.size()));
		System.out.println("lowRank: "+getRank(correctCount));

		answer[0] = getRank(correctCount+unknownNumMap.size());
		answer[1] = getRank(correctCount);

		return answer;
	}

	// 0이 있는 index 확인
	public static Map<Integer, Integer> getUnknownNumMap(List<Integer> list){
		AtomicInteger index = new AtomicInteger();
		return list.stream().filter(num -> num == 0).collect(
			Collectors.toMap( s -> index.getAndIncrement(), s -> s));
	}

	// 0을 제외하고 몇 개 까지 숫자가 맞는지 확인
	static int correctNumberCount(List<Integer> lottoList, List<Integer> winNumList){
		AtomicInteger correctCount = new AtomicInteger();
		lottoList.stream().filter(num -> num > 0).forEach( num -> {
			if(winNumList.contains(num)){
				correctCount.getAndIncrement();
			}
		});
		return correctCount.intValue();
	}

	// 순위 산정 메소드
	public static int getRank(int correctCount){
		int rank = 6;

		switch (correctCount){
			case 6: rank = 1;
			break;
			case 5: rank = 2;
			break;
			case 4: rank = 3;
			break;
			case 3: rank = 4;
			break;
			case 2: rank = 5;
			default:
		}
		return rank;
	}

	// 다른 사람 풀이
	// public int[] solution(int[] lottos, int[] winNums) {
	// 	return LongStream.of(
	// 		(lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
	// 		(lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
	// 	)
	// 		.mapToInt(op -> (int) (op > 6 ? op - 1 : op))
	// 		.toArray();
	// }

}
