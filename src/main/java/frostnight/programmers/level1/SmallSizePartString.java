package frostnight.programmers.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * 숫자로 이루어진 문자열 t와 p가 주어질 때, t에서 p와 길이가 같은 부분문자열 중에서, 이 부분문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는 횟수를
 * return하는 함수 solution을 완성하세요. 예를 들어, t="3141592"이고 p="271" 인 경우, t의 길이가 3인 부분 문자열은 314, 141, 415,
 * 159, 592입니다. 이 문자열이 나타내는 수 중 271보다 작거나 같은 수는 141, 159 2개 입니다. 입출력 예 #2 p의 길이가 1이므로 t의 부분문자열은 "5",
 * "0", 0", "2", "2", "0", "8", "3", "9", "8", "7", "8"이며 이중 7보다 작거나 같은 숫자는 "5", "0", "0", "2", "2",
 * "0", "3", "7" 이렇게 8개가 있습니다. 입출력 예 #3 p의 길이가 2이므로 t의 부분문자열은 "10", "02", "20", "03"이며, 이중 15보다 작거나
 * 같은 숫자는 "10", "02", "03" 이렇게 3개입니다. "02"와 "03"은 각각 2, 3에 해당한다는 점에 주의하세요
 */
public class SmallSizePartString {

  public int solution(String t, String p) {
    List<Long> partStrings = new ArrayList<>();
    // 1. p문자열 길이만큼 t문자열 연속적으로 쪼개기
    int sliceSize = p.length();
    int sliceIndex = 0;
    while (sliceIndex <= t.length() - sliceSize) {
      String partString = t.substring(sliceIndex, sliceIndex + sliceSize);
      partStrings.add(Long.parseLong(partString));
      sliceIndex++;
    }
    // 2. 쪼개진 숫자를 p와 비교해서 작거나 같은 수 필터링
    long count = partStrings.stream().filter(part -> part <= Long.parseLong(p)).count();
    return (int) count;
  }

  public static void main(String[] args) {
    SmallSizePartString solution = new SmallSizePartString();
    String[] t = {"3141592", "500220839878", "10203"};
    String[] p = {"271", "7", "15"};
    int[] except = {2, 8, 3};

    for (int i = 0; i < t.length; i++) {
      int result = solution.solution(t[i], p[i]);
      if (result != except[i]) {
        System.out.println("i = " + i);
        System.out.println("t = " + t[i]);
        System.out.println("p = " + p[i]);
        System.out.println("except = " + except[i]);
        System.out.println("result = " + result);
      }
    }
  }
}
