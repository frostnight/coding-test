package frostnight.programmers.level1;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreeMusketeers {
  public int solution(int[] number) {
    AtomicInteger answer = new AtomicInteger(0);
    findNumber(0, 0, new int[3], number, answer );
    return answer.get();
  }

  public void findNumber(int depth, int start, int[] selected, int[] number, AtomicInteger answer) {
    if (depth == 3) {
      int sum = selected[0] + selected[1] + selected[2];
      if (sum == 0) {
        answer.incrementAndGet();
      }
      return;
    }

    for (int i = start; i < number.length; i++) {
      selected[depth] = number[i];
      findNumber(depth + 1, i + 1, selected, number, answer);
    }
  }

  public static void main(String[] args) {
    ThreeMusketeers t = new ThreeMusketeers();
    int[][] numbers = {
      {-2, 3, 0, 2, -5},
      {-3, -2, -1, 0, 1, 2, 3},
      {-1, 1, -1, 1},
    };
    int[] excepts = {2,5,0};
    for (int i = 0; i < numbers.length; i++) {
      int result = t.solution(numbers[i]);
      if (result != excepts[i]) {
        System.out.println("i = " + i);
        System.out.println("result = " + result);
        System.out.println("excepts[i] = " + excepts[i]);
      }
    }
  }
}
