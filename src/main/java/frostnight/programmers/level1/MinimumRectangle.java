package frostnight.programmers.level1;

public class MinimumRectangle {

  public int solution(int[][] sizes) {
    int maxWidth = 0, maxHeight = 0;

    for (int[] size : sizes) {
      int width = size[0];
      int swipeWidth = size[1];
      int height = size[1];
      int swipeHeight = size[0];

      int tempWidth1 = Math.max(maxWidth, width);
      int tempHeight1 = Math.max(maxHeight, height);
      int tempResult1 = tempWidth1 * tempHeight1;

      int tempWidth2 = Math.max(maxWidth, swipeWidth);
      int tempHeight2 = Math.max(maxHeight, swipeHeight);
      int tempResult2 = tempWidth2 * tempHeight2;

      if (tempResult1 < tempResult2) {
        maxWidth = tempWidth1;
        maxHeight = tempHeight1;
      } else {
        maxWidth = tempWidth2;
        maxHeight = tempHeight2;
      }
    }
    return maxWidth * maxHeight;
  }

  public static void main(String[] args) {

    MinimumRectangle minimumRectangle = new MinimumRectangle();
    int[][][] numbers = {
      {{60, 50}, {30, 70}, {60, 30}, {80, 40}},
      {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}},
      {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}},
    };
    for (int i = 0; i < numbers.length; i++) {
      int result = minimumRectangle.solution(numbers[i]);
      System.out.println("result = " + result);
    }
  }
}
