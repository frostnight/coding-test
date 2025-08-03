package frostnight.programmers.level1;

import java.util.*;

public class HallOfFame {

  public int[] solution(int k, int[] score) {
    List<Integer> rank = new ArrayList<>();

    return Arrays.stream(score)
        .map(
            j -> {
              updateRank(rank, j, k);
              return Collections.min(rank);
            })
        .toArray();
  }

  private void updateRank(List<Integer> rank, int newScore, int k) {
    if (shouldEnterRank(rank, k, newScore)) {
      rank.add(newScore);
      if (rank.size() > k) {
        removeMinValue(rank);
      }
    }
  }

  private boolean shouldEnterRank(List<Integer> rank, int k, int score) {
    return rank.size() < k || Collections.min(rank) < score;
  }

  private void removeMinValue(List<Integer> rank) {
    Integer minValue = Collections.min(rank);
    rank.remove(minValue);
  }

  public static void main(String[] args) {
    HallOfFame hallOfFame = new HallOfFame();
    int[] k = {3, 4};
    int[][] scores = {
      {10, 100, 20, 150, 1, 100, 200},
      {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000}
    };
    int[][] expected = {
      {10, 10, 10, 20, 20, 100, 100},
      {0, 0, 0, 0, 20, 40, 70, 70, 150, 300}
    };
    for (int i = 0; i < expected.length; i++) {
      int[] r = hallOfFame.solution(k[i], scores[i]);
      System.out.println("Expected" + Arrays.toString(expected[i]));
      System.out.println("Result: " + Arrays.toString(r));
    }
  }
}
