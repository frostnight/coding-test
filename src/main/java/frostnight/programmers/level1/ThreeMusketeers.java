package frostnight.programmers.level1;

public class ThreeMusketeers {
  public int solution(int[] number) {
    int answer = 0;
    return answer;
  }

  public static void main(String[] args) {
    ThreeMusketeers t = new ThreeMusketeers();
    int[][] numbers = {
      {-2, 3, 0, 2, -5},
      {-3, -2, -1, 0, 1, 2, 3},
      {-1, 1, -1, 1}
    };
    int[] excepts = {2, 5, 0};

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
