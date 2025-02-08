package frostnight.programmers.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KakaoDartGame {

  static final Map<String, Double> POINT_AREA =
      Map.of(
          "S", 1.0,
          "D", 2.0,
          "T", 3.0);

  static int solution(String dartResult) {
    int answer = 0;
    // 3번의 기회
    // 점수는 0 ~ 10점
    // Single,Double,Triple - 제곱
    // 스타상(*) 이전 획득 점수 2배,아차상(#) 이전 획득 점수 마이너스
    // 1. 정수로 변환해서 숫자면 점수 로직 아니면 보너스 로직
    // 정수면 합산에 일단 포함, 보너스면 로직에 따라 이전 점수를 변환
    String[] dartSplit = dartResult.split("");
    char[] charArray = dartResult.toCharArray();

    List<Integer> points = new ArrayList<>();
    for (int i = 0; i < dartSplit.length; i++) {
      try {
        points.add(Integer.parseInt(dartSplit[i]));
      } catch (NumberFormatException e) {
        bonusProcess(dartSplit[i], points);
      }
    }
    for (Integer point : points) {
      answer += point;
    }
    return answer;
  }

  static void bonusProcess(String option, List<Integer> points) {
    int pointIndex = points.size() - 1;
    if (POINT_AREA.containsKey(option)) {
      double square = POINT_AREA.get(option);
      double powResult = Math.pow(points.getLast(), square);
      points.set(pointIndex, (int) powResult);
    } else if ("*".equals(option)) {
      points.set(pointIndex, points.getLast() * 2);
      if (points.size() > 1) {
        points.set(pointIndex - 1, points.get(pointIndex - 1) * 2);
      }
    } else if ("#".equals(option)) {
      points.set(pointIndex, points.getLast() * -1);
    }
  }

  public static void main(String[] args) {
    String[] dartResult = {
      //      "1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"
      "1D2S#10S"
    };
    //    int[] answer = {37, 9, 3, 23, 5, -4, 59};
    int[] answer = {9};
    for (int i = 0; i < dartResult.length; i++) {
      int excepted = solution(dartResult[i]);
      System.out.println("(excepted == answer[i]) = " + (excepted == answer[i]));
      if (excepted != answer[i]) {
        System.out.println("dartResult[i] = " + dartResult[i]);
        System.out.println("excepted = " + excepted);
      }
    }
  }
}
