package frostnight.programmers.level1;

public class KakaoSecretMap {

  public static void main(String[] args) {
    int n = 5;
    int[] arr1 = {9, 20, 28, 18, 11};
    int[] arr2 = {30, 1, 21, 17, 28};
    String[] result = solution(n, arr1, arr2);
    for (int i = 0; i < result.length; i++) {
      System.out.println("result[i] = " + result[i]);
    }
  }

  static String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = {};
    String[][] binaryMaps = new String[2][n];
    // 1. 각 배열의 숫자를 n자리의 2진수로 변환
    binaryMaps[0] = convertBinaryMap(n, arr1);
    binaryMaps[1] = convertBinaryMap(n, arr2);
    // 2. 변환된 2진수를 원소화해서 1을 #, 0을 공백으로 치환
    // 3. 두 집합을 확인해서 하나라도 1이 있으면 #을 없으면 공백으로
    return answer;
  }

  static String[] convertBinaryMap(int n, int[] arr) {
    String[] binaryMap = new String[arr.length];
    for (int i = 0; i < arr.length; i++) {
      String convertBinary =
          String.format("%" + n + "s", Integer.toBinaryString(arr[i])).replace(' ', '0');
      binaryMap[i] = convertBinary;
    }
    return binaryMap;
  }
}
