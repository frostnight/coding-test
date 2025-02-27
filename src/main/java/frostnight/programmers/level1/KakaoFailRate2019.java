package frostnight.programmers.level1;

import java.util.*;

/**
 * 실패율은 다음과 같이 정의한다. 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수 전체 스테이지의 개수 N 게임을 이용하는 사용자가
 * 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages
 */
public class KakaoFailRate2019 {

  public int[] solution(int N, int[] stages) {
    int[] answer = {};

    if (stages.length < 1) {
      return null;
    }

    // 1. TreeMap으로 N + 1만큼 스테이지 도달한 사람 초기화 한다.
    Map<Integer, Integer> stageMap = new TreeMap<>(Collections.reverseOrder());
    Map<Integer, Integer> challengeMap = new HashMap<>();
    Map<Integer, Double> failRate = new HashMap<>();
    for (int i = 1; i <= N + 1; i++) {
      stageMap.put(i, 0);
      challengeMap.put(i, 0);
      if (i <= N) failRate.put(i, 0d);
    }
    // 2. stage 별 도달한 사용자를 Map 으로 해당 스테이지에 멈춘 사람을 구한다
    for (int stage : stages) {
      stageMap.put(stage, stageMap.get(stage) + 1);

      for (int num = 1; num <= stage; num++) {
        challengeMap.put(num, challengeMap.get(num) + 1);
      }
    }
    // 3. Map 키를 역순으로 뒤집어서 사람 수를 더 해 가면서 실패율도 구한다. 별도 리스트로 저장한다.
    for (Integer stageKey : stageMap.keySet()) {
      if (stageKey <= N) {
        failRate.put(stageKey,  (double)stageMap.get(stageKey) / (double) challengeMap.get(stageKey));
      }
    }
    List<Map.Entry<Integer, Double>> failRateList = new ArrayList<>(failRate.entrySet());

    // 4. 저장된 리스트를 실패율 역순, 인덱스 번호로 정렬 해서 인덱스 값을 리스트로 저장한다.
    failRateList.sort((d1, d2) -> {
      int result = Double.compare(d2.getValue(), d1.getValue());  // 값 기준 내림차순(역순)
      if (result == 0) {                    // 값이 같으면
        return d1.getKey() - d2.getKey();  // 인덱스 기준 오름차순
      }
      return result;
    });
    return answer;
  }

  public static void main(String[] args) {
    KakaoFailRate2019 solution = new KakaoFailRate2019();
    int[] N = {5, 4};
    int[][] stages = {{2, 1, 2, 6, 2, 4, 3, 3}, {4, 4, 4, 4, 4}};
    int[][] except = {{3, 4, 2, 1, 5}, {4, 1, 2, 3}};
    for (int i = 0; i < N.length; i++) {
      int[] result = solution.solution(N[i], stages[i]);
      for (int j = 0; j < result.length; j++) {
        if (result.length != except.length && result[j] != except[i][j]) {
          System.out.println("i = " + i);
          System.out.println("N[i] = " + N[i]);
          System.out.println("result[i] = " + result[i]);
        }
      }
    }
  }
}
