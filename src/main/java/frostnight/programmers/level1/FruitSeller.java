package frostnight.programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

public class FruitSeller {

  // k 상자안의 최소 사과 점수
  // m은 상자 당 사과 갯수
  // 총 사과 개수
  public int solution(int k, int m, int[] score) {
    int answer = 0;
    List<Integer> scoreList =
        Arrays.stream(score).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    for (int i = 0; i + m <= scoreList.size(); i += m) {
      int min = scoreList.get(i + m - 1);
      answer += min * m;
    }
    return answer;
  }

  public static void main(String[] args) {
    FruitSeller fruitSeller = new FruitSeller();
    int[] k = {3, 4};
    int[] m = {4, 3};
    int[][] scores = {{1, 2, 3, 1, 2, 3, 1}, {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}};
    int[] answers = {8, 33};
    int solution = fruitSeller.solution(k[1], m[1], scores[1]);
    System.out.println("solution = " + solution);
  }
}
