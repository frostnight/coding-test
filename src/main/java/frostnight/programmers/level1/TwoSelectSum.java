package frostnight.programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return
 * 하도록 solution 함수를 완성해주세요.
 */
public class TwoSelectSum {
  public int[] solution(int[] numbers) {
    int[] answer = {};
    List<Integer> result = new ArrayList<>();
    Map<String, Integer> memo = new HashMap<>();
    for (int i = 0; i < numbers.length; i++) {
      for (int j = i; j < numbers.length; j++) {
        if (i != j) {
          memo.put(String.valueOf(i) + "," + String.valueOf(j), numbers[i] + numbers[j]);
        }
      }
    }
    System.out.println("result = " + memo);
    return answer;
  }

  public static void main(String[] args) {
    TwoSelectSum twoSelectSum = new TwoSelectSum();
    int[][] numbers = {{2, 1, 3, 4, 1}, {5, 0, 2, 7}};
    int[][] except = {{2, 3, 4, 5, 6, 7}, {2, 5, 7, 9, 12}};

    for (int i = 0; i < numbers.length; i++) {
      int[] result = twoSelectSum.solution(numbers[i]);
      for (int j = 0; j < except.length; j++) {
        if (result[j] != except[i][j]) {
          System.out.println("i = " + i);
          System.out.println("except[i][j] = " + except[i][j]);
          System.out.println("result[j] = " + result[j]);
        }
      }
    }
  }
}
