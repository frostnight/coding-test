package frostnight.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class TemplarWeapon {

  public static int solution(int number, int limit, int power) {
    int answer = 0;
    List<Integer> divisors = new ArrayList<>();
    for (int num = 1; num <= number; num++) {
      // 각 숫자의 약수 개수를 구한다.
      divisors.add(findDivisor(num));
    }
    for (Integer divisor : divisors) {
      if (divisor > limit) {
        answer += power;
      } else {
        answer += divisor;
      }
    }
    // 배열의 반복문을 통해서 공격력에 따라 철의 값을 구한다
    // 공격력이 limit를 초과한다면 power에 대해서 철의 값을 구한다
    return answer;
  }

  public static int findDivisor(int target) {
    // 약수의 개수를 구한다.
    int count = 1;
    int num = target;
    // 소수 2,3,5,7
    int power = 0;
    while (num % 2 == 0) {
      num /= 2;
      power++;
    }
    if (power > 0) {
      count *= (power + 1);
    }

    for (int i = 3; i * i <= num; i += 2) {
      power = 0;
      while (num % i == 0) {
        num /= i;
        power++;
      }
      if (power > 0) {
        count *= (power + 1);
      }
    }

    if (num > 1) {
      count *= 2;
    }

    return count;
  }

  public static void main(String[] args) {
    int[] numbers = {5, 10};
    int[] limits = {3, 3};
    int[] powers = {2, 2};
    int[] except = {10, 21};

    for (int i = 0; i < numbers.length; i++) {
      int result = solution(numbers[i], limits[i], powers[i]);
      if (result != except[i]) {
        System.out.println("result = " + result);
        System.out.println("except[i] = " + except[i]);
      }
    }
  }
}
