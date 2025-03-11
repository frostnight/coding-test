package frostnight.programmers.level1;

import java.util.*;

/**
 * 정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return
 * 하도록 solution 함수를 완성해주세요.
 */
public class TwoSelectSum {
  public int[] solution(int[] numbers) {
    Set<Integer> result = new HashSet<>();
    for (int i = 0; i < numbers.length; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        result.add(numbers[i] + numbers[j]);
      }
    }
    return result.stream().sorted().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    TwoSelectSum twoSelectSum = new TwoSelectSum();
    int[][] numbers = {{2, 1, 3, 4, 1}, {5, 0, 2, 7}, {0,3,3,4,4,23,12}};
    int[][] except = {{2, 3, 4, 5, 6, 7}, {2, 5, 7, 9, 12}, {3, 4, 6, 7, 8, 12, 15, 16, 23, 26, 27, 35}};

    for (int i = 0; i < numbers.length; i++) {
      int[] result = twoSelectSum.solution(numbers[i]);
      for (int j = 0; j < numbers[i].length; j++) {
        if (result[j] != except[i][j]) {
          System.out.println("i = " + i);
          System.out.println("except[i][j] = " + except[i][j]);
          System.out.println("result[j] = " + result[j]);
        }
      }
    }
  }
}
