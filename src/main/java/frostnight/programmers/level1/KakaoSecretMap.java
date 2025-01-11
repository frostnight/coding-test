package frostnight.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class KakaoSecretMap {

  public static void main(String[] args) {
    //    int n = 5;
    //    int[] arr1 = {9, 20, 28, 18, 11};
    //    int[] arr2 = {30, 1, 21, 17, 28};
    int n = 6;
    int[] arr1 = {46, 33, 33, 22, 31, 50};
    int[] arr2 = {27, 56, 19, 14, 14, 10};
    String[] result = solution(n, arr1, arr2);
    for (int i = 0; i < result.length; i++) {
      System.out.println("result[i] = " + result[i]);
    }
  }

  static String[] solution(int n, int[] arr1, int[] arr2) {
    List<String> answers = new ArrayList<>();
    String[][] binaryMaps = new String[2][n];
    // 1. 각 배열의 숫자를 n자리의 2진수로 변환
    // 2. 변환된 2진수를 원소화해서 1을 #, 0을 공백으로 치환
    binaryMaps[0] = convertBinaryMap(n, arr1);
    binaryMaps[1] = convertBinaryMap(n, arr2);
    // 3. 두 집합을 확인해서 하나라도 1이 있으면 #을 없으면 공백으로
    for (int i = 0; i < binaryMaps.length; i++) {
      for (int j = 0; j < binaryMaps[i].length; j++) {
        String binary = binaryMaps[i][j];
        if (i > 0) {
          String answerCode = answers.get(j);
          char[] answerCharArray = answerCode.toCharArray();
          char[] binaryCharArray = binary.toCharArray();
          StringBuilder computedMap = new StringBuilder();
          for (int k = 0; k < answerCharArray.length; k++) {
            if (answerCharArray[k] == '#' || binaryCharArray[k] == '#') {
              computedMap.append("#");
            } else {
              computedMap.append(" ");
            }
          }
          answers.set(j, computedMap.toString());
        } else {
          answers.add(binary);
        }
      }
    }
    return answers.toArray(new String[0]);
  }

  static String[] convertBinaryMap(int n, int[] arr) {
    String[] binaryMap = new String[arr.length];
    for (int i = 0; i < arr.length; i++) {
      String convertBinary =
          String.format("%" + n + "s", Integer.toBinaryString(arr[i])).replace(' ', '0');
      binaryMap[i] = convertBinary.replaceAll("1", "#").replaceAll("0", " ");
    }
    return binaryMap;
  }
}
