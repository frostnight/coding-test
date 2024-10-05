package frostnight.programmers.level1;

public class NegativePositiveSum {
  public static void main(String[] args) {
    int[][] absolutes = {
      {4, 7, 12},
      {1, 2, 3}
    };
    boolean[][] signs = {
      {true, false, true},
      {false, false, true}
    };

    for (int i = 0; i < absolutes.length; i++) {
      int result = solution(absolutes[i], signs[i]);
      System.out.println("result = " + result);
    }
  }

  static int solution(int[] absolutes, boolean[] signs) {
    int answer = 0;

    for (int i = 0; i < absolutes.length; i++) {
      int target = signs[i] ? absolutes[i] : absolutes[i] * -1;
      answer += target;
    }

    return answer;
  }
}
