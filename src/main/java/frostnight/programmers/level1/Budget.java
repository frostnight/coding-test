package frostnight.programmers.level1;

public class Budget {

  public static void main(String[] args) {
    int[][] d = {};
    int[] budget = {};
    int[] excepted = {};
    for (int i = 0; i < d.length; i++) {
      if (excepted[i] != solution(d[i], budget[i])) {
        System.out.println("index error = " + i);
        break;
      }
    }
  }

  static int solution(int[] d, int budget) {
    System.out.println("solution");
    return 0;
  }
}
