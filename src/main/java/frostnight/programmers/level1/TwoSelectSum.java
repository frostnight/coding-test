package frostnight.programmers.level1;

public class TwoSelectSum {
  public int[] solution(int[] numbers) {
    int[] answer = {};
    return answer;
  }

  public static void main(String[] args) {
    TwoSelectSum twoSelectSum = new TwoSelectSum();
    int[][] numbers = {{2, 1, 3, 4, 1}};
    int[][] except = {};

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
