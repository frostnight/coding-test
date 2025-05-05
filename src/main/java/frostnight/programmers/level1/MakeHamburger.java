package frostnight.programmers.level1;

public class MakeHamburger {

  public int solution(int[] ingredient) {
    int answer = 0;
    StringBuilder sb = new StringBuilder();
    for (int ingrd : ingredient) {
      sb.append(String.valueOf(ingrd));
      if (sb.length() >= 4) {
        if (sb.charAt(sb.length() - 4) == '1'
            && sb.charAt(sb.length() - 3) == '2'
            && sb.charAt(sb.length() - 2) == '3'
            && sb.charAt(sb.length() - 1) == '1') {
          sb.delete(sb.length() - 4, sb.length());
          answer++;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    MakeHamburger makeHamburger = new MakeHamburger();
    int[][] ingredients = {{2, 1, 1, 2, 3, 1, 2, 3, 1}, {1, 3, 2, 1, 2, 1, 3, 1, 2}};
    int[] except = {2, 0};
    for (int i = 1; i < ingredients.length; i++) {
      int result = makeHamburger.solution(ingredients[1]);
      if (result != except[i]) {
        System.out.println("i = " + i);
        System.out.println("result = " + result);
        System.out.println("except[i] = " + except[i]);
      }
    }
  }
}
