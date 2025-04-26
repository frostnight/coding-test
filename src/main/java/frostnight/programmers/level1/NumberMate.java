package frostnight.programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

public class NumberMate {

  public String solution(String X, String Y) {
    StringBuilder answer = new StringBuilder();
    List<String> Xlist = new ArrayList<>(Arrays.asList(X.split("")));
    Map<String, Long> YMap =
        Arrays.stream(Y.split("")).collect(Collectors.groupingBy(y -> y, Collectors.counting()));
    List<String> resultList = new ArrayList<>();
    // 두 집단을 비교해서 X와 Y중 겹치는 문자를 하나의 셋에 넣고 비교군에서 제외시킨다.
    for (String x : Xlist) {
      for (Map.Entry<String, Long> yEntry : YMap.entrySet()) {
        if (x.equals(yEntry.getKey()) && yEntry.getValue() > 0L) {
          resultList.add(x);
          yEntry.setValue(yEntry.getValue() - 1L);
          break;
        }
      }
    }
    // 만약 아무것도 없으면 -1, 0만 있으면 0을 문자열로 리턴
    if (resultList.isEmpty()) {
      return "-1";
    } else if (resultList.stream().allMatch(r -> r.equals("0"))) {
      return "0";
    }
    // 내림차순 정렬
    resultList.sort(Collections.reverseOrder());
    // resultList를 String으로 변환
    for (String s : resultList) {
      answer.append(s);
    }
    // String으로 반환
    return answer.toString();
  }

  public static void main(String[] args) {
    NumberMate numberMate = new NumberMate();
    String[] X = {"100", "100", "100", "12321", "5525", "4362318"};
    String[] Y = {"2345", "203045", "123450", "42531", "1255", "4338514"};
    String[] RESULT = {"-1", "0", "10", "321", "552", "84331"};

    for (int i = 0; i < X.length; i++) {
      String result = numberMate.solution(X[i], Y[i]);
      if (!RESULT[i].equals(result)) {
        System.out.println("result = " + result);
        System.out.println("RESULT[i] = " + RESULT[i]);
        System.out.println("i = " + i);
      }
    }
  }
}
