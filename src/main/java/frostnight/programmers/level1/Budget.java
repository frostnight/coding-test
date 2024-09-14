package frostnight.programmers.level1;

import java.util.Arrays;

public class Budget {

  public static void main(String[] args) {
    int[][] d = {
      {1, 3, 2, 5, 4}, {2, 2, 3, 3}, {9, 4, 3, 10}, {7, 3, 10, 12, 5, 7, 8, 15, 6, 1, 4}
    };
    int[] budget = {9, 10, 18, 25};
    int[] excepted = {3, 4, 3, 5};
    for (int i = 0; i < d.length; i++) {
      System.out.println("department>> " + solution(d[i], budget[i]));
      if (excepted[i] != solution(d[i], budget[i])) {
        System.out.println("index error = " + i);
        break;
      }
    }
  }

  static int solution(int[] d, int budget) {
    int admissionCount = 0;
    // 1. 작은 순으로 정렬 한다.
    Arrays.sort(d);
    // 2. 예산를 깎으면서 사용한 예산을 합한다.
    int index = 0;
    while (budget > 0 && index < d.length) {
      int departmentBudget = d[index];

      // 3. 예산이 다 떨어지면 멈춘다.
      if (budget - departmentBudget < 0) {
        break;
      }

      admissionCount++;
      budget -= departmentBudget;
      index++;
    }
    return admissionCount;
  }
}
